import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowActivity {
    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver","/Users/a5hit/Desktop/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://google.com");
        driver.navigate().to("https://dailyobjects.com");
        driver.navigate().back();
        driver.navigate().forward();

    }
}
