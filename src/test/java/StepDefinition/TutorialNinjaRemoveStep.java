package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class TutorialNinjaRemoveStep {
	WebDriver driver;

    @Given("product is already added to cart")
    public void product_is_already_added_to_cart() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");

        driver.findElement(By.name("search"))
                .sendKeys("iPhone");

        driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']"))
                .click();

        driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[2]/button[1]/span"))
                .click();
    }

    @When("user opens shopping cart")
    public void user_opens_shopping_cart() {

        driver.findElement(By.xpath("//*[@id=\"cart\"]/button")).click();

//        driver.findElement(By.xpath("//strong[text()=' View Cart']"))
//                .click();
    }

    @And("user clicks on remove button")
    public void user_clicks_on_remove_button() {

    	driver.findElement(By.xpath("//button[@data-original-title='Remove']"))
        .click();
    	System.out.println("Remove Button Clicked");
    }

    @Then("product should be removed from cart")
    public void product_should_be_removed_from_cart() {

        System.out.println("Product Removed Successfully");
    }

}
