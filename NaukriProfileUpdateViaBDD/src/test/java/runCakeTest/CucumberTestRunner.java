package runCakeTest;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = { "html:cucumber-reports/htmlreprt.html", "json:cucumber-reports/report.json" },
		features = {"D:\\01.eclipse-jee-2022-09-R-win32-x86_64\\eclipse-workspace\\NaukriProfileUpdateViaBDD\\src\\test\\java\\features\\UpdateNaukri.feature" },
		glue = { "stepDefenitions"},
		publish = true,
		monochrome= true,
		tags = ("@naukriIndiaUpdate")
		)

public class CucumberTestRunner {
	
}
