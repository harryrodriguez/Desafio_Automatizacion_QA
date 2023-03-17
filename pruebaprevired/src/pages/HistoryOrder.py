from time import sleep

from pruebaprevired.src.helpers.generic_helpers import GenericHelpers
from pruebaprevired.src.pages.locators.HistoryOrderLocators import HistoryOrderLocators
from pruebaprevired.src.SeleniumExtended import SeleniumExtended
import logging as logger


class HistoryOrder(HistoryOrderLocators):

    def __init__(self, driver):
        self.driver = driver
        self.sl = SeleniumExtended(self.driver)

    def verify_status_order(self, status):
        generic_helpers = GenericHelpers(self.driver)

        self.sl.wait_and_click(self.BTN_VIEW_INFO_ORDER_COMPLETE)
        sleep(2)
        element_status = self.sl.find_element(self.ORDER_HISTORY_STATUS)
        self.driver.execute_script('arguments[0].focus();', element_status)

        self.sl.wait_until_element_contains_text(self.STATUS_ORDER, status)
        generic_helpers.save_screenshot('Evidencias\\Paso a Paso Cheackout', 'Paso4_flat_shipping_rate')
