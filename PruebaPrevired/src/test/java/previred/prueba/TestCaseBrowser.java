package previred.prueba;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class TestCaseBrowser {
	//Variables
	public WebDriver driver;
	public FunctionsSelenium functionCustom = new FunctionsSelenium();  
	 
  @BeforeTest
  public void launchapp() throws IOException {	   
	  // WebDriverManager.chromedriver().setup();
	   //driver = new ChromeDriver();
  }
  
  @BeforeMethod
  public void handleTestMethodName(Method method)
  {
	  DateFormat dateFormat = new SimpleDateFormat("yyyymmdd_HHmmss");
	  functionCustom.nameTest = method.getName(); 
	  FunctionsSelenium.carpeta = functionCustom.nameTest + "_" + dateFormat.format(new Date());
	  
	  WebDriverManager.chromedriver().setup();
	   driver = new ChromeDriver();
  }
  
  @AfterMethod
  public void after_method() {
	  driver.quit();
  }

  @AfterTest
  public void terminatetest() {
	  //driver.quit();
  }  
  
  @AfterSuite
  public void afterSuite() throws IOException {
	  functionCustom.openReportTest();
  }
  
  
  @Test
  public void FlujoCompra() {
	  //Ingreso a la URL
	  functionCustom.openNavigator(driver, "http://opencart.abstracta.us/index.php");
	  
	  //Agrego el primer producto al carro
	  functionCustom.vpAssertExistElement(driver, "Your Store", "Se valida la presencia del texto Your Store dentro de la web.");
	  functionCustom.clickAndText(driver, "//input[@placeholder='Search']", "Ipod Classic", "Se ingresa el producto a buscar.");
      functionCustom.clickElement(driver, "//button[@class='btn btn-default btn-lg']", "Se presiona sobre el botón buscar.");
      functionCustom.vpAssertExistElement(driver, "//img[@title='iPod Classic']", "Se valida la presencia de la imagen dentro de la web.");
      
      functionCustom.clickElement(driver, "//img[@title='iPod Classic']", "Se presiona sobre el cuadro de texto buscar.");
      functionCustom.vpAssertExistElement(driver, "iPod Classic", "Se valida la presencia del texto iPod Classic dentro de la web.");
      
      functionCustom.clickElement(driver, "//button[@id='button-cart']", "Se presiona sobre el botón agregar al carro.");
      functionCustom.vpAssertExistElement(driver, "//div[@class='alert alert-success alert-dismissible']", "Se valida la presencia del texto Success dentro de la web.");
    
      //Agrego el segundo producto al carro
	  functionCustom.clickAndText(driver, "//input[@placeholder='Search']", "iMac", "Se ingresa el producto a buscar.");
      functionCustom.clickElement(driver, "//button[@class='btn btn-default btn-lg']", "Se presiona sobre el botón buscar.");
      functionCustom.vpAssertExistElement(driver, "//img[@title='iMac']", "Se valida la presencia de la imagen dentro de la web.");
      
      functionCustom.clickElement(driver, "//img[@title='iMac']", "Se presiona sobre el cuadro de texto buscar.");
      functionCustom.vpAssertExistElement(driver, "iPod Classic", "Se valida la presencia del texto iPod Classic dentro de la web.");
      
      functionCustom.clickElement(driver, "//button[@id='button-cart']", "Se presiona sobre el botón agregar al carro.");
      functionCustom.vpAssertExistElement(driver, "//div[@class='alert alert-success alert-dismissible']", "Se valida la presencia del texto Success dentro de la web.");
    
      //Visualizo el Carro de Compra
      functionCustom.clickElement(driver, "//span[@id='cart-total']", "Se presiona sobre el botón Items del carro.");
      functionCustom.vpAssertExistElement(driver, "//strong[normalize-space()='View Cart']", "Se valida la presencia del texto View Cart dentro de la web.");
      functionCustom.clickElement(driver, "//strong[normalize-space()='View Cart']", "Se presiona sobre el link View Cart.");
      functionCustom.vpAssertExistElement(driver, "Use Gift Certificate", "Se valida la presencia del texto Use Gift Certificate dentro de la web.");
      
      functionCustom.vpAssertExistElement(driver, "//td[normalize-space()='Product Name']/ancestor::table//tbody//td[contains(normalize-space(),'iMac')]", "Se valida la presencia del texto iMac dentro de la web.");
      functionCustom.vpAssertExistElement(driver, "//td[normalize-space()='Product Name']/ancestor::table//tbody//td[contains(normalize-space(),'iPod Classic')]", "Se valida la presencia del texto iPod Classic dentro de la web.");
    
      //Se va a la página de checkout
      functionCustom.clickElement(driver, "//a[@class='btn btn-primary']", "Se presiona sobre el botón checkout del carro.");
      functionCustom.vpAssertExistElement(driver, "//a[@class='accordion-toggle']", "Se valida la presencia del elemento Step1  dentro de la web.");
      
      //Se ingresan las credenciales del login
      functionCustom.clickAndText(driver, "//input[@id='input-email']", "angelinaleivamartinez@gmail.com", "Se ingresa el texto angelinaleivamartinez@gmail.com.");
      functionCustom.clickAndText(driver, "//input[@id='input-password']", "Pass1234", "Se ingresa el texto Pass1234.");
      functionCustom.clickElement(driver, "//input[@id='button-login']", "Se presiona sobre el botón login."); 
      functionCustom.vpAssertExistElement(driver, "//input[@id='input-payment-firstname']", "Se valida la presencia del cuadro de texto first name  dentro de la web.");
      
      //Se ingresa el detalle de la facturación
      functionCustom.clickElement(driver, "//label[normalize-space()='I want to use a new address']", "Se presiona sobre el radio button new address.");
      functionCustom.clickAndText(driver, "//input[@id='input-payment-firstname']", "Ange", "Se ingresa el texto Ange.");
      functionCustom.clickAndText(driver, "//input[@id='input-payment-lastname']", "Leiva", "Se ingresa el texto Leiva.");
      functionCustom.clickAndText(driver, "//input[@id='input-payment-company']", "Personal", "Se ingresa el texto Personal.");
      functionCustom.clickAndText(driver, "//input[@id='input-payment-address-1']", "las lilas 1234", "Se ingresa el texto las lilas 1234.");
      functionCustom.clickAndText(driver, "//input[@id='input-payment-address-2']", "depto 111", "Se ingresa el texto depto 111.");
      functionCustom.clickAndText(driver, "//input[@id='input-payment-city']", "Santiago", "Se ingresa el texto Santiago.");
      functionCustom.clickAndText(driver, "//input[@id='input-payment-postcode']", "9261000", "Se ingresa el texto 9261000.");
      functionCustom.selectElement(driver, "//select[@id='input-payment-country']", "Chile", 0, "Se selecciona la opción Chile.");
      functionCustom.selectElement(driver, "//select[@id='input-payment-zone']", "Coquimbo", 0, "Se selecciona la opción Coquimbo.");
      functionCustom.clickElement(driver, "//input[@id='button-payment-address']", "Se presiona sobre el botón Continue.");
      functionCustom.vpAssertExistElement(driver, "//div[@id='shipping-existing']//select[@name='address_id']", "Se valida la presencia del elemento Detalle de envio  dentro de la web.");
    
      //Se presiona continuar en el detalle de la dirección de envio
      functionCustom.clickElement(driver, "//input[@id='button-shipping-address']", "Se presiona sobre el botón Continue.");
      functionCustom.vpAssertExistElement(driver, "//p[contains(text(),'Please select the preferred shipping method to use')]", "Se valida la presencia del texto Please select dentro de la web.");
      
      //Se selecciona el metodo de envio
      functionCustom.clickElement(driver, "//input[@id='button-shipping-method']", "Se presiona sobre el botón Continue.");
      functionCustom.vpAssertExistElement(driver, "//p[contains(text(),'Please select the preferred payment method to use ')]", "Se valida la presencia del texto preferred payment dentro de la web.");
      
      //Se selecciona el metodo de pago
      functionCustom.clickElement(driver, "//label[normalize-space()='Cash On Delivery']", "Se presiona sobre el radio button Cash On Delivery .");
      functionCustom.clickElement(driver, "//input[@name='agree']", "Se presiona sobre el botón terminos y condiciones.");
      functionCustom.clickElement(driver, "//input[@id='button-payment-method']", "Se presiona sobre el botón Continue.");
      functionCustom.vpAssertExistElement(driver, "//td[normalize-space()='Product Name']", "Se valida la presencia del texto Product Name dentro de la web.");
      
      
      //Se confirma la Orden
      functionCustom.clickElement(driver, "//input[@id='button-confirm']", "Se presiona sobre el botón .");
      functionCustom.vpAssertExistElement(driver, "//h1[normalize-space()='Your order has been placed!']", "Se valida la presencia del texto Your order has been placed dentro de la web.");
      
      //Se hace el cierre de sesion
      functionCustom.clickElement(driver, "//span[normalize-space()='My Account']", "Se presiona sobre el texto My Account.");
      functionCustom.vpAssertExistElement(driver, "//a[normalize-space()='Logout']", "Se valida la presencia del elemento Logout dentro de la web.");
      
      functionCustom.clickElement(driver, "//a[normalize-space()='Logout']", "Se presiona sobre el link Logout.");
      functionCustom.vpAssertExistElement(driver, "//p[contains(text(),'You have been logged off your account. It is now s')]", "Se valida la presencia del texto You have been logged off dentro de la web.");
   
  }
  
  
  @Test
  public void CrearCuenta() {
	  String mail = functionCustom.generateEmail();
	  
	  //Ingreso a la URL
	  functionCustom.openNavigator(driver, "http://opencart.abstracta.us/index.php");
	  
	  //Ingreso al apartado de registar
	  functionCustom.vpAssertExistElement(driver, "Your Store", "Se valida la presencia del texto Your Store dentro de la web.");
	  functionCustom.clickElement(driver, "//span[normalize-space()='My Account']", "Se presiona sobre el texto My Account.");
      functionCustom.vpAssertExistElement(driver, "//a[normalize-space()='Register']", "Se valida la presencia del elemento Register dentro de la web.");
      
      functionCustom.clickElement(driver, "//a[normalize-space()='Register']", "Se presiona sobre el link Register.");
      functionCustom.vpAssertExistElement(driver, "//legend[normalize-space()='Your Personal Details']", "Se valida la presencia del texto Your Personal Details dentro de la web.");
      
      //Se completan los datos personales
      functionCustom.clickAndText(driver, "//input[@id='input-firstname']", "Ange", "Se ingresa el texto Ange.");      
      functionCustom.clickAndText(driver, "//input[@id='input-lastname']", "Leiva", "Se ingresa el texto Leiva.");
      functionCustom.clickAndText(driver, "//input[@id='input-email']", mail, "Se ingresa el texto " + mail + ".");      
      functionCustom.clickAndText(driver, "//input[@id='input-telephone']", "975550030", "Se ingresa el texto 975550030.");
      
      //Se introduce la pass
      functionCustom.clickAndText(driver, "//input[@id='input-password']", "Pass12345", "Se ingresa el texto Pass12345.");      
      functionCustom.clickAndText(driver, "//input[@id='input-confirm']", "Pass12345", "Se ingresa el texto Pass12345.");
      
      
      //Se aceptan los terminos y condiciones y se presiona el botón Continue
      functionCustom.clickElement(driver, "//input[@name='agree']", "Se presiona sobre el checkbox Acepto terminos.");
      functionCustom.clickElement(driver, "//input[@value='Continue']", "Se presiona sobre el botón Continue.");
      functionCustom.vpAssertExistElement(driver, "//p[contains(text(),'Congratulations! Your new account has been success')]", "Se valida la presencia del texto Congratulations dentro de la web.");
      
      //Se hace el cierre de sesion
      functionCustom.clickElement(driver, "//span[normalize-space()='My Account']", "Se presiona sobre el texto My Account.");
      functionCustom.vpAssertExistElement(driver, "//a[normalize-space()='Logout']", "Se valida la presencia del elemento Logout dentro de la web.");
      
      functionCustom.clickElement(driver, "//a[normalize-space()='Logout']", "Se presiona sobre el link Logout.");
      functionCustom.vpAssertExistElement(driver, "//p[contains(text(),'You have been logged off your account. It is now s')]", "Se valida la presencia del texto You have been logged off dentro de la web.");
       
  }
  
  
  @Test
  public void VerHistorialOrdenes() {
	  //Ingreso a la URL
	  functionCustom.openNavigator(driver, "http://opencart.abstracta.us/index.php");
	  
	  //Ingreso al apartado de Login
	  functionCustom.vpAssertExistElement(driver, "Your Store", "Se valida la presencia del texto Your Store dentro de la web.");
	  functionCustom.clickElement(driver, "//span[normalize-space()='My Account']", "Se presiona sobre el texto My Account.");
	  functionCustom.vpAssertExistElement(driver, "//ul[@class='dropdown-menu dropdown-menu-right']//a[contains(text(),'Login')]", "Se valida la presencia del texto Login dentro de la web.");
	  
	  functionCustom.clickElement(driver, "//ul[@class='dropdown-menu dropdown-menu-right']//a[contains(text(),'Login')]", "Se presiona sobre el botón .");
	  functionCustom.vpAssertExistElement(driver, "//input[@id='input-email']", "Se valida la presencia del cuadro de texto email dentro de la web.");
	  
      //Se ingresan las credenciales del login
      functionCustom.clickAndText(driver, "//input[@id='input-email']", "angeleivamartinez1203@gmail.com", "Se ingresa el texto angelinaleivamartinez@gmail.com.");
      functionCustom.clickAndText(driver, "//input[@id='input-password']", "Pass1234", "Se ingresa el texto Pass1234.");
      functionCustom.clickElement(driver, "//input[@value='Login']", "Se presiona sobre el botón login."); 
      functionCustom.vpAssertExistElement(driver, "//h2[normalize-space()='My Affiliate Account']", "Se valida la presencia del cuadro de texto My Affiliate Account dentro de la web.");
      
      //Ingreso a las ordenes
      functionCustom.vpAssertExistElement(driver, "Your Store", "Se valida la presencia del texto Your Store dentro de la web.");
	  functionCustom.clickElement(driver, "//span[normalize-space()='My Account']", "Se presiona sobre el texto My Account.");
	  functionCustom.vpAssertExistElement(driver, "//ul[@class='dropdown-menu dropdown-menu-right']//a[contains(text(),'Order History')]", "Se valida la presencia del texto Order History dentro de la web.");
	  
	  functionCustom.clickElement(driver, "//ul[@class='dropdown-menu dropdown-menu-right']//a[contains(text(),'Order History')]", "Se presiona sobre el botón Order History.");
	  functionCustom.vpAssertExistElement(driver, "//td[normalize-space()='Order ID']", "Se valida la presencia del texto Order ID dentro de la web.");
	  
	  //Selecciono la primera orden
	  functionCustom.clickElement(driver, "//tbody/tr[1]//i", "Se presiona sobre el botón view.");
	  functionCustom.vpAssertExistElement(driver, "//td[normalize-space()='Order Details']", "Se valida la presencia del texto Order Details dentro de la web.");
	  
	  //Valido los datos de la orden
	  functionCustom.vpAssertExistElement(driver, "//td[text()='Payment Address']//ancestor::table//tbody//td[1][contains(normalize-space(),'Ange Leiva')]", "Se valida la presencia del texto Ange leiva dentro de la web.");
	  functionCustom.vpAssertExistElement(driver, "//td[text()='Payment Address']//ancestor::table//tbody//td[1][contains(normalize-space(),'Personal')]", "Se valida la presencia del texto Personal dentro de la web.");
	  functionCustom.vpAssertExistElement(driver, "//td[text()='Payment Address']//ancestor::table//tbody//td[1][contains(normalize-space(),'las lilas 1234')]", "Se valida la presencia del texto las lilas 1234 dentro de la web.");
	  functionCustom.vpAssertExistElement(driver, "//td[text()='Payment Address']//ancestor::table//tbody//td[1][contains(normalize-space(),'depto 111')]", "Se valida la presencia del texto depto 111 dentro de la web.");
	  functionCustom.vpAssertExistElement(driver, "//td[text()='Payment Address']//ancestor::table//tbody//td[1][contains(normalize-space(),'Santiago 9261000')]", "Se valida la presencia del texto Santiago 9261000 dentro de la web.");
	  functionCustom.vpAssertExistElement(driver, "//td[text()='Payment Address']//ancestor::table//tbody//td[1][contains(normalize-space(),'Coquimbo')]", "Se valida la presencia del texto Coquimbo dentro de la web.");
	  functionCustom.vpAssertExistElement(driver, "//td[text()='Payment Address']//ancestor::table//tbody//td[1][contains(normalize-space(),'Chile')]", "Se valida la presencia del texto Chile dentro de la web.");
	  
	  functionCustom.vpAssertExistElement(driver, "//td[text()='Product Name']//ancestor::table//tbody//td[contains(normalize-space(),'iMac')]", "Se valida la presencia del texto iMac dentro de la web.");
	  functionCustom.vpAssertExistElement(driver, "//td[text()='Product Name']//ancestor::table//tbody//td[contains(normalize-space(),'iPod Classic')]", "Se valida la presencia del texto iPod Classic dentro de la web.");
	  functionCustom.vpAssertExistElement(driver, "//td[text()='Product Name']//ancestor::table//tbody//td[normalize-space()='iMac']/parent::tr/td[5][contains(normalize-space(),'$100.00')]", "Se valida la presencia del texto $100.00 dentro de la web.");
	  functionCustom.vpAssertExistElement(driver, "//td[text()='Product Name']//ancestor::table//tbody//td[normalize-space()='iPod Classic']/parent::tr/td[5][contains(normalize-space(),'$100.00')]", "Se valida la presencia del texto $100.00 dentro de la web.");
	  functionCustom.vpAssertExistElement(driver, "//tfoot//td[normalize-space()='Flat Shipping Rate']/following-sibling::td[contains(normalize-space(),'$5.00')]", "Se valida la presencia del texto $5.00 dentro de la web.");
	  functionCustom.vpAssertExistElement(driver, "//tfoot//td[normalize-space()='Total']/following-sibling::td[contains(normalize-space(),'$205.00')]", "Se valida la presencia del texto $205.00 dentro de la web.");
	  
	  functionCustom.vpAssertExistElement(driver, "//td[normalize-space()='Status']/ancestor::table//tbody//td[2][contains(normalize-space(),'Pending')]", "Se valida la presencia del texto Pending dentro de la web.");
      
      //Se hace el cierre de sesion
      functionCustom.clickElement(driver, "//span[normalize-space()='My Account']", "Se presiona sobre el texto My Account.");
      functionCustom.vpAssertExistElement(driver, "//a[normalize-space()='Logout']", "Se valida la presencia del elemento Logout dentro de la web.");
      
      functionCustom.clickElement(driver, "//a[normalize-space()='Logout']", "Se presiona sobre el link Logout.");
      functionCustom.vpAssertExistElement(driver, "//p[contains(text(),'You have been logged off your account. It is now s')]", "Se valida la presencia del texto You have been logged off dentro de la web.");
   
  }
  
  
  @Test
  public void ComprarMonitorApple() {
	//Ingreso a la URL
	  functionCustom.openNavigator(driver, "http://opencart.abstracta.us/index.php");
	  
	  //Agrego el primer producto al carro
	  functionCustom.vpAssertExistElement(driver, "Your Store", "Se valida la presencia del texto Your Store dentro de la web.");
	  functionCustom.clickAndText(driver, "//input[@placeholder='Search']", "Apple Cinema", "Se ingresa el producto a buscar.");
      functionCustom.clickElement(driver, "//button[@class='btn btn-default btn-lg']", "Se presiona sobre el botón buscar.");
      functionCustom.vpAssertExistElement(driver, "//img[@title='Apple Cinema 30\"']", "Se valida la presencia de la imagen dentro de la web.");
      
      functionCustom.clickElement(driver, "//img[@title='Apple Cinema 30\"']", "Se presiona sobre la imagen apple cinema.");
      functionCustom.vpAssertExistElement(driver, "Apple Cinema 30\"", "Se valida la presencia del texto Apple Cinema 30\" dentro de la web.");
      
      //Se agregan las caracteristicas
      functionCustom.clickElement(driver, "//input[@name='option[218]']", "Se presiona sobre el radio button Large.");
      functionCustom.clickElement(driver, "//input[@name='option[223][]' and @value='10']", "Se presiona sobre el checkbox 3.");
      functionCustom.clickElement(driver, "//input[@name='option[223][]' and @value='11']", "Se presiona sobre el botón checkbox 4.");
      functionCustom.clickAndText(driver, "//input[@id='input-option208']", "Test_1", "Se ingresa el texto Test_1.");
      functionCustom.selectElement(driver, "//select[@id='input-option217']", "2", 1, "Se selecciona el valor Yellow (+$2.00).");
      functionCustom.clickAndText(driver, "//textarea[@id='input-option209']", "Data de prueba", "Se ingresa el texto Data de prueba.");
      functionCustom.vpAssertExistElement(driver, "//textarea[@id='input-option209']", "Se valida la presencia del elemento textarea dentro de la web.");
      functionCustom.uploadFile(driver, "//button[@id='button-upload222']", "marge.png", "Se sube un archivo marge.png.");
      functionCustom.presionarEnter(3000);
      
      //Se selecciona la fecha
      functionCustom.clickElement(driver, "//div[@class='input-group date']//i[@class='fa fa-calendar']", "Se presiona sobre el botón Calendario.");
      functionCustom.clickElement(driver, "//div[contains(@class,'picker-open')]//th[normalize-space()='February 2011']", "Se presiona sobre el botón Año.");
      functionCustom.clickElement(driver, "//div[contains(@class,'picker-open')]//th[normalize-space()='2011']", "Se presiona sobre el botón 2011.");
      functionCustom.clickElement(driver, "//div[contains(@class,'picker-open')]//div[@class='datepicker-years']//th[@class='next'][contains(text(),'›')]", "Se presiona sobre el botón Next.");
      functionCustom.clickElement(driver, "//div[contains(@class,'picker-open')]//div[@class='datepicker-years']//span[@class='year'][contains(text(),'2022')]", "Se presiona sobre el botón 2022.");
      functionCustom.clickElement(driver, "//div[contains(@class,'picker-open')]//div[@class='datepicker-months']//span[@class='month'][contains(text(),'Jan')]", "Se presiona sobre el botón Jan.");
      functionCustom.clickElement(driver, "//div[contains(@class,'picker-open')]//div[@class='datepicker-days']//td[@class='day'][contains(text(),'26')]", "Se presiona sobre el botón 26.");
      
      //Se selecciona la hora
      functionCustom.clickElement(driver, "//div[@class='input-group time']//i[@class='fa fa-calendar']", "Se presiona sobre el botón Calendario.");
      functionCustom.clickElement(driver, "//div[contains(@class,'picker-open')]//span[@class='timepicker-hour']", "Se presiona sobre el botón horas.");
      functionCustom.clickElement(driver, "//div[contains(@class,'picker-open')]//td[@class='hour' and contains(text(),'17')]", "Se presiona sobre el botón 17.");
      functionCustom.clickElement(driver, "//div[contains(@class,'picker-open')]//span[@class='timepicker-minute']", "Se presiona sobre el botón minutos.");
      functionCustom.clickElement(driver, "//div[contains(@class,'picker-open')]//td[@class='minute' and contains(text(),'25')]", "Se presiona sobre el botón 25.");
      functionCustom.clickElement(driver, "//div[@class='input-group time']//i[@class='fa fa-calendar']", "Se presiona sobre el botón Calendario.");
      
      //Selecciono la fecha y hora
      functionCustom.clickElement(driver, "//div[@class='input-group datetime']//i[@class='fa fa-calendar']", "Se presiona sobre el botón Calendario.");
      functionCustom.clickElement(driver, "//div[contains(@class,'picker-open')]//th[normalize-space()='February 2011']", "Se presiona sobre el botón Año.");
      functionCustom.clickElement(driver, "//div[contains(@class,'picker-open')]//th[normalize-space()='2011']", "Se presiona sobre el botón 2011.");
      functionCustom.clickElement(driver, "//div[contains(@class,'picker-open')]//div[@class='datepicker-years']//th[@class='next'][contains(text(),'›')]", "Se presiona sobre el botón Next.");
      functionCustom.clickElement(driver, "//div[contains(@class,'picker-open')]//div[@class='datepicker-years']//span[@class='year'][contains(text(),'2021')]", "Se presiona sobre el botón 2021.");
      functionCustom.clickElement(driver, "//div[contains(@class,'picker-open')]//div[@class='datepicker-months']//span[@class='month'][contains(text(),'Dec')]", "Se presiona sobre el botón Jan.");
      functionCustom.clickElement(driver, "//div[contains(@class,'picker-open')]//div[@class='datepicker-days']//td[@class='day'][contains(text(),'24')]", "Se presiona sobre el botón 24.");
    
      functionCustom.clickElement(driver, "//li[@class='picker-switch accordion-toggle']//a[@class='btn']", "Se presiona sobre el botón Calendario.");
      functionCustom.clickElement(driver, "//div[contains(@class,'picker-open')]//span[@class='timepicker-hour']", "Se presiona sobre el botón horas.");
      functionCustom.clickElement(driver, "//div[contains(@class,'picker-open')]//td[@class='hour' and contains(text(),'23')]", "Se presiona sobre el botón 23.");
      functionCustom.clickElement(driver, "//div[contains(@class,'picker-open')]//span[@class='timepicker-minute']", "Se presiona sobre el botón minutos.");
      functionCustom.clickElement(driver, "//div[contains(@class,'picker-open')]//td[@class='minute' and contains(text(),'55')]", "Se presiona sobre el botón 55.");
      functionCustom.clickElement(driver, "//div[@class='input-group datetime']//i[@class='fa fa-calendar']", "Se presiona sobre el botón Calendario.");
      
      //Ingreso la cantidad
      functionCustom.clickAndText(driver, "//input[@id='input-quantity']", "2", "Se ingresa el texto 2.");
      functionCustom.vpAssertExistElement(driver, "//input[@id='input-quantity']", "Se valida la presencia del cuadro de texto cantidad dentro de la web.");
      
      //Se agrega al carro
      functionCustom.clickElement(driver, "//button[@id='button-cart']", "Se presiona sobre el botón agregar al carro.");
      functionCustom.vpAssertExistElement(driver, "//div[@class='alert alert-success alert-dismissible']", "Se valida la presencia del texto Success dentro de la web.");
    
      //Visualizo el Carro de Compra
      functionCustom.clickElement(driver, "//span[@id='cart-total']", "Se presiona sobre el botón Items del carro.");
      functionCustom.vpAssertExistElement(driver, "//strong[normalize-space()='View Cart']", "Se valida la presencia del texto View Cart dentro de la web.");
      functionCustom.clickElement(driver, "//strong[normalize-space()='View Cart']", "Se presiona sobre el link View Cart.");
      functionCustom.vpAssertExistElement(driver, "Use Gift Certificate", "Se valida la presencia del texto Use Gift Certificate dentro de la web.");
      
      functionCustom.vpAssertExistElement(driver, "//td[normalize-space()='Product Name']/ancestor::table//tbody//td[contains(normalize-space(),'Apple Cinema 30\"')]", "Se valida la presencia del texto iMac dentro de la web.");
      functionCustom.vpAssertExistElement(driver, "//td[normalize-space()='Product Name']/ancestor::table//tbody//td[contains(normalize-space(),'Radio: Large')]", "Se valida la presencia del texto Radio: Large dentro de la web.");
      functionCustom.vpAssertExistElement(driver, "//td[normalize-space()='Product Name']/ancestor::table//tbody//td[contains(normalize-space(),'Checkbox: Checkbox 3')]", "Se valida la presencia del texto Checkbox: Checkbox 3 dentro de la web.");
      functionCustom.vpAssertExistElement(driver, "//td[normalize-space()='Product Name']/ancestor::table//tbody//td[contains(normalize-space(),'Checkbox: Checkbox 4')]", "Se valida la presencia del texto Checkbox: Checkbox 4 dentro de la web.");
      functionCustom.vpAssertExistElement(driver, "//td[normalize-space()='Product Name']/ancestor::table//tbody//td[contains(normalize-space(),'Text: Test_1')]", "Se valida la presencia del texto Text: Test_1 dentro de la web.");
      functionCustom.vpAssertExistElement(driver, "//td[normalize-space()='Product Name']/ancestor::table//tbody//td[contains(normalize-space(),'Select: Yellow')]", "Se valida la presencia del texto Select: Yellow dentro de la web.");
      functionCustom.vpAssertExistElement(driver, "//td[normalize-space()='Product Name']/ancestor::table//tbody//td[contains(normalize-space(),'Textarea: Data de prueba')]", "Se valida la presencia del texto Textarea: Data de prueba dentro de la web.");
      functionCustom.vpAssertExistElement(driver, "//td[normalize-space()='Product Name']/ancestor::table//tbody//td[contains(normalize-space(),'File: marge.png')]", "Se valida la presencia del texto File: marge.png dentro de la web.");
      functionCustom.vpAssertExistElement(driver, "//td[normalize-space()='Product Name']/ancestor::table//tbody//td[contains(normalize-space(),'Date: 2022-01-26')]", "Se valida la presencia del texto Date: 2022-01-26 dentro de la web.");
      functionCustom.vpAssertExistElement(driver, "//td[normalize-space()='Product Name']/ancestor::table//tbody//td[contains(normalize-space(),'Time: 17:25')]", "Se valida la presencia del texto Time: 17:25 dentro de la web.");
      functionCustom.vpAssertExistElement(driver, "//td[normalize-space()='Product Name']/ancestor::table//input[starts-with(@name,'quantity') and @value='2']", "Se valida la presencia del texto 2 asociado a la cantidad dentro de la web.");
    
      //Se va a la página de checkout
      functionCustom.clickElement(driver, "//a[@class='btn btn-primary']", "Se presiona sobre el botón checkout del carro.");
      functionCustom.vpAssertExistElement(driver, "//a[@class='accordion-toggle']", "Se valida la presencia del elemento Step1  dentro de la web.");
      
      //Se ingresan las credenciales del login
      functionCustom.clickAndText(driver, "//input[@id='input-email']", "angelinaleivamartinez@gmail.com", "Se ingresa el texto angelinaleivamartinez@gmail.com.");
      functionCustom.clickAndText(driver, "//input[@id='input-password']", "Pass1234", "Se ingresa el texto Pass1234.");
      functionCustom.clickElement(driver, "//input[@id='button-login']", "Se presiona sobre el botón login."); 
      functionCustom.vpAssertExistElement(driver, "//input[@id='input-payment-firstname']", "Se valida la presencia del cuadro de texto first name  dentro de la web.");
      
      //Se ingresa el detalle de la facturación
      functionCustom.clickElement(driver, "//label[normalize-space()='I want to use a new address']", "Se presiona sobre el radio button new address.");
      functionCustom.clickAndText(driver, "//input[@id='input-payment-firstname']", "Ange", "Se ingresa el texto Ange.");
      functionCustom.clickAndText(driver, "//input[@id='input-payment-lastname']", "Leiva", "Se ingresa el texto Leiva.");
      functionCustom.clickAndText(driver, "//input[@id='input-payment-company']", "Personal", "Se ingresa el texto Personal.");
      functionCustom.clickAndText(driver, "//input[@id='input-payment-address-1']", "las lilas 1234", "Se ingresa el texto las lilas 1234.");
      functionCustom.clickAndText(driver, "//input[@id='input-payment-address-2']", "depto 111", "Se ingresa el texto depto 111.");
      functionCustom.clickAndText(driver, "//input[@id='input-payment-city']", "Santiago", "Se ingresa el texto Santiago.");
      functionCustom.clickAndText(driver, "//input[@id='input-payment-postcode']", "9261000", "Se ingresa el texto 9261000.");
      functionCustom.selectElement(driver, "//select[@id='input-payment-country']", "Chile", 0, "Se selecciona la opción Chile.");
      functionCustom.selectElement(driver, "//select[@id='input-payment-zone']", "Coquimbo", 0, "Se selecciona la opción Coquimbo.");
      functionCustom.clickElement(driver, "//input[@id='button-payment-address']", "Se presiona sobre el botón Continue.");
      functionCustom.vpAssertExistElement(driver, "//div[@id='shipping-existing']//select[@name='address_id']", "Se valida la presencia del elemento Detalle de envio  dentro de la web.");
    
      //Se presiona continuar en el detalle de la dirección de envio
      functionCustom.clickElement(driver, "//input[@id='button-shipping-address']", "Se presiona sobre el botón Continue.");
      functionCustom.vpAssertExistElement(driver, "//p[contains(text(),'Please select the preferred shipping method to use')]", "Se valida la presencia del texto Please select dentro de la web.");
      
      //Se selecciona el metodo de envio
      functionCustom.clickElement(driver, "//input[@id='button-shipping-method']", "Se presiona sobre el botón Continue.");
      functionCustom.vpAssertExistElement(driver, "//p[contains(text(),'Please select the preferred payment method to use ')]", "Se valida la presencia del texto preferred payment dentro de la web.");
      
      //Se selecciona el metodo de pago
      functionCustom.clickElement(driver, "//label[normalize-space()='Cash On Delivery']", "Se presiona sobre el radio button Cash On Delivery .");
      functionCustom.clickElement(driver, "//input[@name='agree']", "Se presiona sobre el botón terminos y condiciones.");
      functionCustom.clickElement(driver, "//input[@id='button-payment-method']", "Se presiona sobre el botón Continue.");
      functionCustom.vpAssertExistElement(driver, "//td[normalize-space()='Product Name']", "Se valida la presencia del texto Product Name dentro de la web.");
      
      
      //Se confirma la Orden
      functionCustom.clickElement(driver, "//input[@id='button-confirm']", "Se presiona sobre el botón .");
      functionCustom.vpAssertExistElement(driver, "//h1[normalize-space()='Your order has been placed!']", "Se valida la presencia del texto Your order has been placed dentro de la web.");
      
      //Se hace el cierre de sesion
      functionCustom.clickElement(driver, "//span[normalize-space()='My Account']", "Se presiona sobre el texto My Account.");
      functionCustom.vpAssertExistElement(driver, "//a[normalize-space()='Logout']", "Se valida la presencia del elemento Logout dentro de la web.");
      
      functionCustom.clickElement(driver, "//a[normalize-space()='Logout']", "Se presiona sobre el link Logout.");
      functionCustom.vpAssertExistElement(driver, "//p[contains(text(),'You have been logged off your account. It is now s')]", "Se valida la presencia del texto You have been logged off dentro de la web.");
  }
  
}
