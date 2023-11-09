package stepDefenitions;

import java.time.Duration;
import java.util.Base64;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utility.BrowserUtility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IndianLoginNaukriUpdate {
	WebDriver driver;


	@Given("I have logged in setup and logged in to Naukri website")
	public void i_have_logged_in_setup_and_logged_in_to_naukri_website() {

		driver = BrowserUtility.supplyDriver("chrome");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));

		// Opening Browser
		driver.get("https://www.naukri.com/");

		// Login Button
		driver.findElement(By.xpath("//a[@href='https://login.naukri.com/nLogin/Login.php']")).click();

	}

	@Given("have my profile section open with {string} login and {string}")
	public void have_my_profile_section_open_with_login_and(String Username, String Password)
			throws InterruptedException {

		byte[] decodedBytesPassword = Base64.getDecoder().decode(Password);
		String decodedPassword = new String(decodedBytesPassword);

		// Username
		WebElement usenameLogin = driver
				.findElement(By.xpath("//input[@placeholder='Enter your active Email ID / Username']"));
		usenameLogin.clear();
		usenameLogin.sendKeys(Username);
		System.out.println("Username used here is " + Username);

		// Password
		WebElement passwordLogin = driver
				.findElement(By.xpath("//input[@type='password' and @placeholder='Enter your password']"));
		passwordLogin.clear();
		passwordLogin.sendKeys(decodedPassword);

		WebDriverWait loginButtonwait = new WebDriverWait(driver, Duration.ofSeconds(30));
		loginButtonwait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//button[@type='submit' and @class='btn-primary loginButton' and contains(text(),'Login')]")));
		driver.findElement(
				By.xpath("//button[@type='submit' and @class='btn-primary loginButton' and contains(text(),'Login')]"))
				.click();
		Thread.sleep(2000);
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Home | Mynaukri";
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		if (ActualTitle.equals(ExpectedTitle)) {
			System.out.println("--------------System logged in successfully, Automating further--------------");
		} else {
			System.out.println("Opps!!! ----   Sorry Couldn't login   --- Failure");
		}

		// Redirecting to profile page page
		driver.get("https://www.naukri.com/mnjuser/profile?id=&altresid");

		// click cv headline
		driver.findElement(
				By.xpath("//div[@class='widgetHead']/span[contains(text(),'Resume headline')]/following-sibling::span"))
				.click();
	}

	@When("I check for profile section and validate whether updated")
	public void i_check_for_profile_section_and_validate_whether_updated() {

		String resumeHeadline = "Experienced Senior Test Analyst proficient in Selenium, Java, SQL, and CICD, with skills in TestNG, Maven, GIT, Cucumber, Jenkins, and PowerBI. Expert in Agile & Waterfall SDLC, Performance Testing, and Test Automation Scripting";
		String resumeHeadlineText = driver
				.findElement(By.xpath("//form[@name='resumeHeadlineForm']//div[@class='row']//div//textarea"))
				.getText();

		System.out.println(resumeHeadlineText);

		//
		WebElement updateHeadlineText = driver
				.findElement(By.xpath("//form[@name='resumeHeadlineForm']//div[@class='row']//div//textarea"));

		if (resumeHeadline.equals(resumeHeadlineText)) {
			updateHeadlineText.click();
			updateHeadlineText.clear();
			updateHeadlineText.sendKeys(
					"Experienced Senior Test Analyst proficient in Selenium, Java, SQL, and CICD, with skills in TestNG, Maven, GIT, Cucumber, Jenkins, and PowerBI. Expert in Agile & Waterfall SDLC, Performance Testing, and Test Automation Scripting.");
		} else {
			updateHeadlineText.clear();
			updateHeadlineText.sendKeys(resumeHeadline);
		}
	}

	@Then("I update bio with new data")
	public void i_update_bio_with_new_data() throws InterruptedException {
		driver.findElement(By.xpath(
				"//form[@name='resumeHeadlineForm']//div[@class='row form-actions']//div//button[@type='submit' and contains(text(),'Save')]"))
				.click();
		Thread.sleep(2000);
		String updatedURL = driver.getCurrentUrl();
		String updatedURLActual = "https://www.naukri.com/mnjuser/profile?id=&altresid";
		if (updatedURL.equals(updatedURLActual)) {
			System.out.println("-----------------Save Successfull------------------------");

		} else {
			System.out.println("-----------------Save unSuccessfull------------------------");
		}
		System.out.println(updatedURL);

	}

	@Then("check whether my profile is updated as of today")
	public void check_whether_my_profile_is_updated_as_of_today() {
		System.out.println("''''''''''''''''''''''''No more action Pending ''''''''''''''''''\n"
				+ "\n Quiting the System Automation" + "\n Thanks and goodbye");
		driver.quit();
	}

}
