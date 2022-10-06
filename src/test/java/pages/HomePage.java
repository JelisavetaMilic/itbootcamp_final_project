package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{

    private By logInButton = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]");
    private By signUpButton = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[4]");

    public HomePage(WebDriver driver) {
        super(driver);

    }

    public WebElement getLoginButton() {
        return getDriver().findElement(logInButton);
    }

    public WebElement getSignupButton() {
        return getDriver().findElement(signUpButton);
    }

    public void clickLoginButton() {
        getLoginButton().click();
    }

    public void clickSignupButton() {
        getSignupButton().click();
    }

}
