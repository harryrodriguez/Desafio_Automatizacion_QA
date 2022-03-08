Creation  BasePage class
-

- Under the folder src > test > java  create a package named "pages"
- Under this package, create a java class named "BasePage"
- Create a protected and static variable of WebDriver called "driver"

      protected static WebDriver driver;



- Create the constructor

        public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        }

- Under the package "pages", create a java class named "PageObjectManager"

This class will extends from BasePage.java

In this class we will instantiate our different page classes

- Create a method to open the page

       public void openPage(String URL) throws InterruptedException {
       driver.get(URL);
       Thread.sleep(3000);
       }



