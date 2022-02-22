# Desafío_Automatización_QA

Realice el siguiente flujo utilizando Selenium con el lenguaje de programación que prefiera.

* Ingresar a [opencart.abstracta.us](http://opencart.abstracta.us/index.php?route=common/home)
* Añadir al carro de compras un Ipod Classic
* Añadir al carro de compras un Imac
* Proceder a realizar la compra
* Realizar login con credenciales obtenidas de un archivo externo a elección (Basta que sea un email con estructura válida y contraseña)
* Crear una cuenta
* Continuar con la compra y llegar a la orden completa
* Visitar el historial de órdenes y validar resumen de orden 
* Cerrar sesión

# Validaciones Mínimas
* Tomar evidencia de cada producto añadido al carro
* Validar que los artículos en el carro sean Ipod Classic y Imac
* Evidencia de creación de la cuenta
* Evidencia de paso a paso del checkout
* Validar que despacho y costo sea = Flat Shipping Rate - $5.00
* Evidencia de costo final de la orden
* Evidencia de orden completa
* Evidencia de apartado "Order History" y validar que el estado de la compra se encuentre en estado "Pending"
* Validar datos de dirección de pago v/s los ingresados al crear la cuenta

# Punto Extra
* "Comprar un monitor Apple Cinema 30'' con las siguientes opciones disponibles:
  - Radio = Large (+30.00)
  - Checkbox múltiple = 2 (+20.00) y 4 (+40.00)
  - Texto = Test_1
  - Select = Yellow (+2.00)
  - TextArea = Data de prueba
  - Archivo = Subir archivo .jpg o .png a elección
  - Fecha = Calendario -> 2022-01-26
  - Tiempo = Reloj -> 17:25
  - Fecha y reloj = Calendario y reloj -> 2021-12-24 23:55
  - Cantidad = 2"
* Se ponderará la cantidad de valores ingresados en duro y la documentación del código.

# Entregables
* Archivo de entrada de data para la ejecución de la automatización
* Archivo/s de salida (Reporte, log, evidencias tomadas)
* La solución debe contener un README.md con la documentación de la automatización.
* Pre-requisitos
* Instrucciones para ejecutar
* Detalle Flujo
* Debe ser enviada vía un pull request a este repositorio [Desafío Automatización](https://github.com/Previred-QA/Desarfio_Automatizacion_QA)
* En el detalle del commit debes indicar los siguientes datos (Nombre Completo y Correo Electrónico)

# Documentacion complementaria :

# Entorno de desarrollo / Pre-requisitos

* LENGUAJE DE PROGRAMACION : JAVA + SELENIUM + CUCUMBER

* COMPONENTES: JDK – JVM – JRE 

* IDE: Visual Studio Code / Intellij

* WEB DRIVER: CHROMEDRIVER

* GESTIÓN DE DEPENDENCIAS: GRADLE (Building Tools)

* EXTENSIONES: 

•	GRADLE LANGUAGE SUPPORT
•	GRADLE TASKS
•	Cucumber (Gherkin) Full Support
•	Snippets and Syntax Highlight for Gherkin (Cucumber)

* VARIABLES DE ENTORNO: 

•	GRADLE_HOME = C:\gradle
•	JAVA_HOME = C:\Program Files\Java\jdk-15.0.2

PATH:

•	C:\gradle\bin
•	%JAVA_HOME%\bin
•	C:\chromedriver

# Estructura del proyecto:

/dataTest : Archivo externo para lectura de creacion de cuenta e imagen para upload en punto extra.
/Documentacion complementaria : Video de muestra de la ejecucion de la prueba.
src/test/java: Lógica y código donde se encuentra las clases de páginas, definición de pasos y configuracion de runner.
src/test/resources: features 
test-ouput/HtmlReport : Informe de ejecucion de features y sus scenarios
test-ouput/LoggerReport : Log de ejecucion de pruebas
test-ouput/Screenshots_test : Evidencias de capturas de pasos.

# Instrucciones de ejecucion 

comando : gradle clean / gradle build via TERMINAL.

# Detalle del flujo

Mediante el lenguaje java y la integración de selenium, se realizan pruebas sobre portal openabstracta donde se valida a nivel front funcionalidades básicas asociadas al enfoque que tiene el sitio, para lo anterior se utiliza un lenguaje de programacion orientado a objetos realizando modularización y validaciones de los ingresos a través de funciones que provee el framework.







