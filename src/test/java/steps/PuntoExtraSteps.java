package steps;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import pages.PuntoExtraPage;
import pages.ShoppingCartPage;

public class PuntoExtraSteps {

    HomePage opencart = new HomePage();
    PuntoExtraPage ptoextra = new PuntoExtraPage();
    ShoppingCartPage shopping = new ShoppingCartPage();
    private String producto_extra = "Apple Cinema 30";
    

    @Given("^ingreso el producto extra a la barra de busqueda$")

    public void writeSearchOpencart() {

        opencart.navigateToOpencartAbstracta();
        opencart.selectSearchOpencartAbstracta();
        opencart.writeSearchOpencartAbstracta(producto_extra);
        ptoextra.searchProductExtra();
        String dir = System.getProperty("user.dir");
        opencart.takeScreenshot((dir + "\\test-output\\Screenshots_test\\Evidence_Cart_Product_Extra_" +producto_extra+ ".png"));

    }

    @When("^agrego el producto extra al carrito$")

    public void addProductCart() {
        opencart.clickAddButtonOpencartAbstracta();
    }

    @Then ("^valido que el producto extra se encuentre en el carrito$")
        public void validateProductOpencart() {

            Assert.assertEquals("shopping cart", shopping.productAddedToCartMessage());
    
        }
    }
    

