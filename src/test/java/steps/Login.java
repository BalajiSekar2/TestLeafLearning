package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login extends BaseClass{
	
//	@Given("A Chrome Browser is launched")
//	public void launchChromeBrowser() {
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//	}
//	
//	@And("Load the leaftaps URL {string}")
//	public void load_the_leaftaps_url(String url) {
//	    driver.get(url);
//	}
//	
//	@And("Maximize the broswer")
//	public void maximize_the_broswer() {
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//	}
	
	@Given("Enter the UserName {string}")
	public void enterUserName(String userName) {
		driver.findElement(By.id("username")).sendKeys(userName);
	}
	
	@And("Enter the Password {string}")
	public void enterPassword(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
	}
	
	@When("Click on Login Button")
	public void clickLogin() {
		driver.findElement(By.className("decorativeSubmit")).click();
	}
	
	@Then("Home screen should be displayed successfully")
	public void verifyHomeScreen() {
		System.out.println("Login is Successful");
	}
	
	@But("Error message should be displayed")
	public void loginErrorMessageValidation() {
		System.out.println("Login is not Successful");
	}

	@Given("Click on CRM\\/SFA link")
	public void clickCRMSFALink() {
		WebElement btnCRMSFA = driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]"));
		btnCRMSFA.click();
	}

}	
	
	
	
	    

