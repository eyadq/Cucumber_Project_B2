package io.loopcamp.step_definitions.docuport;

import io.loopcamp.pages.docuport.BasePage;
import io.loopcamp.pages.docuport.LoginPage;
import io.loopcamp.utilities.ConfigurationReader;
import io.loopcamp.utilities.DocuportConstants;
import io.loopcamp.utilities.Driver;

public class ButtonTest {

    public static void main(String[] args) {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        new LoginPage().loginDocuport(DocuportConstants.USERNAME_ADVISOR, DocuportConstants.PASSWORD);
        BasePage basePage = new BasePage();
        basePage.clickButton("1099 Form");
        basePage.clickButton("Current year (2023)");
        basePage.clickButton("2022");
    }
}
