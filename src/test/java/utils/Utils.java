package utils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Utils {

    WebDriver driver;
    String dir;

    public Utils(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void setDir(String dir) { this.dir = dir; }

    public boolean isThere(WebElement element){
        boolean isThere = false;

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));

        try {
            if (element.isDisplayed()){
                isThere = true;
            }
        } catch (Exception e) {
            isThere = false;
        }
        return isThere;
    }
    public String currentDate() {
        Date date = new Date();
        SimpleDateFormat dots = new SimpleDateFormat("dd.MM.yyyy-HH.mm.ss");
        return dots.format(date);
    }
    public void screenshot(String testResult){
        String archiveName = testResult + currentDate() + ".png";
        File image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            File directory = new File(dir);
            directory.mkdirs();
            FileHandler.copy(image, new File(directory+"\\" + archiveName));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void screenshot(){
        String archiveName = currentDate() + ".png";
        File image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            File directory = new File(dir);
            directory.mkdirs();
            FileHandler.copy(image, new File(directory+"\\" + archiveName));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
