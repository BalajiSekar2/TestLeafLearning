package week2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Week2Day1Assignment {

	static ChromeDriver driver;

	public static void main(String[] args) {

		initalizeBrowser();
		createLead();
		editLead();
		duplicateLead();
	}

	public static void initalizeBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	public static void createLead() {

		WebElement edtUserName = driver.findElement(By.id("username"));
		WebElement edtPassword = driver.findElement(By.id("password"));
		WebElement btnLogin = driver.findElement(By.className("decorativeSubmit"));

		edtUserName.sendKeys("Demosalesmanager");
		edtPassword.sendKeys("crmsfa");
		btnLogin.click();

		// click CRM/SFA app
		WebElement btnCRMSFA = driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]"));
		btnCRMSFA.click();

		WebElement createLeadLink = driver.findElement(By.linkText("Create Lead"));
		createLeadLink.click();

		WebElement lnkCreateLead = driver.findElement(By.xpath("//a[contains(text(),'Create Lead')]"));
		lnkCreateLead.click();

		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Bala");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("S");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Balaji");
		driver.findElement(By.name("departmentName")).sendKeys("Test");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Test Desc");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("TestEmail@gmail.com");
		
		WebElement state = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select stateObj =new Select(state);
		stateObj.selectByVisibleText("New York");	
				
		driver.findElement(By.name("submitButton")).click();
		
		System.out.println(driver.getTitle());
		if(driver.getTitle().contains("View Lead")) {
			System.out.println("Lead is Created Successfully");
		}else {
			System.out.println("Lead is not created");
		}
	}

	public static void editLead() {
		
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		driver.findElement(By.id("updateLeadForm_description")).clear();
		driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("Lead Update");
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		
		if(driver.getTitle().contains("View Lead")) {
			System.out.println("Lead edited Successfully");
		}else {
			System.out.println("Lead is not edited");
		}
		
	}

	public static void duplicateLead() {
		
		driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
		driver.findElement(By.id("createLeadForm_companyName")).clear();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("New Company Name");
		
		driver.findElement(By.id("createLeadForm_firstName")).clear();
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Nehanth");
		
		driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
		
		if(driver.getTitle().contains("View Lead")) {
			System.out.println("Duplicate Lead created Successfully");
		}else {
			System.out.println("Duplicate Lead not created");
		}
		
	}
	
}
