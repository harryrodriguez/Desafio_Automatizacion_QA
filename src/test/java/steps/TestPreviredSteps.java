package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.Driver;
import org.json.simple.parser.ParseException;
import pages.PageObjectManager;
import pages.TestPreviredPage;
import utils.Props;
import java.io.IOException;

public class TestPreviredSteps {

    Props config;
    TestPreviredPage testPreviredPage;
    PageObjectManager pageObjectManager;
    String auxLR=null;


    public TestPreviredSteps(){
        config = new Props();
        pageObjectManager = new PageObjectManager(Driver.driver);
        testPreviredPage = pageObjectManager.getTestPreviredPage();
    }

    @Given("^open browser and go to website$")
    public void open_browser_and_go_to_website() throws InterruptedException, IOException, ParseException {
        pageObjectManager.openPage();
    }

    @When("^add \"([^\"]*)\" to cart$")
    public void add_to_cart(String product) throws InterruptedException {
        testPreviredPage.addProductToCart(product);
    }

    @When("^click on cart button$")
    public void click_on_cart_button() throws InterruptedException {
        testPreviredPage.goToCart();
    }

    @When("^click on checkout button$")
    public void click_on_checkout_button(){
      testPreviredPage.goToCheckOut();
    }
    @When("^insert \"([^\"]*)\" to \"([^\"]*)\"$")
    public void insert(String value, String action) throws InterruptedException, IOException, ParseException {
        switch (action){
            case "login":
                testPreviredPage.loginValuesInputs(value,action);
                break;
            case "register":
                testPreviredPage.registerValuesInputs(value,action);
                break;
            default:
                System.out.println("accion no definida");
        }
    }

    @When("^click on Login button$")
    public void click_on_Login_button() throws InterruptedException {
        testPreviredPage.clickBtnLogin();
    }

    @When("^validate \"([^\"]*)\"$")
    public void validate(String arg1) throws Throwable {
       testPreviredPage.validateMessage(arg1);
    }

    @When("^Click on continue button to register an Account$")
    public void click_on_continue_button_to_register_an_Account() throws Throwable {
        testPreviredPage.continueBtnNewCustomer();
    }

    @When("^Validate check for delivery and billing is selected$")
    public void validate_check_for_delivery_and_billing_is_selected() throws Throwable {
        testPreviredPage.validateCheckDeliBill();
    }

    @When("^check privacy policy$")
    public void check_privacy_policy() throws Throwable {
       testPreviredPage.checkPrivacyPolicy();
    }

    @When("^click in continue button to delivery details$")
    public void click_in_continue_button_to_delivery_details() throws Throwable {
        testPreviredPage.continueBtnToDeliveryDetails();
    }

    @When("^Validate existing address$")
    public void validate_existing_address() throws Throwable {
        testPreviredPage.validateExistinAdress();
    }

    @When("^click in continue button to delivery method$")
    public void click_in_continue_button_to_delivery_method() throws Throwable {
        testPreviredPage.continueBtnToDeliveryMethod();
    }

    @When("^validate flat rate equals \"([^\"]*)\"$")
    public void validate_flat_rate_equals(String arg1) throws Throwable {
        testPreviredPage.validateFlatRate(arg1);
    }

    @When("^click on continue button to Payment Method$")
    public void click_on_continue_button_to_Payment_Method() throws Throwable {
        testPreviredPage.continueBtnToPaymentMethod();
    }

    @When("^check terms and conditions$")
    public void check_terms_and_conditions() throws Throwable {
        testPreviredPage.checkTermsConditions();
    }

    @When("^click on continue button to confirm order$")
    public void click_on_continue_button_to_confirm_order() throws Throwable {
        testPreviredPage.continueBtnToConfirmOrder();
    }

    @When("^click on Confirm Order button$")
    public void click_on_Confirm_Order_button() throws Throwable {
        testPreviredPage.confirmCheckout();
    }

    @Then("^click on history link$")
    public void click_on_history_link() throws Throwable {
        testPreviredPage.clickHistory();
    }

    @Then("^validate status \"([^\"]*)\"$")
    public void validate_status(String value) throws Throwable {
        testPreviredPage.validateOrderStatus(value);
    }
    @When("^search for \"([^\"]*)\"$")
    public void search_for(String value) throws Throwable {
        testPreviredPage.findProduct(value);
    }

    @When("^select \"([^\"]*)\"$")
    public void select(String arg1) throws Throwable {
       testPreviredPage.selects(arg1);
    }

    @When("^insert \"([^\"]*)\"$")
    public void insert(String arg1) throws Throwable {
        testPreviredPage.inserts(arg1);
    }

    @When("^upload the \"([^\"]*)\"$")
    public void upload_the(String arg1) throws Throwable {
        testPreviredPage.uploadImage(arg1);
    }
    @When("^click to add to cart button$")
    public void click_to_add_to_cart_button() throws Throwable {
        testPreviredPage.addToCart();
    }


}
