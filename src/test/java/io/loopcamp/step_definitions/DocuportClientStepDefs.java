package io.loopcamp.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.it.Ma;
import io.loopcamp.pages.docuport.BasePage;
import io.loopcamp.pages.docuport.ClientsPage;
import io.loopcamp.pages.docuport.LoginPage;
import io.loopcamp.utilities.BrowserUtils;
import io.loopcamp.utilities.ConfigurationReader;
import io.loopcamp.utilities.Driver;
import org.assertj.core.api.SoftAssertions;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DocuportClientStepDefs {

    ClientsPage clientsPage = new ClientsPage();
    private SoftAssertions softAssertions = new SoftAssertions();

    @Given("user is on Docuport login page")
    public void user_is_on_docuport_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        BrowserUtils.takeScreenshot();
    }
    @Then("user validates {string} text is displayed")
    public void user_validates_text_is_displayed(String text) {
        String actual = clientsPage.getElement(text).getText();
        softAssertions.assertThat(actual).isEqualTo(text);
    }
    @Then("user enters credentials")
    public void user_enters_credentials(Map<String, String> credentials) {
        new LoginPage().loginDocuport(credentials.get("username"), credentials.get("password"));
    }

    @Given("user valdates all soft assertions")
    public void user_valdates_all_soft_assertions() {
        softAssertions.assertAll();
    }


}
