package org.example.homework3.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemLogin {
    private final WebDriver driver;

    @FindBy(id = "user-name")
    private WebElement userName;


    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public DemLogin(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setUserName(String userNameString) {
        userName.clear();
        userName.sendKeys(userNameString);
    }

    public void setPassword(String passwordString) {
        password.clear();
        password.sendKeys(passwordString);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}
