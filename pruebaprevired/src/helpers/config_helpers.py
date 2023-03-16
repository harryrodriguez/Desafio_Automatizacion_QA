import os


def get_base_url():

    env = os.environ.get('ENV', 'test')
    if env.lower() == 'test':
        return 'http://opencart.abstracta.us/index.php?route=common/home'
    elif env.lower() == 'prod':
        return '' # Aqui url de produccion
    else:
        raise Exception(f"Unknown environment: {env}")