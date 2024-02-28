package io.loopcamp.step_definitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.loopcamp.pages.saucedemo.*;
import io.loopcamp.utilities.BrowserUtils;
import io.loopcamp.utilities.ConfigurationReader;
import io.loopcamp.utilities.Driver;
import net.datafaker.Faker;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class PurchasingTwoItemsStepDefs {

    /*
    -------------------------------------
    Background
    -------------------------------------
     */

    BasePage basePage = new BasePage();

    @Given("The user is signed in from the credentials from the login page")
    public void the_user_is_signed_in_from_the_credentials_from_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("sauce.demo"));
        LoginPage loginPage = new LoginPage();
        loginPage.login(0, true);
        BrowserUtils.waitForClickable(basePage.shoppingCart, 5);
        BrowserUtils.takeScreenshot();
    }

    /*
    -------------------------------------
    Scenario - Positive path
    -------------------------------------
     */

    OrderPage orderPage = new OrderPage();
    @Given("The user sorts items by {string}")
    public void the_user_sorts_items_by(String option) {
        BrowserUtils.waitForClickable(orderPage.productSortWebElement, 5);
        orderPage.switchProductOrder(option);
        BrowserUtils.takeScreenshot();
    }
    List<String> itemsExpected = new ArrayList<>();
    List<String> pricesExpected = new ArrayList<>();
    @Given("The user adds the second item from each column")
    public void the_user_adds_the_second_item_from_each_column() {

        itemsExpected.add(orderPage.inventory.get(2).getText());
        itemsExpected.add(orderPage.inventory.get(3).getText());

        pricesExpected.add(orderPage.prices.get(2).getText());
        pricesExpected.add(orderPage.prices.get(3).getText());

        orderPage.addToCart(itemsExpected.get(0));
        orderPage.addToCart(itemsExpected.get(1));
        BrowserUtils.takeScreenshot();
    }
    @Given("The user goes to the cart and clicks checkout")
    public void the_user_goes_to_the_cart_and_clicks_checkout() {
        orderPage.shoppingCart.click();
        BrowserUtils.takeScreenshot();
        new CartPage().checkoutButton.click();
    }

    Faker faker = new Faker();
    @And("The user enters name and zip on next form and clicks continue")
    public void theUserEntersNameAndZipOnNextFormAndClicksContinue() {
        CheckoutOnePage checkoutOnePage= new CheckoutOnePage();
        checkoutOnePage.firstNameInput.clear();
        checkoutOnePage.firstNameInput.sendKeys(faker.name().firstName());
        checkoutOnePage.lastNameInput.sendKeys(faker.name().lastName());
        checkoutOnePage.postalCodeInput.sendKeys(faker.numerify("#####"));
        BrowserUtils.takeScreenshot();
        checkoutOnePage.continueButton.click();
    }

    CheckoutTwoPage checkoutTwoPage = new CheckoutTwoPage();
    @Given("The user sees payment information and price")
    public void the_user_sees_payment_information_and_price() {

        List<String> itemsActual = checkoutTwoPage.cartItemNames.stream().map(each-> each.getText()).toList();
        Assert.assertEquals(itemsActual, itemsExpected);

        List<String> pricesActual = checkoutTwoPage.cartItemPrices.stream().map(each-> each.getText()).toList();
        Assert.assertEquals(pricesActual, pricesExpected);

        double totalExpected = 0;
        for (String itemPrice : pricesExpected)
            totalExpected += Double.parseDouble(itemPrice.substring(1));
        totalExpected += Double.parseDouble(checkoutTwoPage.taxes.getText().substring(checkoutTwoPage.taxes.getText().indexOf("$") + 1));
        Assert.assertEquals(totalExpected,
                Double.parseDouble(checkoutTwoPage.total.getText().substring(checkoutTwoPage.total.getText().indexOf("$") + 1)),
                1e-15);

        BrowserUtils.takeScreenshot();
    }
    @Given("The user completes the order")
    public void the_user_completes_the_order() {
        checkoutTwoPage.finishButton.click();


    }
    @Then("The user logs out")
    public void the_user_logs_out() {
        BrowserUtils.takeScreenshot();
    }
}
