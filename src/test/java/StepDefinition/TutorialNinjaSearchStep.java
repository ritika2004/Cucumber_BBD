package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class TutorialNinjaSearchStep {
	WebDriver driver;
	@Given("user opens browser and launches website")
	public void user_opens_browser_and_launches_website() {
		driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://tutorialsninja.com/demo/");
	}

	@When("user enters product name in search field")
	public void user_enters_product_name_in_search_field() {
		driver.findElement(By.name("search"))
        .sendKeys("iPhone");
	}

	@When("user clicks on search button")
	public void user_clicks_on_search_button() {
		driver.findElement(
                By.xpath("//button[@class='btn btn-default btn-lg']"))
                .click();
	}

	@Then("searched product should be displayed")
	public void searched_product_should_be_displayed() {
		boolean status = driver.findElement(
                By.linkText("iPhone"))
                .isDisplayed();

        if(status) {

            System.out.println("Product Found");
        }
        else {

            System.out.println("Product Not Found");
        }

        driver.quit();
	}



}
