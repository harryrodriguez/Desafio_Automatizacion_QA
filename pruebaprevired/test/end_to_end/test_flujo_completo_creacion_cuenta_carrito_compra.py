from time import sleep

import pytest
from pruebaprevired.src.pages.PageCommon import PageCommon


@pytest.mark.usefixtures("init_driver")
class TestCreateAddBuy:

    @pytest.mark.test_001
    def test_complete_shopping_flow(self):
        items_to_search = ['iPod Classic', 'iMac']

        page_common = PageCommon(self.driver)

        page_common.go_to_my_homepage()
        self.driver.maximize_window()
        page_common.search_navigation_bar_and_add_item_to_card(items_to_search)
        sleep(4)
        page_common.verify_item_in_preview_card(items_to_search)
