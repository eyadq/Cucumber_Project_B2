package io.loopcamp.pages;

import io.loopcamp.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SmartBearOrderPage extends SmartBearBasePage {
    public Select productDropdown;
    @FindBy(id = "ctl00_MainContent_fmwOrder_ddlProduct")
    private WebElement productDropdownWebElement;
    @FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
    public WebElement quantityInput;
    @FindBy(id = "ctl00_MainContent_fmwOrder_txtName")
    public WebElement customerNameInput;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox2")
    public WebElement streetInput;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox3")
    public WebElement cityInput;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox4")
    public WebElement stateInput;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox5")
    public WebElement zipInput;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox6")
    public WebElement cardNumberInput;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox1")
    public WebElement expirationDateInput;
    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_0")
    public WebElement visaRadioButton;
    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_1")
    public WebElement masterCardRadioButton;
    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_2")
    public WebElement americanExpressRadioButton;
    @FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
    public WebElement processButton;

    public SmartBearOrderPage(){
        PageFactory.initElements(Driver.getDriver(), this);
        productDropdown = new Select(productDropdownWebElement);
    }

    public List<WebElement> getRow(String customerName){
        String xpath = "//td[.='Chuck Norris']//parent::tr//child::td";
        List<WebElement> rowData = Driver.getDriver().findElements(By.xpath("//td[.='" + customerName + "']//parent::tr//child::td"));
        rowData.remove(0);
        rowData.remove(rowData.size()-1);
        return rowData;
    }


}
