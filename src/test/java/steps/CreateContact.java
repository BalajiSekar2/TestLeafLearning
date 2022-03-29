package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CreateContact extends BaseClass{

	@Given("Click Create contact link")
	public void clickCreateContactLink() {
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Create Contact")).click();
	}
	
	@Given("Enter the First Name as {string} and LastName as {string}")
	public void enterNameDetails(String firstName, String lastName) {
		driver.findElement(By.id("firstNameField")).sendKeys(firstName);
		driver.findElement(By.id("lastNameField")).sendKeys(lastName);
	}
	
	@Given("Enter the Department as {string} and Description as {string} and Email as {string}")
	public void enterMandatoryDetails(String department, String description, String email) {
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys(department);
		driver.findElement(By.id("createContactForm_description")).sendKeys(description);
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys(email);
	}
	
	@Given("Select the State as {string}")
	public void selectStateVal(String stateVal) {
		WebElement state = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select s = new Select(state);
		s.selectByVisibleText(stateVal);
	}
	
	@Given("Click on Submit button")
	public void clickSubmitButton() {
		driver.findElement(By.name("submitButton")).click();
	}
	
	@Then("Click on Edit Contact button and Update the details as {string}")
	public void click_on_edit_contact_button_and_update_the_details_as(String string) {
		driver.findElement(By.linkText("Edit")).click();

		driver.findElement(By.id("updateContactForm_description")).clear();
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Test Update");
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		System.out.println(driver.getTitle());
	}
	
}


