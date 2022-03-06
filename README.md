Desafio Practico QA Automatizador PreviRed
=


First steps:
-
-------------

- [Installation](documents/info/Installation.md)
- [Base Page Class](documents/info/bp_creations.md)
- [Utils classes](documents/info/utilsCreation.md)
- [Driver class](documents/info/driverCreation.md)
- [Steps](documents/info/steps.md)

---------------

Create a feature:
-
- Create a file with extension `.feature` under the folder features
- You can start creating your feature looking at `features/testPrevired.feature` as example
-----------------
Create step class:
-
- Create a java class under the package steps. 
- This class will contain all the method thar connect the feature files with the page class
- You can start looking at `steps/TestPreviredSteps.java` as example

---------------------
Create page class:
-
- Create a java class under the package pages.
- this class will contain all the elements declared and methods that make the actions needed for automatization
- You can start looking at `pages/TestPreviredPage.java` as example
-------------------

Create Runner class:
- 
- Create a package under `src/test/java` called runner
- this package will contain the runner class, that allow us to run the test we want
- Inside the package runner, create a java class named `Runner` and copy the following:


    import com.vimalselvam.cucumber.listener.Reporter;
    import cucumber.api.CucumberOptions;
    import cucumber.api.junit.Cucumber;
    import org.junit.AfterClass;
    import org.junit.runner.RunWith;
    
    @RunWith(Cucumber.class)
    @CucumberOptions
    (       glue = { "driver","steps" }, features = "src/test/resources/features/",
    plugin = {"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:cucumber-report/report.html"},
    tags = "@test2"
    )
    
    public class Runner {
    @AfterClass
    public static void writeExtentReport() {
    
            Reporter.loadXMLConfig("documents/extent-config.xml");
        }
    }

- glue: select driver and steps forder
- feature: the path where the files .features are
- tags: this will change depending wich test you want to run. the tag comes from the feature


- Under the folder documents, create a file `extent-config.xml` and add the path inside reporter in writeExtentReport method.
- Inside the file `extent-config.xml` paste the following:



    <?xml version="1.0" encoding="UTF-8"?>
    <extentreports>
        <configuration>
            <!-- report theme --> <!-- standard, dark -->
            <theme>standard</theme>
    
            <!-- document encoding -->  <!-- defaults to UTF-8 -->
            <encoding>UTF-8</encoding>
    
            <!-- protocol for script and stylesheets -->   <!-- defaults to https -->
            <protocol>https</protocol>
    
            <!-- title of the document -->
            <documentTitle>ToolsQA - Cucumber Framework</documentTitle>
    
            <!-- report name - displayed at top-nav -->
            <reportName>ToolsQA - Cucumber Report</reportName>
    
            <!-- global date format override -->  <!-- defaults to yyyy-MM-dd -->
            <dateFormat>yyyy-MM-dd</dateFormat>
    
            <!-- global time format override -->   <!-- defaults to HH:mm:ss -->
            <timeFormat>HH:mm:ss</timeFormat>
    
            <!-- custom javascript -->
            <scripts>
                <![CDATA[
            $(document).ready(function() {
    
            });
          ]]>
            </scripts>
    
            <!-- custom styles -->
            <styles>
                <![CDATA[
    
          ]]>
            </styles>
        </configuration>
    </extentreports>



Run scenarios:
- 

- Go to runner class and change the `tags` for the specific scenario you want to run
or the tag that contains all the scenarios.
- Then, right Click and "Run"