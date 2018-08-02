import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by HariHaraKumar on 2/08/2018.
 */
public class HelloChromeWebDriver extends HelloBrowserWebDriver {

    public static void main(String[] args){
        HelloChromeWebDriver helloChromeWebDriver=new HelloChromeWebDriver();
        helloChromeWebDriver.testBrowser("Chrome");
    }
}
