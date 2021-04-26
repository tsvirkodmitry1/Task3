import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class ActionAddRemoveElements {

    WebDriver driver;

    @BeforeTest

    public void preCondition() {
        System.setProperty("webdriver.chrome.driver", "src\\chromedriver.exe.exe");
        driver = new ChromeDriver();
        driver.get(" http://the-internet.herokuapp.com/");


    }

    @Test
    public void actionAddRemoveElements() //throws InterruptedException
    {
        //different actions on different elements
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/button")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/button")).click();
        driver.findElement(By.xpath("//*[@id=\"elements\"]/button[2]")).click();
        List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"elements\"]/button[1]"));
        int actualCount = list.size();
        int expectedCount = 1;
        Assert.assertEquals(actualCount, expectedCount);


    }

    @AfterTest
    public void postTest() {

        driver.quit();
    }
}
