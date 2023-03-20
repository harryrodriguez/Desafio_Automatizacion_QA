package testing;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;


import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class AgregarElementosCarro {
	
	//@BeforeTest
	//public void setUp() throws InterruptedException{
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\alexm\\eclipse-workspace\\YourStore\\Server\\chromedriver.exe");
	//WebDriver driver = new ChromeDriver();
	//driver.get("http://opencart.abstracta.us/index.php?route=common/home");
	//Thread.sleep(2000);
	//}
		@Test
		public void T001_Agrega_Ipod_Classic() throws InterruptedException, IOException {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\alexm\\eclipse-workspace\\YourStore\\Server\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("http://opencart.abstracta.us/index.php?route=common/home");
			driver.manage().window().maximize();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd - HH;mm;ss");
			String fechaComoCadena = sdf.format(new Date());
			
			WebElement dropmp1 = driver.findElement(By.linkText("MP3 Players"));
			dropmp1.click();
			Thread.sleep(1000);
			WebElement dropmp2 = driver.findElement(By.linkText("Show All MP3 Players"));
			dropmp2.click();
			Thread.sleep(1000);
			WebElement iPodClassic = driver.findElement(By.linkText("iPod Classic"));
			iPodClassic.click();
			Thread.sleep(1000);
			WebElement AddtoCart = driver.findElement(By.id("button-cart"));
			AddtoCart.click();
			Thread.sleep(1000);
			
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File(".//target/screenshot/AgregaElementosCarro/Evidencia_Ipod_Classic_"+fechaComoCadena+".png"));
			Thread.sleep(1000);
			
			WebElement dropim = driver.findElement(By.linkText("Desktops"));
			dropim.click();
			Thread.sleep(1000);
			WebElement dropmim2 = driver.findElement(By.linkText("Mac (1)"));
			dropmim2.click();
			Thread.sleep(1000);
			WebElement iMac = driver.findElement(By.linkText("iMac"));
			iMac.click();
			Thread.sleep(1000);
			WebElement AddtoCartImac = driver.findElement(By.id("button-cart"));
			AddtoCartImac.click();
			Thread.sleep(1000);
			
			File screenshotFile2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile2, new File(".//target/screenshot/AgregaElementosCarro/Evidencia_Imac_"+fechaComoCadena+".png"));
			Thread.sleep(1000);
			
			WebElement cart = driver.findElement(By.id("cart"));
			cart.click();
			Thread.sleep(500);
			WebElement ViewCart = driver.findElement(By.cssSelector("a[href='http://opencart.abstracta.us:80/index.php?route=checkout/cart']"));
			ViewCart.click();
			Thread.sleep(1000);
			
			
			WebElement VisibleIMac = driver.findElement(By.xpath("//td[contains(.,'Product 14')]"));
			Boolean Visible1 = VisibleIMac.isDisplayed();
			System.out.println(Visible1);
			WebElement VisibleIPod = driver.findElement(By.xpath("//td[contains(.,'product 20')]"));
			Boolean Visible2 = VisibleIPod.isDisplayed();
			System.out.println(Visible2);
			Boolean VisibleTotal = null;
			if(Visible1 == Visible2) {
				VisibleTotal = true;
			}else VisibleTotal = false;
			
			assertTrue("Si estan los elementos en el carro de compras",VisibleTotal);
			
			WebElement CheckOut = driver.findElement(By.cssSelector("a[href='https://opencart.abstracta.us:443/index.php?route=checkout/checkout']"));
			CheckOut.click();
			Thread.sleep(2000);
			WebElement Account = driver.findElement(By.cssSelector("input[value='guest']"));
			Account.click();	
			Thread.sleep(1000);
			File EvidenciaCheckOutO1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(EvidenciaCheckOutO1, new File(".//target/screenshot/CheckOut/Evidencia_CheckOut_Oocion1"+fechaComoCadena+".png"));
			Thread.sleep(1000);
			WebElement Continue = driver.findElement(By.cssSelector("#button-account"));
			Continue.click();
			Thread.sleep(1000);
			WebElement FirstName = driver.findElement(By.cssSelector("input[name=firstname]"));
			FirstName.sendKeys("Alex");
			Thread.sleep(500);
			WebElement LastName = driver.findElement(By.cssSelector("input[name=lastname]"));
			LastName.sendKeys("Munoz");
			Thread.sleep(500);
			WebElement Email = driver.findElement(By.cssSelector("#input-payment-email"));
			Email.sendKeys("alex.munoz@gmail.com");
			Thread.sleep(500);
			WebElement Telephone = driver.findElement(By.cssSelector("input[name=telephone]"));
			Telephone.sendKeys("953672092");
			Thread.sleep(500);
			WebElement Adress1 = driver.findElement(By.cssSelector("input[name=address_1]"));
			Adress1.sendKeys("Pedro de Mendoza 13418");
			Thread.sleep(500);
			WebElement City = driver.findElement(By.cssSelector("input[name=city]"));
			City.sendKeys("Santiago");
			Thread.sleep(500);
			WebElement PostCode = driver.findElement(By.cssSelector("input[name=postcode]"));
			PostCode.sendKeys("8050000");
			Thread.sleep(500);
			WebElement Country = driver.findElement(By.cssSelector("select[name=country_id]"));
			Country.click();
			Thread.sleep(500);
			WebElement OptionCountry = driver.findElement(By.cssSelector("div.container:nth-child(4) div.row div.col-sm-12 div.panel-group:nth-child(2) div.panel.panel-default:nth-child(2) div.panel-collapse.collapse.in div.panel-body div.row:nth-child(1) div.col-sm-6:nth-child(2) fieldset:nth-child(1) div.form-group.required:nth-child(7) select.form-control > option:nth-child(48)"));
			OptionCountry.click();
			Thread.sleep(500);
			WebElement Region = driver.findElement(By.cssSelector("select[name=zone_id]"));
			Region.click();
			Thread.sleep(500);
			WebElement OptionRegion = driver.findElement(By.cssSelector("div.container:nth-child(4) div.row div.col-sm-12 div.panel-group:nth-child(2) div.panel.panel-default:nth-child(2) div.panel-collapse.collapse.in div.panel-body div.row:nth-child(1) div.col-sm-6:nth-child(2) fieldset:nth-child(1) div.form-group.required:nth-child(8) select.form-control > option:nth-child(14)"));
			OptionRegion.click();
			Thread.sleep(500);
			File EvidenciaCheckOutO2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(EvidenciaCheckOutO2, new File(".//target/screenshot/CheckOut/Evidencia_CheckOut_Oocion2"+fechaComoCadena+".png"));
			Thread.sleep(1000);
			WebElement Continue2 = driver.findElement(By.cssSelector("#button-guest"));
			Continue2.click();
			Thread.sleep(1000);
			File EvidenciaCheckOutO4 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(EvidenciaCheckOutO4, new File(".//target/screenshot/CheckOut/Evidencia_CheckOut_Oocion4"+fechaComoCadena+".png"));
			Thread.sleep(1000);
			
			WebElement FlatShipping = driver.findElement(By.cssSelector("input[name=shipping_method]"));
			Boolean FlatSelected = FlatShipping.isSelected();
			assertTrue("El campo Flat Shipping se encuentra seleccionado", FlatSelected);
			
			WebElement Continue3 = driver.findElement(By.cssSelector("#button-shipping-method"));
			Continue3.click();
			Thread.sleep(1000);
			WebElement Terms = driver.findElement(By.cssSelector("input[name=agree]"));
			Terms.click();
			Thread.sleep(500);
			File EvidenciaCheckOutO5 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(EvidenciaCheckOutO5, new File(".//target/screenshot/CheckOut/Evidencia_CheckOut_Oocion5"+fechaComoCadena+".png"));
			Thread.sleep(1000);
			WebElement Continue4 = driver.findElement(By.cssSelector("#button-payment-method"));
			Continue4.click();
			Thread.sleep(1000);
			File EvidenciaCheckOutO6 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(EvidenciaCheckOutO6, new File(".//target/screenshot/CheckOut/Evidencia_CheckOut_Oocion6"+fechaComoCadena+".png"));
			Thread.sleep(1000);
			WebElement ConfirmOrder = driver.findElement(By.cssSelector("input[id=button-confirm]"));
			ConfirmOrder.click();
			Thread.sleep(1000);
			File screenshotFile3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile3, new File(".//target/screenshot/AgregaElementosCarro/Orden_Confirmada_"+fechaComoCadena+".png"));
			Thread.sleep(1000);
		}
		
	
	}
	
	

