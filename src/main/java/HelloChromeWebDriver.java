import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by HariHaraKumar on 2/08/2018.
 */
public class HelloChromeWebDriver {

    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","C:\\Data\\Hari\\EB_Workshop\\SELENIUM\\Chrome_Driver\\chromedriver_win32\\chromedriver.exe");
        WebDriver chromeDriver=new ChromeDriver();
        String url="https://www.google.com/";
        String expectedTitle="Google";
        String actualTitle=null;
        chromeDriver.get(url);
        actualTitle=chromeDriver.getTitle();
        if(actualTitle.equalsIgnoreCase(expectedTitle)){
            System.out.println("Test Passed > " + actualTitle);
        }else{
            System.out.println("Test Failed > " + actualTitle);
        }
        chromeDriver.close();
    }
}
