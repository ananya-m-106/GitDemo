import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class noOfLinksinPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		int noOfLinksinPage = driver.findElements(By.tagName("a")).size();
		System.out.println("Total no of links in a page = "+noOfLinksinPage);
		WebElement footerSection = driver.findElement(By.id("gf-BIG"));
		int noOfFooterLinks = footerSection.findElements(By.tagName("a")).size();
		System.out.println("Total no of links in Footer Section = "+noOfFooterLinks);
		 WebElement columndriver = footerSection.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		
		for(int i=1; i<columndriver.findElements(By.tagName("a")).size(); i++) {
			
			String clickonLinks = Keys.chord(Keys.CONTROL, Keys.ENTER);
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonLinks);
		}
		
		Set<String> noOfWindows = driver.getWindowHandles();
		Iterator<String> it = noOfWindows.iterator();
		String ParentWindow = it.next();
		while(it.hasNext()) {
			System.out.println(driver.switchTo().window(it.next()).getTitle());
			
		}
		
		driver.switchTo().window(ParentWindow);
		WebElement Checkboxpath = driver.findElement(By.xpath("//div[@id='checkbox-example']//label[3]/input"));
		Checkboxpath.click();
		String input = driver.findElement(By.xpath("//div[@id='checkbox-example']//label[3]")).getText();
		Select s = new Select(driver.findElement(By.name("dropdown-class-example")));
		s.selectByVisibleText(input);
		driver.findElement(By.name("enter-name")).sendKeys(input);
		driver.findElement(By.id("alertbtn")).click();
		String alertText = driver.switchTo().alert().getText();
		if(alertText.contains(input)) {
			System.out.println("Value is available in Alert popup");
		}
		driver.switchTo().alert().accept();
		
		}
		
		
		
	

}
