package io.loopcamp.pages.docuport;

import io.loopcamp.utilities.BrowserUtils;
import io.loopcamp.utilities.DocuportConstants;
import io.loopcamp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public static final String usernameLabel = "Username or email";
    public static final String passwordLabel = "Password";

    @FindBy(xpath = "//label[.='" + usernameLabel + "']//following-sibling::input")
    public WebElement usernameInput;
    @FindBy(xpath = "//label[.='" + passwordLabel + "']//following-sibling::input")
    public WebElement passwordInput;
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void loginDocuport(String username, String password){
        BrowserUtils.waitForVisibility(usernameInput, DocuportConstants.small);
        sendTextToInputFieldUsingLabel(DocuportConstants.LABEL_USERNAME_OR_EMAIL, username);
        sendTextToInputFieldUsingLabel(DocuportConstants.LABEL_PASSWORD, password);
        BrowserUtils.current_user = username;
        clickButton(DocuportConstants.BUTTON_LOG_IN);

        //If user is client, hit the green continue button
        if(username.contains("client")){
            BrowserUtils.waitForClickable(getElement("Continue"), DocuportConstants.large);
            clickButton(DocuportConstants.BUTTON_CONTINUE);
        }
    }


}
