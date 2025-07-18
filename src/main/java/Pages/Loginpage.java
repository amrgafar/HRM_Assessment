package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Loginpage {
    private WebDriver driver;
    private WebDriverWait wait;

    //web elements
    private By userNameField = By.cssSelector("input[name='username']");
    private By passwordField = By.cssSelector("input[name='password']");
    private By loginButton = By.cssSelector("button[type='submit']");

    public Loginpage(WebDriver driver){

        this.driver  = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    //methods
    public void addusername(String username){
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameField));
        driver.findElement(userNameField).sendKeys(username);
    }

    public void addpassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        driver.findElement(passwordField).sendKeys(password);
    }

    public HomePage clickLogin(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }




//    public boolean isDuplicateRequiredMessageVisible(){
//        List<WebElement> requiredErrorList = driver.findElements(requiredErrormessage);
//        for(int i=0 ; i<requiredErrorList.size() ; i++){
//            if(!requiredErrorList.get(i).isDisplayed()){
//                return false;
//            }
//        }
//        return true;
//    }


}