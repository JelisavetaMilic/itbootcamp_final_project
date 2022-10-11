package pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    private final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }


    public WebDriver getDriver() {
        return driver;
    }

}
