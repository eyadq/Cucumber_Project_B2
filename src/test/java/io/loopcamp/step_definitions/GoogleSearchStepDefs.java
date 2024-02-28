package io.loopcamp.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Hook;
import io.loopcamp.pages.GoogleSearchPage;
import io.loopcamp.utilities.BrowserUtils;
import io.loopcamp.utilities.ConfigurationReader;
import io.loopcamp.utilities.DocuportConstants;
import io.loopcamp.utilities.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class GoogleSearchStepDefs {

    private static final Logger LOG = LogManager.getLogger();
    GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @Given("user is on Google search page")
    public void user_is_on_google_search_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("google.url"));
        LOG.info("User is on google page");
    }
    @When("user types Loop Academy in the Google search box and clicks enter")
    public void user_types_loop_academy_in_the_google_search_box_and_clicks_enter() {
        googleSearchPage.searchBox.sendKeys("Loop Academy" + Keys.ENTER);
        BrowserUtils.takeScreenshot();
    }
    @Then("user should see Loop Academy - Google Search in the google title")
    public void user_should_see_loop_academy_google_search_in_the_google_title() {
        String actualTitle = Driver.getDriver().getTitle();
        assertEquals("expected does not match the actual", "Loop Academy - Google Search", actualTitle);
    }

    @When("user types {string} in the Google search box and clicks enter")
    public void user_types_in_the_google_search_box_and_clicks_enter(String inputText) {
        googleSearchPage.searchBox.sendKeys(inputText + Keys.ENTER);
        BrowserUtils.takeScreenshot();
    }
    @Then("user should see {string} in the google title")
    public void user_should_see_in_the_google_title(String title) {
        String actualTitle = Driver.getDriver().getTitle();
        assertEquals("expected does not match the actual", title, actualTitle);
    }

    @Then("user searches for the following items")
    public void user_searches_for_the_following_items(List<Map<String, String>> items) {
//        items.forEach(item-> {
//            googleSearchPage.searchBox.clear();
//            googleSearchPage.searchBox.sendKeys(item + Keys.ENTER);
//            assertEquals(item + " - Google Search", Driver.getDriver().getTitle());
//        });

//        for (String item: items){
//            googleSearchPage.searchBox.clear();
//            googleSearchPage.searchBox.sendKeys(item + Keys.ENTER);
//            assertEquals(item + " - Google Search", Driver.getDriver().getTitle());
//        }

        for (Map<String, String> item : items){
            System.out.println(item.get("items"));
            googleSearchPage.searchBox.clear();
            googleSearchPage.searchBox.sendKeys(item.get("items") + Keys.ENTER);
        }
    }

    @When("user searches for the {string}")
    public void user_searches_for_the(String country) {
        googleSearchPage.searchBox.sendKeys("What is the capital of " + country + Keys.ENTER);
        BrowserUtils.justWait(DocuportConstants.small);
    }
    @Then("user should see the {string} for the result")
    public void user_should_see_the_for_the_result(String capital) {
        assertEquals("Expected capital city: " + capital + " did not match actual: " + googleSearchPage.capital.getText(),
                capital, googleSearchPage.capital.getText());
    }

}
