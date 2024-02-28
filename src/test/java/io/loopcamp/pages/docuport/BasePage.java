package io.loopcamp.pages.docuport;

import io.loopcamp.utilities.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    private static final Logger LOG = LogManager.getLogger();
    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//div[@class='v-avatar primary']")
    public WebElement userMenu;
    @FindBy(xpath = "//i[@class='v-icon notranslate mdi mdi-menu theme--light']")
    public WebElement menuButton;
    @FindBy(tagName = "h1")
    public WebElement pageHeader;
    @FindBy(xpath = "//span[@class='body-1']")
    public List<WebElement> leftNavigationMenu;
    @FindBy(className = "v-overlay__scrim")
    public WebElement overlay;
    @FindBy(xpath = "//div[@class='v-select__selection v-select__selection--comma']")
    public WebElement rowsPerPageLabel;
    @FindBy(xpath = "//i[@class='v-icon notranslate mdi mdi-menu-down theme--light']")
    public WebElement rowsPerPageInput;

    public void openLeftNavigationPanel() {
        WebElement hamburgerButton = Driver.getDriver()
                .findElement(By.xpath("//i[@class='v-icon notranslate mdi mdi-menu theme--light']/../.."));
        hamburgerButton.click();
    }

    public static void sendTextToInputFieldUsingLabel(String labelText, String textForInput){
        String xpath = "//label[.='" + labelText + "']//following-sibling::input";
        WebElement element = Driver.getDriver().findElement(By.xpath(xpath));
        element.clear();
        element.sendKeys(textForInput);
        LOG.info("Sent: " + textForInput + " ---> " + labelText + " input field");
    }
    public WebElement getElement(String text) {
        //String xpath = "//*[normalize-space()='" + text + "  ']";
        //String xpath = "//*[normalize-space()='" + text + "']";
        String xpath = "//*[contains(text(),'" + text + "')]";
        WebElement element = Driver.getDriver().findElement(By.xpath(xpath));
        LOG.info("Found element with  text: " + text + " of tagName: " + element.getTagName());
        return Driver.getDriver().findElement(By.xpath(xpath));
    }
    public void clickButton(String buttonText) {
        Duration implicitWaitTimeout = Driver.getDriver().manage().timeouts().getImplicitWaitTimeout();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ZERO);
        String xpath = "//*[normalize-space(text())='" + buttonText + "']";
        try{
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(1));
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            new Actions(Driver.getDriver()).moveToElement(button).click(button).perform();
            LOG.info("Clicked on button of: " + buttonText + " ---> URL is now at: " + Driver.getDriver().getCurrentUrl());

        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("No element found with text: " + buttonText);
        }
        Driver.getDriver().manage().timeouts().implicitlyWait(implicitWaitTimeout);

    }

    public List<WebElement> getDropDownOptions() {
        return Driver.getDriver().findElements(By.xpath("//div[@class='v-list-item__title']"));
    }
    public List<WebElement> getOptions(){
        return Driver.getDriver().findElements(By.xpath("//div[@role='listbox']//div[@class='v-list-item__content']"));
    }

    public void selectDropdownOption(String buttonText) {
        try{
            for (WebElement each : getDropDownOptions()) {
            if (each.getText().equals(buttonText)) {
                each.click();
            }
        }
            LOG.info("Clicked on dropdown option of: " + buttonText);
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("No element found with text: " + buttonText);
        }

    }
}

