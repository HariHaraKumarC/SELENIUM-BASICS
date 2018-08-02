import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

/**
 * Created by harih on 8/2/2018.
 * Used Locator: Link Text
 */
public class FindElementExample2 extends HelloBrowserWebDriver {

    public static void main(String[] args){
        FindElementExample2 findElementExample2=new FindElementExample2();
        WebDriver driver= findElementExample2.getBrowserDriver("Chrome");
        findElementExample2.launchGmailFromGoogleHome(driver);
    }

    public void launchGmailFromGoogleHome(WebDriver driver){
        String url = "https://www.google.com/";
        //To Maximise the window
        driver.manage().window().maximize();
        driver.get(url);
        try {
            driver.findElement(By.linkText("Gmail")).click();
            System.out.println("Gmail Launched Successfully from Google Home Page...");
        }catch(NoSuchElementException e){
            System.out.println("No Such Element Exception occured > "+e);
        }
    }
}
