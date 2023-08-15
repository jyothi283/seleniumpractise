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
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


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
        test.log(Status.INFO, "website loaded");
        LoginPage.enterLoginUserName(driver, "Admin");
        test.log(Status.INFO, "username entered");
        LoginPage.enterLoginPassWord(driver, "admin123");
        test.log(Status.INFO, "password entered");
        LoginPage.clickLoginButton(driver);
        test.log(Status.INFO, "login button clicked");
        LoginPage.checkLogin(driver);
        test.log(Status.INFO, "login successfull");
    }

    //test case to verify add employee in pim page with valid inputs
    @Test(priority = 2)
    public void verifyAddEmployeePim() {
        test = extent.createTest("verify add employee in pim page with valid inputs");
        DashBoardPage.clickPimLink(driver);
        test.log(Status.INFO, "clicked on pim link");
        PimPage.clickAddButton(driver);
        test.log(Status.INFO, "clicked on add button");
        PimPage.enterEmployeeFirstName(driver, "jyothi");
        test.log(Status.INFO, "employee first name entered");
        PimPage.enterEmployeeMiddleName(driver, "abc");
        test.log(Status.INFO, "employee middle name entered");
        PimPage.enterEmployeeLastName(driver, "xyz");
        test.log(Status.INFO, "employee last name entered");
        PimPage.clickSaveButton(driver);
        test.log(Status.INFO, "clicked on save button");
        PimPage.checkAddEmployee(driver);
        test.log(Status.INFO, "employee addition successfull");


    }

    //test case to verify search employee in pim page with employee name
    @Test(priority = 3)
    public void verifySearchEmployeePim() {
        test = extent.createTest("verify search employee in pim page with employee name");
        DashBoardPage.clickPimLink(driver);
        test.log(Status.INFO, "clicked on pim link");
        PimPage.enterEmployeeName(driver, "jyothi abc");
        test.log(Status.INFO, "entered employee name");
        PimPage.clickSearchButton(driver);
        PimPage.checkSearchEmployeeByName(driver, "jyothi abc");
        test.log(Status.INFO, "employee record found");

    }

    //test case for verifying deletion of employee by employee name in pim
    @Test(priority = 6)
    public void verifyDeleteEmployeePim() {
        test = extent.createTest("verify delete employee record in pim page with employee name");
        DashBoardPage.clickPimLink(driver);
        test.log(Status.INFO, "clicked on pim link");
        PimPage.enterEmployeeName(driver, "jyothi abc");
        test.log(Status.INFO, "entered employee name");
        PimPage.clickSearchButton(driver);
        PimPage.checkSearchEmployeeByName(driver, "jyothi abc");
        test.log(Status.INFO, "employee record found");

        PimPage.clickDeleteButton(driver);
        test.log(Status.INFO, "clicked on delete button");
        PimPage.clickDeleteConfButton(driver);
        test.log(Status.INFO, "clicked on delete confirmation button");
        PimPage.checkDeletionPim(driver);
        test.log(Status.INFO, "deletion successfull");


    }

    //testcase to verify add user in user management
    @Test(priority = 4)
    public void verifyAddUser() throws InterruptedException {
        test = extent.createTest("Verify add user in user management");
        DashBoardPage.clickAdminLink(driver);
        test.log(Status.INFO, "clicked on admin link");
        AdminPage.clickAddButton(driver);
        test.log(Status.INFO, "clicked on add button");
        AdminPage.selectUserRole(driver);
        test.log(Status.INFO, "user role selected");
        AdminPage.enterEmployeeName(driver, "jyothi abc");
        test.log(Status.INFO, "employee name entered");
        AdminPage.selectStatus(driver);
        test.log(Status.INFO, "employee status selected");
        AdminPage.enterUserName(driver, "jyothi12");
        test.log(Status.INFO, "employee username entered");
        AdminPage.enterPassWord(driver, "Test1234");
        test.log(Status.INFO, "password entered");
        AdminPage.enterConfirmPassWord(driver, "Test1234");
        test.log(Status.INFO, "confirm password entered");
        AdminPage.clickSaveButton(driver);
        test.log(Status.INFO, "clicked on save button");
        AdminPage.confirmSaved(driver);
        test.log(Status.INFO, "details saved");
    }

    @Test(priority = 5)
    public void SearchSystemUserTest() {  //test case to search system user by user name
        test = extent.createTest("Verify search user");
        DashBoardPage.clickAdminLink(driver);
        AdminPage.enterSystemUserName(driver, "jyothi12");
        test.log(Status.INFO, " system username entered");
        AdminPage.clickSystemSearchButton(driver);
        test.log(Status.INFO, "clicked on search button");
        AdminPage.TableElementCheck(driver, "jyothi12");
        test.log(Status.INFO, "element found in the table");
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



