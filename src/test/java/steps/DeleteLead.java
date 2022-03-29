package steps;

import org.openqa.selenium.By;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class DeleteLead extends BaseClass{
	
	@Given("Enter the PhoneNumber as {string}")
	public void enter_the_phone_number_as(String phoneNumber) {
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phoneNumber);
	}
	
	@Then("Click on Delete Lead button and Verify")
	public void click_on_delete_lead_button_and_verify() throws InterruptedException {
		String val=driver.findElement(By.id("viewLead_companyName_sp")).getText();
		String lead = val.substring(val.length()-6,val.length()-1);
		System.out.println("Lead ID::"+ lead);
		
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.name("id")).sendKeys(lead);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		
		if(driver.findElement(By.xpath("//div[text()='No records to display']")).isDisplayed()) {
			System.out.println("Lead is deleted Successfully");
		}else {
			System.out.println("Lead is not deleted");
		}
	}
	

}
