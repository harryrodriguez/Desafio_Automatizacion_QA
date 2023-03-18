package testing;

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

public class CrearCuenta {
	
	@Test
	public void T002_Crear_cuenta() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\alexm\\eclipse-workspace\\YourStore\\Server\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://opencart.abstracta.us/index.php?route=common/home");
		driver.manage().window().maximize();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd - HH;mm;ss");
		String fechaComoCadena = sdf.format(new Date());
		
		WebElement Cuenta = driver.findElement(By.cssSelector("a[href='https://opencart.abstracta.us:443/index.php?route=account/account']"));
		Cuenta.click();
		Thread.sleep(500);
		WebElement Register = driver.findElement(By.linkText("Register"));
		Register.click();
		Thread.sleep(1000);
		WebElement FirstName = driver.findElement(By.cssSelector("input[name=firstname]"));
		FirstName.sendKeys("Alex");
		Thread.sleep(500);
		WebElement LastName = driver.findElement(By.cssSelector("input[name=lastname]"));
		LastName.sendKeys("Muñoz");
		Thread.sleep(500);
		WebElement Email = driver.findElement(By.cssSelector("input[name=email]"));
		Email.sendKeys("alexmunozg.comz@gmail.com");
		Thread.sleep(500);
		WebElement Telephone = driver.findElement(By.cssSelector("input[name=telephone]"));
		Telephone.sendKeys("953672092");
		Thread.sleep(500);
		WebElement Password = driver.findElement(By.cssSelector("input[name=password]"));
		Password.sendKeys("ABCD1234");
		Thread.sleep(500);
		WebElement ConfirmPassword = driver.findElement(By.cssSelector("input[name=confirm]"));
		ConfirmPassword.sendKeys("ABCD1234");
		Thread.sleep(500);
		WebElement Suscribe = driver.findElement(By.cssSelector("input[name=newsletter]"));
		Suscribe.click();
		Thread.sleep(500);
		WebElement Agree = driver.findElement(By.cssSelector("input[name=agree]"));
		Agree.click();
		Thread.sleep(500);
		WebElement Continue = driver.findElement(By.cssSelector("input[value=Continue]"));
		Continue.click();
		Thread.sleep(1500);
		
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//target/screenshot/CrearNuevaCuenta/Registro_cuenta_"+fechaComoCadena+".png"));
		Thread.sleep(1000);
		
		
	}

}

