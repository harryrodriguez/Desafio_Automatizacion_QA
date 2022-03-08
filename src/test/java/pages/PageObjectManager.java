package pages;

import org.openqa.selenium.WebDriver;
import utils.Props;

public class PageObjectManager extends BasePage{


    private TestPreviredPage testPreviredPage;
    Props props = new Props();

    public PageObjectManager(WebDriver driver) {
        super(driver);

    }


    public TestPreviredPage getTestPreviredPage(){
        return (testPreviredPage == null)? testPreviredPage = new TestPreviredPage(driver): testPreviredPage;
    }



    public void openPage() throws InterruptedException {
        String URL = props.getRuta();
        driver.get(URL);
        Thread.sleep(2000);
    }

}
