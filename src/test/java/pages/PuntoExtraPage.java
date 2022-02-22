package pages;

import org.openqa.selenium.By;

public class PuntoExtraPage extends BasePage {

    private String radioButton = "//body/div[@id='product-product']/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/label[1]/input[1]";
    private String checkbox2 = "//body/div[@id='product-product']/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/label[1]/input[1]";
    private String checkbox4 = "//body/div[@id='product-product']/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[4]/label[1]/input[1]";
    private String textProduct = "//input[@id='input-option208']";
    private String selectProduct = "//select[@id='input-option217']";
    private String textArea = "//textarea[@id='input-option209']";
    private String uploadFile = "//body/div[@id='product-product']/div[1]/div[1]/div[1]/div[2]/div[2]/div[6]/button[1]/i[1]";
    private String calendar = "//input[@id='input-option219']";
    private String time = "//input[@id='input-option221']";
    private String dateTime = "//input[@id='input-option220']";
    private String quantity = "//input[@id='input-quantity']";
    private String addToCartButton = "//button[@id='button-cart']";
    private String searchButtonProduct = "//header/div[1]/div[1]/div[2]/div[1]/span[1]/button[1]";
    private String selectProductImage = "//body/div[@id='product-search']/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/a[1]/img[1]";


    public PuntoExtraPage() {
        super(driver);
       
    }

    public void searchProductExtra() {

        clickElement(searchButtonProduct);
        clickElement(selectProductImage);
        clickElement(radioButton);
        clickElement(checkbox2);
        clickElement(checkbox4);
        write(textProduct,"Test_1");
        selectFromDropdownByValue(selectProduct , "1");
        write(textArea,"Data de prueba");
        String dir = System.getProperty("user.dir");
        driver.findElement(By.xpath(uploadFile)).sendKeys(dir + "\\dataTest\\test_imagen_selenium.png");
        checkAlert();
        write(calendar,"2022-01-26");
        write(time,"17:25");
        write(dateTime,"2021-12-24 23:55");
        write(quantity,"2");
        clickElement(addToCartButton);
    }


    
}
