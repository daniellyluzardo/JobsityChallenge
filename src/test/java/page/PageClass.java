package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

public class PageClass  {
    WebDriver driver;
    JavascriptExecutor je;
    Utils utils;
    WebElement element;
    WebDriver wait;

    public PageClass(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utils = new Utils(driver);
    }

    @FindBy(id = "nav")
    private WebElement navBar;
    @FindBy(id = "homeMenu")
    private WebElement HomeButton;
    @FindBy(id = "onlineBankingMenu")
    private WebElement OBMenu;
    @FindBy(id = "feedback")
    private WebElement feedbackButton;
    @FindBy(id = "name")
    private WebElement nameField;
    @FindBy(id = "email")
    private WebElement emailField;
    @FindBy(id = "subject")
    private WebElement subjectField;
    @FindBy(xpath = "//*[@id=\"comment\"]")
    private WebElement textareaField;
    @FindBy(id = "feedback-title")
    private WebElement fbBanner;
    @FindBy(css = ".btn-signin")
    private WebElement sendFeedback;
    @FindBy(css = "input.btn:nth-child(2)")
    private WebElement clearFeedback;

    public void clickHomeTab() {
        utils.isThere(HomeButton);
        HomeButton.click();}
    public void clickOnlineBankingTab() {
        utils.isThere(OBMenu);
        OBMenu.click();
    }
    public void clickFeedbackTab() {
        utils.isThere(feedbackButton);
        feedbackButton.click();
    }
    public void clickSendFBButton() {
        utils.isThere(sendFeedback);
        sendFeedback.click();
    }
    public void clickClearFBButton() {
        utils.isThere(clearFeedback);
        clearFeedback.click();
    }
    public void fillForms(String nameInfo, String emailInfo, String subjectInfo, String commentInfo) {
        nameField.sendKeys(nameInfo);
        emailField.sendKeys(emailInfo);
        subjectField.sendKeys(subjectInfo);
        textareaField.sendKeys(commentInfo);
    }

    public boolean isNavBarThere(){
        //utils = new Utils(driver);
        return utils.isThere(navBar);
    }
    public boolean isFeedbackThere(){
        return utils.isThere(fbBanner);
    }

}
