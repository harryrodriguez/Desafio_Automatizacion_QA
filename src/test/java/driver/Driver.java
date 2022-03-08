package driver;

import cucumber.api.java.Before;
import cucumber.api.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.Props;

public class Driver {

    public static WebDriver driver;

    @Before
    public void setUp() throws Exception {
        Props props = new Props();
        String nav = props.getNavegador();

        /*
        Aca normalmente se utiliza un swich para seleccionar los distintos navegadores. en este ejemplo
        solo usaré chrome
        */

        if (nav.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();
            System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        if (driver != null) {
            driver.quit();
        }
    }

}

