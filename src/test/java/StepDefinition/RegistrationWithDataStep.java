package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class RegistrationWithDataStep {
	 WebDriver driver;
    
	 @Given("user opens the registration page")
    public void user_opens_registration_page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
    }

    @When("user enters firstname {string}")
    public void user_enters_firstname(String firstname) throws InterruptedException {
        driver.findElement(By.id("input-firstname")).sendKeys(firstname);
        Thread.sleep(3000);
    }

    @And("user enters lastname {string}")
    public void user_enters_lastname(String lastname)throws InterruptedException  {
        driver.findElement(By.id("input-lastname")).sendKeys(lastname);
        Thread.sleep(3000);
    }

    @And("user enters email {string}")
    public void user_enters_email(String email) throws InterruptedException {
        driver.findElement(By.id("input-email")).sendKeys(email);
        Thread.sleep(3000);
    }

    @And("user enters telephone {string}")
    public void user_enters_telephone(String telephone)throws InterruptedException  {
        driver.findElement(By.id("input-telephone")).sendKeys(telephone);
        Thread.sleep(3000);
    }

    @And("user enters password {string}")
    public void user_enters_password(String password) throws InterruptedException {
        driver.findElement(By.id("input-password")).sendKeys(password);
    }

    @And("user confirms password {string}")
    public void user_confirms_password(String confirmPassword)throws InterruptedException  {
        driver.findElement(By.id("input-confirm")).sendKeys(confirmPassword);
        Thread.sleep(3000);
    }

    @And("user clicks on register button")
    public void user_clicks_on_register_button() throws InterruptedException {
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        Thread.sleep(3000);
    }

    @Then("registration should be successful")
    public void registration_should_be_successful() {
        System.out.println("Registration Successful");
        driver.quit();
    }
}
