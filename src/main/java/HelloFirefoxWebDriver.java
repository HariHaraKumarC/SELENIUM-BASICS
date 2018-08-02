import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by HariHaraKumar on 2/08/2018.
 */
public class HelloFirefoxWebDriver extends HelloBrowserWebDriver {

    public static void main(String[] args){
        HelloFirefoxWebDriver helloFirefoxWebDriver=new HelloFirefoxWebDriver();
        helloFirefoxWebDriver.testBrowser("firefox");
    }
}
