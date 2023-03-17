import os
from time import sleep
import logging as logger
import pytest
from dotenv import load_dotenv
from pruebaprevired.src.pages.PageCommon import PageCommon
from pruebaprevired.src.pages.Checkout import Checkout
from pruebaprevired.src.pages.Home import Home
from pruebaprevired.src.pages.HistoryOrder import HistoryOrder


load_dotenv()

@pytest.mark.usefixtures("init_driver")
class TestCreateAddBuy:

    @pytest.mark.test_001
    def test_complete_shopping_flow(self):
        items_to_search = ['iPod Classic', 'iMac']

        page_common = PageCommon(self.driver)
        checkout = Checkout(self.driver)
        home = Home(self.driver)
        history_order = HistoryOrder(self.driver)

        logger.info('Started')
        logger.info('*******')
        logger.info('TEST LOGIN EXISTING')
        page_common.go_to_my_homepage()
        self.driver.maximize_window()
        page_common.search_navigation_bar_and_add_item_to_card(items_to_search)
        page_common.verify_item_in_preview_card(items_to_search)
        page_common.click_btn_checkout_preview_card()

        checkout.input_login_username(os.getenv('LOGIN_USER_EMAIL_TEST'))
        checkout.input_login_password(os.getenv('LOGIN_PASSWORD'))
        checkout.click_login_button()
        expected_err = 'Warning: No match for E-Mail Address and/or Password.'
        checkout.wait_until_error_is_displayed(expected_err)
        sleep(6)
        checkout.verify_btn_register_and_click_to_continue_create_user()
        checkout.fill_in_billing_info()
        checkout.click_privacy_policy_and_continue()
        checkout.verify_radio_delivery_details_and_click_continue()
        text_flat_shipping_rate_expected = 'Flat Shipping Rate - $5.00'
        checkout.verify_flat_shipping_rate_and_click_continue(text_flat_shipping_rate_expected)
        sleep(2)
        checkout.click_cash_on_delivery_and_continue()
        checkout.verify_order_complete()
        checkout.click_confirm_orden()
        sleep(2)
        home.click_my_account_and_order_history()
        history_order.verify_status_order('Pending')





