package stepDefenitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utility.BrowserUtility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GulfLoginNaukriUpdate {

	WebDriver driver;

	@Given("^I have logged in setup and logged in to gulfNaukri website$")
	public void i_have_logged_in_setup_and_logged_in_to_gulf_naukri_website() {
		driver = BrowserUtility.supplyDriver("chrome");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));

		// Opening Browser
		driver.get("https://www.gulftalent.com/candidates/login");

	}

	@Given("have my gulfprofile section open with {string} login and {string}")
	public void have_my_gulfprofile_section_open_with_login_and(String string, String string2) {
		driver.findElement(By.xpath("//input[@ng-model='form.username' and @name='email']")).clear();
		driver.findElement(By.xpath("//input[@ng-model='form.username' and @name='email']")).sendKeys(string);
		System.out.println("Username used here is " + string);

		// Password
		driver.findElement(By.xpath("//input[@ng-model='form.password' and @name='password']")).clear();
		driver.findElement(By.xpath("//input[@ng-model='form.password' and @name='password']")).sendKeys(string2);

		WebDriverWait loginButtonwait = new WebDriverWait(driver, Duration.ofSeconds(30));
		loginButtonwait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@type='submit' and contains(text(),'Login')]")));
		driver.findElement(By.xpath("//button[@type='submit' and contains(text(),'Login')]")).click();
		String ActualURL = driver.getCurrentUrl();
		String ExpectedURL = "https://www.gulftalent.com/candidates/home";
		Assert.assertEquals(ActualURL, ExpectedURL);
		if (ActualURL.equals(ExpectedURL)) {
			System.out.println("--------------System logged in successfully, Automating further--------------");
		} else {
			System.out.println("Opps!!! ----   Sorry Couldn't login   --- Failure");
		}

		// Redirecting to profile page page
		driver.get("https://www.gulftalent.com/candidates/edit-cv");

		driver.findElement(
				By.xpath("//span[contains(text(),'Senior QA Analyst')]//parent::dt//parent::dl//preceding-sibling::ul//li//a[@ng-click='edit($index)']"))
				.click();
	}

	@When("^I check for gulfprofile section and validate whether updated$")
	public void i_check_for_gulfprofile_section_and_validate_whether_updated() {
		String resumeHeadline = "Overall 6 Exp. with Manual/Selenium, WebDriver, Java, TestNG, Maven, Jenkins, SVN, API Mobile Testing, Agile, Automation Testing, Manual Testing, Framework Design, SQL, Web Services, Grid, JIRA, Cucumber, GIT. and 5 yrs in Testing Industry";
		String resumeHeadlineText = driver
				.findElement(By.xpath("//form[@name='resumeHeadlineForm']//div[@class='row']//div//textarea"))
				.getText();

		System.out.println(resumeHeadlineText);

		if (resumeHeadline.equals(resumeHeadlineText)) {

			driver.findElement(By.xpath("//form[@name='resumeHeadlineForm']//div[@class='row']//div//textarea"))
					.clear();
			driver.findElement(By.xpath("//form[@name='resumeHeadlineForm']//div[@class='row']//div//textarea"))
					.sendKeys(
							"Overall 6 Exp. with Manual/Selenium, WebDriver, Java, TestNG, Maven, Jenkins, SVN, API Mobile Testing, Agile, Automation Testing, Manual Testing, Framework Design, SQL, Web Services, Grid, JIRA, Cucumber, GIT. and 5 yrs in Testing Industry.");
		} else {
			driver.findElement(By.xpath("//form[@name='resumeHeadlineForm']//div[@class='row']//div//textarea"))
					.clear();
			driver.findElement(By.xpath("//form[@name='resumeHeadlineForm']//div[@class='row']//div//textarea"))
					.sendKeys(
							"Overall 6 Exp. with Manual/Selenium, WebDriver, Java, TestNG, Maven, Jenkins, SVN, API Mobile Testing, Agile, Automation Testing, Manual Testing, Framework Design, SQL, Web Services, Grid, JIRA, Cucumber, GIT. and 5 yrs in Testing Industry");
		}
	}

	@Then("^I update gulfbio with new data$")
	public void i_update_gulfbio_with_new_data() {
		driver.findElement(By.xpath(
				"//form[@name='resumeHeadlineForm']//div[@class='row form-actions']//div//button[@type='submit' and contains(text(),'Save')]"))
				.click();
		String updatedURL = driver.getCurrentUrl();
		String updatedURLActual = "https://www.naukri.com/mnjuser/profile?id=&altresid";
		if (updatedURL.equals(updatedURLActual)) {
			System.out.println("-----------------Save Successfull------------------------");

		} else {
			System.out.println("-----------------Save unSuccessfull------------------------");
		}
		System.out.println(updatedURL);
	}

	@Then("^check whether my gulfprofile is updated as of today$")
	public void check_whether_my_gulfprofile_is_updated_as_of_today() {
		System.out.println("''''''''''''''''''''''''No more action Pending ''''''''''''''''''"
				+ "Quiting the System Automation" + "Thanks and goodbye");
		driver.quit();
	}

}
