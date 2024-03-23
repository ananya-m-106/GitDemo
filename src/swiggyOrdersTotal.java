import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class swiggyOrdersTotal {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.swiggy.com/");
		driver.manage().window().maximize();
		driver.findElement(By.className("x4bK8")).click();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//ul[@class='_1JNGZ']//span[text()='Sign In']")).click();
		driver.findElement(By.id("mobile")).sendKeys("8639907679");
		Thread.sleep(3000);
		driver.findElement(By.className("a-ayg")).click();
		Thread.sleep(10000);
		driver.findElement(By.id("otp")).click();
		Thread.sleep(15000);
		driver.findElement(By.className("a-ayg")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@title='View Account']")).click();
		
//			Actions a = new Actions(driver);
//			a.moveToElement(driver.findElement(By.partialLinkText("my-account"))).keyDown(Keys.DOWN).keyDown(Keys.DOWN).click().build().perform();
		Thread.sleep(5000);
		//List<WebElement> ShowMoreOrders = driver.findElements(By.xpath("//div[text()='Show More Orders']"));
		WebElement ShowMoreOrders = driver.findElement(By.xpath("//div[text()='Show More Orders']"));
		
		/*
		 * do { List<WebElement> ShowOtherOrders =
		 * driver.findElements(By.xpath("//div[text()='Show More Orders']"));
		 * if(ShowOtherOrders.size()>0) { ShowMoreOrders.click(); Thread.sleep(2000); }
		 * 
		 * }
		 */
		while((ShowMoreOrders).isDisplayed()) {
			List<WebElement> ShowOtherOrders = driver.findElements(By.xpath("//div[text()='Show More Orders']"));
			if(ShowOtherOrders.size()>0) {
				ShowMoreOrders.click();
				Thread.sleep(2000);	
				if(driver.findElements(By.xpath("//div[contains(text(),'To view older orders, please use Swiggy App')]")).size()>0) {
					break;
				}
			}
		}
		
		By AmountValuelocator = By.xpath("//div[@class='_2XWVq']//span[contains(text(),'Delivered on')]/ancestor::div[@class='g28rk']/following-sibling::div /div[@class='_23DHc']/span[@class='_1jGfr']");
		Thread.sleep(5000);
		List<WebElement> AmountValue = driver.findElements(AmountValuelocator);
		int TotalNoofOrders = driver.findElements(AmountValuelocator).size();
		System.out.println("Total Orders Placed "+TotalNoofOrders);
		int Sum = 0;
		for(int i=0; i<TotalNoofOrders;i++) {
			Sum = Sum + Integer.parseInt(AmountValue.get(i).getText());
		}
		
		System.out.println("Total amout for Delivered Orders " + Sum);
		
		
	}

}
