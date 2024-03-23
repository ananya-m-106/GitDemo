import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class webTablePractice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(3000);
		int noofRows = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr")).size();
		System.out.println("Total No of Rows in Table are "+noofRows);
		int NoofColumns = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr/th")).size();
		System.out.println("Total No of Columns in Table are "+NoofColumns);
		
		for(int i=0; i<driver.findElements(By.xpath("//table[@name='courses']/tbody/tr")).size(); i++) {
			if(i==2)
			{
				for(int j=0;j<NoofColumns;j++) {
					System.out.println(driver.findElements(By.xpath("//table[@name='courses']/tbody/tr[3]/td")).get(j).getText());	
				}
				
			}
		}
		
	}

}
