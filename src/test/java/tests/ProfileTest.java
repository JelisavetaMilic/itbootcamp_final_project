package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProfilePage;

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
    public void editsProfile() {
        profilePage.getProfileButton().click();
        String name = Faker.instance().name().fullName();
        String phone = Faker.instance().phoneNumber().cellPhone();
        String city = "Cali";
        String country = Faker.instance().address().country();
        String twitter = Faker.instance().internet().avatar();
        String gitHub = Faker.instance().internet().avatar();

        profilePage.makeProfile (name, phone, city, country, twitter, gitHub);

        profilePage.getSaveButton().click();

        profilePage.getDriverWait().until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]"),
                "Profile saved successfuly\nCLOSE"));

        String actualResult = profilePage.getSaveSuccessfullyMessage().getText();
        String expectedResult = "Profile saved successfuly";
        Assert.assertTrue(actualResult.contains(expectedResult));

        String actualName = profilePage.getName().getAttribute("value");
        String actualPhone = profilePage.getPhone().getAttribute("value");
        String actualCity = profilePage.getCity().getAttribute("value");
        String actualCountry = profilePage.getCountry().getAttribute("value");
        String actualTwitter = profilePage.getTwitter().getAttribute("value");
        String actualGitHub = profilePage.getGitHub().getAttribute("value");

        Assert.assertEquals(actualName, name);
        Assert.assertEquals(actualPhone, phone);
        Assert.assertEquals(actualCity, city);
        Assert.assertEquals(actualCountry, country);
        Assert.assertEquals(actualTwitter, twitter);
        Assert.assertEquals(actualGitHub, gitHub);
    }
}
