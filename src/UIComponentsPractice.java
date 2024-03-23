import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class UIComponentsPractice{

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait w =new WebDriverWait(driver,Duration.ofSeconds(30));
		
		/*
		 * driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		 * driver.manage().window().maximize(); Thread.sleep(2000);
		 * driver.findElement(By.name("checkBoxOption1")).click();
		 * Assert.assertTrue(driver.findElement(By.name("checkBoxOption1")).isSelected()
		 * ); driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).click();
		 * Assert.assertFalse(driver.findElement(By.cssSelector(
		 * "input[id='checkBoxOption1']")).isSelected()); int noOfCheckBoxes =
		 * driver.findElements(By.xpath("//input[@type='checkbox']")).size();
		 * System.out.println(noOfCheckBoxes);
		 */
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		/*
		 * driver.findElement(By.cssSelector("input#username")).sendKeys("rahulshettyacademy");
		 * driver.findElement(By.cssSelector("input[type='password']")).sendKeys("learning"); 
		 * driver.findElement(By.xpath("//label[@class='customradio']/span[text()=' User']")).click();
		 * w.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='myModal'] //button[@id='okayBtn']")));
		 * driver.findElement(By.xpath("//div[@id='myModal'] //button[@id='okayBtn']")).click(); 
		 * Select dropdown = new Select(driver.findElement(By.xpath("//*[@class='form-group']/select[@data-style='btn-info']")));
		 * dropdown.selectByValue("consult");
		 * driver.findElement(By.xpath("//input[@value='Sign In']")).click(); By
		 * AddButtonLocator = By.xpath("//button[@class='btn btn-info']");
		 * w.until(ExpectedConditions.elementToBeClickable(AddButtonLocator));
		 * List<WebElement> AddButtonWebElements =
		 * driver.findElements(AddButtonLocator); for(int i=0;
		 * i<AddButtonWebElements.size(); i++) {
		 * driver.findElements(By.xpath("//button[@class='btn btn-info']")).get(i).click
		 * (); }
		 * driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click(
		 * );
		 */
		
		driver.findElement(By.partialLinkText("Free Access to InterviewQues/ResumeAssistance/Material")).click();
		Set<String> Windowslist = driver.getWindowHandles();
		Iterator<String> it = Windowslist.iterator();
		String mainWindow= it.next();
		String childWindow= it.next();
		driver.switchTo().window(childWindow);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("mentor@rahulshettyacademy.com")));
		String UserEmailID = driver.findElement(By.linkText("mentor@rahulshettyacademy.com")).getText();
		driver.switchTo().window(mainWindow);
		driver.findElement(By.cssSelector("input#username")).sendKeys(UserEmailID);
		
		
		
		
		
		

		
	}

}
