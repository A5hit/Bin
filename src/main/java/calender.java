import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class calender {
    public static void main (String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/a5hit/Desktop/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://path2usa.com/travel-companion");

        driver.manage().window().maximize();
        WebElement datePicker = driver.findElement(By.xpath("//div[@class='elementor-form-fields-wrapper elementor-labels-above']"));

// Find the coordinates

      System.out.println(datePicker.getLocation());
      int xCoordinate = datePicker.getLocation().x;
      int yCoordinate = datePicker.getLocation().y;

// Scroll to Form
      JavascriptExecutor js = (JavascriptExecutor)driver;
      js.executeScript("window.scrollBy("+xCoordinate+","+yCoordinate+")");

      Thread.sleep(2000);

      driver.findElement(By.xpath("//input[@id='form-field-travel_comp_date']")).click();

      List<WebElement> dates = driver.findElements(By.cssSelector("span.flatpickr-day"));

      int dCount = dates.size();

        int i=0;
        while (i<dCount) {
            int date = Integer.parseInt(dates.get(i).getText());
            if(date==25){
                dates.get(i).click();
                break;
            }
            i++;
        }


        driver.close();
    }
}

