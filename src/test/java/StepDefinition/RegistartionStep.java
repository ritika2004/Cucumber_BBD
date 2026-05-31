package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistartionStep {

    WebDriver driver;

    @Given("registration page should be open")
    public void registration_page_should_be_open() {

        driver = new ChromeDriver();

        driver.get("https://demoqa.com/automation-practice-form");

        driver.manage().window().maximize();
    }

    @When("enter first name")
    public void enter_first_name() {

        driver.findElement(By.xpath("//*[@id=\"firstName\"]"))
              .sendKeys("Ritika");
    }

    @And("enter last name")
    public void enter_last_name() {

        driver.findElement(By.id("lastName"))
              .sendKeys("Agrawal");
    }

    @And("enter email")
    public void enter_email() {

        driver.findElement(By.id("userEmail"))
              .sendKeys("ritikaagrawal123@gmail.com");
    }

    @And("select gender")
    public void select_gender() {

        driver.findElement(By.xpath("//label[text()='Male']"))
              .click();
    }

    @And("enter mobile number")
    public void enter_mobile_number() {

        driver.findElement(By.id("userNumber"))
              .sendKeys("1234567891");
    }

    @Then("registration form should be filled successfully")
    public void registration_form_should_be_filled_successfully() {

        System.out.println("Registration Form Filled Successfully");
    }
}