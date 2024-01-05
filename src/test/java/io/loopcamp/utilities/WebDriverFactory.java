package io.loopcamp.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverFactory {


    /**
     * @param browserTyoe
     * @return WebDriver specific to browser
     * @author eyadq
     */
    public static WebDriver getDriver(String browserTyoe){
        if(browserTyoe.equalsIgnoreCase("Firefox")){
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else if(browserTyoe.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if (browserTyoe.equalsIgnoreCase("Safari")) {
            WebDriverManager.safaridriver().setup();
            return new SafariDriver();
        } else {
            System.out.println("No driver found.\nDriver is null");
            return null;
        }
    }
}
