package io.loopcamp.pages.saucedemo;


import io.loopcamp.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class OrderPage extends BasePage {

    //public Select productSort;
    @FindBy(className = "product_sort_container")
    public WebElement productSortWebElement;
    @FindBy(xpath = "//div[@class='inventory_item_name ']")
    public List<WebElement> inventory;
    @FindBy(xpath = "//div[@class='inventory_item_price']")
    public List<WebElement> prices;

    public OrderPage(){
        PageFactory.initElements(Driver.getDriver(), this);
        //productSort = new Select(productSortWebElement);
    }

    public void addToCart(String itemName){
        String id = "add-to-cart-" + itemName.replace(" ", "-").toLowerCase();
        Driver.getDriver().findElement(By.id(id)).click();
    }

    public void switchProductOrder(String option){
        String value = "";
        switch(option){
            case "Name (A to Z)":
                value = "az";
                break;
            case "Name (Z to A)":
                value = "za";
                break;
            case "Price (low to high)":
                value = "lohi";
                break;
            case "Price (high to low)":
                value = "hilo";
                break;
            default:
                throw new IllegalArgumentException("That's not a valid option. Double check text in UI");
        }
        new Select(productSortWebElement).selectByValue(value);

    }
}
