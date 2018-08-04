import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * Created by harih on 8/4/2018.
 */
public class AssertExample {

    ClassLoader classLoader = getClass().getClassLoader();
    String url = "https://www.google.com/";
    WebDriver chromeDriver=null;

    @Test(groups = {"testng-assert-tutorial"})
    public void returnsTrue() {
        String expectedTitle="Google";
        String actualTitle=chromeDriver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @Test(groups = {"testng-assert-tutorial"})
    public void returnsFalse() {
        String expectedTitle="Gmail";
        SoftAssert softAssert=new SoftAssert();
        String actualTitle=chromeDriver.getTitle();
        softAssert.assertEquals(expectedTitle,actualTitle);
    }

    @BeforeClass(groups = {"testng-assert-tutorial"})
    public void initializeDriver() {
        ClassLoader classLoader = getClass().getClassLoader();
        System.setProperty("webdriver.chrome.driver", classLoader.getResource("drivers/chromedriver.exe").getFile().replaceAll("%20"," "));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en-ca");
        chromeDriver = new ChromeDriver(options);
        chromeDriver.get(url);
    }

    @AfterClass(groups = {"testng-assert-tutorial"})
    public void closeDriver() {
        chromeDriver.close();
        chromeDriver.quit();
    }

}
