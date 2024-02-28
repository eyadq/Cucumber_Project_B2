package io.loopcamp.pages;

import io.loopcamp.utilities.BrowserUtils;
import io.loopcamp.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SmartBearLoginPage extends SmartBearBasePage{

    @FindBy(id = "ctl00_MainContent_username")
    public WebElement usernameInput;
    @FindBy(id = "ctl00_MainContent_password")
    public WebElement passwordInput;
    @FindBy(id = "ctl00_MainContent_login_button")
    public WebElement loginButton;

    public void login(){
        usernameInput.clear();
        usernameInput.sendKeys(ConfigurationReader.getProperty("smart.username"));
        passwordInput.clear();
        passwordInput.sendKeys(ConfigurationReader.getProperty("smart.password"));
        loginButton.click();
    }
}
