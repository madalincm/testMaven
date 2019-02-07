/**
 * Created by madalin.cotetiu on 2/7/2019.
 */

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.nio.file.Path;

public class testMaven {


    public static void main(String[] args) {
        File webdriverFile = new File("chromedriver/chromedriver.exe");
        String webdriverPath = webdriverFile.getAbsolutePath();

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\madalin.cotetiu\\Desktop\\JavaPractice\\testMaven\\chromedriver\\chromedriver.exe");

        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("http://automationpractice.com/index.php");

        WebElement loginLink = chromeDriver.findElementByClassName("login");
        loginLink.click();

        WebElement emailField = chromeDriver.findElementById("email");
        WebElement passwordField = chromeDriver.findElementById("passwd");
        WebElement submitButton = chromeDriver.findElementById("SubmitLogin");

        emailField.sendKeys("madalincotetiu@gmail.com");
        passwordField.sendKeys("test1923");
        submitButton.click();

        chromeDriver.close();





    }
}
