package org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class  njAlerts {
    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver" ,"/Users/a5hit/Desktop/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        String text = "Ashit";

        driver.findElement(By.id("name")).sendKeys(text);
        driver.findElement(By.id("alertbtn")).click();

        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

    }
}
