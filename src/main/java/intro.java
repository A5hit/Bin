import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import org.testng.Assert;

public class intro {


    public static void main(String[]args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/a5hit/Desktop/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String name = "Ashit";
        String password = getPassword(driver);
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys(name);
        driver.findElement(By.name("inputPassword")).sendKeys(password);
        driver.findElement(By.className("signInBtn")).click();
        Thread.sleep(2000);
//        driver.findElement(By.cssSelector("p.error")).getText();

        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+name+",");
//        driver.findElement(By.xpath("//button[@class='logout-btn']")).click();

        // Sibling - Child to parent traverse
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());

    }


    //Extracting pwd(Password) from String.
    public static String getPassword(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();
        String pwdText  = driver.findElement(By.xpath("//p[@class='infoMsg']")).getText();
        String[] pwdTextArray = pwdText.split("'");
        return pwdTextArray[1].split("'")[0];


    }

}

