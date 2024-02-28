package io.loopcamp.pages.saucedemo;


import io.loopcamp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    public WebElement shoppingCart;

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
