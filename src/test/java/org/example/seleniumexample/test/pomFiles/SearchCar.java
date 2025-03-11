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

public class SearchCar {

    WebDriver driver= new ChromeDriver();
    WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));


    @BeforeClass
    public void setUp(){
        driver.get("http://localhost:3000/cars");
        driver.manage().window().maximize();

    }

    @Test(priority = 1)
    public void getTitle(){
        String title= driver.getTitle();
        System.out.println(title+"Title of the Application");
    }


    @Test(priority = 2)
    public void FilterCars(){

        WebElement searchCar= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search...']")));
        searchCar.sendKeys("Toyota Camry");

        WebElement relatedCar= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Details']")));
        relatedCar.click();

    }




}
