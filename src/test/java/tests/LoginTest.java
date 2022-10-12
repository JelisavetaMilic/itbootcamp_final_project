package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest{

    private LoginPage loginPage;

    @BeforeClass
    @Override
    public void setUp() {
        super.setUp();
        loginPage = new LoginPage(driver);
        driver.get("https://vue-demo.daniel-avellaneda.com/login");
    }

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        driver.get("https://vue-demo.daniel-avellaneda.com/login");
    }

    @Test
    public void visitLoginPage() {
        String actualResult = driver.getCurrentUrl();
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        Assert.assertEquals(actualResult, expectedResult);

    }


    @Test
    public void inputTypes() {
        String actualResultEmail = loginPage.getEmailAttributeType().getText();
        String expectedResultEmail = "E-mail";
        Assert.assertEquals(actualResultEmail,expectedResultEmail);

        String actualResultPassword = loginPage.getPasswordAttributeType().getText();
        String expectedResultPassword = "Password";
        Assert.assertEquals(actualResultPassword, expectedResultPassword);

    }

    @Test
    public void invalidLogin() {
        String emailAddress = Faker.instance().internet().emailAddress();
        String password = Faker.instance().internet().password();
        loginPage.logIn(emailAddress, password);

        String actualResultError = loginPage.getErrorMessageUserNotExist().getText();
        String expectedResultError = "User does not exists";
        Assert.assertTrue(loginPage.getErrorMessageUserNotExist().isDisplayed());
        Assert.assertEquals(actualResultError, expectedResultError);

        String actualResultUrl = driver.getCurrentUrl();
        String expectedResultUrl = "https://vue-demo.daniel-avellaneda.com/login";
        Assert.assertEquals(actualResultUrl, expectedResultUrl);

    }

    @Test
    public void errorMessageForInvalidPassword() {
        loginPage.logIn("admin@admin.com", "54321");

        String actualResultWrongPassword = loginPage.getErrorMessageWrongPassword().getText();
        String expectedResultWrongPassword = "Wrong password";
        Assert.assertTrue(loginPage.getErrorMessageWrongPassword().isDisplayed());
        Assert.assertEquals(actualResultWrongPassword, expectedResultWrongPassword);

        String actualResultUrl = driver.getCurrentUrl();
        String expectedResultUrl = "https://vue-demo.daniel-avellaneda.com/login";
        Assert.assertEquals(actualResultUrl, expectedResultUrl);

    }

    @Test
    public void validLogin() {
        loginPage.logIn("admin@admin.com", "12345");

        loginPage.getDriverWait().until(ExpectedConditions.urlToBe("https://vue-demo.daniel-avellaneda.com/home"));
        String actualResultUrl = driver.getCurrentUrl();
        String expectedResultUrl = "https://vue-demo.daniel-avellaneda.com/home";
        Assert.assertEquals(actualResultUrl, expectedResultUrl);

        loginPage.getLogoutButton().click();
    }

    @Test
    public void logout() {
        loginPage.getDriverWait().until(ExpectedConditions.visibilityOf(loginPage.getEmail()));
        loginPage.logIn("admin@admin.com", "12345");

        boolean actualResultLogoutButton = loginPage.getLogoutButton().isDisplayed();
        boolean expectedResult = true;
        Assert.assertEquals(actualResultLogoutButton, expectedResult);

        loginPage.getLogoutButton().click();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://vue-demo.daniel-avellaneda.com/login";
        Assert.assertEquals(actualUrl, expectedUrl);

        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        String loginActualUrl = driver.getCurrentUrl();
        String loginExpectedUrl = "https://vue-demo.daniel-avellaneda.com/login";
        Assert.assertEquals(loginActualUrl, loginExpectedUrl);

    }

}
