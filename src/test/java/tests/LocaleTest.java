package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LocalePage;
import pages.LoginPage;

public class LocaleTest extends BaseTest {

    private LocalePage localePage;
    private LoginPage loginPage;

    @BeforeClass
    @Override
    public void setUp() {
        super.setUp();
        localePage = new LocalePage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void localeEs() {
        localePage.getLocaleButton().click();
        localePage.getEsButton().click();

        String actualResult = localePage.getPaginaText().getText();
        String expectedResult = "Página de aterrizaje";

        Assert.assertTrue(localePage.getPaginaText().isDisplayed());
        Assert.assertTrue(actualResult.contains(expectedResult));

    }

    @Test
    public void localeEn() {
        localePage.getLocaleButton().click();
        localePage.getEnButton().click();

        String actualResult = localePage.getLandingText().getText();
        String expectedResult = "Landing";

        Assert.assertTrue(localePage.getLandingText().isDisplayed());
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void localeFr() {
        localePage.getLocaleButton().click();
        localePage.getFrButton().click();

        String actualResult = localePage.getFrText().getText();
        String expectedResult = "Page d'atterrissage";

        Assert.assertTrue(localePage.getFrText().isDisplayed());
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

}
