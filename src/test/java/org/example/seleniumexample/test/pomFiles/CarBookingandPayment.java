package org.example.seleniumexample.test.pomFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class CarBookingandPayment {

    WebDriver driver= new ChromeDriver();
    WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(50));


    @BeforeClass
    public void setUp(){
        driver.get("http://localhost:3000/cars");
        driver.manage().window().maximize();

    }

    @Test(priority = 1)
    public void getTitleAndNavigateCarPage(){
        String title= driver.getTitle();
        System.out.println(title+"Title of the Application");

        WebElement SelectNavLogin= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Login']")));
        SelectNavLogin.click();


        WebElement inputName= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
        inputName.sendKeys("samanperera200@gmail.com");

        WebElement inputPassword=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
        inputPassword.sendKeys("samanperera200");


        WebElement loginButton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Login']")));
        loginButton.click();


        WebElement relatedCar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/cars/Toyota Camry']")));

        // Use Actions class to move to the element and click it
        Actions actions = new Actions(driver);
        actions.moveToElement(relatedCar).perform(); // Move to the element

        // Wait a bit to ensure it's fully loaded/visible
        wait.until(ExpectedConditions.elementToBeClickable(relatedCar));

        // Now click the element
        relatedCar.click();

    }

    @Test(priority = 2)
    public void FillBookingForm(){

        WebElement StartDate= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='startDate']")));
        StartDate.sendKeys("03/13/2025");

        WebElement EndDate= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='endDate']")));
        EndDate.sendKeys("03/14/2025");


        WebElement fromPlace= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='fromPlace']//option[@value='Galle'][normalize-space()='Galle']")));
        fromPlace.click();


        WebElement toPlace= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='toPlace']//option[@value='Trincomalee'][normalize-space()='Trincomalee']")));
        toPlace.click();

        WebElement totalAmountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='totalAmount']")));
        String totalAmount = totalAmountElement.getAttribute("value"); // Use getText() if it's not an input field
        System.out.println("Total Amount: " + totalAmount);

        WebElement Submit= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Submit Booking']")));


        Actions actions = new Actions(driver);
        actions.moveToElement(Submit).perform(); // Move to the element
        wait.until(ExpectedConditions.elementToBeClickable(Submit));
        Submit.click();


    }

    @Test(priority = 3)
    public void PaymentForm() {
        // Wait for payment amount field and get its value
        WebElement paymentAmountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //input[@id='paymentAmount']")));
        String paymentAmount = paymentAmountElement.getAttribute("value");

        // Wait for total amount field and get its value
        WebElement totalAmountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='totalAmount']")));
        String totalAmount = totalAmountElement.getAttribute("value");

        // Verify that payment amount and total amount are the same
        Assert.assertEquals(paymentAmount, totalAmount, "Payment amount does not match total amount!");

        // Check if currency is set to LKR
        WebElement currencyElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='currency']")));
        Select currencyDropdown = new Select(currencyElement);
        String selectedCurrency = currencyDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(selectedCurrency, "LKR", "Currency is not set to LKR!");

        // Verify transaction ID field is displayed
        WebElement transactionIdElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='transactionId']")));
        Assert.assertTrue(transactionIdElement.isDisplayed(), "Transaction ID is not displayed!");

        // Click the "Make Payment" button
        WebElement makePaymentButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Make Payment']")));
        Actions actions = new Actions(driver);
        actions.moveToElement(makePaymentButton).perform(); // Move to the element
        wait.until(ExpectedConditions.elementToBeClickable(makePaymentButton));
        makePaymentButton.click();

        System.out.println("Payment process completed successfully.");
    }




}
