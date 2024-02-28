package io.loopcamp.pages.saucedemo;


import io.loopcamp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOnePage extends BasePage {

    @FindBy(id = "first-name")
    public WebElement firstNameInput;
    @FindBy(id = "last-name")
    public WebElement lastNameInput;
    @FindBy(id = "postal-code")
    public WebElement postalCodeInput;
    @FindBy(id = "continue")
    public WebElement continueButton;

    public CheckoutOnePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
