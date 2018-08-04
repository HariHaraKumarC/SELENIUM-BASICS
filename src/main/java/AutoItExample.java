import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.IOException;

/**
 * Created by harih on 8/3/2018.
 */
public class AutoItExample extends HelloBrowserWebDriver {

    public static void main(String[] args){
        AutoItExample autoItExample=new AutoItExample();
        WebDriver driver= autoItExample.getBrowserDriver("Chrome");
        autoItExample.uploadFile(driver);
    }

    public void uploadFile(WebDriver driver){
        ClassLoader classLoader = getClass().getClassLoader();
        String url = "http://softwaretestingplace.blogspot.com/2015/10/sample-web-page-to-test.html";
        //To Maximise the window
        driver.manage().window().maximize();
        driver.get(url);
        try {
            WebElement uploadButton=driver.findElement(By.id("uploadfile"));
            uploadButton.click();
            //Call the AutoIt Script
            Runtime.getRuntime().exec(classLoader.getResource("autoIt/scripts/uploadFile.exe").getFile());
            System.out.println("File Uploaded Successfully...");
        }catch(NoSuchElementException e){
            System.out.println("No Such Element Exception occured > "+e);
        } catch (IOException e) {
            System.out.println("IO Exception occured > "+e);
        }
    }

}
