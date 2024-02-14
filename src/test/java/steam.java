import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class steam{
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","/Users/a5hit/Desktop/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        //click on the Column
        driver.findElement(By.xpath("//th[@aria-sort='descending']")).click();

        //Grab all the WebElements into a list
        List<WebElement> elementsList = driver.findElements(By.xpath("//tbody/tr/td[1]"));

        //Capture text from all WebElements into List(Original list).
        List<String> originalList = elementsList.stream().map(s->s.getText()).collect(Collectors.toList());

        //Sort The original List (Sorted List).
        List<String> sortedList =  originalList.stream().sorted().collect(Collectors.toList());

        //Compare both List.
        Assert.assertTrue(originalList.equals(sortedList));

        //Scan the name of a particular field("Rice") and print its adjacent field value("37")
       List<String> price = elementsList.stream().filter(s->s.getText().contains("Rice")).map(s->getVeggiePrice(s)).collect(Collectors.toList());
       price.forEach(a->System.out.println(a));


        driver.close();

    }

    private static String getVeggiePrice(WebElement s) {
       String priceValue =  s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return priceValue;
    }
}