package PageClasses;
import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertTrue;

public class AdminPage extends BasePage {
    WebDriver driver;
    public static WebElement element = null;
    // Locators of the Elements present in this Page
    private static String USER_MANAGEMENT = "//nav/ul/li[1]/span";


    private static String ADD_BUTTON = "//div[2]/div[1]/button";


    private static String USER_ROLE = "(//div[2]/div/div/div[1])[2]";

    private static String USER_DROPDOWN = "//div[@role='listbox']//span[text()='Admin']";
    private static String Employee_Name = "(//div[contains(@class,'oxd-autocomplete-text-input')])[1]//input";

    private static String EMPLOYEE_DROPDOWN = "//div[@role='listbox']//span[text()='Alice Duval']";

    private static String Status = "//div[3]/div/div[2]/div/div";
    private static String Status_Enabled = "//div[3]/div/div[2]/div/div";
    private static String STATUS_DROPDOWN = "//div[@role='listbox']//span[text()='Enabled']";

    private static String USER_NAME = "(//input[contains(@class,'oxd-input')])[2]";
    private static String PASS_WORD = "//div[1]/div/div[2]/input";
    private static String CONFIRM_PASSWORD = "//div[2]/div/div[2]/input ";
    private static String Save_Button = "//div[3]/button[2]";
    // Web elements from the locators
    private static String SYSTEM_USERNAME = "//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']";
    private static String SYSTEM_USERROLE = "(//div[contains(text(),'-- Select --')])[1]";
    private static String SYSTEM_USERROLE_ADMIN = "//span[contains(text(),'Admin')]";
    private static String SYSTEM_EMPLOYEE = " //input[@placeholder='Type for hints...']";
    private static String SYSTEM_EMPLOYEE_NAME = " //span[contains(text(),'jyothi abc')]";
    //private static String SYSTEM_STATUS=" (//div[contains(text(),'-- Select --')])[2]";
    private static String SYSTEM_STATUS = "(//div[contains(@class,'oxd-select-text-input')])[2]";
    private static String SYSTEM_STATUS_ENABLED = "//span[normalize-space()='Enabled']";
    private static String SYSTEM_RESETBUTTON = "(//button[contains(@class,'oxd-button--medium')])[1]";
    private static String SYSTEM_SEARCHBUTTON = "(//button[contains(@class,'oxd-button--medium')])[1]";

    private static String CONF_MSG = "//div[contains(@class,'oxd-toast--success')]";

    private static String DELETE_SUCCESS_MSG = "//div[contains(@class,'oxd-toast--success')]";
    private static String TABLE_ELEMENT="//div[@class='orangehrm-container']";
    public static WebElement userManagement(WebDriver driver) {
        element = driver.findElement(By.xpath(USER_MANAGEMENT));
        return element;
    }
    public static WebElement addButton(WebDriver driver) {
        element = driver.findElement(By.xpath(ADD_BUTTON));
        return element;
    }
    public static WebElement userRole(WebDriver driver) {
        element = driver.findElement(By.xpath(USER_ROLE));
        return element;
    }

    public static WebElement employeeName(WebDriver driver) {
        element = driver.findElement(By.xpath(Employee_Name));
        return element;
    }

    public static WebElement status(WebDriver driver) {
        element = driver.findElement(By.xpath(Status));
        return element;
    }

    public static WebElement userName(WebDriver driver) {
        element = driver.findElement(By.xpath(USER_NAME));
        return element;
    }

    public static WebElement passWord(WebDriver driver) {
        element = driver.findElement(By.xpath(PASS_WORD));
        return element;
    }

    public static WebElement confirmPassWord(WebDriver driver) {
        element = driver.findElement(By.xpath(CONFIRM_PASSWORD));
        return element;
    }

    public static WebElement saveButton(WebDriver driver) {
        element = driver.findElement(By.xpath(Save_Button));
        return element;
    }

    public static WebElement systemUserName(WebDriver driver) {
        element = driver.findElement(By.xpath(SYSTEM_USERNAME));
        return element;
    }

    public static WebElement systemUserRole(WebDriver driver) {
        element = driver.findElement(By.xpath(SYSTEM_USERROLE));
        return element;
    }

    public static WebElement systemUserRoleAdmin(WebDriver driver) {
        element = driver.findElement(By.xpath(SYSTEM_USERROLE_ADMIN));
        return element;
    }

    public static WebElement systemEmployee(WebDriver driver) {
        element = driver.findElement(By.xpath(SYSTEM_EMPLOYEE));
        return element;
    }

    public static WebElement systemEmployeeName(WebDriver driver) {
        element = driver.findElement(By.xpath(SYSTEM_EMPLOYEE_NAME));
        return element;
    }

    public static WebElement systemStatus(WebDriver driver) {
        element = driver.findElement(By.xpath(SYSTEM_STATUS));
        return element;
    }

    public static WebElement systemStatusEnabled(WebDriver driver) {
        element = driver.findElement(By.xpath(SYSTEM_STATUS_ENABLED));
        return element;
    }

    public static WebElement systemResetButton(WebDriver driver) {
        element = driver.findElement(By.xpath(SYSTEM_RESETBUTTON));


        return element;
    }

    public static WebElement systemSearchButton(WebDriver driver) {
        element = driver.findElement(By.xpath(SYSTEM_SEARCHBUTTON));


        return element;
    }

    public static void confirmation(WebDriver driver) {
        element = driver.findElement(By.xpath(CONF_MSG));
    }
    public static WebElement TableElement(WebDriver driver) {
        element = driver.findElement(By.xpath(USER_NAME));


        return element;
    }

    // Methods to perform actions on the elements in this page


    public static void clickAddButton(WebDriver driver) {
        addButton(driver);
        clickWhenReady(driver, element, 2000);
        System.out.println("Clicked on the add button");
    }

    public static void selectUserRole(WebDriver driver) {
        element = userRole(driver);

        clickWhenReady(driver, element, 2000);
        System.out.println("Clicked on the user role");

        WebElement e = driver.findElement(By.xpath(USER_DROPDOWN));
        clickWhenReady(driver, e, 2000);
        System.out.println("Clicked on the admin");
    }

    public static void enterEmployeeName(WebDriver driver, String name) {
        element = employeeName(driver);
        clickWhenReady(driver, element, 2000);
        element.sendKeys(name);
        WebElement e1 = driver.findElement(By.xpath("//span[contains(text(),'jyothi abc')]"));
        e1.click();
    }
    public static void selectStatus(WebDriver driver) {
        element = status(driver);

        clickWhenReady(driver, element, 2000);
        WebElement e = driver.findElement(By.xpath(STATUS_DROPDOWN));
        clickWhenReady(driver, e, 2000);

    }


    public static void enterUserName(WebDriver driver, String name) {
        element = userName(driver);
        // element.click();
        clickWhenReady(driver, element, 3000);
        element.sendKeys(name);
        System.out.println("name entered as: " + name);
    }

    public static void enterPassWord(WebDriver driver, String name) {
        element = passWord(driver);
        //element.click();
        clickWhenReady(driver, element, 2000);
        element.sendKeys(name);
        System.out.println("password entered as: " + name);
    }

    public static void enterConfirmPassWord(WebDriver driver, String name) {
        element = confirmPassWord(driver);
        clickWhenReady(driver, element, 2000);
        element.sendKeys(name);
        System.out.println("password entered as: " + name);
    }

    public static void clickSaveButton(WebDriver driver) {
        saveButton(driver);
        clickWhenReady(driver, element, 2000);
        System.out.println("Clicked on the add button");
    }

    public static void enterSystemUserName(WebDriver driver, String name) {
        element = systemUserName(driver);
        clickWhenReady(driver, element, 2000);
        element.sendKeys(name);
        System.out.println("system username entered as: " + name);
    }

    public static void clickSystemUserRole(WebDriver driver) {
        systemUserRole(driver);
        clickWhenReady(driver, element, 2000);
        System.out.println("Clicked on the add button");
    }

    public static void selectSystemUserRole(WebDriver driver) {
        element = systemUserRoleAdmin(driver);

        clickWhenReady(driver, element, 2000);

        System.out.println("Clicked on the admin");
    }

    public static void clickSystemEmployee(WebDriver driver, String name) {
        element = systemEmployee(driver);
        clickWhenReady(driver, element, 2000);
        System.out.println("Clicked on the employee dropdown");
        element.sendKeys(name);

        WebElement element2 = systemEmployeeName(driver);

        //clickWhenReady(driver,element2,2000);
        element2.click();
        System.out.println("Clicked on the employee name");
    }

    public static void clickSystemStatus(WebDriver driver) {

        element = systemStatus(driver);
        clickWhenReady(driver, element, 2000);

        element = systemStatusEnabled(driver);

        clickWhenReady(driver, element, 2000);

        System.out.println("selected the system status");
    }



    public static void clickSystemSearchButton(WebDriver driver) {
        systemSearchButton(driver);
        clickWhenReady(driver, element, 2000);
        System.out.println("Clicked on the submit button");
    }

    public static void confirmSaved(WebDriver driver) {
        confirmation(driver);
        assertTrue(element.isDisplayed());
        System.out.println("details saved");


    }

    public static void TableElementCheck(WebDriver driver, String username) {

       element=TableElement(driver);
       String xpathExpression = "//div[contains(text(), '" + username + "')]";
        clickWhenvisible(driver,element,2000);
        WebElement cellElement = element.findElement(By.xpath(xpathExpression));
        assertTrue(cellElement.isDisplayed());
        System.out.println("Element found in the table.");

    }
}

