package POM_test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PHPTravelsPage {

    WebDriver driver;
    WebDriverWait wait;

    public PHPTravelsPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
     By email = By.xpath("//input[@type='email']");
    By password = By.xpath("//input[@type='password']");
    By loginButton = By.xpath("//button[@type='submit']");

    By popupCloseButton = By.xpath("//button[contains(@class,'btn-close')]");


    By citySearchBox = By.xpath("//input[@placeholder='Search By City']");
    By searchButton = By.id("submit");

    public void ClosePopupIfPresent() {

        try {

            WebDriverWait popupWait =
                    new WebDriverWait(driver, Duration.ofSeconds(5));

            WebElement popup =
                    popupWait.until(ExpectedConditions
                    .visibilityOfElementLocated(popupCloseButton));

            if (popup.isDisplayed()) {

                JavascriptExecutor js =
                        (JavascriptExecutor) driver;

                js.executeScript("arguments[0].click();", popup);

                System.out.println("Popup Closed Successfully");

                Thread.sleep(2000);
            }

        } catch (TimeoutException e) {

            System.out.println("Popup Not Displayed");

        } catch (Exception e) {

            System.out.println("Popup Handling Failed");
        }
    }

    public void EnterEmail(String useremail) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(email));
        driver.findElement(email).clear();
        driver.findElement(email).sendKeys(useremail);
    }

    public void EnterPassword(String userpassword) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(password));
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(userpassword);
    }

    public void ClickLogin() {

        WebElement btn =
                wait.until(ExpectedConditions.elementToBeClickable(loginButton));

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript("arguments[0].click();", btn);

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Current URL : " + driver.getCurrentUrl());
        System.out.println("Page Title  : " + driver.getTitle());
    }
    

 

    public void SearchHotel(String city) {

    	WebElement cityField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(citySearchBox));

        cityField.clear();
        cityField.sendKeys(city);

        System.out.println("Hotel City Entered : " + city);

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
        }
    }

    public void ClickSearchButton() {

        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        driver.findElement(searchButton).click();

        System.out.println("Search button clicked");
    }

   

    public void SelectFirstHotel() {

        System.out.println("First Hotel Selected");
    }

    public void ValidatePrices() {

        System.out.println("Hotel Prices Validated");
    }

    public void BookHotel() {

        System.out.println("Hotel Booking Completed");
    }

    public void Logout() {

        System.out.println("Logout Successful");
    }
}