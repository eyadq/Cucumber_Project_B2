package io.loopcamp.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.InputMismatchException;

public class DocuportUtils {

    /**
     * logins to docuport application
     * @param role, comes from docuport constants
     * @author eyad
     */
    public static void login(String role) throws InterruptedException {
        //driver.get("https://beta.docuport.app");
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        WebElement username = Driver.getDriver().findElement(By.xpath("//label[text()='Username or email']//following-sibling::input"));
        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@type='password']"));
        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));

        switch (role.toLowerCase()){
            case "client":
                username.sendKeys(DocuportConstants.USERNAME_CLIENT);
                password.sendKeys(DocuportConstants.PASSWORD);


                break;
            case "supervisor":
                username.sendKeys(DocuportConstants.USERNAME_SUPERVISOR);
                password.sendKeys(DocuportConstants.PASSWORD);
                break;
            case "advisor":
                username.sendKeys(DocuportConstants.USERNAME_ADVISOR);
                password.sendKeys(DocuportConstants.PASSWORD);
                break;
            case "employee":
                username.sendKeys(DocuportConstants.USERNAME_EMPLOYEE);
                password.sendKeys(DocuportConstants.PASSWORD);
                break;
            default: throw new InputMismatchException("There is not such role: " + role);
        }

        loginButton.click();

        if(role.toLowerCase().equals("client")){
            Thread.sleep(3000);

            WebElement cont = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
            cont.click();
            Thread.sleep(3000);
        }


    }

    /**
     * logs out from application
     * @param driver
     * @author eyadq
     */
    public static void logOut(){
        WebElement userIcon = Driver.getDriver().findElement(By.xpath("//div[@class='v-avatar primary']"));

        userIcon.click();

        WebElement logoutButton = Driver.getDriver().findElement(By.xpath("//span[text()='Log out']"));
        logoutButton.click();
    }
}
