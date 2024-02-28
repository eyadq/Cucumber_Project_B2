package io.loopcamp.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.loopcamp.pages.WikipediaHomePage;
import io.loopcamp.pages.WikipediaTopicPage;
import io.loopcamp.utilities.BrowserUtils;
import io.loopcamp.utilities.ConfigurationReader;
import io.loopcamp.utilities.Driver;
import org.junit.Assert;

public class WikipediaStepDefs {

    WikipediaHomePage wikipediaHomePage;
    WikipediaTopicPage wikipediaTopicPage;

    @Given("the user is on the Wikipedia home page.")
    public void the_user_is_on_the_wikipedia_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("wikipedia.url"));
        wikipediaHomePage = new WikipediaHomePage();
        BrowserUtils.takeScreenshot();
    }

    @When("the user types {string} in the wiki search box.")
    public void the_user_types_in_the_wiki_search_box(String topic) {
        wikipediaHomePage.searchInput.clear();
        wikipediaHomePage.searchInput.sendKeys(topic);
        BrowserUtils.takeScreenshot();
    }

    @When("the user clicks the wiki search button.")
    public void the_user_clicks_the_wiki_search_button() {
        wikipediaHomePage.searchButton.click();
    }

    @Then("the user should see the page with {string} in the wiki title.")
    public void the_user_should_see_the_page_with_in_the_wiki_title(String topic) {
        Assert.assertEquals("Actual title of page did not match expected title", topic + " - Wikipedia", Driver.getDriver().getTitle());
        BrowserUtils.takeScreenshot();
    }

    @Then("the user should see the page with {string} in the main header.")
    public void theUserShouldSeeThePageWithInTheMainHeader(String topic) {
        wikipediaTopicPage = new WikipediaTopicPage();
        Assert.assertEquals("Actual main header of page did not match expected title", topic, wikipediaTopicPage.topicHeader.getText());
        BrowserUtils.takeScreenshot();
    }
}
