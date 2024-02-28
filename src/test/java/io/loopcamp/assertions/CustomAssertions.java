package io.loopcamp.assertions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

public class CustomAssertions {

    public static WebElementAssert assertWebElement(WebElement actual){ return new WebElementAssert(actual);}

}
