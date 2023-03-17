from pruebaprevired.src.pages.locators.CheckoutLocators import CheackoutLocators
from pruebaprevired.src.SeleniumExtended import SeleniumExtended
from pruebaprevired.src.helpers.generic_helpers import GenericHelpers
import logging as logger
from faker import Faker
faker = Faker()


class Checkout(CheackoutLocators):

    def __init__(self, driver):
        self.driver = driver
        self.sl = SeleniumExtended(self.driver)

    # Insertar correo no registrado
    def input_login_username(self, username):
        self.sl.wait_and_input_text(self.LOGIN_USER_EMAIL, username)
        logger.info("Ingreso Email")

    # Insertar contraseña
    def input_login_password(self, password):
        self.sl.wait_and_input_text(self.LOGIN_PASSWORD, password)
        logger.info("Ingreso Contraseña")

    # click en iniciar sesion
    def click_login_button(self):
        self.sl.wait_and_click(self.LOGIN_BTN)
        logger.info("Click en Iniciar Sesion")

    def wait_until_error_is_displayed(self, exp_err):
        self.sl.wait_until_element_contains_text(self.ERROR_MESSAGE_LOG_IN, exp_err)
        logger.info("El error se encontro")

    def verify_btn_register_and_click_to_continue_create_user(self):
        generic_helpers = GenericHelpers(self.driver)
        self.sl.is_radio_selected(self.RADIO_REGISTER_USER)
        logger.info("La opcion Register Account esta seleccionada")
        generic_helpers.save_screenshot('Evidencias\\Paso a Paso Cheackout', 'Paso1_select_register_account')
        self.sl.wait_and_click(self.BTN_CONTINUE_REGISTER)


    def input_billing_first_name(self, first_name):
        first_name = faker.name()
        self.sl.wait_and_input_text(self.BILLING_FIRST_NAME_FIELD, first_name)

    def input_billing_last_name(self, last_name):
        last_name = faker.last_name()
        self.sl.wait_and_input_text(self.BILLING_LAST_NAME_FIELD, last_name)

    def input_billing_email(self, email=None):
        generic_helpers = GenericHelpers(self.driver)
        if not email:
            rand_email = generic_helpers.generate_random_email_and_password()
            email = rand_email['email']
        self.sl.wait_and_input_text(self.BILLING_EMAIL_FIELD, email)

    def input_billing_phone_number(self, phone):
        phone = faker.phone_number()
        self.sl.wait_and_input_text(self.BILLING_PHONE_FIELD, phone)

    def input_billing_company(self, company):
        company = 'Prueba' if not company else company
        self.sl.wait_and_input_text(self.BILLING_COMPANY, company)

    def input_billing_street_address_1(self, address1):
        address1 = faker.street_address()
        self.sl.wait_and_input_text(self.BILLING_ADDRESS_1_FIELD, address1)

    def input_billing_city(self, city):
        city = 'Santiago' if not city else city
        self.sl.wait_and_input_text(self.BILLING_CITY_FIELD, city)

    def input_billing_zip(self, zip_code):
        zip_code = faker.address()
        self.sl.wait_and_input_text(self.BILLING_ZIP_FIELD, zip_code)

    def input_option_select_country(self, option_country):
        option_country = 'Chile' if not option_country else option_country
        self.sl.select_option_by_text(self.BILLING_SELECT_COUNTRY, option_country)

    def input_option_select_region(self, option_region):
        option_region = 'Region Metropolitana' if not option_region else option_region
        self.sl.select_option_by_text(self.BILLING_SELECT_REGION, option_region)

    def input_billing_password(self, password):
        password = 'Abc1234.' if not password else password
        self.sl.wait_and_input_text(self.BILLING_PASSWORD, password)
        self.sl.wait_and_input_text(self.BILLING_PASSWORD_CONFIRM, password)

    def fill_in_billing_info(self, f_name=None, l_name=None,email=None, phone=None, company=None, address1=None, city=None, zip_code=None, country=None, region=None, password=None ):
        generic_helpers = GenericHelpers(self.driver)
        self.input_billing_first_name(first_name=f_name)
        self.input_billing_last_name(last_name=l_name)
        self.input_billing_email(email=email)
        self.input_billing_phone_number(phone=phone)
        self.input_billing_company(company=company)
        self.input_billing_street_address_1(address1=address1)
        self.input_billing_city(city=city)
        self.input_billing_zip(zip_code=zip_code)
        self.input_option_select_country(option_country=country)
        self.input_option_select_region(option_region=region)
        self.input_billing_password(password= password)
        logger.info("Se llenaron todos los campos para el regitros de la cuenta")
        generic_helpers.save_screenshot('Evidencias\\Cuenta Creada', 'Registro_cuenta_completado_cheackout')
        generic_helpers.save_screenshot('Evidencias\\Paso a Paso Cheackout', 'Paso2_billing_details')

    def click_privacy_policy_and_continue(self):
        self.sl.wait_and_click(self.BILLING_BTN_PRIVACY_POLICY)
        self.sl.wait_and_click(self.BILLING_BTN_CONTINUE)
        logger.info("Acepte politicas de seguridad de usuario nuevo y continuo con siguiente paso")

    def verify_radio_delivery_details_and_click_continue(self):
        generic_helpers = GenericHelpers(self.driver)
        self.sl.is_radio_selected(self.RADIO_SELECT_ADDRESS_DELIVERY)
        generic_helpers.save_screenshot('Evidencias\\Paso a Paso Cheackout', 'Paso3_delivery_details')
        self.sl.wait_and_click(self.BTN_CONTINUE_DELIVERY_DETAILS)
        logger.info("Verifico que direccion de delivery este seleccionada y doy click a continuar")

    def verify_flat_shipping_rate_and_click_continue(self, text):
        generic_helpers = GenericHelpers(self.driver)
        self.sl.wait_until_element_contains_text(self.ELEMENT_FLAT_SHIPPING_RATE, text)
        generic_helpers.save_screenshot('Evidencias\\Paso a Paso Cheackout', 'Paso4_flat_shipping_rate')
        self.sl.wait_and_click(self.BTN_CONTINUE_SHIPPING_METHOD)
        logger.info("Verifico que Flat Shipping Rate sea de $5.00 luego doy click en continuar")

    def click_cash_on_delivery_and_continue(self):
        generic_helpers = GenericHelpers(self.driver)
        self.sl.wait_and_click(self.RADIO_CASH_ON_DELIVERY)
        self.sl.wait_and_click(self.BTN_TERMS_CONDITIONS)
        self.sl.wait_and_click(self.BTN_CONTINUE_PAYMENT_METHOD)
        generic_helpers.save_screenshot('Evidencias\\Paso a Paso Cheackout', 'Paso5_payment_methond')
        logger.info("Seleccione el pago en efectivo y click en continuar")


    def verify_order_complete(self):
        generic_helpers = GenericHelpers(self.driver)
        elements = self.sl.find_elements(self.ELEMENTS_ORDER_CONFIRM)
        total_order = elements[-1].text
        logger.info(f"Evidencia de el total de la compra que es  {total_order}")
        generic_helpers.save_screenshot('Evidencias\\Paso a Paso Cheackout', 'Paso6_confirm_order')
        generic_helpers.save_screenshot('Evidencias\\Orden completa', 'confirm_order')


    def click_confirm_orden(self):
        generic_helpers = GenericHelpers(self.driver)
        self.sl.wait_and_click(self.BTN_CONFIRM_ORDER)
        generic_helpers.save_screenshot('Evidencias\\Paso a Paso Cheackout', 'Paso7_mgs_order_success')
        self.sl.wait_and_click(self.BTN_CONTINUE_SUCCESS_ORDER)











