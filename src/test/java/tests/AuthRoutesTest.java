package tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class AuthRoutesTest extends BaseTest {


    @Test
    public void forbidsVisitsToHomeUrl() {

        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        String actualResult = driver.getCurrentUrl();
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";

        Assert.assertEquals(actualResult, expectedResult);

    }

    @Test
    public void forbidsVisitsToProfileUrl() {

        driver.get("https://vue-demo.daniel-avellaneda.com/profile");
        String actualResult = driver.getCurrentUrl();
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";

        Assert.assertEquals(actualResult, expectedResult);

    }

    @Test
    public void forbidsVisitsToAdminCitiesUrl() {

        driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities");
        String actualResult = driver.getCurrentUrl();
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";

        Assert.assertEquals(actualResult, expectedResult);

    }

    @Test
    public void forbidsVisitsToAdminUsersUrl() {

        driver.get("https://vue-demo.daniel-avellaneda.com/admin/users");
        String actualResult = driver.getCurrentUrl();
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";

        Assert.assertEquals(actualResult, expectedResult);
    }

}
