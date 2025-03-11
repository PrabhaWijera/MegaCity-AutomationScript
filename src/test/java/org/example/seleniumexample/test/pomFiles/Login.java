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

public class Login {


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
    public void LoginFunction(){

        WebElement SelectNavLogin= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Login']")));
        SelectNavLogin.click();


        WebElement inputName= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
        inputName.sendKeys("samanperera200@gmail.com");

        WebElement inputPassword=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
        inputPassword.sendKeys("samanperera200");


        WebElement loginButton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Login']")));
        loginButton.click();

//        WebElement dash=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='dash']")));
//
//        if(dash.isDisplayed()){
//            System.out.println("Login Successful");
//        }else{
//            System.out.println("Login Failed");
//        }

    }

}
