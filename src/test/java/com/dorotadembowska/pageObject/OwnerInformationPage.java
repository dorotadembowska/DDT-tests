package com.dorotadembowska.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OwnerInformationPage {
    private WebDriver driver;
    @FindBy (xpath = "//h2[contains(text(),'Owner Information')]")
    private WebElement ownerInformation;
    @FindBy(xpath = "//a[contains(text(),'Owner')]")
    private WebElement editOwnerLabel;
    public OwnerInformationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String getTextFromOwnerInformationPage(){
        return ownerInformation.getText();
    }
}
