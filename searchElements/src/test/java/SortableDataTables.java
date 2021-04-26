import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class SortableDataTables {
    WebDriver driver;

    @BeforeTest

    public void preCondition() {
        System.setProperty("webdriver.chrome.driver", "src\\chromedriver.exe.exe");
        driver = new ChromeDriver();
        driver.get(" http://the-internet.herokuapp.com/tables");

    }

    @Test
    public void selectData() {
        //Grab the table
        WebElement table = driver.findElement(By.xpath("//*[@id=\"table1\"]/tbody"));
        List<WebElement> allRows = table.findElements(By.xpath("//*[@id=\"table1\"]/tbody/tr[1]/td[1]"));
        for (WebElement row : allRows) {
            List<WebElement> cells = row.findElements(By.xpath("//*[@id=\"table1\"]/tbody/tr[2]/td[2]"));
            for (WebElement cell : cells) {
            }
            Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"table1\"]/tbody/tr[1]/td[1]")).getText().equalsIgnoreCase("Smith"));
            Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"table1\"]/tbody/tr[2]/td[2]")).getText().equalsIgnoreCase("Frank"));
        }
    }

    @Test
    public void selectData2() {
        //Grab the table
        WebElement table2 = driver.findElement(By.xpath("//*[@id=\"table1\"]/tbody"));
        List<WebElement> allRows2 = table2.findElements(By.xpath("//*[@id=\"table1\"]/tbody/tr[3]/td[3]"));
        for (WebElement row2 : allRows2) {
            List<WebElement> cells2 = row2.findElements(By.xpath("//*[@id=\"table1\"]/tbody/tr[4]/td[4]"));
            for (WebElement cell : cells2) {
            }
            Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"table1\"]/tbody/tr[3]/td[3]")).getText().equalsIgnoreCase("jdoe@hotmail.com"));
            Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"table1\"]/tbody/tr[4]/td[4]")).getText().equalsIgnoreCase("$50.00"));
        }
    }
    @Test
    public void selectData3() {
        //Grab the table
        WebElement table3 = driver.findElement(By.xpath("//*[@id=\"table2\"]"));
        List<WebElement> allRows3 = table3.findElements(By.xpath("//*[@id=\"table2\"]/tbody/tr[4]/td[5]"));
        for (WebElement row : allRows3) {
            List<WebElement> cells3 = row.findElements(By.xpath("//*[@id=\"table2\"]/tbody/tr[1]/td[6]/a[2]"));
            for (WebElement cell : cells3) {
                            }
            Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"table2\"]/tbody/tr[4]/td[5]")).getText().equalsIgnoreCase("http://www.timconway.com"));
            Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"table2\"]/tbody/tr[1]/td[6]/a[2]")).getText().equalsIgnoreCase("delete"));

        }
    }

    @AfterTest
    public void postTest() {
         driver.quit();}
    }



