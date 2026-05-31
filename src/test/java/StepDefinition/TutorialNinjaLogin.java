package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class TutorialNinjaLogin {
	WebDriver driver;
	@Given("user opens website")
	public void user_opens_website() {
		driver = new ChromeDriver();
        driver.manage().window().maximize();
        
	    
	}

	@When("user navigates to login page")
	public void user_navigates_to_login_page() {
		 driver.navigate().to("https://tutorialsninja.com/demo/index.php?route=account/login");
		
	    
	}

	@When("user enters email and password")
	public void user_enters_email_and_password() {
		driver.findElement(By.id("input-email"))
        .sendKeys("test@gmail.com");
		driver.findElement(By.id("input-password"))
        .sendKeys("test123");
	}

	@When("clicks on login button")
	public void clicks_on_login_button() {
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}

	@Then("users should login successfully")
	public void user_should_login_successfully() {
		System.out.println("Login Successful");

        driver.quit();
	}


 
}
