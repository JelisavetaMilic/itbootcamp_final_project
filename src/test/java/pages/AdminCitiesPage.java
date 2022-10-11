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
    private By editButton = By.id("edit");
    private By searchField = By.id("search");
    private By nameOfCity = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr/td[2]");
    private By deleteButton = By.id("delete");
    private By deleteCityButton = By.xpath("//*[@id=\"app\"]/div[6]/div/div/div[2]/button[2]");

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

    public WebElement getNameField() {
        return getDriver().findElement(nameField);
    }

    public WebElement getSaveButton() {
        return getDriver().findElement(saveButton);
    }

    public WebElement getSuccessfullySave() {
        return getDriver().findElement(successfullySave);
    }

    public WebElement getEditButton() {
        return getDriver().findElement(editButton);
    }

    public WebElement getSearchField() {
        return getDriver().findElement(searchField);
    }

    public WebElement getNameOfCity() {
        return getDriver().findElement(nameOfCity);
    }

    public WebElement getDeleteButton() {
        return getDriver().findElement(deleteButton);
    }
    public WebElement getDeleteCityButton(){
        return getDriver().findElement(deleteCityButton);
    }

    public void createNewCity(String name) {
        getNameField().click();
        getNameField().clear();
        getNameField().sendKeys(name);
        getSaveButton().click();

    }

}
