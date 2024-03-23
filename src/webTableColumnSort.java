import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class webTableColumnSort {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//tr/th[1]")).click();
		List<WebElement> Veggies = driver.findElements(By.xpath("//tr/td[1]"));
		List<String> VeggieNames = Veggies.stream().map(s->s.getText()).collect(Collectors.toList()); //Map can manipulate the result and get the text of WebElement
		List<String> sortedVeggieNames = VeggieNames.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(VeggieNames.equals(sortedVeggieNames));
		//print the price of Beans
		//scan veggies column with getText() to find Beans item -> Print price of Beans
		List<String> price;
		do {
			List<WebElement> columnValues = driver.findElements(By.xpath("//tr/td[1]"));
			price = columnValues.stream().filter(s->s.getText().contains("Rice")).map(s->priceOfVeggie(s)).collect(Collectors.toList());
			price.forEach(a->System.out.println(a));
			
			if(price.size()<1) {
				driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
			}
		}while(price.size()<1);
		
	}

	private static String priceOfVeggie(WebElement s) {
		// TODO Auto-generated method stub
		String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}

}
