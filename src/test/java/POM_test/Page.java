package POM_test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {

    WebDriver driver;
    WebDriverWait wait;

    public Page(WebDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Registration

    By firstname = By.id("input-firstname");
    By lastname = By.id("input-lastname");
    By email = By.id("input-email");
    By telephone = By.id("input-telephone");
    By password = By.id("input-password");
    By confirmPassword = By.id("input-confirm");
    By privacyPolicy = By.name("agree");
    By continueBtn = By.xpath("//input[@value='Continue']");

    // Login

    By loginEmail = By.id("input-email");
    By loginPassword = By.id("input-password");
    By loginBtn = By.xpath("//input[@value='Login']");

    // Search

    By searchBox = By.name("search");
    By searchBtn = By.xpath("//button[@class='btn btn-default btn-lg']");

    // Cart

    By addToCartBtn = By.id("button-cart");
    By shoppingCart = By.linkText("shopping cart");
    By checkoutBtn = By.linkText("Checkout");
    By removeBtn = By.xpath("//button[@data-original-title='Remove']");

    // Account

    By registerBtn = By.linkText("Register");

    public void MyAccount() {

        WebElement myAccount = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[@title='My Account']")));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", myAccount);

        System.out.println("My Account Clicked");
    }

    public void Register() {

        wait.until(
                ExpectedConditions.elementToBeClickable(registerBtn))
                .click();
    }

    public void Firstname(String fname) {

        driver.findElement(firstname).sendKeys(fname);
    }

    public void Lastname(String lname) {

        driver.findElement(lastname).sendKeys(lname);
    }

    public void Email(String mail) {

        driver.findElement(email).sendKeys(mail);
    }

    public void Telephone(String phone) {

        driver.findElement(telephone).sendKeys(phone);
    }

    public void Password(String pass) {

        driver.findElement(password).sendKeys(pass);
    }

    public void ConfirmPassword(String cpass) {

        driver.findElement(confirmPassword).sendKeys(cpass);
    }

    public void PrivacyPolicy() {

        driver.findElement(privacyPolicy).click();
    }
    public void PrintRegistrationErrors() {

        try {

            System.out.println("===== Registration Errors =====");

            for(WebElement e :
                    driver.findElements(By.cssSelector(".text-danger"))) {

                System.out.println(e.getText());
            }

            System.out.println("===============================");
        }
        catch(Exception ex) {

            System.out.println("No Validation Error Found");
        }
    }

    public void Continue() {

        driver.findElement(continueBtn).click();

        try {

            Thread.sleep(3000);

        } catch (InterruptedException e) {

            e.printStackTrace();
        }

        System.out.println("Title : " + driver.getTitle());

        System.out.println("URL : " + driver.getCurrentUrl());

        if(driver.getCurrentUrl().contains("success")) {

            System.out.println("Registration Successful");
        }
        else {

            System.out.println("Registration Failed");

            PrintRegistrationErrors();
        }
    }

    public void LoginPage() {

        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
    }

    public void LoginEmail(String mail) {

        driver.findElement(loginEmail).sendKeys(mail);
    }

    public void LoginPassword(String pass) {

        driver.findElement(loginPassword).sendKeys(pass);
    }

    public void Login() {

        driver.findElement(loginBtn).click();
    }

    // IMPORTANT: method name changed to match Step Definition

    public void SearchProduct(String product) {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement search =
                wait.until(
                        ExpectedConditions.presenceOfElementLocated(
                                By.name("search")));

        search.clear();

        search.sendKeys(product);
    }

    public void SearchButton() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement button =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                By.xpath("//button[@class='btn btn-default btn-lg']")));

        button.click();
    }

    public void SearchedProduct(String productname) {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.linkText(productname)))
                .click();
    }

    public void AddToCart() {

        wait.until(
                ExpectedConditions.elementToBeClickable(addToCartBtn))
                .click();
    }

    public void ShoppingCart() {

        wait.until(
                ExpectedConditions.elementToBeClickable(shoppingCart))
                .click();
    }

    public void Checkout() {

        wait.until(
                ExpectedConditions.elementToBeClickable(checkoutBtn))
                .click();
    }

    public void RemoveButton() {

        wait.until(
                ExpectedConditions.elementToBeClickable(removeBtn))
                .click();
    }

    public void Logout() {

        try {

            WebElement logout = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.linkText("Logout")));

            logout.click();

            System.out.println("Logout Successful");
        }
        catch (Exception e) {

            System.out.println(
                    "Logout Link Not Found. Registration/Login may have failed.");
        }
    }
}