import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTest {

    @Test
    public void testGoogle() {
        System.setProperty("webdriver.chrome.driver", "C:/QA/4_stream/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.ru/");
        driver.manage().window().maximize();
        driver.findElement(By.id("L2AGLb")).click();
        driver.findElement(By.name("q")).sendKeys("Selenium");
        WebElement buttonSearch = driver.findElement(By.name("btnK"));
        buttonSearch.click();

        driver.close();
    }

    @Test
    public void testMallFindProduct() {
        System.setProperty("webdriver.chrome.driver", "C:/QA/4_stream/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.mall.sk/");
        driver.manage().window().maximize();
        WebElement buttonFind = driver.findElement(By.id("site-search-input"));
        buttonFind.click();
        buttonFind.sendKeys("ipad");
        driver.findElement(By.id("search-button")).click();
        String actualResult = driver.findElement(By.tagName("h1")).getText();

        Assert.assertEquals(actualResult, "Ipad");
        driver.quit();
    }

    @Test
    public void testPetSmartCheckSearchRow() {
        System.setProperty("webdriver.chrome.driver", "C:/QA/4_stream/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.petsmart.com/");
        driver.manage().window().maximize();
        driver.findElement(By.name("q")).sendKeys("collars");
        driver.findElement(By.xpath("//input[@type = 'submit'][1]")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//span[@class = \"bold\"]")).getText(), "\"collars\"");
        driver.close();
    }

    @Test
    public void testPetSmartRedirectToMainPage() {
        System.setProperty("webdriver.chrome.driver", "C:/QA/4_stream/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.petsmart.com/");
        driver.manage().window().maximize();
        driver.findElement(By.name("q")).sendKeys("collars");
        driver.findElement(By.xpath("//input[@type = 'submit'][1]")).click();
        driver.findElement(By.xpath("//img[@alt = 'PetSmart']")).click();

        Assert.assertEquals(driver.findElement(By.className("featuredProductHeaderText")).getText(), "Deals by pet");
        driver.close();
    }

    @Test
    public void testChoosePetsButton(){
        System.setProperty("webdriver.chrome.driver", "C:/QA/4_stream/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.petsmart.com/");
        driver.manage().window().maximize();
        driver.findElement(By.className("flexGridLayout__title--textGray900")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class = 'flexGridLayout__inlineContent--contentAlignCenter']/img[@alt = 'Cat deals']")).getText(), "Top deals for cats");

    }

    @Test
    public void testEbayFindProduct() {

        System.setProperty("webdriver.chrome.driver", "C:/QA/4_stream/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.ebay.com/");
        WebElement searchRow = driver.findElement(By.xpath("//input[@class = 'gh-tb ui-autocomplete-input']"));
        searchRow.click();
        searchRow.sendKeys("Ipad");
        WebElement buttonSearch = driver.findElement(By.id("gh-btn"));
        buttonSearch.click();
        WebElement actualResult = driver.findElement(By.xpath("//h1[@class = 'srp-controls__count-heading']/span[@class = 'BOLD'][2]"));

        Assert.assertEquals(actualResult.getText(), "ipad");
    }

    @Test
    public void changeShipCountry(){

        System.setProperty("webdriver.chrome.driver", "C:/QA/4_stream/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.get("https://www.ebay.com/");

        driver.findElement(By.cssSelector("#gh-shipto-click")).click();

        driver.findElement(By.xpath("//button[@class = 'expand-btn expand-btn--default menu-button__button']")).click();
        driver.findElement(By.xpath("//span[text()='Afghanistan']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='flag-wrapper']/span[@data-country='AFG|AF']")));

        driver.findElement(By.xpath("//button[@class = 'shipto__close-btn']")).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//i[contains(@class, 'flaaf')]"))));
        WebElement flag = driver.findElement(By.xpath("//i[contains(@class, 'flaaf')]"));
        Assert.assertTrue(flag.isDisplayed());
    }
}
