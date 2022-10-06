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
import pages.SignupPage;

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
    }

    @Test
    public void testVisitAdminCities() {

        adminCitiesPage.getAdminButton().click();
        adminCitiesPage.getCitiesButton().click();

        String actualResultAdminCities = driver.getCurrentUrl();
        String expectedResultAdminCities = "https://vue-demo.daniel-avellaneda.com/admin/cities";

        Assert.assertEquals(actualResultAdminCities, expectedResultAdminCities);

        boolean actualResultLogoutButton = loginPage.getLogoutButton().isDisplayed();
        boolean expectedResultLogoutButton = true;

        Assert.assertEquals(actualResultLogoutButton, expectedResultLogoutButton);

    }

    @Test
    public void testCreateCity() throws InterruptedException {

        adminCitiesPage.getAdminButton().click();
        adminCitiesPage.getCitiesButton().click();
        adminCitiesPage.getNewItem().click();

        adminCitiesPage.createNewCity("Zimbabve");
        Thread.sleep(3000);

        String actualSuccessfullySave = adminCitiesPage.getSuccessfullySave().getText();
        String expectedSuccesfullySave = "Saved successfully\n" +
                "CLOSE";

        Assert.assertEquals(actualSuccessfullySave, expectedSuccesfullySave);
    }

}
