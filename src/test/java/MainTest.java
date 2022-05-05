import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class MainTest {

    @Test
    public void testFirstSelenium() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:/QA/4_stream/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.mall.sk/");
        driver.manage().window().maximize();
        WebElement buttonFind = driver.findElement(By.id("site-search-input"));
        buttonFind.click();
        buttonFind.sendKeys("ipad");
        driver.findElement(By.id("search-button")).click();
        WebElement res = driver.findElement(By.xpath("//h1[@class='search__page-title']"));
        WebElement res2 = driver.findElement(By.xpath("//div[@data-sel='productCountNumber']"));

        res.getAttribute("Ipad");

        Assert.assertEquals(res.getText(), "\n" +
                "         821 produktov\n" +
                "      ");

        driver.quit();
    }

    @Test
    public void testEbayFindProduct(){
        System.setProperty("webdriver.chrome.driver","C:/QA/4_stream/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();
        WebElement searchRow = driver.findElement(By.xpath("//input[@class = 'gh-tb ui-autocomplete-input']"));
        searchRow.click();
        searchRow.sendKeys("Ipad");
        WebElement buttonSearch = driver.findElement(By.id("gh-btn"));
        buttonSearch.click();
        WebElement actualResult = driver.findElement(By.xpath("//h1[@class = 'srp-controls__count-heading']/span[@class = 'BOLD'][2]"));

        Assert.assertEquals(actualResult.getText(), "ipad");

        driver.close();
    }
}
