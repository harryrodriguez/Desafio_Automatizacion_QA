from selenium.webdriver.common.by import By


class HistoryOrderLocators:
    BTN_VIEW_INFO_ORDER_COMPLETE = (By.CSS_SELECTOR, 'td.text-right a.btn')
    ORDER_HISTORY_STATUS= (By.CSS_SELECTOR, '#content > h3')
    STATUS_ORDER = (By.XPATH, '//td[@class="text-left"][text()="Pending"]')