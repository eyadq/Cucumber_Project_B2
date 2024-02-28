package io.loopcamp.step_definitions.docuport;

import io.cucumber.java.en.Given;
import io.loopcamp.pages.docuport.BasePage;
import io.loopcamp.pages.docuport.LoginPage;
import io.loopcamp.pages.docuport.ProfilePage;
import io.loopcamp.utilities.BrowserUtils;
import io.loopcamp.utilities.ConfigurationReader;
import io.loopcamp.utilities.DocuportConstants;
import io.loopcamp.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;

import java.time.Duration;

public class LogInLogOutStepDefs {

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

    @Given("User logs into Docuport as {string}")
    public void user_logs_into_docuport_as(String userType) {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

        boolean assertUsingProfilePage = true;
        String username = "";
        String password = DocuportConstants.PASSWORD;
        switch (userType) {
            case "client":
                username = DocuportConstants.USERNAME_CLIENT;
                break;
            case "employee":
                username = DocuportConstants.USERNAME_EMPLOYEE;
                break;
            case "advisor":
                username = DocuportConstants.USERNAME_ADVISOR;
                break;
            case "supervisor":
                username = DocuportConstants.USERNAME_SUPERVISOR;
                break;
            case "smitty":
                username = DocuportConstants.USERNAME_SMITTY_WERBENJAGERMANJENSEN;
                password = DocuportConstants.PASSWORD_SMITTY_WERBENJAGERMANJENSEN;
                assertUsingProfilePage = false;
                break;
        }
        new LoginPage().loginDocuport(username, password);

        if(assertUsingProfilePage) {
            ProfilePage profilePage = new ProfilePage();
            try {
                BrowserUtils.waitForInvisibility(profilePage.overlay, DocuportConstants.large);
            } catch (TimeoutException e){
                System.out.println("The overlay got in the way again");
            }
            BrowserUtils.waitForClickable(profilePage.userMenu, DocuportConstants.large).click();
            profilePage.clickButton(DocuportConstants.BUTTON_PROFILE);

            Assert.assertEquals("The actual user type role obtained from the profile did not meet expected value from the scenario", username, profilePage.emailAddress.getText());
        } else {
            //find a different method for verify new client
        }
        BrowserUtils.takeScreenshot();
    }

    @Given("User logs out of Docuport")
    public void user_logs_out_of_docuport() {
        BasePage basePage = new BasePage();
        BrowserUtils.waitForClickable(basePage.userMenu, 10).click();
        basePage.clickButton(DocuportConstants.BUTTON_LOG_OUT);
        BrowserUtils.waitForClickable(new LoginPage().getElement(DocuportConstants.BUTTON_LOG_IN), DocuportConstants.large);
        Assert.assertTrue(new LoginPage().getElement(DocuportConstants.BUTTON_LOG_IN).isDisplayed());

        BrowserUtils.takeScreenshot();
    }

}
