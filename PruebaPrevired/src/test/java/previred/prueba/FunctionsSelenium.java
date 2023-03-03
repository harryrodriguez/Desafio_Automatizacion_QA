package previred.prueba;
import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;


public class FunctionsSelenium {
	List<String> filesListInDir = new ArrayList<String>();
	public int waitTime = 10;
	static String directoryName = System.getProperty("user.dir");
	static String sSistemaOperativo = System.getProperty("os.name").toUpperCase();
	public String nameTest;
	public static String carpeta;
	public static String separador;
	public static Robot keySend;
	
	/**
	* Función creada para usar el metodo de espera de un elemento que se puede presionar
	*
	* @param WebDriver navegador que será usado para recibir los comandos.
	* @param int tiempo de espera.
	* @param String es el xpath a utilizar para proceder con la espera.
	*
	* @throws Exception describe cuando existe una excepción en el metodo.
	*/
	public void  waitElementToBeClickableXpath(WebDriver driver, int timeWait, String xpathContent) {
		try{
			new WebDriverWait(driver, Duration.ofSeconds(timeWait)).until(ExpectedConditions.elementToBeClickable(By.xpath(xpathContent)));
		}catch(StaleElementReferenceException exc) {
			Reporter.log("</br>Se actualiza el elemento "+xpathContent);
		}catch (Exception e) {
			System.out.println("waitElementToBeClickableXpath, " + xpathContent);
			Reporter.log("</br>Se produjo un error: </br>&nbsp;&nbsp;&nbsp;&nbsp;"+e.getMessage(),2,true);
            org.testng.Assert.fail(e.getMessage());
        }
	}
	
	/**
	* Función creada para usar el metodo de espera para ver si un elemento esta presente
	*
	* @param WebDriver navegador que será usado para recibir los comandos.
	* @param int tiempo de espera.
	* @param String es el xpath a utilizar para proceder con la espera.
	*
	* @throws Exception describe cuando existe una excepción en el metodo.
	*/
	public int  waitPresenceOfElementLocatedXpath(WebDriver driver, int timeWait, String xpathContent) {
		try{
			new WebDriverWait(driver, Duration.ofSeconds(timeWait)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathContent)));
			return 0;
		} catch(StaleElementReferenceException exc) {
			Reporter.log("</br>Se actualiza el elemento "+xpathContent);
			return 0;
		} catch (Exception e) {
			Reporter.log("</br>Se produjo un error: </br>&nbsp;&nbsp;&nbsp;&nbsp;"+e.getMessage(),2,true);
            org.testng.Assert.fail(e.getMessage());
            return 1;
        }
	}
	
	
	
	/**
	* Función creada para usar el metodo de click y agregar texto
	*
	* @param WebDriver navegador que será usado para recibir los comandos.
	* @param String es el xpath a utilizar para proceder con la espera.
	* @param String es el sendText que se desea agregar.
	* @throws Exception describe cuando existe una excepción en el metodo.
	*/
	public void clickAndText(WebDriver driver, String xpathContent, String sendText, String textReport) {
		try{
			Thread.sleep(500);
			Reporter.log("</br>"+textReport);
			
			waitElementToBeClickableXpath(driver, waitTime, xpathContent);
			driver.findElement(By.xpath(xpathContent)).click();
			driver.findElement(By.xpath(xpathContent)).clear();
			driver.findElement(By.xpath(xpathContent)).sendKeys(sendText);
		} catch(StaleElementReferenceException exc) {
			Reporter.log("</br>Se actualiza el elemento "+xpathContent);
		} catch (Exception e) {
			Reporter.log("</br>Se produjo un error: </br>&nbsp;&nbsp;&nbsp;&nbsp;"+e.getMessage(),2,true);
            org.testng.Assert.fail(e.getMessage());
        }
	}
	
	/**
	* Función creada para abrir el navegador
	*
	* @param WebDriver navegador que será usado para recibir los comandos.
	* @param String es el xpath a utilizar para proceder con la espera y click.
	* @throws Exception describe cuando existe una excepción en el metodo.
	*/
	public void openNavigator(WebDriver driver, String varUrl) {
		try{
			Reporter.log("Se abre la URL: " + varUrl,2);
		    driver.get(varUrl);
		      
		    Reporter.log("</br>Se maximiza el navegador.",2);
		    driver.manage().window().maximize();
		    
		    driver.manage().deleteAllCookies();

		} catch (Exception e) {
			Reporter.log("</br>Se produjo un error: </br>&nbsp;&nbsp;&nbsp;&nbsp;"+e.getMessage(),2,true);
            org.testng.Assert.fail(e.getMessage());
        }
	}
	
	
	
	/**
	* Función creada para buscar un elemento y hacerle click
	*
	* @param WebDriver navegador que será usado para recibir los comandos.
	* @param String es el xpath a utilizar para proceder con la espera y click.
	* @throws Exception describe cuando existe una excepción en el metodo.
	*/
	public void clickElement(WebDriver driver, String xpathContent, String textReport) {
		try{
			Thread.sleep(500);
			Reporter.log("</br>"+textReport);
			waitElementToBeClickableXpath(driver, waitTime, xpathContent);
			WebElement element = driver.findElement(By.xpath(xpathContent));
			element.click();
		}catch(StaleElementReferenceException exc) {
			Reporter.log("</br>Se actualiza el elemento "+xpathContent);
		}catch (Exception e) {
			Reporter.log("</br>Se produjo un error: </br>&nbsp;&nbsp;&nbsp;&nbsp;"+e.getMessage(),2,true);
            org.testng.Assert.fail(e.getMessage());
        }
	}
	
	/**
	* Función creada para poder realizar el scroll de un elemento
	*
	* @param WebDriver navegador que será usado para recibir los comandos.
	* @param String es el nombre del elemento por xpath.
	* @throws Exception describe cuando existe una excepción en el metodo.
	*/
	public void vpAssertExistElement(WebDriver driver, String textSearch, String textReport) {
		DateFormat dateFormat = new SimpleDateFormat("yyyymmdd_HHmmss");
		String date = dateFormat.format(new Date());
		String evidenciaImagen = "Evidencia_" + nameTest + "_" + date + ".png";
		String mensajeExitoso = "</br>Se valida de forma exitosa, la existencia del elemento o texto: " + textSearch + " (<a href=\"../evidencias/" + carpeta + "/" + evidenciaImagen + "\" target=\"_blank\">Evidencia</a>)";
		String mensajeNoExitoso = "No se detecta la existencia del elemento o texto: " + textSearch + " (<a href=\"../evidencias/" + carpeta + "/" + evidenciaImagen + "\" target=\"_blank\">Evidencia</a>)";
		String imagenError = " (<a href=\"../evidencias/" + carpeta + "/" + evidenciaImagen + "\" target=\"_blank\">Evidencia</a>)";
		String mensajeActualizacion = "</br>Se actualiza el elemento " + textSearch  + " (<a href=\"../evidencias/" + carpeta + "/" + evidenciaImagen + "\" target=\"_blank\">Evidencia</a>)";
		
		try{
			//Reporter.log("</br>"+textReport);
			
			crearDirectorio(carpeta);
			takeSnapShot(driver, evidenciaImagen);
			
			if(!textSearch.substring(0, 2).equals("//")) {
				if (driver.getPageSource() .contains (textSearch)) {
					Reporter.log(mensajeExitoso,2);
			    }else {
			    	throw new Exception(mensajeNoExitoso);
			    }
			}else {
				waitPresenceOfElementLocatedXpath(driver, waitTime, textSearch);
				Reporter.log(mensajeExitoso,2);
			}
			
		} catch(StaleElementReferenceException exc) {
			Reporter.log(mensajeActualizacion);
		} catch (Exception e) {
            Reporter.log("</br>Se produjo un error " + imagenError + ": </br>&nbsp;&nbsp;&nbsp;&nbsp;"+e.getMessage(),2,true);
            org.testng.Assert.fail(e.getMessage());
        }
	}
	
	/**
	* Función creada para poder crear un email random
	*/
	public String generateEmail() {
		Random rand = new Random(); 
		int upperbound = 1000;
		int int_random = rand.nextInt(upperbound);
		String mail = "angeLeiva" + int_random + "@gmail.com";
		
		return mail;
	}
	
	
	/**
	* Función creada para buscar un elemento y seleccionar un valor de una lista desplegable
	*
	* @param WebDriver navegador que será usado para recibir los comandos.
	* @param Xpath es el xpath a utilizar para proceder con la espera.
	* @param Texto es el sendText que se desea seleccionar.
	* @throws Exception describe cuando existe una excepción en el metodo.
	*/
	public void selectElement(WebDriver driver, String xpathContent, String sendText, int tipoBusqueda, String textReport){
		try{
			Thread.sleep(1000);
			Reporter.log("</br>"+textReport);
			waitElementToBeClickableXpath(driver, waitTime, xpathContent);
			WebElement element = driver.findElement(By.xpath(xpathContent));
			Select objSelect = new Select(element);
			if(tipoBusqueda == 0) {
				objSelect.selectByVisibleText(sendText);
			}else {
				objSelect.selectByValue(sendText);
			}
		}catch(StaleElementReferenceException exc) {
			Reporter.log("</br>Se actualiza el elemento "+xpathContent);
		}catch (Exception e) {
			Reporter.log("</br>Se produjo un error: </br>&nbsp;&nbsp;&nbsp;&nbsp;"+e.getMessage(),2,true);
            org.testng.Assert.fail(e.getMessage());
        }
	}
	
	/**
	* Función para tomar capturas
	* @param webdriver
	* @param nombreEvidencia
	* @throws Exception
	*/

	public static void takeSnapShot(WebDriver webdriver, String nombreEvidencia){
		separador = "/";
		String fileWithPath = directoryName;
		try {
			if(sSistemaOperativo.contains("WIN")) {
				separador = "\\";
			}
			
			fileWithPath = fileWithPath + separador + "evidencias" + separador + carpeta + separador + nombreEvidencia;
			
			//Convert web driver object to TakeScreenshot
		    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		    //Call getScreenshotAs method to create image file
		    File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		    //Move image file to new destination
		    File DestFile=new File(fileWithPath);
		    //Copy file at destination
		    FileUtils.copyFile(SrcFile, DestFile);
		}catch(Exception e) {
			Reporter.log("</br>Se produjo un error: </br>&nbsp;&nbsp;&nbsp;&nbsp;"+e.getMessage(),2,true);
            org.testng.Assert.fail(e.getMessage());
		}		
	}
	
	/**
	 * 
	 * Función para crear directorio
	 * 
	*/
	public void crearDirectorio(String carpeta) {
		separador = "/";
		
		if(sSistemaOperativo.contains("WIN")) {
			separador = "\\";
		}
		
		String path = directoryName + separador + "evidencias" + separador + carpeta;
        File directorio = new File(path);
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado");
            } else {
                System.out.println("Error al crear directorio");
            }
        }
	}
	
	/**
	* Función creada para subir archivos
	*
	* @param WebDriver navegador que será usado para recibir los comandos.
	* @param xpathContent es el xpath a utilizar para proceder con la espera.
	* @param imageText es el nombre de la imagen que se desea agregar.
	* @throws Exception describe cuando existe una excepción en el metodo.
	*/
	public void uploadFile(WebDriver driver, String xpathContent, String imageText, String textReport) {
		try{
			//Se espera 0.5 segundo
			Thread.sleep(500);
			//Agregar el mensaje en el reporte
			Reporter.log("</br>"+textReport);
			//Se llama al metodo que hace la espera a que el elemento sea clickeable
			waitElementToBeClickableXpath(driver, waitTime, xpathContent);
			//Se hace click sobre el elemento
			driver.findElement(By.xpath(xpathContent)).click();
			//Se crea una variable que contiene la ruta de la imagen
			String pathImage = directoryName + separador + "files" + separador + imageText;
			//Se crea una variable que tiene la capacidad de ejecutar teclas fuera del navegador
			Robot keySend = new Robot();
		    //Se pasa la ruta del archivo al portapapeles
		    StringSelection str = new StringSelection(pathImage);
		    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		    //Se espera 2 segundo
		    Thread.sleep(2000);
		    
		    //Se llama al metodo para pegar desde el portapapeles
		    presionarCtrV(1000);
		    presionarEnter(500);
		    
		} catch(StaleElementReferenceException exc) {
			Reporter.log("</br>Se actualiza sube el archivo " + imageText);
		} catch (Exception e) {
			Reporter.log("</br>Se produjo un error: </br>&nbsp;&nbsp;&nbsp;&nbsp;"+e.getMessage(),2,true);
            org.testng.Assert.fail(e.getMessage());
        }
	}
	
	/**
	* Función creada para presionar la tecla Control + V desde el portapapeles
	*
	*/
	public void presionarCtrV(int time) {
		try {
			//Se crea una variable que tiene la capacidad de ejecutar teclas fuera del navegador
			keySend = new Robot();
			Thread.sleep(time);
			
			//Presiono Contol+V para pegar
			keySend.keyPress(KeyEvent.VK_CONTROL);
		    keySend.keyPress(KeyEvent.VK_V);
		    
		    //Suelto Contol+V para pegar
		    keySend.keyRelease(KeyEvent.VK_CONTROL);
		    keySend.keyRelease(KeyEvent.VK_V);
		    
		} catch(StaleElementReferenceException exc) {
			Reporter.log("</br>Se presiona la tecla Ctrl + V");
		} catch (Exception e) {
			Reporter.log("</br>Se produjo un error: </br>&nbsp;&nbsp;&nbsp;&nbsp;"+e.getMessage(),2,true);
            org.testng.Assert.fail(e.getMessage());
        }
	}
	
	/**
	* Función creada para presionar la tecla Enter fuera del navegador
	* 
	*/
	public void presionarEnter(int time) {
		try {
			//Se crea una variable que tiene la capacidad de ejecutar teclas fuera del navegador
			keySend = new Robot();
			Thread.sleep(time);
			
			//Presiono y suelto la tecla Enter
		    keySend.keyPress(KeyEvent.VK_ENTER);
		    keySend.keyRelease(KeyEvent.VK_ENTER);
		} catch(StaleElementReferenceException exc) {
			Reporter.log("</br>Se presiona la tecla Enter");
		} catch (Exception e) {
			Reporter.log("</br>Se produjo un error: </br>&nbsp;&nbsp;&nbsp;&nbsp;"+e.getMessage(),2,true);
            org.testng.Assert.fail(e.getMessage());
        }
	}
	
	public void openReportTest() throws IOException {
		String pathReport = directoryName + separador + "test-output" + separador + "index.html";
		File file = new File(pathReport);   
		  Desktop desktop = Desktop.getDesktop(); 
		  desktop.open(file);
	}
	
	
	
	


}
