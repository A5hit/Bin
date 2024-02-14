import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Assignment3 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/a5hit/Desktop/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // Implicit Wait of 5 Seconds(Global)

           // -------------------  Login Page -------------------------------

        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("rahulshettyacademy"); // Username
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("learning"); // Password

        driver.findElement(By.xpath("//label[@class='customradio'][2]")).click(); // User Selection
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@id='okayBtn']")).click(); // Accept Popup

        WebElement staticDropdown = driver.findElement(By.xpath("//select[@class='form-control']")); // Dropdown Selection
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByVisibleText("Student");

        driver.findElement(By.xpath("//input[@id='terms']")).click(); // CheckBox
        driver.findElement(By.xpath("//input[@id='signInBtn']")).click(); // Submit


       // -------------- Product Page ----------------------------

        List <WebElement> products = driver.findElements(By.xpath("//app-card[@class='col-lg-3 col-md-6 mb-3']")); // Grouping Products Cards

        for (int i=0;i< products.size();i++){  // Add to Cart the grouped Products
            driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();
        }

        driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click(); // Open Checkout Page

        driver.close(); // close Driver



    }
}
