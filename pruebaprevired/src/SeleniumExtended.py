import time

from selenium.common import StaleElementReferenceException, NoSuchElementException
from selenium.webdriver.support.select import Select
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

class SeleniumExtended:

    def __init__(self, driver):
        self.driver = driver
        self.default_timeout = 10

    def wait_and_click(self, locator, timeout=None):
        timeout = timeout if timeout else self.default_timeout
        try:
            WebDriverWait(self.driver, timeout).until(
                EC.visibility_of_element_located(locator)
            ).click()
        except StaleElementReferenceException:
            time.sleep(5)
            WebDriverWait(self.driver, timeout).until(
                EC.visibility_of_element_located(locator)
            ).click()

    def wait_and_input_text(self, locator, text, timeout=None):
        timeout = timeout if timeout else self.default_timeout
        WebDriverWait(self.driver, timeout).until(
            EC.visibility_of_element_located(locator)
        ).send_keys(text)

    def find_element(self, locator, timeout=None):
        timeout = timeout if timeout else self.default_timeout
        try:
            # Espera hasta que se encuentre el elemento especificado
            time.sleep(3)
            elemento = WebDriverWait(self.driver, timeout).until(
                EC.presence_of_element_located(locator)
            )
            return elemento
        except:
            # Si no se encuentra el elemento, lanza una excepción
            raise NoSuchElementException(f"No se pudo encontrar el elemento con el selector {locator}")

    def wait_until_element_contains_text(self, locator, text, timeout=None):
        timeout = timeout if timeout else self.default_timeout
        WebDriverWait(self.driver, timeout).until(
            EC.text_to_be_present_in_element(locator, text)
        )

    def find_elements(self, locator, timeout=None):
        timeout = timeout if timeout else self.default_timeout
        try:
            # Espera hasta que se encuentre el elemento especificado
            time.sleep(3)
            elementos = WebDriverWait(self.driver, timeout).until(
                EC.presence_of_all_elements_located(locator)
            )
            return elementos
        except:
            # Si no se encuentra el elemento, lanza una excepción
            raise NoSuchElementException(f"No se pudo encontrar el elemento con el selector {locator}")

    def wait_and_input_text(self, locator, text, timeout=None):
        timeout = timeout if timeout else self.default_timeout
        WebDriverWait(self.driver, timeout).until(
            EC.visibility_of_element_located(locator)
        ).send_keys(text)

    def wait_and_get_element_text(self , locator, timeout=None):
        timeout = timeout if timeout else self.default_timeout
        element = WebDriverWait(self.driver, timeout).until(
            EC.visibility_of_element_located(locator)
        )
        element = element.text
        return element

    def wait_until_element_contains_text(self, locator, text, timeout=None):
        timeout = timeout if timeout else self.default_timeout
        WebDriverWait(self.driver, timeout).until(
            EC.text_to_be_present_in_element(locator, text)
        )

    def is_radio_selected(self, locator, timeout=None):
        timeout = timeout if timeout else self.default_timeout
        radio_element = WebDriverWait(self.driver, timeout).until(
            EC.presence_of_element_located(locator)
        )

        return radio_element.is_selected()

    def select_option_by_text(self, locator, option, timeout=None):
        timeout = timeout if timeout else self.default_timeout
        time.sleep(5)
        select_element = WebDriverWait(self.driver, timeout).until(
            EC.presence_of_element_located(locator)
        )
        select = Select(select_element)
        select.select_by_visible_text(option)

