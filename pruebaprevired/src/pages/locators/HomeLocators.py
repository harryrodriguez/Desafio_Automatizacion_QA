from selenium.webdriver.common.by import By


class HomeLocators:
    ELEMENTS_MY_ACCOUNT = (By.CSS_SELECTOR, 'ul.list-inline li.dropdown a.dropdown-toggle')
    ELEMENT_ORDER_HISTORY = (By.CSS_SELECTOR, 'ul.dropdown-menu a[href*="order"]')