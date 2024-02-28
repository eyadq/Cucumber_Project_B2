package io.loopcamp.step_definitions;

import io.loopcamp.pages.docuport.BasePage;
import io.loopcamp.pages.docuport.LoginPage;
import io.loopcamp.utilities.BrowserUtils;
import io.loopcamp.utilities.ConfigurationReader;
import io.loopcamp.utilities.DocuportConstants;
import io.loopcamp.utilities.Driver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static io.loopcamp.assertions.CustomAssertions.assertWebElement;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestWebElementAsserts {

    @Test
    public void testDocuport(){
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        new LoginPage().loginDocuport(DocuportConstants.USERNAME_ADVISOR, DocuportConstants.PASSWORD);
        BasePage basePage = new BasePage();

        BrowserUtils.waitForClickable(basePage.userMenu, 10);
        assertEquals("BG", basePage.userMenu.getText());
        basePage.userMenu.click();

        //Same as:

        assertWebElement(basePage.userMenu)
                .waitForClickable(5)
                .hasText("BG")
                .hasAttribute("innerText").ofAttributeValue("BG")
                .hasAttribute("class").ofAttributeValue("v-avatar primary")
                .hasAttribute("style").ofAttributeValue("height: 32px; min-width: 32px; width: 32px;")
                .hover()
                .click().click();


        assertWebElement(basePage.menuButton).waitForVisibility(5)
                .hover()
                .click()
                .click();

        BrowserUtils.justWait(3);

        basePage.clickButton("Users");
        basePage.clickButton("Leads");

        WebElement header =
                assertWebElement(basePage.pageHeader)
                .waitForVisibility(5)
                .waitForTextToBe(5, "Leads")
                 .getElement();


    }
}
