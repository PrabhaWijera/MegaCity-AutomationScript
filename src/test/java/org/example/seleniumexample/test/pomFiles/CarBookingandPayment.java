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

public class CarBookingandPayment {

    WebDriver driver= new ChromeDriver();
    WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));


    @BeforeClass
    public void setUp(){
        driver.get("http://localhost:3000/cars");
        driver.manage().window().maximize();

    }

    @Test(priority = 1)
    public void getTitleAndNavigateCarPage(){
        String title= driver.getTitle();
        System.out.println(title+"Title of the Application");
        WebElement searchCar= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search...']")));
        searchCar.sendKeys("Toyota Camry");

        WebElement relatedCar= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Details']")));
        relatedCar.click();

    }

    @Test(priority = 2)
    public void FillBookingForm(){

        WebElement StartDate= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='startDate']")));
        StartDate.sendKeys("03/13/2025");

        WebElement EndDate= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='endDate']")));
        EndDate.sendKeys("03/19/2025");


        WebElement fromPlace= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='fromPlace']//option[@value='Galle'][normalize-space()='Galle']")));
        fromPlace.click();


        WebElement toPlace= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='toPlace']//option[@value='Trincomalee'][normalize-space()='Trincomalee']")));
        toPlace.click();

        WebElement totalAmountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='totalAmount']")));
        String totalAmount = totalAmountElement.getAttribute("value"); // Use getText() if it's not an input field
        System.out.println("Total Amount: " + totalAmount);

        WebElement bookSubmit= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Submit Booking']")));
        bookSubmit.click();


    }

}
