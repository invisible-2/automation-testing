package org.example.homework3.pagefactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuyProducts {

    private final WebDriver driver;

    @FindBy(xpath = "//*[@name='add-to-cart-sauce-labs-backpack']")
    private WebElement firstProduct;

    @FindBy(xpath = "//*[@id='add-to-cart-sauce-labs-bike-light']")
    private WebElement secondProduct;


    @FindBy(xpath = "//*[@class='shopping_cart_link']")
    private WebElement cartButton;

    @FindBy(xpath = "//*[@id='checkout']")
    private WebElement checkoutButton;

    @FindBy(xpath = "//*[@id='first-name']")
    private WebElement firstName;

    @FindBy(xpath = "//*[@id='last-name']")
    private WebElement lastName;

    @FindBy(xpath = "//*[@id='postal-code']")
    private WebElement postalCode;

    @FindBy(xpath = "//*[@id='continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//*[@class='summary_info_label summary_total_label']")
    private WebElement totalPrice;

    @FindBy(xpath = "//*[@id='finish']")
    private WebElement finishButton;

    @FindBy(xpath = "//h2[@class='complete-header']")
    private WebElement completeHeader;


    public BuyProducts(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addFirstProductToCart() {
        firstProduct.click();
    }

    public void addSecondProductToCart() {
        secondProduct.click();
    }

    public void clickOnCartButton() {
        cartButton.click();
    }

    public void clickOnCheckoutButton() {
        checkoutButton.click();
    }

    public void setFirstName(String firstNameString) {
        firstName.clear();
        firstName.sendKeys(firstNameString);
    }

    public void setLastName(String lastNameString) {
        lastName.clear();
        lastName.sendKeys(lastNameString);
    }

    public void setPostalCode(String postalCodeString) {
        postalCode.clear();
        postalCode.sendKeys(postalCodeString);
    }

    public void clickOnContinueButton() {
        continueButton.click();
    }

    public String getTotalPrice() {
        return totalPrice.getText();
    }

    public void clickOnFinishButton() {
        finishButton.click();
    }

    public String getCompleteHeader() {
        return completeHeader.getText();
    }
}
