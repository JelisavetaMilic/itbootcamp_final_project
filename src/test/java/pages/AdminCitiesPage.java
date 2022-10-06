package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminCitiesPage extends BasePage {


    private By adminButton = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]");
    private By citiesButton = By.xpath("//*[@id=\"app\"]/div[3]/div[1]/a[1]");
    private By newItem = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button");
    private By nameField = By.id("name");
    private By saveButton = By.xpath("//*[@id=\"app\"]/div[5]/div/div/div[3]/button[2]");
    private By successfullySave = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]");


    public AdminCitiesPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getAdminButton() {
        return getDriver().findElement(adminButton);
    }

    public WebElement getCitiesButton() {
        return getDriver().findElement(citiesButton);
    }

    public WebElement getNewItem() {
        return getDriver().findElement(newItem);
    }

    private WebElement getNameField() {
        return getDriver().findElement(nameField);
    }

    public WebElement getSaveButton() {
        return getDriver().findElement(saveButton);
    }

    public WebElement getSuccessfullySave() {
        return getDriver().findElement(successfullySave);
    }

    public void createNewCity(String name) {
        getNameField().click();
        getNameField().clear();
        getNameField().sendKeys(name);
        getSaveButton().click();

    }

}
