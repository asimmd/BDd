package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		
		
		features =  {".\\src\\test\\java\\features"},
		glue =  "stepdefinitions",
		dryRun=false,
		tags="@smoke",
		monochrome = true,
		plugin = {"pretty",
				"html:./target/report.html",
				"json:./target/report.json"	
		}
		
		)

public class Runner extends AbstractTestNGCucumberTests {
	

	
	
	

}
