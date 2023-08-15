package PageClasses;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class PimPage extends BasePage {
    public static WebElement element = null;
    //locators for add employee
    private static String EMPLOYEE_FIRST_NAME = "//input[@name='firstName']";
    private static String EMPLOYEE_MIDDLE_NAME = "//input[@name='middleName']";
    private static String EMPLOYEE_LAST_NAME = "//input[@name='lastName']";
    private static String CANCEL_BUTTON = "//button[contains(@class,'oxd-button')][1]";

    private static String SAVE_BUTTON = "//button[contains(@class,'oxd-button')][2]";

    //locators for employee search
    private static String EMPLOYEE_NAME = "(//input[@placeholder='Type for hints...'])[1]";
    private static String EMPLOYEE_ID = "(//input[@class='oxd-input oxd-input--active'])[2]";
    private static String EMPLOYMENT_STATUS = "(//div[contains(text(),'-- Select --')])[1]";
    private static String FULL_TIME_CONTRACT = "//div[@role='listbox']//div[3]";
    private static String INCLUDE_BUTTON = " //i[@class='oxd-icon bi-caret-up-fill oxd-select-text--arrow']";

    private static String SEARCH_BUTTON = "//button[normalize-space()='Search']";


    private static String ADD_BUTTON = "//i[@class='oxd-icon bi-plus oxd-button-icon']";

    private static String DELETE_BUTTON = " //i[@class='oxd-icon bi-trash']";
    private static String DELETE_CONF_MSG = "//button[normalize-space()='Yes, Delete']";
    private static String DELETE_SUCCESS_MSG = "//div[contains(@class,'oxd-toast--success')]";
    private static String TABLE_ELEMENT="(//div[@class='orangehrm-container'])[1]";
   // private static String EMPLOYEE_XPATH= "//div[contains(text(), '" + employeename + "')]";
    public static WebElement employeeFirstName(WebDriver driver) {
        element = driver.findElement(By.xpath(EMPLOYEE_FIRST_NAME));
        return element;
    }

    public static WebElement employeeMiddleName(WebDriver driver) {
        element = driver.findElement(By.xpath(EMPLOYEE_MIDDLE_NAME));
        return element;
    }

    public static WebElement employeeLastName(WebDriver driver) {
        element = driver.findElement(By.xpath(EMPLOYEE_LAST_NAME));
        return element;
    }

    public static WebElement cancelButton(WebDriver driver) {
        element = driver.findElement(By.xpath(CANCEL_BUTTON));
        return element;
    }

    public static WebElement saveButton(WebDriver driver) {
        element = driver.findElement(By.xpath(SAVE_BUTTON));
        return element;
    }

    public static WebElement addButton(WebDriver driver) {
        element = driver.findElement(By.xpath(ADD_BUTTON));
        return element;
    }

    public static WebElement employeeName(WebDriver driver) {
        element = driver.findElement(By.xpath(EMPLOYEE_NAME));
        return element;
    }












    public static WebElement search_Button(WebDriver driver) {
        element = driver.findElement(By.xpath(SEARCH_BUTTON));
        return element;
    }

    public static WebElement deleteButton(WebDriver driver) {
        element = driver.findElement(By.xpath(ADD_BUTTON));
        return element;
    }

    public static WebElement deleteConfMsg(WebDriver driver) {
        element = driver.findElement(By.xpath(DELETE_CONF_MSG));
        return element;
    }

    public static WebElement deleteSuccessMsg(WebDriver driver) {
        element = driver.findElement(By.xpath(DELETE_SUCCESS_MSG));
        return element;
    }
    public static WebElement tableElement(WebDriver driver) {
        element = driver.findElement(By.xpath(TABLE_ELEMENT));
        return element;
    }
    public static void enterEmployeeName(WebDriver driver, String name) {
        element = employeeName(driver);
        clickWhenReady(driver, element, 2000);
        element.sendKeys(name);

    }

    public static void enterEmployeeFirstName(WebDriver driver, String name) {
        element = employeeFirstName(driver);
        clickWhenReady(driver, element, 2000);
        element.sendKeys(name);

    }

    public static void enterEmployeeMiddleName(WebDriver driver, String name) {
        element = employeeMiddleName(driver);
        clickWhenReady(driver, element, 2000);
        element.sendKeys(name);

    }

    public static void enterEmployeeLastName(WebDriver driver, String name) {
        element = employeeLastName(driver);
        clickWhenReady(driver, element, 2000);
        element.sendKeys(name);

    }

    public static void clickSaveButton(WebDriver driver) {
        element = saveButton(driver);
        clickWhenReady(driver, element, 2000);
        System.out.println("Clicked on the add button");
    }


    public static void clickAddButton(WebDriver driver) {
        element = addButton(driver);
        clickWhenReady(driver, element, 2000);
        System.out.println("Clicked on the add button");
    }

    public static void checkAddEmployee(WebDriver driver) {
        WebElement success = driver.findElement(By.xpath("//div[contains(@class,'oxd-toast--success ')]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'oxd-toast--success ')]")));
        assertTrue(success.isDisplayed());
        System.out.println("verify add employee test passed");
    }

    public static void checkSearchEmployeeByName(WebDriver driver, String employeename) {
        //WebElement tableElement = driver.findElement(By.xpath("(//div[@class='orangehrm-container'])[1]"));
        element = tableElement(driver);
        String xpathExpression = "//div[contains(text(), '" + employeename + "')]";
        try {
            WebElement cellElement = element.findElement(By.xpath(xpathExpression));
            assertTrue(cellElement.isDisplayed());
            System.out.println("Element found in the table.");
        } catch (StaleElementReferenceException e) {
            WebElement cellElement = element.findElement(By.xpath(xpathExpression));
            assertTrue(cellElement.isDisplayed());
            System.out.println("Element found in the table.");
        }
    }
    public static void clickSearchButton(WebDriver driver) {
        element = search_Button(driver);
        clickWhenReady(driver, element, 2000);
        System.out.println("Clicked on the search button");
    }

    public static void clickDeleteButton(WebDriver driver) {

        WebElement tableElement = driver.findElement(By.xpath("(//div[@class='orangehrm-container'])[1]"));
        try{
        WebElement delete = tableElement.findElement(By.xpath(DELETE_BUTTON));
        clickWhenReady(driver, delete, 2000);
        System.out.println("Clicked on the delete button");
    }catch(Exception e)
       {
           WebElement delete = tableElement.findElement(By.xpath(DELETE_BUTTON));
           clickWhenReady(driver, delete, 2000);
           System.out.println("Clicked on the delete button");
       }
    }
    public static void clickDeleteConfButton(WebDriver driver) {
        element = deleteConfMsg(driver);
        clickWhenvisible(driver,element,2000);
        System.out.println("Clicked on the delete confirmation button");
    }
    public static void checkDeletionPim(WebDriver driver) {

      WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(4000));
       wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(DELETE_SUCCESS_MSG))));
       assertTrue(deleteSuccessMsg(driver).isDisplayed());
        System.out.println("deletion success");
    }
}