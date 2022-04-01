package week6.practice;

import io.cucumber.testng.CucumberOptions;
import steps.BaseClass;

	@CucumberOptions(features="src/test/java/features",
			glue={"steps"}, 
			monochrome = true, 
			publish = true,
			tags="@smoke and @sanity"
			)
	
	public class RunTest extends BaseClass{
		
		
	}
