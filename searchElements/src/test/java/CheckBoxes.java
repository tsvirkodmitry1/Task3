import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckBoxes {
    WebDriver driver;

    @BeforeTest

    public void preCondition() {
        System.setProperty("webdriver.chrome.driver", "src\\chromedriver.exe.exe");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/checkboxes");

    }

    @Test
    public void checkBoxes() //throws InterruptedException
    {
        //different actions on different elements window
        WebElement checkbox1 = driver.findElement(By.cssSelector("[type=checkbox]"));
        Assert.assertTrue(driver.findElement(By.cssSelector("[type=checkbox]")).isEnabled());

    }

    @Test
    public void checkBoxes1Selected() //throws InterruptedException
    {
        WebElement checkbox1 = driver.findElement(By.cssSelector("[type=checkbox]"));
        checkbox1.click();
        Assert.assertTrue(driver.findElement(By.cssSelector("[type=checkbox]")).isSelected());
    }

    @Test
    public void checkBox2IsSelected() {
        WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]")).isSelected());
    }

    @Test
    public void checkBox2IsUnchecked() {
        WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]")).isSelected());
        checkbox2.click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]")).isEnabled());
    }

    @AfterTest
    public void postTest() {

        driver.quit();
    }
}

