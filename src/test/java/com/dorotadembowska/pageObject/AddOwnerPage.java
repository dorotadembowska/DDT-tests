package com.dorotadembowska.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddOwnerPage {
    private WebDriver driver;
    @FindBy(id="firstName")
    private WebElement fieldFirstName;
    @FindBy(id="lastName")
    private WebElement fieldLastName;
    @FindBy(id="address")
    private WebElement fieldAddress;
    @FindBy(id="city")
    private WebElement fieldCity;
    @FindBy(id="telephone")
    private WebElement fieldTelephone;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonAddOwner;
    public AddOwnerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void inputOwnerDetails(String firstName, String lastName, String address, String city, String telephone){
        fieldFirstName.sendKeys(firstName);
        fieldLastName.sendKeys(lastName);
        fieldAddress.sendKeys(address);
        fieldCity.sendKeys(city);
        fieldTelephone.sendKeys(telephone);
        buttonAddOwner.click();
    }
}
