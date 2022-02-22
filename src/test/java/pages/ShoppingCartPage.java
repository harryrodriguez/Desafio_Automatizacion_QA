package pages;

public class ShoppingCartPage extends BasePage {

    private String checkoutCart = "//a[contains(text(),'Checkout')]";
    private String addedMessage = "//a[contains(text(),'shopping cart')]";
    private String shoppingCartButton = "//*[@id='top-links']/ul/li[4]/a";

    public ShoppingCartPage() {
        super(driver);
    }

    public void enterShoppingCart() {

        clickElement(shoppingCartButton);

    }

    public void clickCheckoutCart() {
        clickElement(checkoutCart);
    }

    public String productAddedToCartMessage() {
        return textFromElement(addedMessage);
    }

}
