package org.example.homework2.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class BuyProducts {

    private final WebDriver driver;
    private final By firstProduct = By.xpath("//*[@name='add-to-cart-sauce-labs-backpack']");
    private final By secondProduct = By.xpath("//*[@id='add-to-cart-sauce-labs-bike-light']");
    private final By cartButton = By.xpath("//*[@class='shopping_cart_link']");

    private final By checkoutButton = By.id("checkout");

    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By postalCode = By.id("postal-code");
    private final By continueButton = By.id("continue");

    private final By totalPrice = By.xpath("//*[@class='summary_info_label summary_total_label']");
    private final By finishButton = By.id("finish");

    private final By completeHeader = By.xpath("//h2[@class='complete-header']");


    public BuyProducts(WebDriver driver) {
        this.driver = driver;
    }

    public void addFirstProductToCart() {

        driver.findElement(firstProduct).click();
    }

    public void addSecondProductToCart() {
        driver.findElement(secondProduct).click();
    }

    public void clickOnCartButton() {
        driver.findElement(cartButton).click();
    }

    public void clickOnCheckoutButton() {
        driver.findElement(checkoutButton).click();
    }

    public void setFirstName(String firstNameString) {
        WebElement webElement = driver.findElement(firstName);
        webElement.clear();
        webElement.sendKeys(firstNameString);
    }

    public void setLastName(String lastNameString) {
        WebElement webElement = driver.findElement(lastName);
        webElement.clear();
        webElement.sendKeys(lastNameString);
    }

    public void setPostalCode(String postalCodeString) {
        WebElement webElement = driver.findElement(postalCode);
        webElement.clear();
        webElement.sendKeys(postalCodeString);
    }

    public void clickOnContinueButton() {
        driver.findElement(continueButton).click();
    }

    public String getTotalPrice() {
        return driver.findElement(totalPrice).getText();
    }

    public void clickOnFinishButton() {
        driver.findElement(finishButton).click();
    }

    public String getCompleteHeader() {
        return driver.findElement(completeHeader).getText();
    }
}
