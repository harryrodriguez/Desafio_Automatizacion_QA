import logging as logger
import os
import pytest
from selenium import webdriver
import logging.config


@pytest.fixture(scope="class")
def init_driver(request):
    supported_browsers = ['chrome', 'ch', 'headlesschrome', 'firefox', 'ff']
    browser = os.environ.get('BROWSER', None)
    if not browser:
        raise Exception("La variable de entorno 'BROWSER' debe estar reteada.")
    browser = browser.lower()
    if browser not in supported_browsers:
        raise Exception(f"El navegador proporcionado  '{browser}' no es uno de los admitidos."
                        f"Los admitidos son: {supported_browsers}")
    if browser in ('chrome', 'ch'):
        driver = webdriver.Chrome()
    elif browser in ('firefox', 'ff'):
        driver = webdriver.Firefox()
    request.cls.driver = driver
    yield
    #driver.quit

@pytest.fixture(scope='session', autouse=True)
def setup_logging():
    logging.config.fileConfig('logging.ini')
    logger = logging.getLogger(__name__)
    logger.info('Logging configured')