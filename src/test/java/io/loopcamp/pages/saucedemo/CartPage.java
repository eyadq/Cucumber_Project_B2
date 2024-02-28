package io.loopcamp.pages.saucedemo;


import io.loopcamp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(className = "inventory_item_name")
    public List<WebElement> cartItemNames;
    @FindBy(className = "inventory_item_price")
    public List<WebElement> cartItemPrices;
    @FindBy(id = "checkout")
    public WebElement checkoutButton;

    public CartPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
