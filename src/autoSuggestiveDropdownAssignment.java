import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class autoSuggestiveDropdownAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.cssSelector("input.ui-autocomplete-input")).sendKeys("ind");
		Thread.sleep(3000);
		List<WebElement> autoSuggestiveDropdownValues = driver.findElements(By.cssSelector("ul#ui-id-1 li"));
		int i = 0;
		String ArrowDown = Keys.chord(Keys.ARROW_DOWN);
		for (WebElement options : autoSuggestiveDropdownValues) {
			if (options.getText().equalsIgnoreCase("India")) {
				System.out.println(i);
				autoSuggestiveDropdownValues.get(i).click();
				break;

			}
			
			 else { 
			 driver.findElement(By.cssSelector("input.ui-autocomplete-input")).sendKeys(ArrowDown);
			 i++;
			 }
			 
		}
		System.out.println(driver.findElement(By.cssSelector("input.ui-autocomplete-input")).getAttribute("value"));

	}

}
