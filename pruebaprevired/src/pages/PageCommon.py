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
            if item == item_text_web:
                self.sl.wait_and_click(self.BTN_ADD_CARD)
                logger.info(f"El item {item} fue")
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
                    logger.info(f"El item {item} fue agregregado con éxito ")
                    #tomo evidencia del mensaje que me dice que se agrego al carrito
                    generic_helpers.save_screenshot('Evidencias\\Items Agregados', f'Evidencia_{item}_agregado')
                    logger.info(f"Se toma evidencia de la alerta del item {item}")
                else:
                    print('El item no se añadio al carrito')

    def verify_item_in_preview_card(self, search_items):
        generic_helpers = GenericHelpers(self.driver)
        logger.info("Comienzo la validacion de los item agregados al carrito")
        self.sl.wait_and_click(self.BTN_PREVIEW_CARD)
        items_add_preview_card = self.sl.find_elements(self.ITEM_PREVIEW_CARD)
        for item in items_add_preview_card:
            text_item = item.text
            if text_item in search_items:
                logger.info(f"El item {text_item} está en la lista de items.")
            else:
                logger.info(f"El item {text_item} no está en la lista de items.")

        generic_helpers.save_screenshot('Evidencias\\Items Agregados', 'Evidencia_previsualizacion_items_agregados_en_carrito')
        logger.info("tomo evidecias de los items agregados")



    def click_btn_checkout_preview_card(self):
        self.sl.wait_and_click(self.BTN_CHECKOUT_PREVIEW_CARD)
        logger.info("Doy click al boton checkout")





