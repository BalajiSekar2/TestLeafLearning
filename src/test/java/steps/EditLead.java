package steps;

import org.openqa.selenium.By;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditLead extends BaseClass{
	
	@Then("Edit button is available and Clicked")
	public void clickEditButton() {
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
	}
	
	@Then("Update the Company name as {string}")
	public void updateCompanyName(String updatedName) {
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(updatedName);
	}
	
	@When("click submit button")
	public void clickSubmitButton() {
		driver.findElement(By.name("submitButton")).click();
	}
	
	@Then("Verify the edit lead details {string}")
	public void verifyLeadDetails(String updatedName) {
		String updatedCompanyName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if(updatedCompanyName.contains(updatedName)) {
			System.out.println("Company Name Updated successfully");
		}else {
			System.out.println("Unable to update the company Name");
		}
	}

}
