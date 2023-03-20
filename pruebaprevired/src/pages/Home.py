from pruebaprevired.src.pages.locators.HomeLocators import HomeLocators
from pruebaprevired.src.SeleniumExtended import SeleniumExtended
import logging as logger


class Home(HomeLocators):

    def __init__(self, driver):
        self.driver = driver
        self.sl = SeleniumExtended(self.driver)

    def click_my_account_and_order_history(self):
        self.sl.wait_and_click(self.ELEMENTS_MY_ACCOUNT)
        self.sl.wait_and_click(self.ELEMENT_ORDER_HISTORY)
        logger.info("Home -- Click en mi cuenta y luego en historial de orden")