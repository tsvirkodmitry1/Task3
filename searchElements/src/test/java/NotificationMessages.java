import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NotificationMessages {
    WebDriver driver;

    @BeforeTest

    public void preCondition() {
        System.setProperty("webdriver.chrome.driver", "src\\chromedriver.exe.exe");
        driver = new ChromeDriver();
        driver.get(" http://the-internet.herokuapp.com/notification_message_rendered");

    }

    @Test
    public void selectData() {
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/p/a")).click();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/p")).getText().equalsIgnoreCase("The message displayed above the heading is a notification message. It is often used to convey information about an action previously taken by the user.\n" +
                "\n" +
                "Some rudimentary examples include 'Action successful', 'Action unsuccessful, please try again', etc.\n" +
                "\n" +
                "Click here to load a new message."));


    }

    @AfterTest
    public void postTest() {
        driver.quit();
    }
}
