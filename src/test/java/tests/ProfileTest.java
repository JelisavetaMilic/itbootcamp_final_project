package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProfilePage;

import java.time.Duration;

public class ProfileTest extends BaseTest {

    private ProfilePage profilePage;
    private LoginPage loginPage;

    @BeforeClass
    @Override
    public void setUp() {
        super.setUp();
        profilePage = new ProfilePage(driver);
        loginPage = new LoginPage(driver);
    }

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        driver.get("https://vue-demo.daniel-avellaneda.com/login");
        loginPage.logIn("admin@admin.com", "12345");
    }

    @Test
    public void editsProfile() throws InterruptedException {

        profilePage.getProfileButton().click();
        profilePage.makeProfile (
                String.valueOf(Faker.instance().name()),
                String.valueOf(Faker.instance().phoneNumber()),
                Faker.instance().address().city(),
                Faker.instance().address().country(),
                Faker.instance().internet().avatar(),
                Faker.instance().internet().avatar()
        );

        Thread.sleep(3000);

        profilePage.getSaveButton().click();

        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driverWait.until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]"),
                "Profile saved successfuly\nCLOSE"));

        String actualResult = profilePage.getSaveSuccessfullyMessage().getText();
        String expectedResult = "Profile saved successfuly";

        Assert.assertTrue(actualResult.contains(expectedResult));

    }
}
