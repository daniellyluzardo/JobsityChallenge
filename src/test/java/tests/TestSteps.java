package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageobjects.PageClass;
import utils.Utils;

import java.io.IOException;
import java.time.Duration;

public class TestSteps {
    String baseUrl;
    WebDriver driver;
    PageClass home;
    Utils utils;
    SoftAssert sa;

    public static final String dir = "C:\\Screenshots\\";

    @Test(priority = 3)
    public void scenarioNavigationBar(){
        utils = new Utils(driver);
        utils.setDir(dir + "scenarioNavigationBar");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        sa.assertTrue(home.isNavBarThere());
        utils.screenshot();
        home.clickOnlineBankingTab();
        sa.assertTrue(home.isNavBarThere());
        utils.screenshot();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        home.clickFeedbackTab();
        sa.assertTrue(home.isNavBarThere());
        home.clickHomeTab();
        utils.screenshot();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        sa.assertTrue(home.isNavBarThere());
        utils.screenshot();
    }
    @Test(priority = 2)
    public void scenarioFeedbackForm() {
        utils = new Utils(driver);
        utils.setDir(dir + "scenarioFeedbackForm");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        sa.assertTrue(home.isNavBarThere());
        utils.screenshot();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        home.clickFeedbackTab();
        utils.screenshot();
        sa.assertTrue(home.isFeedbackThere());
        home.fillForms("Lorem", "Lorem@ipsum.com", "Lorem ipsum", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi interdum ante massa, ut congue eros tristique ac. Suspendisse tempus pretium metus, tristique facilisis nisl fringilla et. Nam venenatis orci ullamcorper velit bibendum, fringilla dignissim mauris vulputate. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin finibus fringilla egestas.");
        utils.screenshot();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        home.clickSendFBButton();
        utils.screenshot();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }
    @Test(priority = 1)
    public void scenarioClearForm() {
        utils = new Utils(driver);
        utils.setDir(dir + "scenarioClearForm");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        sa.assertTrue(home.isNavBarThere());
        utils.screenshot();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        home.clickFeedbackTab();
        sa.assertTrue(home.isFeedbackThere());
        home.fillForms("Lorem", "Lorem@ipsum.com", "Lorem ipsum", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi interdum ante massa, ut congue eros tristique ac. Suspendisse tempus pretium metus, tristique facilisis nisl fringilla et. Nam venenatis orci ullamcorper velit bibendum, fringilla dignissim mauris vulputate. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin finibus fringilla egestas.");
        utils.screenshot();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        home.clickClearFBButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        utils.screenshot();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }


    @BeforeMethod
    public void beforeMethod() {
        sa = new SoftAssert();
        String projectPath = System.getProperty("user.dir");
        //System.setProperty("webdriver.chrome.driver", projectPath+"/src/pages/resources/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", projectPath+"/src/pages/resources/geckodriver.exe");
        //System.setProperty("webdriver.gecko.driver", "C:\\Users\\danie\\Documents\\libs\\drivers\\geckodriver.exe");
        baseUrl = "http://zero.webappsecurity.com/";
        driver = new FirefoxDriver();
        //driver = new ChromeDriver();
        home = new PageClass(driver);
        utils = new Utils(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void afterMethod(ITestResult testResult) throws IOException{
        if (testResult.getStatus() == ITestResult.FAILURE) {
            utils.screenshot(testResult.getName());
    }
        driver.close();}
}
