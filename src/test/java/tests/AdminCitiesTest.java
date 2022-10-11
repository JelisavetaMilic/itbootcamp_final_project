package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminCitiesPage;
import pages.LoginPage;

import java.time.Duration;

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

    @Test
    public void visitAdminCities() {
        String actualResultAdminCities = driver.getCurrentUrl();
        String expectedResultAdminCities = "https://vue-demo.daniel-avellaneda.com/admin/cities";

        Assert.assertEquals(actualResultAdminCities, expectedResultAdminCities);

        boolean actualResultLogoutButton = loginPage.getLogoutButton().isDisplayed();
        boolean expectedResultLogoutButton = true;

        Assert.assertEquals(actualResultLogoutButton, expectedResultLogoutButton);
        loginPage.getLogoutButton().click();
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
        loginPage.getLogoutButton().click();
    }

    @Test
    public void editCity() throws InterruptedException {
        adminCitiesPage.getNewItem().click();
        adminCitiesPage.createNewCity("Zimbabve");
        Thread.sleep(3000);
        adminCitiesPage.getEditButton().click();
        adminCitiesPage.getNameField().click();

        adminCitiesPage.getNameField().sendKeys(" - edited");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        adminCitiesPage.getSaveButton().click();

        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driverWait.until(ExpectedConditions.textToBe(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"),
                "Saved successfully\nCLOSE"));
        String actualSuccessfullySave = adminCitiesPage.getSuccessfullySave().getText();
        String expectedSuccesfullySave = "Saved successfully";

        Assert.assertTrue(actualSuccessfullySave.contains(expectedSuccesfullySave));
        adminCitiesPage.getDeleteButton().click();
        adminCitiesPage.getDeleteCityButton().click();
        loginPage.getLogoutButton().click();

    }

    @Test
    public void searchCity() throws InterruptedException {
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
        loginPage.getLogoutButton().click();

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

        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driverWait.until(ExpectedConditions.textToBe(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"),
                "Deleted successfully\nCLOSE"));

        String actualDeletedSuccessfully = adminCitiesPage.getSuccessfullySave().getText();
        String expectedDeletedSuccessfully = "Deleted successfully";

        Assert.assertTrue(actualDeletedSuccessfully.contains(expectedDeletedSuccessfully));
        loginPage.getLogoutButton().click();

    }
}
