package org;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Section8 {

    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver" , "/Users/a5hit/Desktop/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise");

        



    }
}
