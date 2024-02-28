package io.loopcamp.step_definitions.docuport;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.loopcamp.pages.docuport.BasePage;
import io.loopcamp.utilities.ConfigurationReader;
import io.loopcamp.utilities.Driver;
import org.junit.Assert;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class VerifyToolbarElementsStepDef {

    @When("User navigates to {string}")
    public void user_navigates_to(String module) {
        new BasePage().clickButton(module);
        String urlExpected = ConfigurationReader.getProperty("env") + module.toLowerCase().replace(" ", "-");
        Assert.assertEquals(urlExpected, Driver.getDriver().getCurrentUrl());
    }

    @Then("User verifies {string} elements")
    public void user_verifies_elements(String module, List<List<String>> allLists) {
        List <String> items = allLists.get(0);
        BasePage basePage = new BasePage();
        for (String item : items){
            assertTrue(basePage.getElement(item).isDisplayed());
        }
    }

}
