package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class DuplicateLead extends BaseClass{
	
	@Given("Click Find Leads link")
	public void ClickFindLeadLink() {
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
	}
	
	@Given("Enter the Email as {string}")
	public void searchByEmail(String email) {
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys(email);
	}
	
	@Given("Click on Find Leads button")
	public void clickFindLeadsButton() {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	}
	
	@Given("Click on the First Search result")
	public void clickFirstSearchResult() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		Thread.sleep(3000);
		WebElement leadID = driver.findElement(By.xpath("(//table[@class='x-grid3-row-table'])[1]//td[1]//a"));
		wait.until(ExpectedConditions.elementToBeClickable(leadID));
		leadID.click();
	}
	
	@When("Click on Duplicate Lead button and Verify")
	public void clickDuplicateButtonAndVerfiy() {
		driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
		String name=driver.findElement(By.id("createLeadForm_companyName")).getAttribute("value");
				
		if(driver.getTitle().contains("Duplicate Lead")) {
			System.out.println("Duplicate Lead page is displayed Successfully");
		}else {
			System.out.println("Duplicate Lead page is displayed");
		}
		
		driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
		String val = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		
		if(val.contains(name)) {
			System.out.println("Duplicate Lead Name is same");
		}else {
			System.out.println("Duplicate Lead Name is not same");
		}
	}
	

}
