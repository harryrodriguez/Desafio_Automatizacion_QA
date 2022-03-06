Creation  "Runner" classes
=


- Under the folder src > test > java  create a package named "runner"
- Under this package, create a java class named "Runner"
- Paste the following:

        
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








