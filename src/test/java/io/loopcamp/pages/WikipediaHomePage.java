package io.loopcamp.pages;

import io.loopcamp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikipediaHomePage {

    @FindBy(id = "searchInput")
    public WebElement searchInput;

    @FindBy(className = "pure-button")
    public WebElement searchButton;

    public WikipediaHomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
