package org.Adobe.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class GoogleLogin {
    WebDriver driver;
    WebDriverWait wait;

    public GoogleLogin(WebDriver driver) {
        this.driver=driver;
        this.wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@type='email']")
    WebElement gEmailField;

    @FindBy(xpath ="//span[normalize-space()='Next']")
    WebElement gContinueButton;

    @FindBy(xpath = "//input[@type='password']")
    WebElement gPasswordField;

    public WebElement getGEmailField() {
        return gEmailField;
    }

    public WebElement getGContinueButton() {
        return gContinueButton;
    }

    public WebElement getGPasswordField() {
        return gPasswordField;
    }



}