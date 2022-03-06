package week2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Week2Day2Assignment {
	
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		faceBook();
		acmeSystem();
		createContact();
		editLead();
		duplicateLead();
		deleteLead();
	}
	
	public static void initializeBrowser(String url){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	public static void selectDropDownValue(WebElement element,String val) {
		 Select s = new Select(element);
		 s.selectByVisibleText(val);
	}
	
	public static void faceBook() {
		
		initializeBrowser("https://en-gb.facebook.com/");
		driver.findElement(By.linkText("Create New Account")).click();
		driver.findElement(By.name("firstname")).sendKeys("Balaji");
		driver.findElement(By.name("lastname")).sendKeys("S");
		driver.findElement(By.name("reg_email__")).sendKeys("Testabc@email.com");
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("Testabc@email.com");
		driver.findElement(By.id("password_step_input")).sendKeys("TEST@1234");
		driver.findElement(By.name("sex")).click();
		
		WebElement date = driver.findElement(By.name("birthday_day"));
		selectDropDownValue(date,"19");
		
		WebElement month = driver.findElement(By.name("birthday_month"));
		selectDropDownValue(month,"Jun");
		
		WebElement year = driver.findElement(By.name("birthday_year"));
		selectDropDownValue(year,"1993");		
		
		driver.close();
	}
	
	public static void acmeSystem() {
		
		initializeBrowser("https://acme-test.uipath.com/login");
		driver.findElement(By.name("email")).sendKeys("kumar.testleaf@gmail.com");
		driver.findElement(By.name("password")).sendKeys("leaf@12");
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		System.out.println(driver.getTitle());
		driver.findElement(By.partialLinkText("Log Out")).click();
		driver.close();
		
	}

	public static void createContact() {
		
		initializeBrowser("http://leaftaps.com/opentaps/control/login");
		
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();		
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Create Contact")).click();
		driver.findElement(By.id("firstNameField")).sendKeys("Balaji");
		driver.findElement(By.id("lastNameField")).sendKeys("S");
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("Test Dept");
		driver.findElement(By.id("createContactForm_description")).sendKeys("Test Desc");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("Test@email.com");
		
		WebElement state = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		selectDropDownValue(state,"New York");
		
		driver.findElement(By.name("submitButton")).click();
		driver.findElement(By.linkText("Edit")).click();
		
		driver.findElement(By.id("updateContactForm_description")).clear();
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Test Update");
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		System.out.println(driver.getTitle());
				
		driver.close();
	}

	public static void editLead() throws InterruptedException {
		
		initializeBrowser("http://leaftaps.com/opentaps/control/main");
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();		
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("(//label[text()='First name:'])[3]/following-sibling::div/input")).sendKeys("A");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		WebElement leadID = driver.findElement(By.xpath("(//table[@class='x-grid3-row-table'])[1]//td[1]//a"));
		leadID.click();
		
		if(driver.getTitle().contains("View Lead")) {
			System.out.println("Find Lead is Successful");
		}else{
			System.out.println("Unable to find Lead");
		}
		
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("Updated Name");
		driver.findElement(By.name("submitButton")).click();

		String updatedCompanyName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if(updatedCompanyName.contains("Updated Name")) {
			System.out.println("Company Name Updated successfully");
		}else {
			System.out.println("Unable to update the company Name");
		}
		
		driver.close();
	}

	public static void duplicateLead() throws InterruptedException {
		
		initializeBrowser("http://leaftaps.com/opentaps/control/main");
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();		
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("Test");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		WebElement leadID = driver.findElement(By.xpath("(//table[@class='x-grid3-row-table'])[1]//td[1]//a"));
		leadID.click();
		
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
		
		driver.close();
	}

	public static void deleteLead() throws InterruptedException {
		
		initializeBrowser("http://leaftaps.com/opentaps/control/main");
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();		
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("99");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(3000);
		WebElement leadID = driver.findElement(By.xpath("(//table[@class='x-grid3-row-table'])[1]//td[1]//a"));
		leadID.click();
		
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
		
		driver.close();
		
	}
	
}
