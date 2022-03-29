package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateLead extends BaseClass{

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
	public void enterLastName(String lastName) {
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
