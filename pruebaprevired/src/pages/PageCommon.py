from time import sleep


from pruebaprevired.src.pages.locators.PageCommonLocators import PageCommonLocators
from pruebaprevired.src.helpers.config_helpers import get_base_url
from pruebaprevired.src.SeleniumExtended import SeleniumExtended
from pruebaprevired.src.helpers.generic_helpers import GenericHelpers
import logging as logger


class PageCommon(PageCommonLocators):


    def __init__(self, driver):
        self.driver = driver
        self.sl = SeleniumExtended(self.driver)
        generic_helpers = GenericHelpers(self.driver)

    def go_to_my_homepage(self):
        base_url = get_base_url()
        logger.info(f"Going to: {base_url}")
        self.driver.get(base_url)

    def search_navigation_bar_and_add_item_to_card(self, search_items):
        generic_helpers = GenericHelpers(self.driver)
        #search_input = self.sl.find_element(self.SEARCH_BOX)
        for item in search_items:
            search_input = self.sl.find_element(self.SEARCH_BOX)
            search_input.clear()
            search_input.send_keys(item)
            #sleep(3)
            self.sl.wait_and_click(self.BTN_SEARCH)
            item_web = self.sl.find_element(self.TEXT_ITEM_SEARCH)
            item_text_web = item_web.text
            print(f"El item buscado es {item} y el item de la busqueda es {item_text_web}")
            if item == item_text_web:
                print('entre al if')
                self.sl.wait_and_click(self.BTN_ADD_CARD)
                sleep(3)
                alert = self.sl.find_element(self.ALERT_SUCCESS_ADD_ITEM)
                alert_text = alert.text
                print(alert_text)
                text_success_expected= f'Success: You have added'
                print(alert_text)
                print(text_success_expected)
                #import pdb;pdb.set_trace()
                if text_success_expected in text_success_expected:
                    print('entre al if evidencia')
                    #tomo evidencia del mensaje que me dice que se agrego al carrito
                    generic_helpers.save_screenshot('Evidencias', f'Evidencia_{item}_agregado')
                else:
                    print('El item no se añadio al carrito')

    def verify_item_in_preview_card(self , search_items):
        generic_helpers = GenericHelpers(self.driver)
        self.sl.wait_and_click(self.BTN_PREVIEW_CARD)
        items_add_preview_card = self.sl.find_elements(self.ITEM_PREVIEW_CARD)
        print(items_add_preview_card)
        for item in items_add_preview_card:
            text_item = item.text
            if text_item in search_items:
                print(f"El item {text_item} está en la lista de items.")
            else:
                print(f"El item {text_item} no está en la lista de items.")
            generic_helpers.save_screenshot('Evidencias', f'Evidencia_previsualizacion_items_agregados')







