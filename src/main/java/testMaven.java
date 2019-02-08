/**
 * Created by madalin.cotetiu on 2/7/2019.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.nio.file.Path;

public class testMaven {


    public static void main(String[] args) {

        //Chrome tests
//        System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver.exe");
//
//        ChromeDriver chromeDriver = new ChromeDriver();
//        chromeDriver.get("http://automationpractice.com/index.php");
//
//        WebElement loginLink = chromeDriver.findElementByClassName("login");
//        loginLink.click();
//
//        WebElement emailField = chromeDriver.findElementById("email");
//        WebElement passwordField = chromeDriver.findElementById("passwd");
//        WebElement submitButton = chromeDriver.findElementById("SubmitLogin");
//
//        emailField.sendKeys("madalincotetiu@gmail.com");
//        passwordField.sendKeys("test1923");
//        submitButton.click();
//
//        chromeDriver.close();



        //Firefox tests
        System.setProperty("webdriver.gecko.driver", "geckodriver/geckodriver.exe");

        FirefoxDriver firefoxDriver = new FirefoxDriver();
        firefoxDriver.get("http://automationpractice.com/index.php");

        WebElement loginLink = firefoxDriver.findElementByClassName("login");
        loginLink.click();

        WebElement emailField = firefoxDriver.findElementById("email");
        WebElement passwordField = firefoxDriver.findElementById("passwd");
        WebElement submitButton = firefoxDriver.findElementById("SubmitLogin");

        emailField.sendKeys("madalincotetiu@gmail.com");
        passwordField.sendKeys("test1923");
        submitButton.click();

        firefoxDriver.close();

    }
}
