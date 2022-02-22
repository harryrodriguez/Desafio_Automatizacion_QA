package pages;

public class OrderHistoryPage extends BasePage {

    private String myAccountButton = "//span[contains(text(),'My Account')]";
    private String OrderHistoryOption = "//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]";
    private String viewOrderHistorybuttton = "//tbody/tr[1]/td[7]/a[1]/i[1]";
    private String logoutButton = "//*[@id='column-right']/div/a[13]";
    private String continueLogoutButton = "//*[@id='content']/div/div/a";
    private String shippingMethod = "//b[contains(text(),'Flat Shipping Rate')]";
    private String costShippingMethod = "//td[contains(text(),'$5.00')]";
    private String totalCostCart = "//td[contains(text(),'$205.00')]";
    private String statusOrder = "//td[contains(text(),'Pending')]";

    public OrderHistoryPage() {
        super(driver);

    }

    public void enterOrderHistory() {

        clickElement(myAccountButton);
        clickElement(OrderHistoryOption);

    }

    public void viewOrderHistory() {
        clickElement(viewOrderHistorybuttton);
    }

    public String validateShippingMethod() {
        return textFromElement(shippingMethod);
    }

    public String validateCostShippingMethod() {
        return textFromElement(costShippingMethod);

    }

    public String validateStatusOrder() {
        return textFromElement(statusOrder);
    }

    public String validateTotalCost() {
        return totalCostCart;
    }

    public void closeOrderHistory() {
        clickElement(logoutButton);
        clickElement(continueLogoutButton);
    }

}
