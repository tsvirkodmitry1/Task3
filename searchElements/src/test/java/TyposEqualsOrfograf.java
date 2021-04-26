import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TyposEqualsOrfograf {
    WebDriver driver;

    @BeforeTest

    public void preCondition() {
        System.setProperty("webdriver.chrome.driver", "src\\chromedriver.exe.exe");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/typos");
    }

    @Test
    public void typosEqualsOrfograf() {
        WebElement text = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p[1]"));
        text.isDisplayed();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/p[1]")).getText().equalsIgnoreCase("This example demonstrates a typo being introduced. It does it randomly on each page load."));
    }

    @Test
    public void typosEqualsOrfografSecondLine() {
        WebElement text = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p[2]"));
        text.isDisplayed();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/p[2]")).getText().equalsIgnoreCase("Sometimes you'll see a typo, other times you won't."));
    }

    @AfterTest
    public void postTest() {

        driver.quit();
    }
}
