package org.example.seleniumexample.test.pomFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Register {


    WebDriver driver= new ChromeDriver();
    WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));


    @BeforeClass
    public void setUp(){
        driver.get("http://localhost:3000/home");
        driver.manage().window().maximize();

    }

    @Test(priority = 1)
    public void getTitle(){
        String title= driver.getTitle();
        System.out.println(title+"Title of the Application");
    }


    @Test(priority = 2)
    public void RegisterFunction(){


        WebElement SelectNavRegister= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Register']")));
        SelectNavRegister.click();


        WebElement inputUserName= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
        inputUserName.sendKeys("samanperera200");

        WebElement inputEmail=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='email']")));
        inputEmail.sendKeys("samanperera200@gmail.com");


        WebElement inputPassword=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")));
        inputPassword.sendKeys("samanperera200");


        WebElement inputPhoneNumber=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Phone']")));
        inputPhoneNumber.sendKeys("0770531993");

        WebElement  ClickRegisterBtn= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Register']")));
        ClickRegisterBtn.click();



    }


}
