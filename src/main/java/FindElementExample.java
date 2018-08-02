import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

/**
 * Created by harih on 8/2/2018.
 * Used Locator: Name and Id
 */
public class FindElementExample extends HelloBrowserWebDriver {

    public static void main(String[] args){
        FindElementExample findElementExample=new FindElementExample();
        WebDriver driver= findElementExample.getBrowserDriver("Chrome");
        findElementExample.searchGoogle(driver);
    }

    public void searchGoogle(WebDriver driver){
        String url = "https://www.google.com/";
        //To Maximise the window
        driver.manage().window().maximize();
        driver.get(url);
        try {
            driver.findElement(By.id("lst-ib")).sendKeys("Selenium tutorial");
            System.out.println("Inserted text in the google search box successfully...");
            driver.findElement(By.name("btnK")).submit();
            System.out.println("Search button clicked successfully...");
        }catch(NoSuchElementException e){
            System.out.println("No Such Element Exception occured > "+e);
        }
    }
}
