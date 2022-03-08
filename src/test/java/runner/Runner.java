package runner;

import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (       glue = { "driver","steps" }, features = "src/test/resources/features/",
                plugin = {"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:cucumber-report/report.html"},
                tags = "@test1"
        )

public class Runner {
    @AfterClass
    public static void writeExtentReport() {

        Reporter.loadXMLConfig("documents/extent-config.xml");
    }
}
