from time import sleep

from pruebaprevired.src.helpers.generic_helpers import GenericHelpers
from pruebaprevired.src.pages.locators.HistoryOrderLocators import HistoryOrderLocators
from pruebaprevired.src.SeleniumExtended import SeleniumExtended
import logging as logger


class HistoryOrder(HistoryOrderLocators):

    def __init__(self, driver):
        self.driver = driver
        self.sl = SeleniumExtended(self.driver)



    def validate_order(self):
        logger.info("History Order -- Comienzo con la verificacion de datos")
        generic_helpers = GenericHelpers(self.driver)
        self.sl.wait_and_click(self.BTN_VIEW_INFO_ORDER_COMPLETE)
        sleep(2)
        #comienzo validacion de datos
        #data payment address
        data_payment_address = self.sl.find_element(self.DATA_PAYMENT_ADDRESS)
        data_payment_address_text = data_payment_address.text
        data_payment_address_string = data_payment_address_text.replace("\n", ",")
        # data shipping address
        data_shipping_address = self.sl.find_element(self.DATA_SHIPPING_ADDRESS)
        data_shipping_address_text = data_shipping_address.text
        data_shipping_address_string = data_shipping_address_text.replace("\n", ",")
        if data_payment_address_string == data_shipping_address_string:
            logger.info("History Order -- Los datos de direccion de pago son iguales a los datos de la cuenta")
            generic_helpers.save_screenshot('Evidencias\\Validacion pago vs Cuenta', 'Info_pago_vs_cuenta')
            logger.info("Evidencia -- Toma de Evidencia validacion pago vs Cuenta (ver la evidencia en la ruta Evidencias\\Validacion pago vs Cuenta)")
        else:
            logger.info("History Order -- Los datos de direccion de pago NO son iguales a los datos de la cuenta")
            generic_helpers.save_screenshot('Evidencias\\Validacion Pago vs Cuenta', 'Info_pago_vs_cuenta')
            logger.info("Evidencia -- Toma de Evidencia validacion pago vs Cuenta (ver la evidencia en la ruta Evidencias\\Validacion pago vs Cuenta)")

    def verify_status_history_order(self , status):
        generic_helpers = GenericHelpers(self.driver)
        btn_continue = self.sl.find_element(self.BTN_CONTINUE)
        self.driver.execute_script('arguments[0].focus();', btn_continue)
        # element_status.focus()
        self.sl.wait_until_element_contains_text(self.STATUS_ORDER, status)
        logger.info("History Order -- Validacion de status Pendiente")
        generic_helpers.save_screenshot('Evidencias\\Estatus Historial de Orden', 'Status_order')
        logger.info("Evidencia -- Toma de Evidencia del Status History Order Pending(ver la evidencia en la ruta Evidencias\\Status History Order)")
        self.sl.wait_and_click(self.BTN_CONTINUE)

    def click_my_account_and_logout(self):
        self.sl.wait_and_click(self.ELEMENTS_MY_ACCOUNT)
        self.sl.wait_and_click(self.ELEMENT_LOGOUT)
        logger.info("History Order -- Click en mi cuenta y luego cerrar sesion")

