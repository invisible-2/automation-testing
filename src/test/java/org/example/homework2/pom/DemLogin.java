package org.example.homework2.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemLogin {

    private final WebDriver driver;
    private final By userName = By.id("user-name");
    private final By password = By.id("password");
    private final By loginButton = By.id("login-button");

    public DemLogin(WebDriver driver) {
        this.driver = driver;
    }

    public void setUserName(String userNameString) {
        WebElement webElement = driver.findElement(userName);
        webElement.clear();
        webElement.sendKeys(userNameString);
    }

    public void setPassword(String passwordString) {
        WebElement webElement = driver.findElement(password);
        webElement.clear();
        webElement.sendKeys(passwordString);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

}
