package org.example.seleniumexample.test.pomFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddReview {


    WebDriver driver= new ChromeDriver();
    WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(50));


    @BeforeClass
    public void setUp(){
        driver.get("http://localhost:3000/contact");
        driver.manage().window().maximize();

    }

    @Test(priority = 1)
    public void getTitle(){
        String title= driver.getTitle();
        System.out.println(title+"Title of the Application");
    }

    @Test(priority = 2)
    public void loginFunction(){


        WebElement SelectNavLogin= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Login']")));
        SelectNavLogin.click();


        WebElement inputName= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
        inputName.sendKeys("samanperera200@gmail.com");

        WebElement inputPassword=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
        inputPassword.sendKeys("samanperera200");


        WebElement loginButton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Login']")));
        loginButton.click();

        WebElement SelectNavProfile= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Profile']")));
        SelectNavProfile.click();

    }
    @Test(priority = 3)
    public void AddReviewFunction(){

        WebElement SelectNavProfile= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Profile']")));
        SelectNavProfile.click();


        WebElement typereview= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='review']")));
        typereview.sendKeys("Nice application");

        WebElement SelectRate= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'container mt-5 mb-5')]//span[2]")));
        SelectRate.click();

        WebElement submitReview= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Submit Review']")));
        submitReview.click();
    }

}
