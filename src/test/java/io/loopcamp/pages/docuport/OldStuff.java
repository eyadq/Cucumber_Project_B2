package io.loopcamp.pages.docuport;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OldStuff {

    //From Base page
    @FindBy(xpath = "//div[@class='v-list-item__title']//span")
    public List<WebElement> options;
    @FindBy(xpath = "//div[@class='v-list-item__title']")
    public List<WebElement> dropDownOptions;
    @FindBy(xpath = "//span[contains(text(), 'has been created successfully')]")
    public WebElement message;
    @FindBy(xpath = "//button[class='v-icon notranslate v-icon--link mdi mdi-close theme--light success--text v-snack__btn']")
    public WebElement closeMessageButton;
    @FindBy(xpath = "//span[.='Download']//parent::button")
    public WebElement downloadButton;
    @FindBy(xpath = "//span[.='Search']//parent::button")
    public WebElement searchButton;
    @FindBy(tagName = "h1")
    public WebElement moduleHeader;
    @FindBy(xpath = "//span[contains(text(),' Continue ')]")
    public WebElement continueButton;
    @FindBy(xpath = "//span[contains(., 'Home')]//parent::div")
    public WebElement homeButton;
    @FindBy(xpath = "//span[contains(., 'Invitations')]//parent::div")
    public WebElement invitationButton;
    @FindBy(xpath = "//img[@alt='Docuport']")
    public WebElement homeLogo;

    //From Profile Page
    @FindBy(xpath = "//div[@class='d-page__content']//child::span[.='Batch1 Group1']//parent::div//following-sibling::div")
    public WebElement role;
    @FindBy(xpath = "//span[.='First name']//parent::div//following-sibling::div//child::span")
    public WebElement firstName;
    @FindBy(xpath = "//span[.='Last name']//parent::div//following-sibling::div//child::span")
    public WebElement LastName;

    //From ClientPage
    @FindBy(xpath = "//span[@class='body-2']")
    public List<WebElement> newClientOptions;
    @FindBy(xpath = "//label[text()='Create new user']")
    public WebElement newUserCheckbox;

    /* References of examples of cliclable Buttons in Docuport
        Modules
        <div class="v-list-item__title">
            <span class="body-1">Home</span>
        </div>

        User Icon options
        <div class="v-list-item__title">
            <span class="body-2">Log out</span>
        </div>

        Drop down options
        <div class="v-list-item__content">
            <div class="v-list-item__title">Batch1 Group1</div>
        </div>

        Buttons with span containing text
        <button type="submit" class="text-none body-2 font-weight-medium v-btn v-btn--has-bg theme--light v-size--default success" data-twofas-element-number="1">
            <span class="v-btn__content"> Continue </span>
        </button>

        */
}
