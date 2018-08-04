import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.SkipException;
import org.testng.annotations.*;

/**
 * Created by harih on 8/4/2018.
 */
public class HelloTestNg {

    public WebDriver driver;

    @Test(dependsOnMethods = {"printBrowser"})
    public void openGoogleSearch() {
        String url = "https://www.google.com/";
        driver.get(url);
    }

    @Test
    @Parameters("browser")
    public void printBrowser(String browser){
        System.out.println("Browser Value > "+browser);
    }

    @Test(dataProvider = "getBrowserList")
    public void  printBrowserUsingDP(String key, String value){
        System.out.println(key+" > "+value);
    }

    @DataProvider(name = "getBrowserList")
    public Object[][] getBrowserList(){
        Object[][] browserList=new Object[2][2];
        browserList[0][0]="Browser 1";
        browserList[0][1]="Chrome";
        browserList[1][0]="Browser 2";
        browserList[1][1]="Firefox";
        return browserList;
    }

    @Test(enabled = false)
    public void printTitle() {
        String title = driver.getTitle();
        System.out.println("Title > "+title);
    }

    @Test
    public void learnSkipTest(){
        boolean isSkipTestEnabled=true;
        if(isSkipTestEnabled){
            throw new SkipException("This method will be skipped.");
        }
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testException(){
        System.out.println("Inside test exception >");
        int result=1/0;
    }

    @BeforeClass
    public void initializeDriver() {
        ClassLoader classLoader = getClass().getClassLoader();
        System.setProperty("webdriver.chrome.driver", classLoader.getResource("drivers/chromedriver.exe").getFile());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en-ca");
        driver = new ChromeDriver(options);
    }

    @AfterClass
    public void closeDriver() {
        driver.close();
        driver.quit();
    }

}
