package io.loopcamp.pages.docuport;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage{
    @FindBy(xpath = "//span[.='Email address']//parent::div//following-sibling::div//child::span")
    public WebElement emailAddress;

}
