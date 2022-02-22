package steps;

import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pages.OrderHistoryPage;

public class OrderHistorySteps {

    OrderHistoryPage order = new OrderHistoryPage();

    @And("^ingreso al historial de ordenes$")
    public void viewOrderDetails() {
        String dir = System.getProperty("user.dir");
        order.enterOrderHistory();
        order.takeScreenshot((dir + "\\test-output\\Screenshots_test\\Evidence_Order_History.png"));
        order.viewOrderHistory();
        order.takeScreenshot((dir + "\\test-output\\Screenshots_test\\Evidence_Complete_Order.png"));
        order.takeScreeshotFromElement(order.validateTotalCost(),
                (dir + "\\test-output\\Screenshots_test\\Evidence_Total_Cost_Cart.png"));

    }

    @Then("^valido los datos de la orden de compra$")
    public void validateShipppingRate() {

        Assert.assertEquals("Flat Shipping Rate", order.validateShippingMethod());
        Assert.assertEquals("$5.00", order.validateCostShippingMethod());
        Assert.assertEquals("Pending", order.validateStatusOrder());
        order.closeOrderHistory();

    }

}
