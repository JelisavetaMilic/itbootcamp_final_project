package pages;

import com.github.javafaker.Name;
import com.github.javafaker.PhoneNumber;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage extends BasePage {

    private By profileButton = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[3]");
    private By name = By.id("name");
    private By phone = By.id("phone");
    private By city = By.id("city");
    private By country = By.id("country");
    private By twitter = By.id("urlTwitter");
    private By gitHub = By.id("urlGitHub");
    private By saveButton = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[8]/button");
    private By saveSuccessfullyMessage = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]");

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getProfileButton() {
        return getDriver().findElement(profileButton);
    }

    public WebElement getName() {
        return getDriver().findElement(name);
    }

    public WebElement getPhone() {
        return getDriver().findElement(phone);
    }

    public WebElement getCity() {
        return getDriver().findElement(city);
    }

    public WebElement getCountry() {
        return getDriver().findElement(country);
    }

    public WebElement getTwitter() {
        return getDriver().findElement(twitter);
    }

    public WebElement getGitHub() {
        return getDriver().findElement(gitHub);
    }

    public WebElement getSaveButton() {
        return getDriver().findElement(saveButton);
    }

    public WebElement getSaveSuccessfullyMessage() {
        return getDriver().findElement(saveSuccessfullyMessage);
    }

    public void makeProfile(String name, String phone, String city, String country, String twitter, String gitHub) {
        getName().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getPhone().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getCity().sendKeys(Keys.CONTROL + "A", Keys.DELETE);;
        getCountry().sendKeys(Keys.CONTROL + "A", Keys.DELETE);;
        getTwitter().sendKeys(Keys.CONTROL + "A", Keys.DELETE);;
        getGitHub().sendKeys(Keys.CONTROL + "A", Keys.DELETE);;
        getName().sendKeys(name);
        getPhone().sendKeys(phone);
        getCity().sendKeys(city);
        getCountry().sendKeys(country);
        getTwitter().sendKeys(twitter);
        getGitHub().sendKeys(gitHub);

    }

}
