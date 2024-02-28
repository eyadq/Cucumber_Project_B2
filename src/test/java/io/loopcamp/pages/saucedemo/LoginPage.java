package io.loopcamp.pages.saucedemo;


import io.loopcamp.utilities.Driver;
import net.datafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginPage {
    private Faker faker = new Faker();
    public List<String> userNames;
    public List<String> passwords;
    @FindBy(id = "user-name")
    public WebElement usernameInput;
    @FindBy(id = "password")
    public WebElement passwordInput;
    @FindBy(id = "login-button")
    public WebElement loginButton;
    @FindBy(id = "login_credentials")
    public WebElement loginUsernames;
    @FindBy(className = "login_password")
    public WebElement loginPassword;

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
        userNames = new ArrayList<>(Arrays.stream(loginUsernames.getText().split("\n")).toList());
        userNames.removeIf(each-> !each.endsWith("_user"));
        passwords = new ArrayList<>(Arrays.stream(loginPassword.getText().split("\n")).toList());
        passwords.removeIf(each-> !each.endsWith("_sauce"));
    }

    public void login(int indexOfUserNameList, boolean useCorrectPassword){
        usernameInput.clear();
        usernameInput.sendKeys(userNames.get(indexOfUserNameList));
        passwordInput.clear();
        String password = useCorrectPassword ? passwords.get(0) : faker.animal().name() + faker.numerify("###");
        passwordInput.sendKeys(password);
        loginButton.click();


    }
}
