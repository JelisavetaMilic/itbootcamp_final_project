package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\38163\\IdeaProjects\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://vue-demo.daniel-avellaneda.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    @BeforeMethod
    public void beforeMethod() {
        driver.manage().deleteAllCookies();
        driver.get("https://vue-demo.daniel-avellaneda.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }


    @AfterClass
    public void afterClass() {
       driver.quit();
    }


}
