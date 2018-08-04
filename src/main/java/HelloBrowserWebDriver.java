import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Created by HariHaraKumar on 8/2/2018.
 */
public class HelloBrowserWebDriver {

    public void testBrowser(String browser) {
        WebDriver browserWebDriver = getBrowserDriver(browser);
        if(browserWebDriver != null) {
            String url = "https://www.google.com/";
            String expectedTitle = "Google";
            String actualTitle = null;
            browserWebDriver.get(url);
            actualTitle = browserWebDriver.getTitle();
            if (actualTitle.equalsIgnoreCase(expectedTitle)) {
                System.out.println("Expected Title Value: " + expectedTitle);
                System.out.println("Actual Title Value: " + actualTitle);
                System.out.println("Test Passed");
            } else {
                System.out.println("Expected Title Value: " + expectedTitle);
                System.out.println("Actual Title Value: " + actualTitle);
                System.out.println("Test Failed");
            }
            browserWebDriver.close();
            browserWebDriver.quit();
        }
    }

    public WebDriver getBrowserDriver(String browser) {
        WebDriver browserWebDriver = null;
        ClassLoader classLoader = getClass().getClassLoader();
        if ("Chrome".equalsIgnoreCase(browser)) {
            System.setProperty("webdriver.chrome.driver", classLoader.getResource("drivers/chromedriver.exe").getFile().replaceAll("%20"," "));
            ChromeOptions options= new ChromeOptions();
            options.addArguments("--lang=en-ca");
            browserWebDriver = new ChromeDriver(options);
        } else if ("Firefox".equalsIgnoreCase(browser)) {
            System.setProperty("webdriver.gecko.driver", classLoader.getResource("drivers/geckodriver.exe").getFile().replaceAll("%20"," "));
            browserWebDriver = new FirefoxDriver();
        } else if ("Edge".equalsIgnoreCase(browser)) {
            System.setProperty("webdriver.ie.driver", classLoader.getResource("drivers/MicrosoftWebDriver.exe").getFile().replaceAll("%20"," "));
            browserWebDriver = new InternetExplorerDriver();
        } else {
            System.out.println("Browser not Supported");
        }
        return browserWebDriver;
    }
}

