import Pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Pages.HomePage.adminButton;
import static Pages.HomePage.searchButton;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Loginpagetests extends BaseTest{


    @Test
    public void testSuccessLogin() throws InterruptedException {
        //Add username
        loginpage.addusername("Admin");
        //Add password
        loginpage.addpassword("admin123");
        //Click login
        loginpage.clickLogin();
        //Thread.sleep(2000);

        homePage.adminUserSearch();
        //Thread.sleep(1000);

        driver.findElement(searchButton).click();
        //Thread.sleep(1000);

        //Assertions
        Thread.sleep(1000);
        // Assert that the number of Results are correct
        WebElement NoOfResults = driver.findElement(HomePage.noOfResults);
        String actualText = NoOfResults.getText();
        Assert.assertEquals(actualText, "(1) Record Found", "Text does not match!");

        // Assert that the user name is correct
        WebElement userNameAssert = driver.findElement(HomePage.userNameAssert);
        String actualName = userNameAssert.getText();
        Assert.assertEquals(actualName, "Admin");

        // Assert that the user role is correct
        WebElement userRoleAssert = driver.findElement(HomePage.userRoleAssert);
        String actualUserRole = userRoleAssert.getText();
        Assert.assertEquals(actualUserRole, "Admin");

        // Assert that the status is correct
        WebElement statusAssert = driver.findElement(HomePage.statusAssert);
        String actualStatus = statusAssert.getText();
        Assert.assertEquals(actualStatus, "Enabled");

        // Click the Delete icon (trash bin) on the table
        homePage.clickOnElement(homePage.deleteIcon);

        //Assert that the admin user deletion is not allowed (an error appears
        Thread.sleep(100);
        WebElement popupMessage = driver.findElement(HomePage.popupMessage);
        String Message = popupMessage.getText();
        Assert.assertEquals(Message,"Error\n" +
                "Cannot be deleted\n" +
                "×","Assersion Failed");
    }



}