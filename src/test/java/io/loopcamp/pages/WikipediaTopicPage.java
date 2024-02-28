package io.loopcamp.pages;

import io.loopcamp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikipediaTopicPage {

    @FindBy(className = "mw-page-title-main")
    public WebElement topicHeader;

    public WikipediaTopicPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
