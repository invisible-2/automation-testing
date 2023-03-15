package org.example.homework3.tests;

import org.example.homework3.pagefactory.DemLogin;
import org.example.homework3.pagefactory.DemLogout;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class TestLogout {

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
    public void logoutTest() throws InterruptedException {
        System.out.println("Start logoutTest");
        driver.get(BASE_URL);

        DemLogin login = new DemLogin(driver);
        login.setUserName(USER_NAME);
        login.setPassword(PASSWORD);

        Thread.sleep(500);
        login.clickLoginButton();


        DemLogout logout = new DemLogout(driver);

        Thread.sleep(1000);
        logout.clickMenuButton();

        Thread.sleep(500);
        logout.clickLogoutButton();

        Thread.sleep(1000);
        //Expected: Swag Labs
        String actualResult = logout.getCompleteContainer();

        Assert.assertEquals("Swag Labs", actualResult);

        System.out.println("Finish logoutTest");

    }

    @AfterClass
    public static void afterClass() {
        driver.quit();
    }
}
