package week4.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day2Assignment4WebTables {
	WebDriver driver;

	public static void main(String[] args) {
		Day2Assignment4WebTables obj = new Day2Assignment4WebTables();
		//obj.playWithTables();
		obj.sortTable();
	}
	
	public void initilaizeBrowser(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	public void playWithTables() {
		
		initilaizeBrowser("http://www.leafground.com/pages/table.html");
		
		// To Find the number of columns present in WebTable
		List<WebElement> tableColumns = driver.findElements(By.xpath("//table//tr[1]/th"));
		System.out.println("No of Columns::"+tableColumns.size());
		
		//To Find the number of Rows present in WebTable
		List<WebElement> tableRows = driver.findElements(By.xpath("//table//tr"));
		System.out.println("No of Rows::"+tableRows.size());
		
		for(int i=2;i<=tableRows.size();i++) {
			String val = driver.findElement(By.xpath("//table//tr["+i+"]/td[1]")).getText();
			if(val.equalsIgnoreCase("Learn to interact with Elements")) {
				System.out.println("Learn to interact with Elements is present in Row::"+(i));
				
				String pro = driver.findElement(By.xpath("//table//tr["+i+"]/td[2]")).getText();
				System.out.println("Progress Value::"+pro);
				break;
			}
		}
		
		List<Integer> progress = new ArrayList<Integer>();
		for(int j=2;j<=tableRows.size();j++) {
			String val = driver.findElement(By.xpath("//table//tr["+j+"]/td[2]")).getText();
			String v =  val.replaceAll("[^0-9]","");
			progress.add(Integer.parseInt(v));
		}
		System.out.println("Minimum Progress value from all Rows::"+Collections.min(progress));
		
		for(int x=0;x<progress.size();x++) {
			if(progress.get(x)==Collections.min(progress)) {
				System.out.println("Minimum Progress value is present in the Row::"+(x+2));
				driver.findElement(By.xpath("//table//tr["+(x+2)+"]/td[3]/input[@type='checkbox']")).click();
				break;
			}
		}
		
	}
	
	public void sortTable() {

		initilaizeBrowser("http://www.leafground.com/pages/sorttable.html");
		
		List<WebElement> rows = driver.findElements(By.xpath("//table//tr"));
		List<String> beforeList = new ArrayList<String>();
		List<String> afterList = new ArrayList<String>();
		
		for(int i=1;i<rows.size();i++) {
			String val = driver.findElement(By.xpath("//table//tr["+i+"]/td[2]")).getText();
			beforeList.add(val);
		}
		System.out.println("Names before Sorting::"+beforeList);
		
		driver.findElement(By.xpath("//table/thead//th[2]")).click();
		
		for(int i=1;i<rows.size();i++) {
			String val = driver.findElement(By.xpath("//table//tr["+i+"]/td[2]")).getText();
			afterList.add(val);
		}
		System.out.println("Names after Sorting::"+afterList);
		
		if(beforeList.equals(afterList)) {
			System.out.println("Names are already in sorted order");
		}else {
			System.out.println("Sorting functionality is working as expected");
		}
	}

}
