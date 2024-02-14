import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class brokenLinks {
    public static void main(String[] args) throws IOException  {

        System.setProperty("webdriver.chrome.driver","/Users/a5hit/Desktop/chromedriver");
        WebDriver driver = new ChromeDriver();
        SoftAssert a = new SoftAssert();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> links = driver.findElements(By.xpath("(//li[@class='gf-li'] //a)"));

        for(WebElement link : links){
            String url = link.getAttribute("href");
            HttpURLConnection conn =  (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int resCode = conn.getResponseCode();
            a.assertTrue(resCode<400,"\"The Link with text :\"+link.getText()+\": is broken\"+resCode");
            System.out.println(resCode);
        }
        a.assertAll();
        driver.close();

    }
}
