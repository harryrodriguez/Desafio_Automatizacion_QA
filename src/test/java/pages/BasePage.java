package pages;

import com.vimalselvam.cucumber.listener.Reporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class BasePage {

    protected static WebDriver driver;
    protected static WebDriverWait wait;
    static String destDir;
    static DateFormat dateFormat;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);

    }

    public void waitElement(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        //wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitListElements(String elements){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(elements)));
    }

    public static void captureScreenShot() throws InterruptedException {
        destDir = "cucumber-report/null";
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Thread.sleep(500);
        dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
        new File(destDir).mkdir();
        String destFile = dateFormat.format(new Date()) + ".png";
        try {
            FileUtils.copyFile(scrFile, new File(destDir +"/"+ destFile));
            Reporter.addScreenCaptureFromPath(System.getProperty(destDir) + "/"+ destFile);
        }catch (IOException e){
            e.printStackTrace();
        }
    }



}
