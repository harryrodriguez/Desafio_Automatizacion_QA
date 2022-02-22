package steps;

import java.io.IOException;

import cucumber.api.java.en.And;
import pages.CheckOutPage;

public class CheckOutSteps {

    CheckOutPage checkout = new CheckOutPage();

    @And("^realizo creacion de cuenta y envio de compra$")

    public void createAccountOpencart() throws IOException {

        checkout.clickRegisterAccount();
        String dir = System.getProperty("user.dir");
        checkout.takeScreenshot((dir + "\\test-output\\Screenshots_test\\Evidence_CheckOut_Step_1.png"));
        checkout.registerAccount();

    }

}
