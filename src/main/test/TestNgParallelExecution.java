import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.SkipException;
import org.testng.annotations.*;

/**
 * Created by harih on 8/4/2018.
 */
public class TestNgParallelExecution {

    ClassLoader classLoader = getClass().getClassLoader();
    String url = "https://www.google.com/";

    @Test(groups = {"testng-parallel-execution-tutorial"})
    public void openGoogleInChrome() {
        System.setProperty("webdriver.chrome.driver", classLoader.getResource("drivers/chromedriver.exe").getFile().replaceAll("%20"," "));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en-ca");
        WebDriver chromeDriver = new ChromeDriver(options);
        chromeDriver.get(url);
        chromeDriver.close();
        chromeDriver.quit();
    }

    @Test(groups = {"testng-parallel-execution-tutorial"})
    public void openGoogleInFirefox() {
        System.setProperty("webdriver.gecko.driver", classLoader.getResource("drivers/geckodriver.exe").getFile().replaceAll("%20"," "));
        WebDriver firefoxDriver = new FirefoxDriver();
        firefoxDriver.get(url);
        firefoxDriver.close();
        firefoxDriver.quit();
    }
}
