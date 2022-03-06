package pages;

import gherkin.lexer.Th;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ReadJson;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class TestPreviredPage extends PageObjectManager{
    private ReadJson read = new ReadJson();

    public TestPreviredPage(WebDriver driver){super(driver);}

//declaracion de WebElements

    @FindBy(id="search")
    private WebElement searchBar;

    @FindBy(className="button-group")
    private WebElement addToCartBtn;

    @FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
    private WebElement errorMsj;

    @FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
    private WebElement addCartSuccesMsj;

    @FindBy(id="cart")
    private WebElement cartBtn;

    @FindBy(xpath="//strong[contains(.,' Checkout')]")
    private WebElement checkOutBtn;

    @FindBy(id="collapse-checkout-option")
    private WebElement checkoutOption;

    @FindBy(id="collapse-payment-address")
    private WebElement accountBillingDetails;

    @FindBy(id="collapse-payment-address")
    private WebElement billingDetails;

    @FindBy(id="collapse-shipping-address")
    private WebElement deliveryDetails;

    @FindBy(id="collapse-shipping-method")
    private WebElement deliveryMethod;

    @FindBy(id="collapse-payment-method")
    private WebElement paymentMethod;

    @FindBy(id="collapse-checkout-confirm")
    private WebElement checkoutConfirm;

    @FindBy(xpath = "//a[contains(text(),'history')]")
    private  WebElement historyLink;

    @FindBy(className="table-responsive")
    private WebElement resumeTable;

    //test2
    @FindBy (className = "product-thumb")
    private WebElement productsResult;

    @FindBy (id= "product")
    private WebElement productFeaturesPage;





//metodos

    public void addProductToCart(String product) throws InterruptedException {

        searchBar.findElement(By.tagName("input")).sendKeys(product);
        searchBar.findElement(By.tagName("button")).click();
        addToCartBtn.findElements(By.tagName("button")).get(0).click();
        waitElement(addCartSuccesMsj);
        captureScreenShot();
        Assert.assertTrue("no agregado", addCartSuccesMsj.getText().contains("Success"));
        Assert.assertTrue("producto erroneo", addCartSuccesMsj.findElement(By.tagName("a")).getText().equalsIgnoreCase(product));
        searchBar.findElement(By.tagName("input")).clear();
    }

    public void goToCart() throws InterruptedException {
        waitElement(cartBtn);
        cartBtn.findElement(By.tagName("i")).click();
        captureScreenShot();

    }
    public void goToCheckOut(){
        checkOutBtn.click();
    }

    public void loginValuesInputs(String value, String jsonFile) throws InterruptedException, IOException, ParseException {
        waitElement(checkoutOption);

        switch (value) {
            case "email":
                checkoutOption.findElement(By.id("input-email")).sendKeys(read.readJson(value, jsonFile));
                captureScreenShot();
                break;
            case "password":
                checkoutOption.findElement(By.id("input-password")).sendKeys(read.readJson(value, jsonFile));
                captureScreenShot();
                break;
            default:
                System.out.println("campo no definido");
                break;
        }
    }

    public void registerValuesInputs(String value, String jsonFile) throws InterruptedException, IOException, ParseException {
            waitElement(accountBillingDetails);
            switch (value) {
                case "first_name":
                    accountBillingDetails.findElement(By.id("input-payment-firstname")).sendKeys(read.readJson(value, jsonFile));

                    break;
                case "last_name":
                    accountBillingDetails.findElement(By.id("input-payment-lastname")).sendKeys(read.readJson(value, jsonFile));
                    break;
                case "email":
                    accountBillingDetails.findElement(By.id("input-payment-email")).sendKeys(read.readJson(value, jsonFile));
                    break;
                case "phone":
                    accountBillingDetails.findElement(By.id("input-payment-telephone")).sendKeys(read.readJson(value, jsonFile));
                    break;
                case "password":
                    accountBillingDetails.findElement(By.id("input-payment-password")).sendKeys(read.readJson(value, jsonFile));
                    break;
                case "password_confirm":
                    accountBillingDetails.findElement(By.id("input-payment-confirm")).sendKeys(read.readJson(value, jsonFile));
                    break;
                case "address":
                    accountBillingDetails.findElement(By.id("input-payment-address-1")).sendKeys(read.readJson(value, jsonFile));
                    break;
                case "city":
                    accountBillingDetails.findElement(By.id("input-payment-city")).sendKeys(read.readJson(value, jsonFile));
                    break;
                case "post_code":
                    accountBillingDetails.findElement(By.id("input-payment-postcode")).sendKeys(read.readJson(value, jsonFile));
                    break;
                case "country":
                    accountBillingDetails.findElement(By.id("input-payment-country")).click();
                    accountBillingDetails.findElement(By.id("input-payment-country")).sendKeys(read.readJson(value, jsonFile));
                    accountBillingDetails.findElement(By.id("input-payment-country")).sendKeys(Keys.ENTER);
                    break;
                case "region":
                    accountBillingDetails.findElement(By.id("input-payment-zone")).click();
                    Thread.sleep(500);
                    accountBillingDetails.findElement(By.id("input-payment-zone")).sendKeys("v");
                    accountBillingDetails.findElement(By.id("input-payment-zone")).sendKeys(Keys.ENTER);
                    break;
                default:
                    System.out.println("campo no definido");
                    break;
            }

        }

    public void clickBtnLogin() throws InterruptedException {
        waitElement(checkoutOption);
        checkoutOption.findElement(By.id("button-login")).click();
        captureScreenShot();

    }
    public void continueBtnNewCustomer(){
        checkoutOption.findElement(By.id("button-account")).click();
    }

    public void validateMessage(String value) throws IOException, ParseException, InterruptedException {
        switch (value){
            case "error":
                waitElement(errorMsj);
                Assert.assertTrue("No se encuentra msj error",
                        errorMsj.getText().contains(read.readJson(value, "message")));
                captureScreenShot();
                break;
            case "success":
                String successMsj = read.readJson(value, "message");
                Thread.sleep(500);
                WebElement eleSuc = driver.findElement(By.xpath("//h1[contains(.,'"+successMsj+"')]"));
                Assert.assertTrue("no está el mensaje success", eleSuc.isDisplayed() );
                captureScreenShot();

                break;
            default:
                System.out.println("campo no definido");
                break;
        }

    }
    public void validateCheckDeliBill() throws InterruptedException {
        waitElement(accountBillingDetails);
        Assert.assertTrue("No está seleccionado",
                accountBillingDetails.findElement(By.xpath("//input[@name='shipping_address']")).isSelected());
        captureScreenShot();
    }
    public void checkPrivacyPolicy(){
        accountBillingDetails.findElement(By.xpath("//input[@name='agree']")).click();
    }

    public void continueBtnToDeliveryDetails() throws InterruptedException {

        //añadir boton para delivery cuando inicia sesion.

        accountBillingDetails.findElement(By.id("button-register")).click();
        captureScreenShot();
    }

    public void validateExistinAdress() throws IOException, ParseException, InterruptedException {

        waitElement(deliveryDetails);

        String name = read.readJson("first_name", "register");
        String lastName = read.readJson("last_name", "register");
        String address = read.readJson("address", "register");
        String city = read.readJson("city", "register");
        String region = read.readJson("region", "register");
        String country = read.readJson("country", "register");

        String info = name +" "+lastName+", "+address+", "+city+ ", "+region+", "+country;

        System.out.println(info);
        Assert.assertTrue("Error en direccion",
                deliveryDetails.findElement(By.tagName("option")).getText().equalsIgnoreCase(info));
        captureScreenShot();

    }

    public void continueBtnToDeliveryMethod() throws InterruptedException {
        deliveryDetails.findElement(By.id("button-shipping-address")).click();


    }

    public void validateFlatRate(String value) throws InterruptedException {
        waitElement(deliveryMethod);
        Assert.assertTrue("no coincide",
        deliveryMethod.findElement(By.tagName("label")).getText().equalsIgnoreCase(value));
        captureScreenShot();
    }

    public void continueBtnToPaymentMethod() throws InterruptedException {
        deliveryMethod.findElement(By.id("button-shipping-method")).click();
    }

    public void checkTermsConditions() throws InterruptedException {
        Thread.sleep(1000);
        paymentMethod.findElement(By.xpath("//input[@name='agree']")).click();
        captureScreenShot();
    }
    public void continueBtnToConfirmOrder() throws InterruptedException {

        paymentMethod.findElement(By.id("button-payment-method")).click();
    }

    public void confirmCheckout() throws InterruptedException {
        Thread.sleep(1000);
        checkoutConfirm.findElement(By.id("button-confirm")).click();
    }

    public void clickHistory() throws InterruptedException {
        waitElement(historyLink);
        historyLink.click();
    }

    public void validateOrderStatus(String value) throws InterruptedException {
        waitElement(resumeTable);
        Assert.assertTrue("Estado no pendiente",
        resumeTable.findElements(By.className("text-left")).get(4).getText().equalsIgnoreCase(value));
        captureScreenShot();

    }

    public void findProduct(String product) throws InterruptedException {
        searchBar.findElement(By.tagName("input")).sendKeys(product);
        searchBar.findElement(By.tagName("button")).click();
        productsResult.click();
        captureScreenShot();
    }
    public void selects(String value) throws IOException, ParseException {
        waitListElements("product");
        String valueJson = read.readJson(value, "productFeature");
        switch (value){
            case "radio":
                    if(valueJson.equalsIgnoreCase("Small")){
                        productFeaturesPage.findElement(By.xpath("(//input[@name='option[218]'])[1]")).click();
                    }
                    if(valueJson.equalsIgnoreCase("Large")){
                        productFeaturesPage.findElement(By.xpath("(//input[@name='option[218]'])[2]")).click();
                    }
                break;
            case "checkbox1":
                    checkBoxes(value);
                break;
            case "checkbox2":
                    checkBoxes(value);
                break;
            case "select":
                System.out.println(valueJson);
                if (valueJson.contains("Yellow")){
                    productFeaturesPage.findElement(By.xpath("//select[@id='input-option217']")).click();
                    productFeaturesPage.findElement(By.xpath("//select[@id='input-option217']")).sendKeys("y");
                    productFeaturesPage.findElement(By.xpath("//select[@id='input-option217']")).sendKeys(Keys.ENTER);
                }
                //acá irian las otras alternativas.

                break;
            default:
                System.out.println("selects no encontrado");
                break;
        }
    }

    public void inserts(String value) throws IOException, ParseException {
        String valueJson = read.readJson(value, "productFeature");
        switch (value){
            case "text":
                productFeaturesPage.findElement(By.id("input-option208")).clear();
                productFeaturesPage.findElement(By.id("input-option208")).sendKeys(valueJson);
                break;
            case "textArea":
                productFeaturesPage.findElement(By.id("input-option209")).clear();
                productFeaturesPage.findElement(By.id("input-option209")).sendKeys(valueJson);
                break;
            case "date":
                productFeaturesPage.findElement(By.id("input-option219")).clear();
                productFeaturesPage.findElement(By.id("input-option219")).sendKeys(valueJson);
                break;
            case "time":
                productFeaturesPage.findElement(By.id("input-option221")).clear();
                productFeaturesPage.findElement(By.id("input-option221")).sendKeys(valueJson);
                break;
            case "dateTime":
                productFeaturesPage.findElement(By.id("input-option220")).clear();
                productFeaturesPage.findElement(By.id("input-option220")).sendKeys(valueJson);
                break;
            case "qty":
                productFeaturesPage.findElement(By.id("input-quantity")).clear();
                productFeaturesPage.findElement(By.id("input-quantity")).sendKeys(valueJson);

                break;
            default:
                System.out.println("inserts no encontrado");
                break;
        }
    }

    public void addToCart() throws InterruptedException {
        productFeaturesPage.findElement(By.id("button-cart")).click();

    }

    public void uploadImage(String value) throws IOException, ParseException, InterruptedException {
        String valueJson = read.readJson(value, "productFeature");

        //productFeaturesPage.findElement(By.xpath("//button[@id='button-upload222']"))
          //      .sendKeys("jetbrains://idea/navigate/reference?project=previred&path=documents/images/hola.png");
        //productFeaturesPage.findElement(By.id("button-upload222")).click();

    }

    public void checkBoxes(String value) throws IOException, ParseException {
        String check = read.readJson(value, "productFeature");

        if(check.equalsIgnoreCase("Checkbox 1")){
            productFeaturesPage.findElement(By.xpath("//input[@name='option[223][]'])[1]")).click();
        }
        if(check.equalsIgnoreCase("Checkbox 2")){
            productFeaturesPage.findElement(By.xpath("(//input[@name='option[223][]'])[2]")).click();
        }
        if(check.equalsIgnoreCase("Checkbox 3")){
            productFeaturesPage.findElement(By.xpath("//input[@name='option[223][]'])[3]")).click();
        }
        if(check.equalsIgnoreCase("Checkbox 4")){
            productFeaturesPage.findElement(By.xpath("(//input[@name='option[223][]'])[4]")).click();
        }
    }

}
