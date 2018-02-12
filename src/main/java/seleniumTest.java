import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class seleniumTest {
    WebDriver WebDriver;
    SearchResultsPage webSite;

    @Before
    public void setUp(){
        WebDriver = new ChromeDriver();
        WebDriver.get("http://www.google.com");

    }
    @Test
    public void searchWords() {
        webSite = new SearchResultsPage(WebDriver);
        System.out.println("1. Поиск слова \"Selenium\"  в поле поиск");
        WebDriver.findElement(By.id("lst-ib")).sendKeys("Selenium");
        WebDriver.findElement(By.id("lst-ib")).sendKeys(Keys.TAB);
        WebDriver.findElement(By.name("btnK")).click();
        webSite.waitForSearchResult();
        Assert.assertTrue("В заголовках данное слово не найдено",
                webSite.searchWordInTitle("WebDriver"));
        System.out.println("Тест выполнен");
    }
    @After
    public void tearDown(){
        if(WebDriver != null) {
            WebDriver.quit();
        }
    }
}
