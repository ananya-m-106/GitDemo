import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class brokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> Links = driver.findElement(By.id("gf-BIG")).findElements(By.tagName("a"));
		String URL;
		SoftAssert a = new SoftAssert();
		for(WebElement Link : Links) {
			URL = Link.getAttribute("href");
			int code = connection(URL, Link);
			a.assertTrue(code<400, "The link with text "+Link.getText()+" is broken with Status code "+ code);
		}
	a.assertAll();
	
		
	}
	
	public static int connection(String URL, WebElement Link) throws MalformedURLException, IOException, InterruptedException {
		HttpURLConnection conn= (HttpURLConnection)new URL(URL).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		int StatusCode = conn.getResponseCode();
		return StatusCode;
		
		
		/*
		 * if(StatusCode>400) { System.out.println("The link with text "+Link.getText()
		 * +" is broken with Status code "+ StatusCode); Assert.assertEquals(StatusCode,
		 * 200); }
		 */
		
	}

}
