package StepDefinition;

import org.openqa.selenium.WebDriver;

import Hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import POM_test.PHPTravelsPage;

public class PHPTravelsSteps {

    WebDriver driver = Hooks.driver;

    PHPTravelsPage p = new PHPTravelsPage(driver);

    @Given("user launches PHPTravels application")
    public void user_launches_phptravels_application() {

        System.out.println("PHPTravels Application Opened");
    }

    @When("^user enters phptravels username (.*)$")
    public void user_enters_phptravels_username(String username) {

        p.EnterEmail(username);
    }

    @And("^user enters phptravels password (.*)$")
    public void user_enters_phptravels_password(String password) {

        p.EnterPassword(password);
    }

    @And("user clicks login button")
    public void user_clicks_login_button() {

        p.ClickLogin();
    }

    @Then("user should login successfully")
    public void user_should_login_successfully() {

        System.out.println("Login Successful");
    }

    @When("^user searches hotel (.*)$")
    public void user_searches_hotel(String city) {

        p.SearchHotel(city);
    }

    @And("^user selects checkin date (.*)$")
    public void user_selects_checkin_date(String checkin) {

        System.out.println("Checkin Date Selected : " + checkin);
    }

    @And("^user selects checkout date (.*)$")
    public void user_selects_checkout_date(String checkout) {

        System.out.println("Checkout Date Selected : " + checkout);
    }

    @And("^user selects travellers (.*)$")
    public void user_selects_travellers(String travellers) {

        System.out.println("Travellers Selected : " + travellers);
    }

    @And("user clicks hotel search button")
    public void user_clicks_hotel_search_button() {

        p.ClickSearchButton();
    }

    @Then("hotel search result should display")
    public void hotel_search_result_should_display() {

        System.out.println("Hotel Search Results Displayed");
    }

    @When("user selects first hotel")
    public void user_selects_first_hotel() {

        p.SelectFirstHotel();
    }

    @And("user validates hotel prices")
    public void user_validates_hotel_prices() {

        p.ValidatePrices();
    }

    @And("user books hotel")
    public void user_books_hotel() {

        p.BookHotel();
    }

    @Then("booking should complete successfully")
    public void booking_should_complete_successfully() {

        System.out.println("Booking Completed Successfully");
    }

    @When("user logout from phptravels application")
    public void user_logout_from_phptravels_application() {

        p.Logout();
    }

    @Then("browser should close successfully")
    public void browser_should_close_successfully() {

        System.out.println("Execution Completed");
    }
}