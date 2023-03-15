package org.example.homework3.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.homework3.pagefactory.DemLogin;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestLogin {

    private static final String BASE_URL = "https://www.saucedemo.com/";
    private static WebDriver driver;
    private final String USER_NAME = "standard_user";
    private final String PASSWORD = "secret_sauce";

    @BeforeClass
    public static void beforeClass() {
       // driver = WebDriverManager.chromedriver().create();

        System.setProperty("webdriver.chrome.driver", "D:\\WebDrivers\\ChromeDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void loginTest() throws InterruptedException {
        System.out.println("Start loginTest");
        driver.get(BASE_URL);
        DemLogin login = new DemLogin(driver);

        login.setUserName(USER_NAME);
        login.setPassword(PASSWORD);

        Thread.sleep(1000);

        login.clickLoginButton();

        System.out.println("Finish loginTest");

    }

    @AfterClass
    public static void afterClass() {
        driver.quit();
    }
}
