package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinitions {
	ChromeDriver driver;
	
	@Given("A Chrome Browser is launched")
	public void launchChromeBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@And("Load the leaftaps URL {string}")
	public void load_the_leaftaps_url(String url) {
	    driver.get(url);
	}
	
	@And("Maximize the broswer")
	public void maximize_the_broswer() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
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
		driver.close();
	}
	
	@But("Error message should be displayed")
	public void loginErrorMessageValidation() {
		System.out.println("Login is not Successful");
		driver.close();
	}
	
	@Given("Click on CRM\\/SFA link")
	public void clickCRMSFALink() {
		// click CRM/SFA app
		WebElement btnCRMSFA = driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]"));
		btnCRMSFA.click();
	}
	
	@Given("Create Lead link is available")
	public void clickCreateLead() {
		
		WebElement createLeadLink = driver.findElement(By.linkText("Create Lead"));
		createLeadLink.click();

		WebElement lnkCreateLead = driver.findElement(By.xpath("//a[contains(text(),'Create Lead')]"));
		lnkCreateLead.click();
	}
	
	@Given("Enter the CompanyName as {string}")
	public void enterCompanyName(String companyName) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
	}
	
	@Given("Enter the FirstName as {string}")
	public void enterFirstName(String firstName) {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
	}
	
	@Given("Enter the LastName as {string}")
	public void enter_the_last_name_as(String lastName) {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Balaji");
		driver.findElement(By.name("departmentName")).sendKeys("Test");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Test Desc");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("TestEmail@gmail.com");
	}
	
	@When("Create Lead button is clicked")
	public void clickCreateLeadButton() {
		driver.findElement(By.name("submitButton")).click();
	}
	
	@Then("Lead should be created successfully")
	public void verifyCreateLead() {
		System.out.println(driver.getTitle());
		if(driver.getTitle().contains("View Lead")) {
			System.out.println("Lead is Created Successfully");
		}else {
			System.out.println("Lead is not created");
		}
	}

	
	

}	
	
	
	
	    

