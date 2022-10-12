package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminCitiesPage;
import pages.LoginPage;

import java.util.List;

public class AdminCitiesTest extends BaseTest {

    private AdminCitiesPage adminCitiesPage;
    private LoginPage loginPage;


    @BeforeClass
    @Override
    public void setUp() {
        super.setUp();
        adminCitiesPage = new AdminCitiesPage(driver);
        loginPage = new LoginPage(driver);
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities");
    }

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        driver.get("https://vue-demo.daniel-avellaneda.com/login");
        loginPage.logIn("admin@admin.com", "12345");
        adminCitiesPage.getAdminButton().click();
        adminCitiesPage.getCitiesButton().click();
    }

    @AfterMethod
    public void afterMethod() {
        List<WebElement> logout = driver.findElements(By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]/span"));
        if (logout.size() == 1) {
            logout.get(0).click();
        }
    }

    @Test
    public void visitAdminCities() {
        String actualResultAdminCities = driver.getCurrentUrl();
        String expectedResultAdminCities = "https://vue-demo.daniel-avellaneda.com/admin/cities";
        Assert.assertEquals(actualResultAdminCities, expectedResultAdminCities);

        boolean actualResultLogoutButton = loginPage.getLogoutButton().isDisplayed();
        boolean expectedResultLogoutButton = true;
        Assert.assertEquals(actualResultLogoutButton, expectedResultLogoutButton);
    }

    @Test
    public void createCity() {
        adminCitiesPage.getNewItem().click();
        adminCitiesPage.createNewCity("Zimbabve");

        String actualSuccessfullySave = adminCitiesPage.getSuccessfullySave().getText();
        String expectedSuccesfullySave = "Saved successfully";
        Assert.assertTrue(actualSuccessfullySave.contains(expectedSuccesfullySave));

        adminCitiesPage.getDeleteButton().click();
        adminCitiesPage.getDeleteCityButton().click();
    }

    @Test
    public void editCity() throws InterruptedException {
        adminCitiesPage.getNewItem().click();
        adminCitiesPage.createNewCity("Zimbabve");
        // Waiters didn't work so I needed to use Thread.sleep
        Thread.sleep(3000);
        adminCitiesPage.getEditButton().click();
        adminCitiesPage.getNameField().click();

        adminCitiesPage.getNameField().sendKeys(" - edited");
        adminCitiesPage.getDriverWait().until(ExpectedConditions.visibilityOf(adminCitiesPage.getSaveButton()));
        adminCitiesPage.getSaveButton().click();

        adminCitiesPage.getDriverWait().until(ExpectedConditions.textToBe(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"),
                "Saved successfully\nCLOSE"));
        String actualSuccessfullySave = adminCitiesPage.getSuccessfullySave().getText();
        String expectedSuccesfullySave = "Saved successfully";
        Assert.assertTrue(actualSuccessfullySave.contains(expectedSuccesfullySave));

        adminCitiesPage.getDeleteButton().click();
        adminCitiesPage.getDeleteCityButton().click();
    }

    @Test
    public void searchCity() throws InterruptedException {
        adminCitiesPage.getNewItem().click();
        adminCitiesPage.createNewCity("Zimbabve - edited");

        String searchText = "Zimbabve - edited";
        adminCitiesPage.getSearchField().click();
        adminCitiesPage.getSearchField().sendKeys(searchText);
        // Waiters didn't work so I needed to use Thread.sleep
        Thread.sleep(3000);
        String actualCityText = adminCitiesPage.getNameOfCity().getText();

        Assert.assertTrue(actualCityText.contains(searchText));
        adminCitiesPage.getDeleteButton().click();
        adminCitiesPage.getDeleteCityButton().click();
    }

    @Test
    public void deleteCity() throws InterruptedException {
        adminCitiesPage.getNewItem().click();
        adminCitiesPage.createNewCity("Zimbabve - edited");

        String searchText = "Zimbabve - edited";
        adminCitiesPage.getSearchField().click();
        adminCitiesPage.getSearchField().sendKeys(searchText);
        Thread.sleep(3000);
        String actualCityText = adminCitiesPage.getNameOfCity().getText();
        Assert.assertTrue(actualCityText.contains(searchText));

        adminCitiesPage.getDeleteButton().click();
        adminCitiesPage.getDeleteCityButton().click();

        adminCitiesPage.getDriverWait().until(ExpectedConditions.textToBe(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"),
                "Deleted successfully\nCLOSE"));

        String actualDeletedSuccessfully = adminCitiesPage.getSuccessfullySave().getText();
        String expectedDeletedSuccessfully = "Deleted successfully";
        Assert.assertTrue(actualDeletedSuccessfully.contains(expectedDeletedSuccessfully));
    }
}
