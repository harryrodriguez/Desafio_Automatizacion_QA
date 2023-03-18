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
    logger.info("Comienzo con la prueba de inicio de sesion con un archivo externo (Las credenciales estan en un archivo .env)")
    def input_login_email(self, username):
        self.sl.wait_and_input_text(self.LOGIN_USER_EMAIL, username)
        logger.info("Checkout -- Prueba Inicio Sesion, Ingreso Email")

    # Insertar contraseña
    def input_login_password(self, password):
        self.sl.wait_and_input_text(self.LOGIN_PASSWORD, password)
        logger.info("Checkout -- Prueba Inicio Sesion, Ingreso Contraseña")


    # click en iniciar sesion
    def click_login_button(self):
        self.sl.wait_and_click(self.LOGIN_BTN)
        logger.info("Checkout -- Prueba Inicio Sesion, Click en Iniciar Sesion")

    def wait_until_error_is_displayed(self, exp_err):
        self.sl.wait_until_element_contains_text(self.ERROR_MESSAGE_LOG_IN, exp_err)
        logger.info("Checkout -- Prueba Inicio Sesion, Verifico el error al enviar email no registrado")

    logger.info("Checkout -- Comienzo Flujo de Registrar Usuario nuevo")
    def verify_btn_register_and_click_to_continue_create_user(self):
        generic_helpers = GenericHelpers(self.driver)
        self.sl.is_radio_selected(self.RADIO_REGISTER_USER)
        logger.info("Checkout -- Verifico que la opcion Register Account esta seleccionada")
        generic_helpers.save_screenshot('Evidencias\\Paso a Paso Cheackout', 'Paso1_select_register_account')
        logger.info("Evidencia -- Comienzo con la evidencia de paso a paso de cheakout paso 1 (ver la evidencia en la ruta Evidencias\\Paso a Paso Cheackout)")
        self.sl.wait_and_click(self.BTN_CONTINUE_REGISTER)
        logger.info("Checkout -- Click en continuar con el registro ")


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

    logger.info("Checkout -- Comienzo con el llenado de facturación")
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
        logger.info("Checkout -- Se llenaron todos los campos del primer paso, datos de usuario")
        generic_helpers.save_screenshot('Evidencias\\Cuenta Creada', 'Registro_cuenta_completado_cheackout')
        logger.info("Evidencia -- Toma de Evidencia Cuenta Creada (ver la evidencia en la ruta Evidencias\\Cuenta Creada)")
        generic_helpers.save_screenshot('Evidencias\\Paso a Paso Cheackout', 'Paso2_billing_details')
        logger.info("Evidencia -- Toma de Evidencia de paso a paso de cheakout paso 2 (ver la evidencia en la ruta Evidencias\\Paso a Paso Cheackout)")

    def click_privacy_policy_and_continue(self):
        self.sl.wait_and_click(self.BILLING_BTN_PRIVACY_POLICY)
        self.sl.wait_and_click(self.BILLING_BTN_CONTINUE)
        logger.info("Usuario Nuevo-- Acepte politicas de seguridad de usuario nuevo y continuo con siguiente paso")

    def verify_radio_delivery_details_and_click_continue(self):
        generic_helpers = GenericHelpers(self.driver)
        self.sl.is_radio_selected(self.RADIO_SELECT_ADDRESS_DELIVERY)
        generic_helpers.save_screenshot('Evidencias\\Paso a Paso Cheackout', 'Paso3_delivery_details')
        logger.info("Evidencia -- Toma de Evidencia de paso a paso de cheakout paso 3 (ver la evidencia en la ruta Evidencias\\Paso a Paso Cheackout)")
        self.sl.wait_and_click(self.BTN_CONTINUE_DELIVERY_DETAILS)
        logger.info("Checkout -- Verifico que direccion de delivery este seleccionada y doy click a continuar")

    def verify_flat_shipping_rate_and_click_continue(self, text):
        generic_helpers = GenericHelpers(self.driver)
        try:
            self.sl.wait_until_element_contains_text(self.ELEMENT_FLAT_SHIPPING_RATE, text)
            generic_helpers.save_screenshot('Evidencias\\Paso a Paso Cheackout', 'Paso4_flat_shipping_rate')
            logger.info("Evidencia -- Toma de Evidencia de paso a paso de cheakout paso 4 (ver la evidencia en la ruta Evidencias\\Paso a Paso Cheackout)")
            self.sl.wait_and_click(self.BTN_CONTINUE_SHIPPING_METHOD)
            logger.info("Checkout -- Validacion el  Flat Shipping Rate tiene que ser igual a $5.00, luego doy click en continuar")
        except Exception as e:
            logger.error(f'Checkout -- Error en la validacion de Flat Shipping Rate el error es el siguiente {e}')


    def click_cash_on_delivery_and_continue(self):
        generic_helpers = GenericHelpers(self.driver)
        self.sl.wait_and_click(self.RADIO_CASH_ON_DELIVERY)
        self.sl.wait_and_click(self.BTN_TERMS_CONDITIONS)
        logger.info("Checkout -- Se seleciona el pago en efectivo (para que status quede pendiente) y se acepta terminos y condiciones")
        generic_helpers.save_screenshot('Evidencias\\Paso a Paso Cheackout', 'Paso5_payment_methond')
        logger.info("Evidencia -- Toma de Evidencia de paso a paso de cheakout paso 5 (ver la evidencia en la ruta Evidencias\\Paso a Paso Cheackout)")
        self.sl.wait_and_click(self.BTN_CONTINUE_PAYMENT_METHOD)

    def verify_order_complete(self):
        generic_helpers = GenericHelpers(self.driver)
        elements = self.sl.find_elements(self.ELEMENTS_ORDER_CONFIRM)
        total_order = elements[-1].text
        logger.info(f"Checkout --  Validacion del total de la compra que es  {total_order}")
        generic_helpers.save_screenshot('Evidencias\\Paso a Paso Cheackout', 'Paso6_confirm_order')
        logger.info("Evidencia -- Toma de Evidencia de paso a paso de cheakout paso 6 (ver la evidencia en la ruta Evidencias\\Paso a Paso Cheackout)")
        generic_helpers.save_screenshot('Evidencias\\Orden Completa', 'Confirm_order')
        logger.info("Evidencia -- Toma de Evidencia de Orden Completa (ver la evidencia en la ruta Evidencias\\Orden completa)")

    def click_confirm_orden(self):
        generic_helpers = GenericHelpers(self.driver)
        self.sl.wait_and_click(self.BTN_CONFIRM_ORDER)
        generic_helpers.save_screenshot('Evidencias\\Paso a Paso Cheackout', 'Paso7_mgs_order_success')
        logger.info("Checkout -- Toma de Evidencia de paso a paso de cheakout paso 7 (ver la evidencia en la ruta Evidencias\\Paso a Paso Cheackout)")
        self.sl.wait_and_click(self.BTN_CONTINUE_SUCCESS_ORDER)
        logger.info("Checkout -- Se confirma la orden y se da click en Continuar")











