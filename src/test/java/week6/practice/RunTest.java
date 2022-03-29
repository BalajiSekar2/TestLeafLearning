package week6.practice;

import io.cucumber.testng.CucumberOptions;
import steps.BaseClass;


	@CucumberOptions(features="src/test/java/features",
			glue={"steps"}, 
			monochrome = true, 
			publish = true
			//tags="@Smoke"
			)
	
	public class RunTest extends BaseClass{
		
		
	}
