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
        logger.info(f" Page Common -- Abro la Url: {base_url}")
        self.driver.get(base_url)

    def search_navigation_bar_and_add_item_to_card(self, search_items):
        generic_helpers = GenericHelpers(self.driver)
        logger.info("Page Common -- Comenzamos añadiendo los items en el carrito")
        for item_name in search_items:
            search_input = self.sl.find_element(self.SEARCH_BOX)
            search_input.clear()
            search_input.send_keys(item_name)
            self.sl.wait_and_click(self.BTN_SEARCH)
            item_web = self.sl.find_element(self.TEXT_ITEM_SEARCH)
            item_text_web = item_web.text
            if item_name == item_text_web:
                self.sl.wait_and_click(self.BTN_ADD_CARD)
                sleep(3)
                alert = self.sl.find_element(self.ALERT_SUCCESS_ADD_ITEM)
                alert_text = alert.text
                print(alert_text)
                text_success_expected = 'Success: You have added'
                print(alert_text)
                print(text_success_expected)
                #import pdb;pdb.set_trace()
                if text_success_expected in alert_text:
                    generic_helpers.save_screenshot('Evidencias\\Items Agregados', f'Evidencia_{item_name}_agregado')
                else:
                    logger.error(f'Page Common -- El item {item_name} no se añadio al carrito')
            else:
                logger.error(f'Page Common -- El nombre del {item_name} del archivo no es igual al de la web {item_text_web}')
            # tomo evidencia del mensaje que me dice que se agrego al carrito
            logger.info(f"Page Common -- El item {item_name} fue agregado con éxito")
            logger.info(f"Evidencia -- Se toma evidencia del mensaje de exito al agregar el item {item_name} (ver la evidencia en la ruta Evidencias\\Items Agregados)")

    def verify_item_in_preview_card(self, search_items):
        generic_helpers = GenericHelpers(self.driver)
        logger.info("Page Common -- Comienzo la validacion de los item agregados al carrito")
        self.sl.wait_and_click(self.BTN_PREVIEW_CARD)
        items_add_preview_card = self.sl.find_elements(self.ITEM_PREVIEW_CARD)
        for item in items_add_preview_card:
            text_item = item.text
            if text_item in search_items:
                logger.info(f"Page Common -- El item {text_item} se agrego correctamente al carrito.")
            else:
                logger.error(f"Page Common -- El item {text_item} no se agrego correctamente al carrito.")

        generic_helpers.save_screenshot('Evidencias\\Items Agregados', 'Evidencia_previsualizacion_items_agregados_en_carrito')
        logger.info("Evidencia -- Se tomo evidecias de los items agregados al carrito (ver la evidencia en la ruta Evidencias\\Items Agregados)) ")



    def click_btn_checkout_preview_card(self):
        self.sl.wait_and_click(self.BTN_CHECKOUT_PREVIEW_CARD)
        logger.info("Page Common -- Una vez validados los items, se da click en Cheakout")





