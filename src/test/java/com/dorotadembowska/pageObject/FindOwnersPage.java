package com.dorotadembowska.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindOwnersPage {
    private WebDriver driver;
    @FindBy(id = "lastName")
    private WebElement fieldOwnerLastName;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonFindOwner;
    @FindBy(xpath = "//a[@class='btn btn-default']")
    private WebElement labelAddOwner;

    public FindOwnersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void typeOwnerLastName(String lastName) {
        fieldOwnerLastName.sendKeys(lastName);
    }

    public void chooseButtonFindOwner() {
        buttonFindOwner.click();
    }

    public void chooseLabelAddOwner() {
        labelAddOwner.click();
    }
}
//assertThat(cataloguePage.showingNineOfNineGetText().contains("Showing 9 of 9 products"));