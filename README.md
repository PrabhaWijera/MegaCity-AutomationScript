# Selenium Automation Test Cases for Web Application

This project includes Selenium automation tests for a web application. The tests cover various functionalities such as **Login**, **Registration**, **Search Car**, **Add Review**, **Car Booking and Payment**, and **Contact Form**. Below is a comprehensive list of all the test cases and their execution results.

---

## Test Cases Summary

| **TestCase ID** | **TestScenario Title**              | **Description**                                                       | **Test Steps**                                                                                                                                                                                                        | **Expected Results**                                                                      | **Actual Results**                | **Status [Pass or Fail]** | **Screenshots** | **Execute Results [Pass or Fail]** |
|-----------------|--------------------------------------|-----------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------|------------------------------------|---------------------------|-----------------|------------------------------------|
| TC_001          | Verify Application Title (Login)    | Verify if the application title is displayed correctly.               | 1. Open the application at **http://localhost:3000/home**. <br> 2. Get the title of the page using `getTitle()`.                                                                                                     | The title of the page should be correct.                                                   | Title printed as expected.        | Pass                      | N/A             | Pass                               |
| TC_002          | Login with Valid Credentials         | Verify login functionality using valid credentials.                   | 1. Click on **Login** link. <br> 2. Enter **Email**: `samanperera200@gmail.com` and **Password**: `samanperera200`. <br> 3. Click **Login** button.                                                               | User should be logged in successfully.                                                     | User logged in successfully.      | Pass                      | N/A             | Pass                               |
| TC_003          | Register with Valid Data             | Verify registration functionality with valid details.                 | 1. Navigate to **Register** link. <br> 2. Enter **Username**: `samanperera200`, **Email**: `samanperera200@gmail.com`, **Password**: `samanperera200`, **Phone**: `0770531993`. <br> 3. Click **Register** button.    | Registration is successful and user is registered.                                        | Registration successful.           | Pass                      | N/A             | Pass                               |
| TC_004          | Search for a Car (Filter)            | Verify car search and filtering functionality.                         | 1. Enter **Car Name**: `Toyota Camry` in the search box.                                                                                                                                                           | The system should filter and display cars matching the search term.                      | Search filter works as expected.   | Pass                      | N/A             | Pass                               |
| TC_005          | Select and View Car Details          | Verify if the user can click on a car and view its details.            | 1. After search, click on **Toyota Camry** from the search results.                                                                                                                                                 | User is redirected to the selected car's detail page.                                     | Redirection successful.            | Pass                      | N/A             | Pass                               |
| TC_006          | Add Review for Car                   | Verify the functionality of adding a review for a car.                 | 1. Log in using valid credentials. <br> 2. Go to **Profile**. <br> 3. Enter **Review**: `Nice application`. <br> 4. Select rating and click **Submit Review** button.                                                 | Review is successfully submitted with rating.                                              | Review submitted successfully.     | Pass                      | N/A             | Pass                               |
| TC_007          | Car Booking Form (Start and End Date)| Verify the car booking form with date and location selection.          | 1. Enter **Start Date**: `03/13/2025`, **End Date**: `03/14/2025`, **From Place**: `Galle`, **To Place**: `Trincomalee`. <br> 2. Submit the booking form.                                                             | Booking is successfully submitted and total amount is displayed.                           | Booking submitted successfully.     | Pass                      | N/A             | Pass                               |
| TC_008          | Payment Verification and Completion  | Verify payment functionality, including amount and currency.           | 1. Ensure **Payment Amount** matches **Total Amount**. <br> 2. Verify **Currency** is LKR. <br> 3. Check **Transaction ID** is displayed. <br> 4. Click **Make Payment** button.                                      | Payment is completed successfully with valid amount and currency.                          | Payment completed successfully.    | Pass                      | N/A             | Pass                               |
| TC_009          | Verify Application Title (Contact)   | Verify if the application title is displayed correctly on the contact page. | 1. Open **http://localhost:3000/contact**. <br> 2. Get the title of the page using `getTitle()`.                                                                                                                   | The title of the page should be correct.                                                   | Title printed as expected.        | Pass                      | N/A             | Pass                               |
| TC_010          | Contact Form Submission              | Verify the functionality of submitting a contact form.                 | 1. Enter **Your Name**: `Testing Name`, **Email**: `samanperera200@gmail.com`, **Message**: `samanperera200`. <br> 2. Click **Send Message**.                                                                    | Contact form should be successfully submitted.                                            | Contact form submitted successfully. | Pass                      | N/A             | Pass                               |
| TC_011          | Verify Application Title (Car Page)  | Verify if the application title is displayed correctly on the car page. | 1. Open **http://localhost:3000/cars**. <br> 2. Get the title of the page using `getTitle()`.                                                                                                                     | The title of the page should be correct.                                                   | Title printed as expected.        | Pass                      | N/A             | Pass                               |
| TC_012          | View Car Details After Search        | Verify if the user can see car details after performing a search.      | 1. Search for **Car**: `Toyota Camry`. <br> 2. Click on the car name from the search results.                                                                                                                       | User is redirected to the car's details page.                                              | Redirection successful.            | Pass                      | N/A             | Pass                               |
| TC_013          | Filter Cars Based on Price Range     | Verify if the user can filter cars based on a price range.             | 1. Open **Car Filter**. <br> 2. Set **Price Range**: `$20,000 - $40,000`. <br> 3. Apply filter.                                                                                                                     | Cars should be filtered based on the specified price range.                               | Filter works as expected.          | Pass                      | N/A             | Pass                               |
| TC_014          | Reset Car Filter                     | Verify if the car filter can be reset successfully.                    | 1. Set car filter to **Price Range**: `$20,000 - $40,000`. <br> 2. Click **Reset Filter**.                                                                                                                        | The filter should be reset and all cars should be displayed.                              | Filter reset works as expected.     | Pass                      | N/A             | Pass                               |
| TC_015          | Verify Booking Form Submission       | Verify that the car booking form is submitted successfully.            | 1. Fill out booking details: **Start Date**: `03/13/2025`, **End Date**: `03/14/2025`, **From Place**: `Galle`, **To Place**: `Trincomalee`. <br> 2. Click **Submit Booking**.                                          | The booking form is successfully submitted and a confirmation message appears.            | Form submitted successfully.       | Pass                      | N/A             | Pass                               |
| TC_016          | Verify Payment Form Submission       | Verify that the payment form is submitted successfully.                | 1. Verify **Payment Amount** matches **Total Amount**. <br> 2. Ensure **Currency** is set to LKR. <br> 3. Enter **Transaction ID** and click **Make Payment**.                                                        | Payment should be processed successfully and a confirmation message appears.              | Payment processed successfully.    | Pass                      | N/A             | Pass                               |
| TC_017          | Verify Contact Form Submission       | Verify contact form functionality with valid input.                    | 1. Enter the following test data: <br> **Your Name**: `Testing Name` <br> **Email**: `samanperera200@gmail.com` <br> **Message**: `samanperera200` <br> 2. Click on the **Send Message** button.               | The contact form should be submitted successfully with no errors.                         | Contact form submitted successfully. | Pass                      | N/A             | Pass                               |

---

## Setup Instructions

1. **Prerequisites**:
    - Ensure that **Java**, **Maven**, and **Selenium WebDriver** are installed.
    - Set up **ChromeDriver** for the Chrome browser.
    - Ensure that the application is running at **http://localhost:3000**.

2. **Run Tests**:
    - You can run the tests using **TestNG** by executing the `TestNG` suite in your IDE or via command line.

---

## Notes
- **Test Steps** include specific **Test Data** used for each action.
- **Expected Results** reflect what should happen after performing the steps.
- **Actual Results** are based on the outcome after executing the test cases.
- **Execute Results** indicate the final result of the test execution (Pass/Fail).

---

Feel free to modify or expand the instructions as per your requirements. This file can now serve as a comprehensive reference for understanding the tests and their execution process!

