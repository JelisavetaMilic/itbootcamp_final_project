package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignupPage extends BasePage{

    private By nameField = By.id("name");
    private By emailField = By.id("email");
    private By emailAttributeType = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div[2]/span/div/div/div[1]/div/label");
    private By passwordField = By.id("password");
    private By passwordAttributeType = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div[3]/span/div/div/div[1]/div/label");
    private By confirmPasswordField = By.id("confirmPassword");
    private By confirmPasswordAttributeType = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div[4]/span/div/div/div[1]/div/label");
    private By errorMessageEmailAlreadyExists = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/ul/li");
    private By signMeUpButton = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button");
   private By closeEmailButton = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/button");
    private By importantErrorMessage = By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]");
    private By closeImportantButton = By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[3]/button/span");
    private By logOutButtonSignUpPage = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]");
    private By signUpButton = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[4]");


    public SignupPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getNameField() {
        return getDriver().findElement(nameField);
    }

    public WebElement getEmailField() {
        return getDriver().findElement(emailField);
    }

    public WebElement getEmailAttributeType() {
        return getDriver().findElement(emailAttributeType);
    }

    public WebElement getPasswordField() {
        return getDriver().findElement(passwordField);
    }

    public WebElement getPasswordAttributeType() {
        return getDriver().findElement(passwordAttributeType);
    }

    public WebElement getConfirmPasswordField() {
        return getDriver().findElement(confirmPasswordField);
    }

    public WebElement getConfirmPasswordAttributeType() {
        return getDriver().findElement(confirmPasswordAttributeType);
    }

    public WebElement getErrorMessageEmailAlreadyExists() {
        return getDriver().findElement(errorMessageEmailAlreadyExists);
    }

    public WebElement getSignMeUpButton() {
        return getDriver().findElement(signMeUpButton);
    }

    public WebElement getCloseEmailButton() {
        return getDriver().findElement(closeEmailButton);
    }

    public WebElement getImportantMessage() {
        return getDriver().findElement(importantErrorMessage);
    }

    public WebElement getCloseImportantButton() {
        return getDriver().findElement(closeImportantButton);
    }

    public WebElement getLogOutButtonSignUp() {
        return getDriver().findElement(logOutButtonSignUpPage);
    }

    public WebElement getSignUpButton() {
        return getDriver().findElement(signUpButton);
    }



    public void signUp(String name, String email, String password, String confirmPassword) {
       getNameField().clear();
       getEmailField().clear();
       getPasswordField().clear();
       getConfirmPasswordField().clear();
       getNameField().sendKeys(name);
       getEmailField().sendKeys(email);
       getPasswordField().sendKeys(password);
       getConfirmPasswordField().sendKeys(confirmPassword);
       getSignMeUpButton().click();

    }



}
