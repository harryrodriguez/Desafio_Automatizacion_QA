# Prueba técnica de automatización QA

Esta es una solución de automatización QA que se utiliza para realizar pruebas en la plataforma Opencart.abstracta.us. La solución se ha creado utilizando `Selenium WebDriver y Python` Esta solución realiza las siguientes acciones:

  - Ingresa a Opencart.abstracta.us
  - Añade al carro de compras un Ipod Classic y un Imac
  - Realiza el proceso de checkout
  - Realizar login con credenciales obtenidas de un archivo externo a elección 
  - Crea una cuenta y procede con la compra
  - Visita el historial de órdenes y valida el resumen de la orden
  - Cierra sesión

## Configuración

Para utilizar esta solución de automatización, se deben tener instalados los siguientes programas:

```
Python = 3.10.8
Selenium WebDriver = 4.5.0
Pytest = 7.2.1
ChromeDriver = Version complatible con la version de Chrome de la maquina
Un IDE (Pycharm)
faker
python-dotenv
```

## Estructura del proyecto

El proyecto sigue la estructura de Page Object Model (POM), dividiéndose en cinco carpetas principales:

- `pruebaprevired\pruebaprevired\test`: contiene la prueba  de automatización solicitada en la prueba, contiene el siguiente subdirectorio:

  - `end_to_end`: contiene la prueba de automatización, que utilizan los archivos de página para interactuar con la interfaz de usuario y realizar las pruebas necesarias.

- `pruebaprevired\pruebaprevired\src`: contiene los archivos de página que representan los elementos de la interfaz de usuario y las acciones que se pueden realizar en ella, contiene los siguientes subdirectorios:

  - `pages`: Carpeta que contiene los archivos de página, que representan los elementos de la interfaz de usuario y las acciones que se pueden realizar en ella. Cada archivo de página debe tener un nombre que refleje el nombre de la página en la que se encuentra. Por ejemplo, si estamos en la página de inicio de sesión, el archivo se llamaría "LoginPage.py". Ademas contiene una subcarpeta llamada "locators" donde se encuetran todas las varibles que se van a utilizar en las pages conrrespondientes.

  - `helpers`: Carpeta que contiene clases de utilidad que se utilizan en todo el proyecto, como las clases de configuración. esta carpeta es divida en 2 subdirectorios que son "config_helpers" y "generic_helpers". en la carpeta "config_helpers" tenemos una funcion para trabajar la url con variables de entorno y en la carpeta "generic_helpers" tenemos funciones de utilidad como hacer screenshot o generar randoms email.

  - `SeleniumExtended` : Archivo que contiene funciones de Selenium que son de utilidad en toda la ejecucion de proyecto para la reultilizacion de codigo.

- `pruebaprevired\pruebaprevired\log` : contiene un log donde describe los pasos realizados por al pruebas ademas de algunas validacones solicitadas, contiene el siguiente subdirectorio:

  - `test.log`: Archivo donde se encribe todo el flujo que va haciendo el test, tambien se agregan la informacion de las validaciones solicitadas para la prueba.

- `pruebaprevired\pruebaprevired`: contiene un archivo util para la configuracion de browser y logging

  - `conftest.py`: contiene funciones utiles para  inicializar un controlador de Selenium en un navegador o  usar logging para le generacion de log


- `pruebaprevired` : contiene los siguientes archivos de configuración y adicionales:

    - `Evidencias` : Archivo que contiene varios subdirectorios con todas las evidencias en screenshot con su nombre, fecha y hora de ejecucion.
    - `.env.example` :  Contiene las varibles de email y password, para la prueba de incio de sesion
    - `datos_items_busqueda.csv` : Archivo externo usado para buscar los items que vamos a buscar en la pagina
    - `logging.ini`: Contiene la configuracion para manejar logging 
    - `pytest.ini`: Contiene la configuracion para ignorar las alertas PytestUnknownMarkWarning debido a que se usa pytest con etiquetas personalizadas   como test_001
    - `requirements.txt`: Contiene todas las dependencias necesarias
    - `Documentacion_evidencia` : Contiene la documentacion de los archivos de evidencia y log, referencia [Documentacion Evidencia](./Documentacion_evidencia.md) 
    

## Resultados y validaciones

Las siguientes validaciones mínimas se han incluido en la solución de automatización:

- Evidencia de cada producto añadido al carro (Ver en Carpeta Evidencia)
- Validación de que los artículos en el carro son Ipod Classic y Imac (Ver en Carpeta - Evidencia)
- Evidencia de creación de la cuenta (Ver en Carpeta Evidencia)
- Evidencia de paso a paso del checkout (Ver en Carpeta Evidencia) (Ver en test.log)
- Validación de que despacho y costo es Flat Shipping Rate - $5.00 
- Evidencia de costo final de la orden 
- Evidencia de orden completa (Ver en Carpeta Evidencia)
- Evidencia de apartado "Order History" y validación de que el estado de la compra se encuentre en estado "Pending".  (Ver en test.log)
- Validación de datos de dirección de pago v/s los ingresados al crear la cuenta (Ver en Carpeta Evidencia) y en (Ver en test.log)

## Limitaciones

 - El proceso de checkout solo funciona para despacho "Flat Shipping Rate - $5.00"
 - La solución no incluye pruebas de automatización para otros tipos de despacho
 - La solución no incluye pruebas de automatización para otras secciones del sitio web

## Intrucciones para ejecutar

  Seguir las siguientes instrucciones para ejecutar la prueba 
  - Abre PyCharm y asegúrate de que tienes un proyecto existente donde deseas ejecutar el test automatizado.
  - Abre una terminal dentro de PyCharm y navega hasta el directorio donde se encuentra el archivo de prueba.
  - Asegúrate de que tienes todas las dependencias necesarias instaladas. (ver archivo `requirements.txt`)
  - Asegúrate de que tienes configurado el driver del navegador que deseas utilizar. Por ejemplo, si deseas utilizar Chrome, asegúrate de que tienes el driver de Chrome descargado y configurado en tu sistema. Puedes descargar el driver de Chrome desde la página oficial de Selenium.
  - En la terminal, configura el navegador que deseas utilizar como variable de entorno. Puedes hacer esto utilizando el siguiente comando para Mac/Linux: `export BROWSER=chrome` o el siguiente comando para Windows: `set BROWSER=chrome`. Si deseas utilizar otro navegador, cambia el valor de la variable BROWSER.
  - Ejecuta el comando 
  ```shell
     pytest -m <nombre de la marca> (en este caso es test_001) -s
  ```
   Para ejecutar el test automatizado. Asegúrate de reemplazar `<nombre de la marca>` con el nombre de la marca que hayas utilizado en tu archivo de prueba para identificar los casos de prueba específicos que deseas ejecutar. El argumento `-s` le permite a pytest mostrar la salida de los logs de la consola.

  Una vez que hayas ejecutado el comando, Pytest ejecutará el archivo de prueba que hayas creado y te mostrará los resultados de la ejecución en la consola de PyCharm ademas de el log y las evidencias antes mencionadas.  
