import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class handlingCalendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.findElement(By.partialLinkText("offers")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String Parentid = it.next();
		String childID = it.next();
		driver.switchTo().window(childID);
		String monthNumber = "6";
		String Date = "15";
		String Year = "2027";
		
		/*1. To modify Year click on middle component twice
		2. Verify if the year specified is available in that 10 years. If not Compare with Max Year and click on Prev or Next icons using a function
		3.When Year is found, we need to select month in given Year. for function to 
		
		
		*/
		driver.findElement(By.xpath("//button[contains(@class,'calendar-button')]")).click();
		WebElement middleComponent = driver.findElement(By.xpath("//button[@class='react-calendar__navigation__label']/span"));
		middleComponent.click();
		middleComponent.click();
		
		By Years =By.xpath("//button[contains(@class,'decade-view__years__year')]");
		By Months =By.xpath("//button[contains(@class,'year-view__months__month')]");
		By Dates = By.xpath("//button[contains(@class,'month-view__days__day')]");
		
		
		for(int i=0; i<driver.findElements(Years).size(); i++) {
			if(driver.findElements(Years).get(i).getText().equalsIgnoreCase(Year)) {
				driver.findElements(Years).get(i).click();
				break;
			}
		}
		
	//	driver.findElement(Months)
		// Complete this code to select an year/ Month and Date
		
		
		
				
		
	}

}
