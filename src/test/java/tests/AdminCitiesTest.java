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
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities");
        loginPage.logIn("admin@admin.com", "12345");

    }

    @Test(priority = 1)
    public void testVisitAdminCities() {

        adminCitiesPage.getAdminButton().click();
        adminCitiesPage.getCitiesButton().click();

        String actualResultAdminCities = driver.getCurrentUrl();
        String expectedResultAdminCities = "https://vue-demo.daniel-avellaneda.com/admin/cities";

        Assert.assertEquals(actualResultAdminCities, expectedResultAdminCities);

        boolean actualResultLogoutButton = loginPage.getLogoutButton().isDisplayed();
        boolean expectedResultLogoutButton = true;

        Assert.assertEquals(actualResultLogoutButton, expectedResultLogoutButton);
        loginPage.getLogoutButton().click();

    }

    @Test(priority = 2)
    public void testCreateCity() {

        adminCitiesPage.getAdminButton().click();
        adminCitiesPage.getCitiesButton().click();
        adminCitiesPage.getNewItem().click();

        adminCitiesPage.createNewCity("Zimbabve");

        String actualSuccessfullySave = adminCitiesPage.getSuccessfullySave().getText();
        String expectedSuccesfullySave = "Saved successfully";

        Assert.assertTrue(actualSuccessfullySave.contains(expectedSuccesfullySave));
        loginPage.getLogoutButton().click();
    }

    @Test(priority = 3)
    public void testEditCity() {

        adminCitiesPage.getAdminButton().click();
        adminCitiesPage.getCitiesButton().click();

        adminCitiesPage.getEditButton().click();
        adminCitiesPage.getNameField().click();

        adminCitiesPage.getNameField().sendKeys(" edited");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        adminCitiesPage.getSaveButton().click();

        String actualSuccessfullySave = adminCitiesPage.getSuccessfullySave().getText();
        String expectedSuccesfullySave = "Saved successfully";

        Assert.assertTrue(actualSuccessfullySave.contains(expectedSuccesfullySave));
        loginPage.getLogoutButton().click();

    }

    @Test(priority = 4)
    public void testSearchCity() throws InterruptedException {

        String searchText = "Zimbabve edited";

        adminCitiesPage.getAdminButton().click();
        adminCitiesPage.getCitiesButton().click();
        adminCitiesPage.getSearchField().click();
        adminCitiesPage.getSearchField().sendKeys(searchText);

        Thread.sleep(3000);

        String actualCityText = adminCitiesPage.getNameOfCity().getText();

        Assert.assertTrue(actualCityText.contains(searchText));
        loginPage.getLogoutButton().click();

    }

    @Test(priority = 5)
    public void testDeleteCity() throws InterruptedException {

        adminCitiesPage.getAdminButton().click();
        adminCitiesPage.getCitiesButton().click();

        String searchText = "Zimbabve edited";

        adminCitiesPage.getAdminButton().click();
        adminCitiesPage.getCitiesButton().click();
        adminCitiesPage.getSearchField().click();
        adminCitiesPage.getSearchField().sendKeys(searchText);

        Thread.sleep(3000);

        String actualCityText = adminCitiesPage.getNameOfCity().getText();

        Assert.assertTrue(actualCityText.contains(searchText));

        adminCitiesPage.getDeleteButton().click();

        adminCitiesPage.getDeleteDialogButton().click();

        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driverWait.until(ExpectedConditions.textToBe(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"),
                "Deleted successfully\nCLOSE"));

        String actualDeletedSuccessfully = adminCitiesPage.getSuccessfullySave().getText();
        String expectedDeletedSuccessfully = "Deleted successfully";

        Assert.assertTrue(actualDeletedSuccessfully.contains(expectedDeletedSuccessfully));
        loginPage.getLogoutButton().click();

    }


}
