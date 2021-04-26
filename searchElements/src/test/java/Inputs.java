import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.openqa.selenium.Keys.ARROW_DOWN;
import static org.openqa.selenium.Keys.ARROW_UP;

public class Inputs {
    WebDriver driver;


    @BeforeTest

    public void preCondition() {
        System.setProperty("webdriver.chrome.driver", "src\\chromedriver.exe.exe");
        driver = new ChromeDriver();
        driver.get(" http://the-internet.herokuapp.com/inputs");

    }

    @Test
    public void actionInputs() {
        WebElement up = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/input"));
        Actions action = new Actions(driver);
        action.moveToElement(up).click();
        action.contextClick(up).sendKeys(ARROW_UP).sendKeys(ARROW_UP).build().perform();
        Assert.assertEquals(action.moveToElement(up), action.contextClick(up));
    }

    @Test
    public void actionInputs2() {
        WebElement down = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/input"));
        Actions action = new Actions(driver);
        action.moveToElement(down).click();
        action.contextClick(down).sendKeys(ARROW_DOWN).sendKeys(ARROW_DOWN).sendKeys(ARROW_DOWN).build().perform();
        Assert.assertEquals(action.moveToElement(down), action.contextClick(down));
    }

    @Test
    public void actionInputs3() {
        //WebElement copyText = driver.findElement(By.xpath("//*[@id=\"page-footer\"]/div/div/a"));
        WebElement fieldInputs = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/input"));
        fieldInputs.click();
        fieldInputs.sendKeys("Powered by Elemental Selenium");
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"page-footer\"]/div/div/a")).getText().equalsIgnoreCase("Powered by Elemental Selenium"));
    }

    @AfterTest
    public void postTest() {
        driver.quit();
    }
}
