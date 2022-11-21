package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.PageClass;
import utils.Utils;

import java.time.Duration;

public class TestSteps {
    String baseUrl;
    WebDriver driver;
    PageClass home;
    Utils utils;
    SoftAssert sa;

    public static final String dir = "C:\\Screenshots\\";

    @Test
    public void scenarioNavigationBar(){
        utils = new Utils(driver);
        utils.setDir(dir + "scenarioNavigationBar");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        sa.assertTrue(home.isNavBarThere());
        utils.screenshot();
        home.clickOnlineBankingTab();
        sa.assertTrue(home.isNavBarThere());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        utils.screenshot();
        home.clickFeedbackTab();
        sa.assertTrue(home.isNavBarThere());
        home.clickHomeTab();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        utils.screenshot();
        sa.assertTrue(home.isNavBarThere());
        utils.screenshot();
    }
    @Test
    public void scenarioFeedbackForm() {
        utils = new Utils(driver);
        utils.setDir(dir + "scenarioFeedbackForm");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        sa.assertTrue(home.isNavBarThere());
        utils.screenshot();
        home.clickFeedbackTab();
        utils.screenshot();
        sa.assertTrue(home.isFeedbackThere());
        home.fillForms("Lorem", "Lorem@ipsum.com", "Lorem ipsum", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi interdum ante massa, ut congue eros tristique ac. Suspendisse tempus pretium metus, tristique facilisis nisl fringilla et. Nam venenatis orci ullamcorper velit bibendum, fringilla dignissim mauris vulputate. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin finibus fringilla egestas.");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        utils.screenshot();
        home.clickSendFBButton();

    }


    @BeforeMethod
    public void beforeMethod() {
        sa = new SoftAssert();
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath+"/src/pages/resources/chromedriver.exe");
        //System.setProperty("webdriver.gecko.driver", "C:\\Users\\danie\\Documents\\libs\\drivers\\geckodriver.exe");
        baseUrl = "http://zero.webappsecurity.com/";
        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
        home = new PageClass(driver);
        utils = new Utils(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(baseUrl);
    }
    @AfterMethod
    public void afterMethod(){driver.close();}
}
