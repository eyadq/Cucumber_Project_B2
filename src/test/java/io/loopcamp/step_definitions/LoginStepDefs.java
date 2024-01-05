package io.loopcamp.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefs {

    @Given("user is on Docuport login page")
    public void user_is_on_docuport_login_page() {
        System.out.println("This is given step");
    }

    @When("user enters username for client")
    public void user_enters_username_for_client() {
        System.out.println("This is when step");
    }

    @When("user enters password for client")
    public void user_enters_password_for_client() {
        System.out.println("This is when/and step");
    }

    @When("user clicks login button")
    public void user_clicks_login_button() {
        System.out.println("This is when/add step");
    }

    @Then("user should see the home page for client")
    public void user_should_see_the_home_page_for_client() {
        System.out.println("This is then step");
    }

    @When("user enters username for employee")
    public void user_enters_username_for_employee() {
        System.out.println("employee when/and");
    }

    @When("user enters password for employee")
    public void user_enters_password_for_employee() {
        System.out.println("employee when/and");
    }

    @Then("user should see the home page for employee")
    public void user_should_see_the_home_page_for_employee() {
        System.out.println("employee then");
    }
}
