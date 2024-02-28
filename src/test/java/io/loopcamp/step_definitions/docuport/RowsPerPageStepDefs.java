package io.loopcamp.step_definitions.docuport;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.loopcamp.pages.docuport.BasePage;

import static io.loopcamp.assertions.CustomAssertions.assertWebElement;

public class RowsPerPageStepDefs {

    BasePage basePage = new BasePage();

    @When("the advisor navigates to the {string} section")
    public void the_advisor_navigates_to_the_section(String module) {
        basePage.clickButton(module);
        assertWebElement(basePage.pageHeader).waitForVisibility(5).waitForTextToBe(5, module);
        assertWebElement(basePage.pageHeader).hasAttribute("innerText").ofAttributeValue(module);
    }
    @Then("the default Rows Per Page in {string} should be set to {string}")
    public void the_default_rows_per_page_in_should_be_set_to(String module, String numberOfRows) {
        assertWebElement(basePage.rowsPerPageLabel).hasText(numberOfRows);
    }
    @When("the advisor changes Rows Per Page to {string} in {string} section")
    public void the_advisor_changes_rows_per_page_to_in_section(String targetNumberOfRows, String module) {
        basePage.rowsPerPageInput.click();
        basePage.clickButton(targetNumberOfRows);
    }
    @When("the default Rows Per Page in {string} section should be set to {string}")
    public void the_default_rows_per_page_in_section_should_be_set_to(String modules, String targetNumberOfRows) {
        System.out.println("=====================================================");
    }
    @Then("the Rows Per Page setting in {string} section should be updated to {string}")
    public void the_rows_per_page_setting_in_section_should_be_updated_to(String module, String targetNumberOfRows) {
        assertWebElement(basePage.rowsPerPageLabel).hasText(targetNumberOfRows);
    }
    @Then("the Rows Per Page setting in Users section should be updated to {string}")
    public void the_rows_per_page_setting_in_users_section_should_be_updated_to(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
