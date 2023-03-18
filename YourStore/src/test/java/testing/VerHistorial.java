package testing;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerHistorial {

	@Test
	public void T004_Historial() throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\alexm\\eclipse-workspace\\YourStore\\Server\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://opencart.abstracta.us/index.php?route=common/home");
		driver.manage().window().maximize();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd - HH;mm;ss");
		String fechaComoCadena = sdf.format(new Date());
		
		WebElement Cuenta = driver.findElement(By.cssSelector("a[href='https://opencart.abstracta.us:443/index.php?route=account/account']"));
		Cuenta.click();
		Thread.sleep(500);
		WebElement Register = driver.findElement(By.linkText("Login"));
		Register.click();
		Thread.sleep(1500);
		WebElement EmailAdress = driver.findElement(By.cssSelector("input[name=email]"));
		EmailAdress.sendKeys("alexmunozg.com@gmail.com");
		Thread.sleep(500);
		WebElement Password = driver.findElement(By.cssSelector("input[name=password]"));
		Password.sendKeys("ABCD1234");
		Thread.sleep(500);
		WebElement Login = driver.findElement(By.cssSelector("input[value=Login]"));
		Login.click();
		Thread.sleep(1000);
		WebElement LogOut = driver.findElement(By.linkText("Order History"));
		LogOut.click();
		Thread.sleep(1000);
		File OCTotales = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(OCTotales, new File(".//target/screenshot/Historial/Historial_"+fechaComoCadena+".png"));
		Thread.sleep(1000);
		
		WebElement VisibleOC = driver.findElement(By.cssSelector("a[href='https://opencart.abstracta.us:443/index.php?route=account/order/info&order_id=8620']"));
		VisibleOC.click();
		
		File DetalleOrden = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(DetalleOrden, new File(".//target/screenshot/Historial/DetalleOC8620_"+fechaComoCadena+".png"));
		Thread.sleep(1000);
		
	}
	
}
