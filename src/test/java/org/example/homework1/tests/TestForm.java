package org.example.homework1.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TestForm {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.firefox.marionette", "D:\\WebDrivers\\FirefoxDriver\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        driver.navigate().to("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();

        Thread.sleep(2000);

        driver.findElement(By.id("firstName")).sendKeys("Daniel");
        driver.findElement(By.id("lastName")).sendKeys("Musteata");
        driver.findElement(By.id("userEmail")).sendKeys("daniel@gmail.com");

        Thread.sleep(5);
        WebElement radioBtn = driver.findElement(By.xpath("//input[@id='gender-radio-1']"));
        new Actions(driver).moveToElement(radioBtn).click().build().perform();

        driver.findElement(By.id("userNumber")).sendKeys("1234567890");
        WebElement date = driver.findElement(By.id("dateOfBirthInput"));

        Thread.sleep(10);
        new Actions(driver).moveToElement(date).click().build().perform();
        Select month = new Select(driver.findElement(By.className("react-datepicker__month-select")));
        month.selectByValue("3"); // 3 -> April

        Thread.sleep(10);
        Select year = new Select(driver.findElement(By.className("react-datepicker__year-select")));
        year.selectByValue("2003");


        // Select date (28)
        Thread.sleep(10);
        new Actions(driver).moveToElement(driver.findElement(By.className("react-datepicker__day--028")))
                .click()
                .perform();


        Thread.sleep(10);
        WebElement subjects = driver.findElement(By.className("subjects-auto-complete__value-container"));
        new Actions(driver).moveToElement(subjects)
                .click()
                .sendKeys("computer science")
                .pause(5)
                .sendKeys(Keys.ENTER)
                .pause(5)
                .sendKeys("eng")
                .pause(5)
                .sendKeys(Keys.ENTER)
                .build()
                .perform();



        Thread.sleep(5);
        WebElement checkBtnSport = driver.findElement(By.xpath("//input[@id='hobbies-checkbox-1']"));
        new Actions(driver).moveToElement(checkBtnSport).click().build().perform();

        Thread.sleep(5);
        WebElement checkBtnMusic = driver.findElement(By.xpath("//input[@id='hobbies-checkbox-3']"));
        new Actions(driver).moveToElement(checkBtnMusic).click().build().perform();


        WebElement picture = driver.findElement(By.xpath("//input[@id='uploadPicture']"));
        picture.sendKeys("C:\\Users\\Daniel\\Desktop\\logo.png");


        driver.findElement(By.id("currentAddress"))
                .sendKeys("Str. Stefan cel Mare 10/2");


        WebElement state = driver.findElement(By.xpath("//input[@id='react-select-3-input']"));
        state.sendKeys("n");
        state.sendKeys(Keys.ENTER);


        WebElement city = driver.findElement(By.xpath("//input[@id='react-select-4-input']"));
        city.sendKeys("del");
        city.sendKeys(Keys.ENTER);


        //Submit Button
        driver.findElement(By.xpath("//button[@id='submit']")).submit();

         driver.quit();
    }

}
