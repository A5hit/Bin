import jdk.jshell.SourceCodeAnalysis;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Dropdown {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/a5hit/Desktop/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

//      ----------- Check Box ---------------
        System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
        driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
        System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());




//        //dropdown with Select Tag (Static dropdowns)
//        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
//
//        Select dropdown = new Select(staticDropdown);
//        dropdown.selectByIndex(3); // Select by Index
//        System.out.println(dropdown.getFirstSelectedOption().getText());
//
//        dropdown.selectByVisibleText("AED");
//        System.out.println(dropdown.getFirstSelectedOption().getText());
//
//        dropdown.selectByValue("INR");
//        System.out.println(dropdown.getFirstSelectedOption().getText());

//        driver.findElement(By.id("divpaxinfo")).click();
//        Thread.sleep(2000L);
//
//        int i = 1;
//        while(i<5){
//            driver.findElement(By.id("hrefIncAdt")).click();
//            i++;
//        }
//
//        driver.findElement(By.id("btnclosepaxoption")).click();


//           --------  Static Dropdown with multiple Index ------
//        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
//        driver.findElement(By.xpath("//a[@value='BHO']")).click();
//        driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
//        driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='JAI']")).click();


//        -------- Auto-Suggestion Dropdown Lists ------------
          driver.findElement(By.id("autosuggest")).sendKeys("ind");
          Thread.sleep(3000);
          List<WebElement> options= driver.findElements(By.cssSelector("li[class=ui-menu-item] a"));

          for(WebElement option : options){
              if(option.getText().equalsIgnoreCase("India")){
                  option.click();
                  break;
              }
          }


    }
}
