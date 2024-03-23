import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocator_multiplewindow_partialSS {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String Parentwindow = it.next();
		String childwindow = it.next();
		driver.switchTo().window(childwindow);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/");
		String courseName = driver.findElements(By.cssSelector("[class*='courses-block'] img")).get(0).getAttribute("alt");
		System.out.println(courseName);
		driver.switchTo().window(Parentwindow);
		WebElement name = driver.findElement(By.xpath("//input[@name='name']"));
		name.sendKeys(courseName);
		File file = name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("NameAttribute.png"));
		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());
		/*
		 * driver.findElement(By.xpath("//*[@value='Submit']")).click();
		 * driver.findElement(with(By.tagName("input")).toLeftOf(driver.findElement(By.
		 * xpath("//label[@for='exampleCheck1']")))).click();
		 */
		
		
		
	}

}
