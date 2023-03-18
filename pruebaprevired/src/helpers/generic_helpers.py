from datetime import datetime
import os
import logging as logger
import random
import string


class GenericHelpers:

    def __init__(self, driver):
        self.driver = driver

    def save_screenshot(self, path_name, screenshot_name):

            # Crear la carpeta si no existe
            if not os.path.exists(path_name):
                os.makedirs(path_name)

            # Tomar la captura de pantalla y guardarla en la carpeta especificada
            timestamp = datetime.now().strftime("%Y-%m-%d_%H-%M-%S")
            file_name = f"{screenshot_name}_{timestamp}.png"
            file_path = os.path.join(path_name, file_name)
            self.driver.save_screenshot(file_path)
            # Devolver el nombre completo de la captura de pantalla
            return file_path

    def generate_random_email_and_password(self, domain=None, email_prefix=None):

        if not domain:
            domain = 'prev.com'
        if not email_prefix:
            email_prefix = 'test-user'

        random_email_string_length = 10
        random_string = ''.join(random.choices(string.ascii_lowercase, k=random_email_string_length))

        email = email_prefix + '_' + random_string + '@' + domain

        logger.info(f"Se genero email random {email}")

        rand_psswd_length = 20
        rand_password = ''.join(random.choices(string.ascii_letters, k=rand_psswd_length))

        random_info = {"email": email, "password": rand_password}

        return random_info