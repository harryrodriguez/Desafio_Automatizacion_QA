package pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected static WebDriver driver;
    private static WebDriverWait wait;

    static {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, 10);

    }

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public static void navigateTo(String url) {
        driver.get(url);
        driver.manage().window().maximize();

    }

    public static void closeBrowser() {
        driver.quit();
    }

    private WebElement find(String locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void clickElement(String locator) {

        find(locator).click();

    }

    public void write(String locator, String textToWrite) {
        find(locator).clear();
        find(locator).sendKeys(textToWrite);

    }

    public void eraseSearch(String locator) {
        find(locator).clear();
    }

    public void selectFromDropdownByText(String locator, String TextToSelect) {
        Select dropdown = new Select(find(locator));
        dropdown.selectByVisibleText(TextToSelect);

    }

    public void selectFromDropdownByValue(String locator, String value){
        Select dropdown = new Select(find(locator));
        dropdown.selectByValue(value);
    }

    public boolean elementIsDisplayed(String locator) {
        return find(locator).isDisplayed();

    }

    public String textFromElement(String locator) {
        return find(locator).getText();
    }

    public void takeScreenshot(String pathname) {

        try {

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File(pathname));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void takeScreeshotFromElement(String locator, String pathname)

    {
        try {

            WebElement element = driver.findElement(By.xpath(locator));
            File src = element.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File(pathname));

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

    public void checkAlert() {
        try {
          WebDriverWait wait = new WebDriverWait(driver, 2);
          wait.until(ExpectedConditions.alertIsPresent());
          Alert alert = driver.switchTo().alert();
          alert.accept();
        } catch (Exception e) {
 
      }
}

}
