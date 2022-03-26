package week6.practice;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


	@CucumberOptions(features="src/test/java/features/CreateLead.feature",
			glue="steps", monochrome=true)
	public class RunTest extends AbstractTestNGCucumberTests{
		
	
	}
