package com.dorotadembowska.testDDT;

import static org.assertj.core.api.Assertions.assertThat;

import com.dorotadembowska.pageObject.*;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

@RunWith(DataProviderRunner.class)
public class AddOwnersTest {
    private static final String PAGE_URL = "http://localhost:8080/";
    private WebDriver driver;
    private HomePage homePage;
    private FindOwnersPage findOwnersPage;
    private AddOwnerPage addOwnerPage;
    private OwnerInformationPage ownerInformationPage;
    @DataProvider
    public static Object[][] testForAddingOwners()
    {        return new String[][]{
            new String[]{"Olek", "Kowalski", "Aleja Biala 5", "Opole", "789456123"},
            new String[]{"Kamila", "Nowak", "Ulica Kochanowskiego 10", "Gdansk", "123456789"},
            new String[]{"Ania", "Kowalska", "Ulica Mickiewicza 63/5", "Warszawa", "234567891"},
            new String[]{"Pawel", "Wisniewski", "Ulica Nowa 12", "Bydgoszcz", "345678912"},
            new String[]{"Jan", "Wozniak", "Ulica Nowa 24", "Lublin", "456789123"},
    };
    }
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/osboxes/mavenprojectddt/src/utils/drivers/chrome/chromedriver_Linux64");
        driver = new ChromeDriver();
        homePage = PageFactory.initElements(driver, HomePage.class);
        findOwnersPage = PageFactory.initElements(driver, FindOwnersPage.class);
        addOwnerPage = PageFactory.initElements(driver, AddOwnerPage.class);
        ownerInformationPage = PageFactory.initElements(driver, OwnerInformationPage.class);
        driver.get(PAGE_URL);
    }
    @Test
    @UseDataProvider("testForAddingOwners")
    public void addNewOwner(String firstName, String lastName, String address, String city, String telephone) {
        homePage.clickFindOwner();
        findOwnersPage.chooseLabelAddOwner();
        addOwnerPage.inputOwnerDetails(firstName, lastName, address, city, telephone);
        ownerInformationPage.getTextFromOwnerInformationPage();
        assertThat(ownerInformationPage.getTextFromOwnerInformationPage().contains("Owner Information"));
    }
    @After
    public void tearDown() {
        driver.close();
    }
}


