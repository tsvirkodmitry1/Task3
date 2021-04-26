import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class Dropdown {
    WebDriver driver;

    @BeforeTest

    public void preCondition() {
        System.setProperty("webdriver.chrome.driver", "src\\chromedriver.exe.exe");
        driver = new ChromeDriver();
        driver.get(" http://the-internet.herokuapp.com/dropdown");
    }

    @Test
    public void allElementsDropdown() {
        WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"dropdown\"]"));
        dropdown.click();
        WebElement elementsOfDropdown = driver.findElement(By.id("dropdown"));
        Select selectAllElementsOfDropdown = new Select(elementsOfDropdown);
        List<WebElement> allElements = selectAllElementsOfDropdown.getOptions();
        for (int i = 0; i < allElements.size(); i++) {
            String tempOption = allElements.get(i).getText();
            if (allElements.equals("Please select an option" + "\"Option 1\"" + "\"Option 2\"")) ;
            {
                System.out.println(allElements);

            }
            if (i == 0) {
                Assert.assertEquals(tempOption, "Please select an option");
            } else {
                Assert.assertEquals(tempOption, "Option " + i);
            }
        }
    }


    @Test
    public void actionDropdownChooseCheck() {
        //different actions with dropdown
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        driver.findElement(By.id("dropdown")).click();
        dropdown.selectByVisibleText("Option 1");
        Assert.assertTrue(driver.findElement(By.cssSelector("#dropdown > option:nth-child(2)")).isSelected());
    }

    @Test
    public void actionDropdown2ChooseCheck() {
        //different actions with dropdown
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        driver.findElement(By.id("dropdown")).click();
        dropdown.selectByVisibleText("Option 2");
        Assert.assertTrue(driver.findElement(By.cssSelector("#dropdown > option:nth-child(3)")).isSelected());
    }

    @AfterTest
    public void postTest() {
        //driver.quit();
    }
}