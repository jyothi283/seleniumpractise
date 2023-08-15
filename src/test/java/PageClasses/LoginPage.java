package PageClasses;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertTrue;

public class LoginPage extends BasePage {

    WebDriver driver;
    public static WebElement element = null;
    // Locators of the Elements present in this Page
    private static String USER_NAME = "username";
    private static String PASS_WORD="password";
    private static String LOGIN_BUTTON="//button[contains(@class,'orangehrm')]";

private static String DASHBOARD_TEXT="//h6[contains(@class,'oxd-text--h6')]";
private static String INVALID_CREDENTIALS_MESSAGE="(//p[contains(@class,'oxd-text--p')])[1]";
    // Web elements from the locators
    public static WebElement loginUserName(WebDriver driver) {
        element = driver.findElement(By.name(USER_NAME));
        return element;
    }

    public static WebElement loginPassWord(WebDriver driver) {
        element = driver.findElement(By.name( PASS_WORD));

        return element;
    }
    public static void loginButton(WebDriver driver) {

        element = driver.findElement(By.xpath(LOGIN_BUTTON));
    }
    public static WebElement dashBoardText(WebDriver driver) {

        element = driver.findElement(By.xpath(DASHBOARD_TEXT));
    return element;
    }
    public static WebElement invalidCredentialsMessage(WebDriver driver) {

        element = driver.findElement(By.xpath(INVALID_CREDENTIALS_MESSAGE));
        return element;
    }



    public static void enterLoginUserName(WebDriver driver, String name) {
        element = loginUserName(driver);
        element.sendKeys(name);
        System.out.println("name entered as: " + name);
    }
    public static void enterLoginPassWord(WebDriver driver, String name) {
        element = loginPassWord(driver);
        element.sendKeys(name);
        System.out.println("password entered as: " + name);
    }

    public static void clickLoginButton(WebDriver driver) {
        loginButton(driver);
        clickWhenReady(driver,element,2000);
        System.out.println("Clicked on the login button");
    }

public static void checkLogin(WebDriver driver){

       element= dashBoardText(driver);
        assertTrue(element.isDisplayed());
    System.out.println("login test passed");

    }
    public static void checkLoginInvalidInputs(WebDriver driver){

        element= invalidCredentialsMessage(driver);
        assertTrue(element.isDisplayed());
        System.out.println("check login with invalid inputs test passed");

    }



}
