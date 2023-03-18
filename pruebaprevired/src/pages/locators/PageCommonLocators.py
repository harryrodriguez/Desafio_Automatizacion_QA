from selenium.webdriver.common.by import By


class PageCommonLocators:
    SEARCH_BOX = (By.CSS_SELECTOR, 'div.input-group input.form-control')
    BTN_SEARCH = (By.CSS_SELECTOR, 'button.btn i.fa-search')
    TEXT_ITEM_SEARCH = (By.CSS_SELECTOR, 'div.product-thumb div.caption h4 a')
    BTN_ADD_CARD = (By.CSS_SELECTOR , 'div.button-group  button i.fa-shopping-cart')
    ALERT_SUCCESS_ADD_ITEM = (By.CSS_SELECTOR , '#product-search div.alert.alert-success.alert-dismissible')
    BTN_PREVIEW_CARD = (By.CSS_SELECTOR, 'div.btn-group button.btn-inverse')
    ITEM_PREVIEW_CARD = (By.CSS_SELECTOR , 'table.table-striped tr td.text-left')
    BTN_CHECKOUT_PREVIEW_CARD = (By.CSS_SELECTOR, 'div p.text-right a i.fa-share')
