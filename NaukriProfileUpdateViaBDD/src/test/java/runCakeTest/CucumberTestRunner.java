package runCakeTest;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = { "html:cucumber-reports/htmlreprt.html", "json:cucumber-reports/report.json" },
		features = {"src/test/java/features"},
		glue = { "stepDefenitions"},
		publish = true,
		monochrome=true,
		dryRun=false,
		tags = "@naukriIndiaUpdate"
		)
 
public class CucumberTestRunner {
	
}
//tags = "@naukriIndiaUpdate and @naukriUpdateInternational"


///update password before running in feature file