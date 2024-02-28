package io.loopcamp.pages;

import io.loopcamp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SmartBearBasePage {

    @FindBy(css = "a[href='Process.aspx']")
    public WebElement orderLink;
    @FindBy(css = "a[href='Default.aspx']")
    public WebElement orderTable;

    public SmartBearBasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
