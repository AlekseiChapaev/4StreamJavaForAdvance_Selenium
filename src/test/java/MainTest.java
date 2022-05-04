import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTest {

    @Test
    public void testFirstSelenium() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:/QA/4_stream/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com");
        driver.manage().window().maximize();
        driver.findElement(By.className("QS5gu sy4vM"));
        Thread.sleep(1000);

        WebElement searchBox = driver.findElement(By.name("q"));
        WebElement searchButton = driver.findElement(By.name("btnK"));

        searchBox.sendKeys("Selenium");


        searchButton.click();

        searchBox = driver.findElement(By.name("q"));
        Assert.assertEquals(searchBox.getAttribute("value"), "Selenium");

        driver.quit();
    }
}
