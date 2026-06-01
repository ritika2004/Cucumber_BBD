package POM_test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class Page {

    WebDriver driver;

    public Page(WebDriver driver) {

        this.driver = driver;
    }

  
    By firstname = By.id("input-firstname");

    By lastname = By.id("input-lastname");

    By email = By.id("input-email");

    By telephone = By.id("input-telephone");

    By password = By.id("input-password");

    By confirmPassword = By.id("input-confirm");

    By privacyPolicy = By.name("agree");

    By continueBtn = By.xpath("//input[@value='Continue']");

    
    By loginEmail = By.id("input-email");

    By loginPassword = By.id("input-password");

    By loginBtn = By.xpath("//input[@value='Login']");

    
    By searchBox = By.name("search");

    By searchBtn = By.xpath("//button[@class='btn btn-default btn-lg']");

   
    By addToCartBtn = By.id("button-cart");

    By shoppingCart = By.linkText("shopping cart");

    By checkoutBtn = By.linkText("Checkout");

    By removeBtn = By.xpath("//button[@data-original-title='Remove']");

    
    By myAccount = By.xpath("//span[contains(text(),'My Account')]");

    By registerBtn = By.linkText("Register");

    By logoutBtn = By.xpath("//a[text()='Logout']");

    

    public void MyAccount() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement myAccount = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[text()='My Account']")
                ));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);",
                myAccount);

        wait.until(ExpectedConditions.elementToBeClickable(myAccount));

        myAccount.click();

        System.out.println("My Account Clicked");
    }

    public void Register() {

        driver.findElement(registerBtn).click();
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

    public void Continue() {

        driver.findElement(continueBtn).click();
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

    

    public void searchProduct(String product) {

        driver.findElement(searchBox).sendKeys(product);
    }

    public void SearchButton() {

        driver.findElement(searchBtn).click();
    }

    public void SearchedProduct(String productname) {

        driver.findElement(By.linkText(productname)).click();
    }

  

    public void AddToCart() {

        driver.findElement(addToCartBtn).click();
    }

    public void ShoppingCart() {

        driver.findElement(shoppingCart).click();
    }

    public void Checkout() {

        driver.findElement(checkoutBtn).click();
    }

    public void RemoveButton() {

        driver.findElement(removeBtn).click();
    }

    

    public void Logout() {

    	driver.findElement(By.linkText("Logout")).click();
    }
}