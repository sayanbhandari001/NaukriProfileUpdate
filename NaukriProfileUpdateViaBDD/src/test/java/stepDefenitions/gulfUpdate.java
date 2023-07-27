package stepDefenitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class gulfUpdate {

	WebDriver driver;
	
	@Given("I have all logged in setup and logged in to GulfNaukri website")
	public void i_have_all_logged_in_setup_and_logged_in_to_gulf_naukri_website() {
	}

	@Given("have my profile section open with GulfNaukri login")
	public void have_my_profile_section_open_with_gulf_naukri_login() {
	}

	@When("I check for Profile Page")
	public void i_check_for_profile_page() {
	}

	@Then("I update data as per my requirement")
	public void i_update_data_as_per_my_requirement() {
	}

	@Then("validate whether my profile is updated")
	public void validate_whether_my_profile_is_updated() {

		driver.quit();
	}
}
