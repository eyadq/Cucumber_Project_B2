package io.loopcamp.pages.saucedemo;

import io.loopcamp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutTwoPage extends BasePage {

    @FindBy(className = "inventory_item_name")
    public List<WebElement> cartItemNames;
    @FindBy(className = "inventory_item_price")
    public List<WebElement> cartItemPrices;
    @FindBy(id = "finish")
    public WebElement finishButton;
    @FindBy(className = "summary_tax_label")
    public WebElement taxes;
    @FindBy(className = "summary_total_label")
    public WebElement total;

    public CheckoutTwoPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
