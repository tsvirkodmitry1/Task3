import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HoversMakeAChainOfActions {
    WebDriver driver;

    @BeforeTest

    public void preCondition() {
        System.setProperty("webdriver.chrome.driver", "src\\chromedriver.exe.exe");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/hovers");
    }

    @Test
    public void hoversMakeAChainOfActions() {
        //hover over profile, check name, click on link,check 404
        Actions action = new Actions(driver);
        WebElement user1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/img"));
        action.moveToElement(user1).moveToElement(user1).build().perform();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/h5")).getText().equalsIgnoreCase(
                "name: user1"));
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/a")).click();
        String actualMessageText = driver.findElement(By.xpath("/html/body/h1")).getText();
        System.out.println(actualMessageText);
        String expectedMsgText = "Not Found";
        Assert.assertTrue(expectedMsgText.equals(actualMessageText));
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/h1")).getText().equalsIgnoreCase("Not Found"));
        driver.get("http://the-internet.herokuapp.com/hovers");
    }

    @Test
    public void hoversMakeAChainOfActions2() {
        //hover over profile2, check name, click on link,check 404
        Actions action = new Actions(driver);
        WebElement user2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/img"));
        action.moveToElement(user2).moveToElement(user2).build().perform();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/h5")).getText().equalsIgnoreCase(
                "name: user2"));
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/a")).click();
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/h1")).getText().equalsIgnoreCase("Not Found"));
        driver.get("http://the-internet.herokuapp.com/hovers");
    }

    @Test
    public void hoversMakeAChainOfActions45() {
        //hover over profile3, check name, click on link,check 404
        Actions action = new Actions(driver);
        WebElement user3 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/img"));
        action.moveToElement(user3).moveToElement(user3).build().perform();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/div/h5")).getText().equalsIgnoreCase(
                "name: user3"));
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/div/a")).click();
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/h1")).getText().equalsIgnoreCase("Not Found"));

    }
    @AfterTest
        public void postTest () {
            driver.quit();
        }
    }

