import Pages.HomePage;
import Pages.Loginpage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public WebDriver driver;
    protected Loginpage loginpage;
    protected HomePage homePage;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
        driver.manage().window().maximize();
        loginpage = new Loginpage(driver);
        homePage = new HomePage(driver);


    }
    @AfterMethod
    public void tearDown(){
        driver.quit();


    }
}