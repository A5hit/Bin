package org.Adobe.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// page_url = about:blank
public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    public LoginPage(WebDriver driver) {
        this.driver=driver;
        this.wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath ="//input[@type='email']")
    WebElement emailInputField ;

    @FindBy(xpath="//span[@class='spectrum-Button-label']")
    WebElement continueButton ;

    @FindBy(xpath="//input[@name='passwd']")
    WebElement passwordInputFiled ;

    @FindBy(xpath="//input[@type='submit']")
    WebElement rememberMeButton;

    public WebElement emailInput(){
        return emailInputField ;
    }

    public void clickContinue (){
        continueButton.click();
    }

    public WebElement passwordField(){
        return passwordInputFiled;
    }

    public WebElement getRememberMeButton(){
        return rememberMeButton;
    }




}