import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class Section8 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/a5hit/Desktop/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        Thread.sleep(4000);

        String[] items = {"Cucumber","Brocolli","Beans"};

        additems(driver,items);
        
    }
    
    public static void additems(WebDriver driver,String[] items) {
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        int neededItemsQuantity = 0;


        for (int i = 0; i < products.size(); i++) {

            String[] name = products.get(i).getText().split("-");
            String formattedName = name[0].trim();
            List<String> itemsNeededList = Arrays.asList(items);

            if (itemsNeededList.contains(formattedName)) {
                neededItemsQuantity++;
                driver.findElements(By.xpath("//div[@class='product-action']//button")).get(i).click();
                if (neededItemsQuantity == items.length)
                    break;
            }
        }


    }
}
