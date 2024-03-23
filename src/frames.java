import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		//driver.manage().window().maximize();
		System.out.println(driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']"))).findElement(By.xpath("//div[@id='draggable']//p")).getText());
		driver.findElement(By.xpath("//div[@id='draggable']//p")).click();
		Actions a = new Actions(driver);
		WebElement Draggable = driver.findElement(By.xpath("//div[@id='draggable']//p"));
		WebElement Droppable = driver.findElement(By.cssSelector("#droppable"));
		a.dragAndDrop(Draggable, Droppable).build().perform();
		driver.switchTo().defaultContent(); 
		
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Nested Frames")).click();
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-middle");
		System.out.println(driver.findElement(By.id("content")).getText());
		
	}

}
