import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by HariHaraKumar on 2/08/2018.
 */
public class HelloFirefoxWebDriver {

    public static void main(String[] args){
        System.setProperty("webdriver.gecko.driver","C:\\Data\\Hari\\EB_Workshop\\SELENIUM\\Gecko_Driver\\geckodriver-v0.21.0-win64\\geckodriver.exe");
        WebDriver firefoxDriver=new FirefoxDriver();
        String url="https://www.google.com/";
        String expectedTitle="Google";
        String actualTitle=null;
        firefoxDriver.get(url);
        actualTitle=firefoxDriver.getTitle();
        if(actualTitle.equalsIgnoreCase(expectedTitle)){
            System.out.println("Expected Title Value: "+expectedTitle);
            System.out.println("Actual Title Value: "+actualTitle);
            System.out.println("Test Passed");
        }else{
            System.out.println("Expected Title Value: "+expectedTitle);
            System.out.println("Actual Title Value: "+actualTitle);
            System.out.println("Test Failed");
        }
        firefoxDriver.close();
    }
}
