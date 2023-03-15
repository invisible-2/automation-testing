package org.example.homework3.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.homework3.pagefactory.BuyProducts;
import org.example.homework3.pagefactory.DemLogin;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBuyingProducts {

    private static final String BASE_URL = "https://www.saucedemo.com/";
    private static WebDriver driver;

    private final String USER_NAME = "standard_user";
    private final String PASSWORD = "secret_sauce";

    @BeforeClass
    public static void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "D:\\WebDrivers\\ChromeDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void buyingTest() throws InterruptedException {

        System.out.println("Start buyingTest");
        driver.get(BASE_URL);

        DemLogin login = new DemLogin(driver);
        login.setUserName(USER_NAME);
        login.setPassword(PASSWORD);

        Thread.sleep(500);
        login.clickLoginButton();

        BuyProducts buyProducts = new BuyProducts(driver);

        Thread.sleep(2000);
        buyProducts.addFirstProductToCart();
        buyProducts.addSecondProductToCart();

        Thread.sleep(500);
        buyProducts.clickOnCartButton();

        Thread.sleep(1000);
        buyProducts.clickOnCheckoutButton();

        Thread.sleep(1000);
        buyProducts.setFirstName("Daniel");
        buyProducts.setLastName("Musteata");
        buyProducts.setPostalCode("2250");

        Thread.sleep(500);
        buyProducts.clickOnContinueButton();

        Thread.sleep(1000);
        String totalPrice = buyProducts.getTotalPrice();
        System.out.println(totalPrice);

        buyProducts.clickOnFinishButton();

        Thread.sleep(1000);
        String completeHeader = buyProducts.getCompleteHeader();
        System.out.println(completeHeader);

        Assert.assertEquals("Thank you for your order!", completeHeader);
        System.out.println("Finish buyingTest");
    }

    @AfterClass
    public static void afterClass() {
        driver.quit();
    }
}
