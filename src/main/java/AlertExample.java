import org.openqa.selenium.*;

import java.io.IOException;

/**
 * Created by harih on 8/3/2018.
 */
public class AlertExample extends HelloBrowserWebDriver {

    public static void main(String[] args){
        AlertExample alertExample=new AlertExample();
        WebDriver driver= alertExample.getBrowserDriver("Chrome");
        alertExample.playWithAlerts(driver);
    }

    public void playWithAlerts(WebDriver driver){
        String url = "http://softwaretestingplace.blogspot.com/2017/03/javascript-alert-test-page.html";
        //To Maximise the window
        driver.manage().window().maximize();
        driver.get(url);
        try {
            WebElement alertClickButton=driver.findElement(By.xpath("//*[@id='content']/button"));
            alertClickButton.click();
            Alert alert=driver.switchTo().alert();
            System.out.println("Alert Text > "+alert.getText());
            alert.accept();
            System.out.println("Played with Popup Successfully...");
        }catch(NoSuchElementException e){
            System.out.println("No Such Element Exception occured > "+e);
        }
    }

}
