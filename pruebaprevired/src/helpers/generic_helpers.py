import os
from datetime import date


class GenericHelpers:

    def __init__(self, driver):
        self.driver = driver

    def save_screenshot(self, path_name, screenshot_name):

            # Crear la carpeta si no existe
            if not os.path.exists(path_name):
                os.makedirs(path_name)

            # Tomar la captura de pantalla y guardarla en la carpeta especificada
            file_name = screenshot_name + ".png"
            file_path = os.path.join(path_name, file_name)
            self.driver.save_screenshot(file_path)
            # Devolver el nombre completo de la captura de pantalla
            return file_path