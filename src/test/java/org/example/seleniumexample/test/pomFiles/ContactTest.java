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

public class ContactTest {



    WebDriver driver= new ChromeDriver();
    WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));


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
    public void ContactFormFunction(){

        WebElement inputYourName= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Your Name']")));
        inputYourName.sendKeys("Testing Name");

        WebElement inputEmail= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='email']")));
        inputEmail.sendKeys("samanperera200@gmail.com");

        WebElement inputMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@placeholder='Message']")));
        inputMessage.sendKeys("samanperera200");


        WebElement contactButton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Send Message']")));
        Actions actions = new Actions(driver);
        actions.moveToElement(contactButton).perform(); // Move to the element
        wait.until(ExpectedConditions.elementToBeClickable(contactButton));


        contactButton.click();

    }


}
