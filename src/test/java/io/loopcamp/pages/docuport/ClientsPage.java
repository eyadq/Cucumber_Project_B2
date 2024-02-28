package io.loopcamp.pages.docuport;

import io.loopcamp.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ClientsPage extends BasePage{

    public ClientsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[.='Create new client']//parent::button")
    public WebElement createNewClientButton;
    @FindBy(xpath = "//span[.=' Save ']//parent::button")
    public WebElement saveButton;
    @FindBy(xpath = "//label[.='Advisor']//following-sibling::input[@type='text']")
    public WebElement advisorDropdown;
    @FindBy(xpath = "//label[.='Services']//parent::div//child::input[@type='text']")
    public WebElement servicesDropdown;
    @FindBy(xpath = "//h3[.='Choose account']")
    public WebElement chooseAccountText;


    public enum ClientType{
        BUSINESS("Business"),
        PERSONAL("Personal");
        private String client;
        private ClientType(String client){this.client = client;}
        public String getClientType(){return client;}
    }
    public void createNewClientType(ClientType clientType){

        String xpath = "//span[@class='body-2']";
        for (WebElement element: Driver.getDriver().findElements(By.xpath(xpath)))
            if (clientType.getClientType().equals(element.getAttribute("innerText")))
                element.click();
    }
}
