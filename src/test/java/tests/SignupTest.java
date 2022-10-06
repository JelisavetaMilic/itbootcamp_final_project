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
import pages.SignupPage;

import java.time.Duration;

public class SignupTest extends BaseTest{

    private SignupPage signupPage;

    @BeforeClass
    @Override
    public void setUp() {
        super.setUp();
        signupPage = new SignupPage(driver);
        driver.get("https://vue-demo.daniel-avellaneda.com/signup");
    }

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        driver.get("https://vue-demo.daniel-avellaneda.com/signup");
    }

    @Test(priority = 1)
    public void testVisitSignupPage() {
        String actualResultSignup = driver.getCurrentUrl();
        String expectedResultSignUp = "https://vue-demo.daniel-avellaneda.com/signup";

        Assert.assertEquals(actualResultSignup, expectedResultSignUp);
    }

    @Test(priority = 2)
    public void testInputTypes() {
        String actualResultEmail = signupPage.getEmailAttributeType().getText();
        String expectedResultEmail = "E-mail";

        Assert.assertEquals(actualResultEmail, expectedResultEmail);

        String actualResultPassword = signupPage.getPasswordAttributeType().getText();
        String expectedResultPassword = "Password";

        Assert.assertEquals(actualResultPassword, expectedResultPassword);

        String actualResultConfirmPassword = signupPage.getConfirmPasswordAttributeType().getText();
        String expectedResultConfirmPassword = "Confirm Password";

        Assert.assertEquals(actualResultConfirmPassword, expectedResultConfirmPassword);
    }

    @Test(priority = 3)
    public void testErrorEmailExists() {
        signupPage.signUp("Test Test", "admin@admin.com", "123654", "123654");

        String actualResultErrorMessageEmailExist = signupPage.getErrorMessageEmailAlreadyExists().getText();
        String expectedResultErrorMessageEmailExist = "E-mail already exists";

        Assert.assertTrue(signupPage.getErrorMessageEmailAlreadyExists().isDisplayed());
        Assert.assertEquals(actualResultErrorMessageEmailExist, expectedResultErrorMessageEmailExist);

        String actualSignUpUrl = driver.getCurrentUrl();
        String expectedSignUpUrl = "https://vue-demo.daniel-avellaneda.com/signup";

        Assert.assertEquals(actualSignUpUrl, expectedSignUpUrl);

        signupPage.getCloseEmailButton().click();
    }

    @Test(priority = 4)
    public void testSignup() {

        String name = Faker.instance().name().fullName();
        String emailAddress = Faker.instance().internet().emailAddress();
        String password = Faker.instance().internet().password();
        String confirmPassword = password;
        signupPage.signUp(name,emailAddress,password, confirmPassword);

        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driverWait.until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]"), "IMPORTANT: Verify your account"));

        String actualImportantMessage = signupPage.getImportantMessage().getText();
        String expectedImportantMessage = "IMPORTANT: Verify your account";

        Assert.assertTrue(signupPage.getImportantMessage().isDisplayed());
        Assert.assertEquals(actualImportantMessage, expectedImportantMessage);
    }

}
