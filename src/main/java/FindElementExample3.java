import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;

/**
 * Created by harih on 8/2/2018.
 * Used Locator: Tag Selector
 */
public class FindElementExample3 extends HelloBrowserWebDriver {

    public static void main(String[] args){
        FindElementExample3 findElementExample3=new FindElementExample3();
        WebDriver driver= findElementExample3.getBrowserDriver("Chrome");
        findElementExample3.launchGoogleAppsFromGoogleHome(driver);
    }

    public void launchGoogleAppsFromGoogleHome(WebDriver driver){
        String url = "https://www.google.com/";
        //To Maximise the window
        driver.manage().window().maximize();
        driver.get(url);
        try {
            List <WebElement> anchorTags=driver.findElements(By.tagName("a"));
            Iterator<WebElement> iterator=anchorTags.iterator();
            while(iterator.hasNext()){
                WebElement anchor= iterator.next();
                if(anchor.getAttribute("title").equalsIgnoreCase("Google apps")){
                    anchor.click();
                    break;
                }
            }
            System.out.println("Google App Launched Successfully from Google Home Page...");
        }catch(NoSuchElementException e){
            System.out.println("No Such Element Exception occured > "+e);
        }
    }
}
