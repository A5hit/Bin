import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AssignmentIII {
    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver","/Users/a5hit/Desktop/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement table = driver.findElement(By.id("product"));

        int rows = table.findElements(By.tagName("tr")).size();
        System.out.println(rows);  // print no. of rows

        int columns = table.findElements(By.xpath("//tr[1]//td")).size();
        System.out.println(columns);  // Print no. of Columns

        List<WebElement> secondRow = table.findElements(By.xpath("//tr[3]//td"));
        System.out.println(secondRow.get(0).getText());
        System.out.println(secondRow.get(1).getText());
        System.out.println(secondRow.get(2).getText());

        driver.close();












    }
}
