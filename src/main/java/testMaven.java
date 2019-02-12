/**
 * Created by madalin.cotetiu on 2/7/2019.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestMaven {

    private String baseUrl = "http://automationpractice.com/index.php";
    private WebDriver driver;


    @BeforeClass
    public void setup() {
        //Chrome tests
        System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver.exe");
        driver = new ChromeDriver();


        //Firefox tests
//        System.setProperty("webdriver.gecko.driver", "geckodriver/geckodriver.exe");
//        driver = new FirefoxDriver();

        driver.get(baseUrl);
    }

    @Test(priority = 1)
    public void verifyHomepageTitle() {
        String expectedTitle = "My Store";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Test(priority = 2)
    public void clickSignInLink() {
        WebElement loginLink = driver.findElement(By.className("login"));
        loginLink.click();
        String expectedTitle = "Login - My Store";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Test(priority = 3)
    public void clickSignInButtonWithEmptyEmailEmptyPassword() {
        WebElement submitButton = driver.findElement(By.id("SubmitLogin"));
        submitButton.click();
        String actualErrorMessage = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/ol[1]/li[1]")).getText();
        String expectedErrorMesage = "An email address required.";

        Assert.assertEquals(expectedErrorMesage, actualErrorMessage);
    }

    @Test(priority = 3)
    public void clickSignInButtonWithInvalidEmailFormat() {
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement submitButton = driver.findElement(By.id("SubmitLogin"));

        emailField.clear();

        emailField.sendKeys("test");

        submitButton.click();
        String actualErrorMessage = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/ol[1]/li[1]")).getText();
        String expectedErrorMesage = "Invalid email address.";

        Assert.assertEquals(expectedErrorMesage, actualErrorMessage);
    }

    @Test(priority = 3)
    public void clickSignInButtonWithValidEmailEmptyPassword() {
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement submitButton = driver.findElement(By.id("SubmitLogin"));

        emailField.clear();
        emailField.sendKeys("madalincotetiu@gmail.com");

        submitButton.click();
        String actualErrorMessage = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/ol[1]/li[1]")).getText();
        String expectedErrorMesage = "Password is required.";

        Assert.assertEquals(expectedErrorMesage, actualErrorMessage);
    }

    @Test(priority = 3)
    public void clickSignInButtonWithValidEmailInvalidPassword() {
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement submitButton = driver.findElement(By.id("SubmitLogin"));
        WebElement passwordField = driver.findElement(By.id("passwd"));

        emailField.clear();
        emailField.sendKeys("madalincotetiu@gmail.com");
        passwordField.sendKeys("test");

        submitButton.click();
        String actualErrorMessage = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/ol[1]/li[1]")).getText();
        String expectedErrorMesage = "Invalid password.";

        Assert.assertEquals(expectedErrorMesage, actualErrorMessage);
    }

    @Test(priority = 3)
    public void clickSignInButtonWithValidEmailWrongPassword() {
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement submitButton = driver.findElement(By.id("SubmitLogin"));
        WebElement passwordField = driver.findElement(By.id("passwd"));

        emailField.clear();
        passwordField.clear();

        emailField.sendKeys("madalincotetiu@gmail.com");
        passwordField.sendKeys("testtest");

        submitButton.click();
        String actualErrorMessage = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/ol[1]/li[1]")).getText();
        String expectedErrorMesage = "Authentication failed.";

        Assert.assertEquals(expectedErrorMesage, actualErrorMessage);
    }

    @Test(priority = 4)
    public void clickSignInButtonWithValidDetails() {
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id("passwd"));
        WebElement submitButton = driver.findElement(By.id("SubmitLogin"));

        emailField.clear();
        passwordField.clear();

        emailField.sendKeys("madalincotetiu@gmail.com");
        passwordField.sendKeys("test1923");
        submitButton.click();
        String expectedTitle = "My account - My Store";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @AfterClass
    public void quitBrowser() {
        driver.quit();
    }
}
