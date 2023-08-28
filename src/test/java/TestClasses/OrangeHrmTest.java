package TestClasses;
import PageClasses.AdminPage;
import PageClasses.DashBoardPage;
import PageClasses.LoginPage;
import PageClasses.PimPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import static org.testng.Assert.assertTrue;

public class OrangeHrmTest {
    private static WebDriver driver;
    private static String baseUrl;
    ExtentReports extent;
    ExtentTest test;
    @BeforeClass
    public void setup() {
        extent = new ExtentReports();
        extent.setSystemInfo("orange hrm", "XYZ Automation");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("ExtentReports/ExtentReport.html");
        extent.attachReporter(sparkReporter);
        driver = new ChromeDriver();
        //test.log(Status.INFO, "browser opened");
        baseUrl = " https://opensource-demo.orangehrmlive.com/";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
    }

    @Test(priority = 1)
//test case to verify login with valid inputs
    public void verifyLoginValidInputs() {
        test = extent.createTest("Verify login with valid inputs");
        driver.get(baseUrl);
        LoginPage.enterLoginUserName(driver, "Admin");
        LoginPage.enterLoginPassWord(driver, "admin123");
        LoginPage.clickLoginButton(driver);
        test.log(Status.INFO, "login button clicked");
        LoginPage.checkLogin(driver);
        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");

        test.log(Status.INFO, " Navigated to expected URL after successful login");
    }

    //test case to verify add employee in pim page with valid inputs
    @Test(priority = 2)
    public void verifyAddEmployeePim() {
        test = extent.createTest("verify add employee in pim page with valid inputs");
        DashBoardPage.clickPimLink(driver);
        PimPage.clickAddButton(driver);
        PimPage.enterEmployeeFirstName(driver, "jyothi");
        PimPage.enterEmployeeMiddleName(driver, "abc");
        PimPage.enterEmployeeLastName(driver, "xyz");
        PimPage.clickSaveButton(driver);
        test.log(Status.INFO, "clicked on save button");
        WebElement test_success = PimPage.checkAddEmployee(driver);
        Assert.assertTrue(test_success.isDisplayed());
        test.log(Status.INFO, " employee addition successfull");

    }

    //test case to verify search employee in pim page with employee name
    @Test(priority = 3)
    public void verifySearchEmployeePim() {
        test = extent.createTest("verify search employee in pim page with employee name");
        DashBoardPage.clickPimLink(driver);
        PimPage.enterEmployeeName(driver, "jyothi abc");
        PimPage.clickSearchButton(driver);
        //PimPage.checkSearchEmployeeByName(driver, "jyothi abc");
        WebElement search_success=PimPage.checkSearchEmployeeByName(driver, "jyothi abc");
        assertTrue(search_success.isDisplayed());
        test.log(Status.INFO, " employee record found");

    }

    //test case for verifying deletion of employee by employee name in pim
    @Test(priority = 6)
    public void verifyDeleteEmployeePim() {
        test = extent.createTest("verify delete employee record in pim page with employee name");
        DashBoardPage.clickPimLink(driver);
        PimPage.enterEmployeeName(driver, "jyothi abc");
        PimPage.clickSearchButton(driver);
        PimPage.checkSearchEmployeeByName(driver, "jyothi abc");

        PimPage.clickDeleteButton(driver);
        test.log(Status.INFO, "clicked on delete button");
        PimPage.clickDeleteConfButton(driver);
        WebElement DeleteE_element = PimPage.checkDeletionPim(driver);
        assertTrue(DeleteE_element.isDisplayed());
        test.log(Status.INFO, " Deletion successfull");
    }

    //testcase to verify add user in user management
    @Test(priority = 4)
    public void verifyAddUser() throws InterruptedException {
        test = extent.createTest("Verify add user in user management");
        DashBoardPage.clickAdminLink(driver);
        AdminPage.clickAddButton(driver);
        AdminPage.selectUserRole(driver);
        AdminPage.enterEmployeeName(driver, "jyothi abc");
        test.log(Status.INFO, "employee name entered");
        AdminPage.selectStatus(driver);

        AdminPage.enterUserName(driver, "jyothi12");
        AdminPage.enterPassWord(driver, "Test1234");
        AdminPage.enterConfirmPassWord(driver, "Test1234");
        AdminPage.clickSaveButton(driver);
        test.log(Status.INFO, "clicked on save button");
        AdminPage.confirmSaved(driver);
        WebElement addE_success=AdminPage.confirmSaved(driver);
        assertTrue(addE_success.isDisplayed());
        test.log(Status.INFO, " User details saved");
    }

    @Test(priority = 5)
    public void SearchSystemUserTest() {  //test case to search system user by user name
        test = extent.createTest("Verify search user");
        DashBoardPage.clickAdminLink(driver);
        AdminPage.enterSystemUserName(driver, "jyothi12");
        AdminPage.clickSystemSearchButton(driver);
        test.log(Status.INFO, "clicked on search button");

        WebElement SearchU_element=AdminPage.TableElementCheck(driver, "jyothi12");
        assertTrue(SearchU_element.isDisplayed());
        test.log(Status.INFO, " User found in the table");
    }
    @AfterMethod
    public void attachScreenshot(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            String path = takeScreenshot(testResult.getName());
            test.addScreenCaptureFromPath("." + path);
            test.log(Status.FAIL, "Test Method Failed: " + testResult.getName());
        }
    }
    @AfterClass
public void tearDown()
{

  driver.quit();
  extent.flush();

}
    public String takeScreenshot(String fileName) throws IOException {
        fileName = fileName + ".png";
        String directory = "./ExtentReports/Screenshots//";
        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File(directory + fileName));
        return directory + fileName;
    }
}



