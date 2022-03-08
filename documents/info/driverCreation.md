Creation  Driver class
-

- Create a folder under prohect "previred" called "drivers". this will contain our drivers files
- Under the folder src > test > java  create a package named "driver" 
- Under this package, create a java class named "Driver"
- Create a variable of WebDriver


    public static WebDriver driver;

-Create a method to select driver will we use with the tag @Before

    @Before
    public void setUp() throws Exception {
    Props props = new Props();
    String nav = props.getNavegador();
    String projectPath = System.getProperty("user.dir");

        if (nav.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
            driver = new ChromeDriver(options);
            driver.manage().window().setSize(new Dimension(1366, 768));


-Create a method to close the browser with the tag @After


    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
