package io.loopcamp.assertions;

import io.loopcamp.utilities.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.AbstractAssert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class WebElementAssert extends AbstractAssert<WebElementAssert, WebElement> {

    private static final Logger LOG = LogManager.getLogger();
    private static Duration currentImplicitWaitDuration;
    private String expectedConditionErrorMessage;
    private String attributeName;
    protected WebElementAssert(WebElement actual) {
        super(actual, WebElementAssert.class);
    }

    public WebElement getElement(){
        return actual;
    }

    /*

    WebElement Assertions

     */
    public WebElementAssert hasText(String textExpected){
        isNotNull();
        if(!Objects.equals(actual.getAttribute("innerText"), textExpected)){
            failWithMessage("Expected text of the " + getNameForElement() + " to be <%s> but was <%s>", textExpected, actual.getAttribute("innerText"));
        }
        return this;
    }

    public WebElementAssert hasLink(String linkExpected){
        isNotNull();
        if(!Objects.equals(actual.getAttribute("href"), linkExpected)){
            failWithMessage("Expected link of the " + getNameForElement() + " to be <%s> but was <%s>", linkExpected, actual.getAttribute("href"));
        }
        return this;
    }
    public WebElementAssert hasAttribute(String attributeName){
        isNotNull();
        if(actual.getAttribute(attributeName) == null){
            failWithMessage("No attribute of <%s> for " + getNameForElement(), attributeName);
        }else {
            this.attributeName = attributeName;
        }
        return this;
    }

    public WebElementAssert ofAttributeValue(String attributeValue){
        isNotNull();
        if(!Objects.equals(actual.getAttribute(attributeName), attributeValue)){
            failWithMessage("Expected attribute value of the " + getNameForElement() + " to be <%s> but was <%s>", attributeValue, actual.getAttribute(attributeName));
        }
        return this;
    }

    /*

    Explicit Waits

     */

    private WebElementAssert waitForWebElement(int timeToWaitInSec, ExpectedCondition<WebElement> expectedCondition, String expectedConditionErrorMessage) {
        setImplicitWaitDurationToZero();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeToWaitInSec));
        WebElement element = null;

        try{
            element = wait.until(expectedCondition);
        } catch (TimeoutException e){
            LOG.error(expectedConditionErrorMessage + " returning a null value", e);
        }

        resetImplicitWaitDuration();

        if(element == null)
            failWithMessage(expectedConditionErrorMessage);

        return this;
    }

    private WebElementAssert waitForBoolean(int timeToWaitInSec, ExpectedCondition<Boolean> expectedCondition, String expectedConditionErrorMessage) {
        setImplicitWaitDurationToZero();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeToWaitInSec));
        boolean b = false;

        try{
            b = wait.until(expectedCondition);
        } catch (TimeoutException e){
            LOG.error(expectedConditionErrorMessage + " returning false", e);
        }

        resetImplicitWaitDuration();

        if(!b)
            failWithMessage(expectedConditionErrorMessage);

        return this;
    }

    public WebElementAssert waitForClickable(int timeToWaitInSec){
        waitForWebElement(timeToWaitInSec, ExpectedConditions.elementToBeClickable(actual), "Time out while waiting for element to be clickable");
        return this;
    }

    public WebElementAssert waitForVisibility(int timeToWaitInSec) {
        waitForWebElement(timeToWaitInSec, ExpectedConditions.visibilityOf(actual), "Time out while waiting for element to be visible");
        return this;
    }

    public WebElementAssert waitForInvisibility(int timeToWaitInSec){
        waitForBoolean(timeToWaitInSec, ExpectedConditions.invisibilityOf(actual), "Time out while waiting for element to be visible");
        return this;
    }
    public WebElementAssert waitForTextToBe(int timeToWaitInSec, String textToBeInElement){
        waitForBoolean(timeToWaitInSec, ExpectedConditions.textToBePresentInElement(actual, textToBeInElement), "Time out while waiting for text in element to change");
        return this;
    }

    /*

    Actions involving Web Elements

     */
    public WebElementAssert hover(){
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(actual).perform();
        return this;
    }

    public WebElementAssert scrollToElement(){
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", actual);
        return this;
    }

    public WebElementAssert clickWIthJS(){
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", actual);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click;", actual);
        return this;
    }

    public WebElementAssert doubleClick(){
        new Actions(Driver.getDriver()).doubleClick(actual).build().perform();
        return this;
    }
    public WebElementAssert click(){
        actual.click();
        return this;
    }

    /*

    Helper methods

     */
    private String getNameForElement(){
        String elementText = actual.getText();
        String elementTagName = actual.getTagName();

        if(elementText.isEmpty())
            elementText = "EmptyText";

        return "\"" + elementText + " " + elementTagName + "\"";
    }

    private void setImplicitWaitDurationToZero(){
        currentImplicitWaitDuration = Driver.getDriver().manage().timeouts().getImplicitWaitTimeout();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ZERO);
    }
    private void resetImplicitWaitDuration(){
        Driver.getDriver().manage().timeouts().implicitlyWait(currentImplicitWaitDuration);
    }

}
