package PageClasses;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class DashBoardPage extends BasePage {
    WebDriver driver;
    public static WebElement element = null;
    // Locators of the Elements present in this Page
    private static String DASHBOARD_LINK = "//i[contains(@class,'hamburger')]";
    private static String ADMIN_LINK = "//ul/li[1]/a/span";
    private static String PIM_LINK = "//span[normalize-space()='PIM']";
    // Web elements from the locators
    public static WebElement AdminLink(WebDriver driver) {
        element = driver.findElement(By.xpath(ADMIN_LINK));

        return element;
    }
    public static void PimLink(WebDriver driver) {

        element = driver.findElement(By.xpath(PIM_LINK));
    }
    public static void clickAdminLink(WebDriver driver) {
        AdminLink(driver);
        clickWhenReady(driver, element, 2000);
        System.out.println("Clicked on the  admin link");
    }

    public static void clickPimLink(WebDriver driver) {
        PimLink(driver);
        clickWhenReady(driver, element, 2000);
        System.out.println("Clicked on the  admin link");
    }


}