package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocalePage extends BasePage{


    private By localeButton = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button");
    private By esButton = By.id("list-item-75");
    private By paginaText = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1");
    private By enButton = By.id("list-item-73");
    private By landingText = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1");
    private By frButton = By.id("list-item-77");
    private By frText = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1");

    public LocalePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getLocaleButton() {
        return getDriver().findElement(localeButton);
    }

    public WebElement getEsButton() {
        return getDriver().findElement(esButton);
    }

    public WebElement getPaginaText() {
        return getDriver().findElement(paginaText);
    }

    public WebElement getEnButton() {
        return getDriver().findElement(enButton);
    }

    public WebElement getLandingText() {
        return getDriver().findElement(landingText);
    }

    public WebElement getFrButton() {
        return getDriver().findElement(frButton);
    }

    public WebElement getFrText() {
        return getDriver().findElement(frText);
    }

}
