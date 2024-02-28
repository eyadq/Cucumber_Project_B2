package io.loopcamp.pages;

import io.loopcamp.utilities.BrowserUtils;
import io.loopcamp.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPage {

    public ProductPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void clickCategory(String category){
        String xpath = "//a[contains(.,'" + category + "')]";
        Driver.getDriver().findElement(By.xpath(xpath)).click();
    }

    public String getProductPrice(String productName){
        String xpath = "//a[normalize-space(.)='" + productName + "']/../../h5";
        BrowserUtils.justWait(2);
        String actualPrice = Driver.getDriver().findElement(By.xpath(xpath)).getText();
        return actualPrice.substring(1);
    }
}
