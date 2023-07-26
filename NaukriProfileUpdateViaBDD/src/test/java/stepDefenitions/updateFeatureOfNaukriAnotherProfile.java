package stepDefenitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utility.BrowserUtility;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class updateFeatureOfNaukriAnotherProfile{
	
	WebDriver driver;

	@Before
	public void openBrowser() {
	driver = BrowserUtility.supplyDriver("chrome");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
	}
	
	@After
    public void closeBrowser() {

        driver.quit();
    }

	@Given("I have all logged in setup and logged in to Naukri website")
	public void i_have_all_logged_in_setup_and_logged_in_to_naukri_website() throws InterruptedException {
	
		

		// Opening Browser
		driver.get("https://www.naukri.com/");

		// Login Button
		driver.findElement(By.xpath("//a[@href='https://login.naukri.com/nLogin/Login.php']")).click();

		// Username
		driver.findElement(By.xpath("//input[@placeholder='Enter your active Email ID / Username']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Enter your active Email ID / Username']"))
				.sendKeys("bhandarisayan@gmail.com");

		// Password
		driver.findElement(By.xpath("//input[@type='password' and @placeholder='Enter your password']")).clear();
		driver.findElement(By.xpath("//input[@type='password' and @placeholder='Enter your password']"))
				.sendKeys("Opps@sam*95");
		// System.out.println(driver.getTitle());

		// Login Button
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
	}


	@Given("have my profile section open with 2nd login")
	public void have_my_profile_section_open_with_2nd_login() {
		// Redirecting to profile page page
		driver.get("https://www.naukri.com/mnjuser/profile?id=&altresid");

		driver.findElement(
				By.xpath("//div[@class='widgetHead']/span[contains(text(),'Resume headline')]/following-sibling::span"))
				.click();
	}

	@When("I check for about section and validate whether updated")
	public void i_check_for_about_section_and_validate_whether_updated() {
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

	@Then("I add dots if not available or remove if already available")
	public void i_add_dots_if_not_available_or_remove_if_already_available() throws InterruptedException {
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

	@Then("check whether my profile is updated")
	public void check_whether_my_profile_is_updated() {
		System.out.println("''''''''''''''''''''''''No more action Pending ''''''''''''''''''"
				+ "Quiting the System Automation" + "Thanks and goodbye");

	}
}
