import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.List;

/**
 * Created by harih on 8/2/2018.
 * Used Locator: Dropdown Selection
 */
public class FindElementExample4 extends HelloBrowserWebDriver {

    public static void main(String[] args){
        FindElementExample4 findElementExample4=new FindElementExample4();
        WebDriver driver= findElementExample4.getBrowserDriver("Chrome");
        findElementExample4.launchGoogleAppsFromGoogleHome(driver);
    }

    public void launchGoogleAppsFromGoogleHome(WebDriver driver){
        String url = "https://www.softwaretestingmaterial.com/sample-webpage-to-automate";
        //To Maximise the window
        driver.manage().window().maximize();
        driver.get(url);
        try {
            WebElement dropdownElement=driver.findElement(By.name("dropdown"));
            Select dropdown=new Select(dropdownElement);
            dropdown.selectByVisibleText("Automation Testing");
            System.out.println("Drop down successfully selected...");
        }catch(NoSuchElementException e){
            System.out.println("No Such Element Exception occured > "+e);
        }
    }
}
