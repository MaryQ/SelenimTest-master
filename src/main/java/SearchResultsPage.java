import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchResultsPage {
    WebDriver WebDriver;
    WebDriverWait wait;

    public SearchResultsPage(WebDriver driver){
        WebDriver = driver;
        wait = new WebDriverWait(WebDriver, 30, 300);
    }
    public void waitForSearchResult(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("srg")));
    }

    public boolean searchWordInTitle(String siteTitle){
        System.out.println("Выполняется поиск слова \"" + siteTitle + "\" в заголовках");
        List<WebElement> links = WebDriver.findElements(By.xpath(".//*[@class='srg']//h3"));
        for(WebElement link: links){
            if(link.getText().contains(siteTitle)){
                return true;
            }
        }
        return false;
    }
}
