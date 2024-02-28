package io.loopcamp.step_definitions.docuport;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.loopcamp.pages.docuport.BasePage;
import io.loopcamp.pages.docuport.ClientsPage;
import io.loopcamp.utilities.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

import static io.loopcamp.utilities.DocuportConstants.*;

public class NewClientStepDefs {

    @Given("user creates new client")
    public void user_creates_new_client() {
        //Go to Clients Page
        BasePage basePage = new BasePage();
        basePage.clickButton(BUTTON_CLIENTS);

        //Create new user and save
        ClientsPage clientsPage = new ClientsPage();
        clientsPage.createNewClientButton.click();
        clientsPage.createNewClientType(ClientsPage.ClientType.PERSONAL);
        clientsPage.clickButton(BUTTON_CREATE_NEW_USER);

        BasePage.sendTextToInputFieldUsingLabel(LABEL_FIRST_NAME, SMITTY_WERBENJAGERMANJENSEN_FIRST_NAME);
        BasePage.sendTextToInputFieldUsingLabel(LABEL_LAST_NAME, SMITTY_WERBENJAGERMANJENSEN_LAST_NAME);
        BasePage.sendTextToInputFieldUsingLabel(LABEL_EMAIL_ADDRESS, USERNAME_SMITTY_WERBENJAGERMANJENSEN);
        BasePage.sendTextToInputFieldUsingLabel(LABEL_PHONE_NUMBER, SMITTY_WERBENJAGERMANJENSEN_PHONE_NUMBER);
        BasePage.sendTextToInputFieldUsingLabel(LABEL_PASSWORD, PASSWORD_SMITTY_WERBENJAGERMANJENSEN);
        BasePage.sendTextToInputFieldUsingLabel(LABEL_CONFIRM_PASSWORD, PASSWORD_SMITTY_WERBENJAGERMANJENSEN);
        clientsPage.advisorDropdown.click();
        clientsPage.selectDropdownOption(SMITTY_WERBENJAGERMANJENSEN_ADVISOR);
        clientsPage.saveButton.click();

        clientsPage = new ClientsPage();
        BrowserUtils.waitForClickable(clientsPage.advisorDropdown, 10);
        clientsPage.advisorDropdown.click();
        BrowserUtils.waitForClickable(clientsPage.getDropDownOptions().get(0), 5);
        clientsPage.selectDropdownOption(DocuportConstants.SMITTY_WERBENJAGERMANJENSEN_ADVISOR);
        clientsPage.servicesDropdown.click();
        BrowserUtils.waitForClickable(clientsPage.getDropDownOptions().get(0), 5);
        clientsPage.selectDropdownOption("testing");

        BrowserUtils.waitForClickable(new BasePage().userMenu, 5);
    }

    @Test
    @Then("new account is deleted")
    public void new_account_is_deleted() {
        DB_Utility.createConnection(DOCUPORT_DATABASE_URL, DOCUPORT_DATABASE_USERNAME, DOCUPORT_DATABASE_PASSWORD);

        String queryFindUser = "select * from postgres.document.users where first_name = 'Smitty' and last_name = 'Werbenjagermanjensen'";
        String queryFindIdentity = "select * from postgres.identity.users where first_name = 'Smitty' and last_name = 'Werbenjagermanjensen";
        String queryDeleteUser = "delete from postgres.document.users where first_name = 'Smitty' and last_name = 'Werbenjagermanjensen'";
        String queryDeleteIdentity = "delete from postgres.identity.users where first_name = 'Smitty' and last_name = 'Werbenjagermanjensen'";

        DB_Utility.runQuery(queryFindUser);

        Map<String,String> rowActual =  DB_Utility.getRowMap(1);

        if(!rowActual.isEmpty()){
            DB_Utility.runQuery(queryDeleteUser);
            DB_Utility.runQuery(queryDeleteIdentity);
            DB_Utility.runQuery("commit");
            DB_Utility.runQuery(queryFindUser);
            rowActual =  DB_Utility.getRowMap(1);
        }
        Assert.assertTrue(rowActual.isEmpty());
    }
}
