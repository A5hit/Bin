import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

    public static void main (String[] args){

        System.setProperty("webdriver.chrome.driver","/Users/a5hit/Desktop/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println(driver.findElements(By.tagName("a")).size());
        WebElement footerDriver=driver.findElement(By.id("gf-BIG"));
        System.out.println(footerDriver.findElements(By.tagName("a")).size());

        WebElement coloumnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(coloumnDriver.findElements(By.tagName("a")).size());

        for(int i=1;i<coloumnDriver.findElements(By.tagName("a")).size();i++){
            String clickonLinkTabs = Keys.chord(Keys.COMMAND,Keys.ENTER);
            coloumnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickonLinkTabs);
        }


    }
}
