from selenium.webdriver.common.by import By


class HistoryOrderLocators:
    BTN_VIEW_INFO_ORDER_COMPLETE = (By.CSS_SELECTOR, 'td.text-right a.btn')
    INFO_PAYMENT_AND_SHIPPING_ORDER = (By.CSS_SELECTOR, '#content table:nth-child(2) tbody tr td:nth-child(2) b')
    DATA_PAYMENT_ADDRESS = (By.CSS_SELECTOR , '#content table:nth-child(3) tbody tr td:nth-child(1)')
    DATA_SHIPPING_ADDRESS = (By.CSS_SELECTOR , '#content table:nth-child(3) tbody tr td:nth-child(2)')
    BTN_CONTINUE = (By.CSS_SELECTOR, 'div.pull-right  a.btn[href*="order"]')
    STATUS_ORDER = (By.XPATH, '//td[@class="text-left"][text()="Pending"]')
    ELEMENTS_MY_ACCOUNT = (By.CSS_SELECTOR, 'ul.list-inline li.dropdown a.dropdown-toggle')
    ELEMENT_LOGOUT = (By.CSS_SELECTOR, 'ul.dropdown-menu a[href*="logout"]')