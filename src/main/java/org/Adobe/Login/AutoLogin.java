package org.Adobe.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AutoLogin {
    WebDriver driver;
    LoginPage loginpage;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/ashit/Desktop/chromedriver"); // add you webdriver's directory
//        ChromeOptions options=new ChromeOptions();
//        options.addArguments("headless");
        driver = new ChromeDriver();
        loginpage = new LoginPage(driver);

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void Login() throws InterruptedException {
        loginpage.emailInput().sendKeys("Send Email Here");
        loginpage.clickContinue();
        loginpage.passwordField().sendKeys("Send Password here");
        loginpage.getRememberMeButton().click();

        //This Element is inside single shadow DOM.
        // clicks Continue button
        String cssSelectorForHost1 = "x-welcome-modal[size='l']";
        Thread.sleep(1000);
        SearchContext shadow = driver.findElement(By.cssSelector("x-welcome-modal[size='l']")).getShadowRoot();
        Thread.sleep(1000);
        shadow.findElement(By.cssSelector("sp-button[role='button']")).click();

        //Click Let's Go button
        //This Element is inside single shadow DOM.
        Thread.sleep(3000);
        shadow.findElement(By.cssSelector("sp-button[role='button'][size='l'][data-test-id='x-dialog-primary-cta']"));
    }

}
