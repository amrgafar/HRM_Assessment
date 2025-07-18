package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver){

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }
    //WenElements
    public static By adminButton = By.cssSelector("a[class='oxd-main-menu-item.active'] span[class='oxd-text.oxd-text--span.oxd-main-menu-item--name']");
    public static By userNameField = By.cssSelector("div[class='oxd-input-group oxd-input-field-bottom-space'] div input[class='oxd-input oxd-input--active']");
    public static By searchButton = By.cssSelector("button[type='submit']");
    public static By noOfResults = By.cssSelector("div[class='orangehrm-horizontal-padding orangehrm-vertical-padding'] span[class='oxd-text oxd-text--span']");
    public static By userNameAssert = By.cssSelector("div[class='oxd-table-card'] div:nth-child(2)");
    public static By userRoleAssert = By.cssSelector("div[class='oxd-table-card'] div:nth-child(3)");
    public static By statusAssert = By.cssSelector("div[class='oxd-table-card'] div:nth-child(5)");
    public static By deleteIcon = By.cssSelector(".oxd-icon.bi-trash");
    public static By popupMessage = By.cssSelector("div[id='oxd-toaster_1'] div:nth-child(1)");


    //Methods
    public void clickOnElement(By element){
        driver.findElement(element).click();
    }
    public void adminUserSearch(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameField));
        driver.findElement(userNameField).sendKeys("Admin");
    }

    public void assertingOnResults(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(noOfResults));
        WebElement NoOfResults = driver.findElement(HomePage.noOfResults);
        String actualText = NoOfResults.getText();
        //Assert.assertEquals(actualText, "(1) Record Found", "Text does not match!");
    }






}