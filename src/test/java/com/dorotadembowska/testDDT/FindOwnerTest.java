package com.dorotadembowska.testDDT;

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

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(DataProviderRunner.class)
public class FindOwnerTest {
    private static final String PAGE_URL = "http://localhost:8080/";
    private WebDriver driver;
    private HomePage homePage;
    private FindOwnersPage findOwnersPage;
    private OwnerInformationPage ownerInformationPage;
        @DataProvider
    public static Object[][] testForFindingOwners()
    {        return new String[][]{
            new String[]{"Kowalski"},
            new String[]{"Nowak"},
            new String[]{"Kowalska"},
            new String[]{"Wisniewski"},
            new String[]{"Wozniak"},
    };
    }
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/osboxes/mavenprojectddt/src/utils/drivers/chrome/chromedriver_Linux64");
        driver = new ChromeDriver();
        homePage = PageFactory.initElements(driver, HomePage.class);
        findOwnersPage = PageFactory.initElements(driver, FindOwnersPage.class);
        ownerInformationPage = PageFactory.initElements(driver, OwnerInformationPage.class);
        driver.get(PAGE_URL);
    }
    @Test
    @UseDataProvider("testForFindingOwners")
    public void findOwner( String lastName) {
        homePage.clickFindOwner();
        findOwnersPage.typeOwnerLastName(lastName);
        findOwnersPage.chooseButtonFindOwner();
        ownerInformationPage.getTextFromOwnerInformationPage();
        assertThat(ownerInformationPage.getTextFromOwnerInformationPage().contains("Owner Information"));
           }
    @After
    public void tearDown() {
        driver.close();
    }
}
