package week4.practice;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassRoom {
	static ClassRoom obj = new ClassRoom();
	WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		obj.iframeExamples();
	}
	
	public void initializeBrowser(String url){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	public void iframeExamples() throws InterruptedException {
		
		String name="Bala";
		
		obj.initializeBrowser("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert Text Displayed:: "+alert.getText());
		alert.sendKeys(name);
		alert.accept();
		
		String val = driver.findElement(By.id("demo")).getText();
		if(val.contains(name)) {
			System.out.println(name+" is present in the Text displayed");
		}else {
			System.out.println(name+" is not present in the Text displayed");
		}
		
	}

}
