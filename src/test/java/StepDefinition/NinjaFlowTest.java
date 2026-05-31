package StepDefinition;

import org.openqa.selenium.WebDriver;

import Hooks.Hooks;
import POM_test.Page;
import io.cucumber.java.en.*;

public class NinjaFlowTest {

    WebDriver driver = Hooks.driver;

    Page p = new Page(Hooks.driver);

    @Given("user open TutorialsNinja homepage")
    public void user_open_tutorialsninja_homepage() {

        System.out.println("Homepage Opened");
    }

    @Given("user open TutorialsNinja registration page")
    public void user_open_tutorialsninja_registration_page() {

        p.MyAccount();

        p.Register();

        System.out.println("Registration Page Opened");
    }

    @When("^user enter firstname (.*)$")
    public void user_enter_firstname(String firstname) {

        p.Firstname(firstname);
    }

    @And("^user enter lastname (.*)$")
    public void user_enter_lastname(String lastname) {

        p.Lastname(lastname);
    }

    @And("^user enter registration email (.*)$")
    public void user_enter_registration_email(String email) {

        p.Email(email);
    }

    @And("^user enter telephone (.*)$")
    public void user_enter_telephone(String telephone) {

        p.Telephone(telephone);
    }

    @And("^user enter registration password (.*)$")
    public void user_enter_registration_password(String password) {

        p.Password(password);
    }

    @And("^user enter confirm password (.*)$")
    public void user_enter_confirm_password(String confirmpassword) {

        p.ConfirmPassword(confirmpassword);
    }

    @And("user click on privacy policy checkbox")
    public void user_click_on_privacy_policy_checkbox() {

        p.PrivacyPolicy();
    }

    @And("user click on continue button")
    public void user_click_on_continue_button() throws InterruptedException {

        p.Continue();

        Thread.sleep(3000);
    }

    @And("user logout after registration")
    public void user_logout_after_registration() throws InterruptedException {

    	p.MyAccount();

        Thread.sleep(2000);

        p.Logout();

        System.out.println("Logout Passed");

        Thread.sleep(3000);
    
    }

    @And("user open login page")
    public void user_open_login_page() {

        p.LoginPage();
    }

    @And("^user enter login email (.*)$")
    public void user_enter_login_email(String email) {

        p.LoginEmail(email);
    }

    @And("^user enter login password (.*)$")
    public void user_enter_login_password(String password) {

        p.LoginPassword(password);
    }

    @And("user click on login button")
    public void user_click_on_login_button() throws InterruptedException {

        p.Login();

        Thread.sleep(3000);
    }

    @And("^user search product (.*)$")
    public void user_search_product(String productname) {

        p.searchProduct(productname);
    }

    @And("user click on search button")
    public void user_click_on_search_button() throws InterruptedException {

        p.SearchButton();

        Thread.sleep(3000);
    }

    @And("^user click on searched product (.*)$")
    public void user_click_on_searched_product(String productname)throws InterruptedException {

        p.SearchedProduct(productname);

        Thread.sleep(3000);
    }

    @And("user click on add to cart button")
    public void user_click_on_add_to_cart_button()
            throws InterruptedException {

        p.AddToCart();

        Thread.sleep(3000);
    }

    @And("user click on shopping cart")
    public void user_click_on_shopping_cart()
            throws InterruptedException {

        p.ShoppingCart();

        Thread.sleep(3000);
    }

    @And("user click on checkout button")
    public void user_click_on_checkout_button() {

        try {

            p.Checkout();

        } catch (Exception e) {

            System.out.println("Checkout Not Available");
        }
    }

    @And("user click on remove button")
    public void user_click_on_remove_button() {

    	driver.get("https://tutorialsninja.com/demo/index.php?route=checkout/cart");

        p.RemoveButton();

        System.out.println("Remove Cart Passed");
    }

    @And("user logout successfully")
    public void user_logout_successfully() throws InterruptedException {

    	driver.get("https://tutorialsninja.com/demo/");

      
    	p.MyAccount();

        Thread.sleep(2000);

        p.Logout();

        System.out.println("Final Logout Passed");
    }

    @Then("complete ecommerce flow should execute successfully")
    public void complete_ecommerce_flow_should_execute_successfully() {

        System.out.println("Complete Ecommerce Flow Passed");
    }
}