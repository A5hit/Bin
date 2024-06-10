import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Utilities {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/ashit/Desktop/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.dailyobjects.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        WebElement banner =  driver.findElement(By.xpath("//video[@oncanplay='this.play()']"));

        // get Height and Width
        int height = banner.getSize().getHeight();
        int width = banner.getSize().getWidth();

        // Calculate Aspect ratio
         double actualAspectRatio = (double)height/width;

        //define expected ratio
        double expectedAspectRatio = 1372 / 553.875 ;

        // define tolerance
        double tolerance = 0.01;






    }
}
