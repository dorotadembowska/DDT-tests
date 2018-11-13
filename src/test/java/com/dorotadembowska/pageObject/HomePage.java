package com.dorotadembowska.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    @FindBy(xpath = "//span[contains(text(),'Home')]")
    private WebElement homeLinkElement;
    @FindBy(xpath = "//span[contains(text(),'Find owners')]")
    private WebElement findOwnerLinkElement;
    @FindBy(xpath = "//span[contains(text(),'Veterinarians')]")
    private WebElement veterinariansLinkElement;
    private WebDriver driver;
    private Waits waits;
    public HomePage(WebDriver driver){
        this.driver = driver;
        waits = new Waits();
        PageFactory.initElements(driver, this);
    }
    public void clickFindOwner(){
        findOwnerLinkElement.click();
    }
}
