package lecture4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class GoogleSearch
{
    private WebDriver driver;
    private WebElement searchBar;
    @BeforeTest
    public void setUp()
    {
        driver = new ChromeDriver();
        driver.get("https://www.google.by/");

    }

    @Test
    public void searchTest1()
    {
        String searchTxt = "-DskipTests=true";

        searchBar = driver.findElement(By.id("W0wltc"));
        searchBar.click();
        searchBar = driver.findElement(By.cssSelector("[type='search']"));
        searchBar.sendKeys(searchTxt, Keys.ENTER);
        Assert.assertEquals(driver.findElement(By.cssSelector("[class='card-section'] em")).getText(), searchTxt);
    }
    @Test
    public void searchTest2()
    {

        searchBar = driver.findElement(By.cssSelector("[type='search']"));
        searchBar.clear();
        searchBar.sendKeys("Hello, world",Keys.ENTER);

    }
    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }
}
