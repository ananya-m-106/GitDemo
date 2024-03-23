package test_TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extent_Reports {

	ExtentReports report;
	
	@BeforeTest
	public void config() {
		
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results"); //Updating Report Name
		reporter.config().setDocumentTitle("Initial Demo of Extent Reports"); //Update the Report document Name
		
		report = new ExtentReports(); 
		report.attachReporter(reporter);
		report.setSystemInfo("Tester", "Ananya");
		
	}
	
	@Test
	public void initialDemo() {
		
		report.createTest("Initial Demo");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		driver.close();
		report.flush();
	}
}
