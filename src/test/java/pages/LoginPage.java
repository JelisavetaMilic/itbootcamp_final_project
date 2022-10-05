package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By loginButton = By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button");
    private By emailAttributeType = By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[3]/span/form/div/div[1]/span/div/div/div[1]/div/label");
    private By passwordAttributeType = By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[3]/span/form/div/div[2]/span/div/div/div[1]/div/label");
    private By errorMessageUserNotExist = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li");
    private By errorMessageWrongPassword = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li");
    private By logoutButton = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/button[2]");
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getEmail() {
        return getDriver().findElement(emailField);
    }

    public WebElement getPassword() {
        return getDriver().findElement(passwordField);
    }

    public WebElement getLoginButton() {
        return getDriver().findElement(loginButton);
    }

    public WebElement getEmailAttributeType() {
        return getDriver().findElement(emailAttributeType);
    }

    public WebElement getPasswordAttributeType() {
        return getDriver().findElement(passwordAttributeType);
    }

    public WebElement getErrorMessageUserNotExist(){
        return getDriver().findElement(errorMessageUserNotExist);
    }

    public WebElement getErrorMessageWrongPassword() {
        return getDriver().findElement(errorMessageWrongPassword);
    }

    public WebElement getLogoutButton(){
        return getDriver().findElement(logoutButton);
    }

    public void logIn(String email, String password) {
        getEmail().clear();
        getPassword().clear();
        getEmail().sendKeys(email);
        getPassword().sendKeys(password);
        getLoginButton().click();
    }


}
