package stepDefenitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utility.BrowserUtility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GulfUpdateNaukriProfile {
	
	WebDriver driver;
	

	@Given("I have logged in setup and logged in to gulfNaukri website")
	public void i_have_logged_in_setup_and_logged_in_to_gulf_naukri_website() {
		driver = BrowserUtility.supplyDriver("chrome");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));

		// Opening Browser
		driver.get("https://www.naukrigulf.com/");

		// click on login Button
		driver.findElement(By.xpath("//a[contains(@href,'.naukrigulf.com/jobseeker/login')]")).click();

	}

	@Given("have my gulfprofile section open with {string} login and {string}")
	public void have_my_gulfprofile_section_open_with_login_and(String username, String password) {
		
		// Type into on username Button
		WebElement jobSeekerLogin = driver.findElement(By.xpath("//input[@id='loginModalLoginEmail']"));
		jobSeekerLogin.clear();
		jobSeekerLogin.click();
		jobSeekerLogin.sendKeys(username);
		
		// Type into on Password Button
		WebElement jobSeekerPassword = driver.findElement(By.xpath("//input[@id='loginPassword']"));
		jobSeekerPassword.clear();
		jobSeekerPassword.click();
		jobSeekerPassword.sendKeys(password);
	}

	@When("I check for gulfprofile section and validate whether updated")
	public void i_check_for_gulfprofile_section_and_validate_whether_updated() {

		System.out.println("hi");
	}

	@Then("I update gulfbio with new data")
	public void i_update_gulfbio_with_new_data() {
		System.out.println("hi");

	}

	@Then("check whether my gulfprofile is updated as of today")
	public void check_whether_my_gulfprofile_is_updated_as_of_today() {
		System.out.println("hi");

	}

}
