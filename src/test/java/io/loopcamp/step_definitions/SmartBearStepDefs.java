package io.loopcamp.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.loopcamp.pages.SmartBearBasePage;
import io.loopcamp.pages.SmartBearLoginPage;
import io.loopcamp.pages.SmartBearOrderPage;
import io.loopcamp.utilities.BrowserUtils;
import io.loopcamp.utilities.ConfigurationReader;
import io.loopcamp.utilities.Driver;
import org.junit.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SmartBearStepDefs {

        SmartBearBasePage smartBearBasePage;
        SmartBearOrderPage smartBearOrderPage;
        List<String> expected = new ArrayList<>();

    @Given("user is already logged in and navigated to order page")
    public void user_is_already_logged_in_and_navigated_to_order_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("smart.bear"));
        new SmartBearLoginPage().login();
        smartBearBasePage = new SmartBearBasePage();
        BrowserUtils.waitForClickable(smartBearBasePage.orderLink, 5);
        smartBearBasePage.orderLink.click();
    }
    @When("user selects product type {string}")
    public void user_selects_product_type(String dropdownValue) {
        expected.add(dropdownValue);
        smartBearOrderPage = new SmartBearOrderPage();
        smartBearOrderPage.productDropdown.selectByValue(dropdownValue);
    }
    @When("user enters quantity {int}")
    public void user_enters_quantity(Integer quantity) {
        expected.add("" + quantity);
        smartBearOrderPage.quantityInput.clear();
        smartBearOrderPage.quantityInput.sendKeys("" + quantity);
    }
    @When("user enters customer name {string}")
    public void user_enters_customer_name(String customerName) {
        expected.add(0, customerName);
        expected.add(LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        smartBearOrderPage.customerNameInput.clear();
        smartBearOrderPage.customerNameInput.sendKeys(customerName);
    }
    @When("user enters street {string}")
    public void user_enters_street(String streetName) {
        expected.add(streetName);
        smartBearOrderPage.streetInput.clear();
        smartBearOrderPage.streetInput.sendKeys(streetName);
    }
    @When("user enters city {string}")
    public void user_enters_city(String cityName) {
        expected.add(cityName);
        smartBearOrderPage.cityInput.clear();
        smartBearOrderPage.cityInput.sendKeys(cityName);
    }
    @When("user enters state {string}")
    public void user_enters_state(String stateName) {
        expected.add(stateName);
        smartBearOrderPage.stateInput.clear();
        smartBearOrderPage.stateInput.sendKeys(stateName);
    }
    @When("user enters zip {string}")
    public void user_enters_zip(String zipCode) {
        expected.add(zipCode);
        smartBearOrderPage.zipInput.clear();
        smartBearOrderPage.zipInput.sendKeys(zipCode);
    }
    @When("user selects credit card type {string}")
    public void user_selects_credit_card_type(String creditCardType) {
        expected.add(creditCardType);
        switch (creditCardType){
            case "American Express":
                smartBearOrderPage.americanExpressRadioButton.click();
                break;
            case "MasterCard":
                smartBearOrderPage.masterCardRadioButton.click();
                break;
            case "Visa":
                smartBearOrderPage.visaRadioButton.click();
        }
    }
    @When("user enters credit car number {string}")
    public void user_enters_credit_car_number(String cardNumber) {
        expected.add(cardNumber);
        smartBearOrderPage.cardNumberInput.clear();
        smartBearOrderPage.cardNumberInput.sendKeys(cardNumber);
    }
    @When("user enters expiration date {string}")
    public void user_enters_expiration_date(String expirationDate) {
        expected.add(expirationDate);
        smartBearOrderPage.expirationDateInput.clear();
        smartBearOrderPage.expirationDateInput.sendKeys(expirationDate);
    }
    @When("user enters process order button")
    public void user_enters_process_order_button() {
        smartBearOrderPage.processButton.click();
    }
    @Then("user should see {string} in the first row of the table")
    public void user_should_see_in_the_first_row_of_the_table(String customerName) {
        smartBearBasePage.orderTable.click();
        BrowserUtils.waitForClickable(smartBearBasePage.orderLink, 5);
        BrowserUtils.takeScreenshot();

        List<String> actual = smartBearOrderPage.getRow(customerName).stream().map(each-> each.getText()).toList();
        Assert.assertEquals("Actual list of strings making row data did not match expected",
                expected, actual);

        System.out.println("expected = " + expected);
        System.out.println("actual = " + actual);
    }
}
