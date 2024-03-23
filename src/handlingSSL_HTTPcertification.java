import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class handlingSSL_HTTPcertification {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ChromeOptions option = new ChromeOptions();
		option.setAcceptInsecureCerts(true);
		option.addExtensions(new File("/path/to/extension.crx")); //Add extension
		Proxy proxyvalue = new Proxy();
		proxyvalue.setHttpProxy("ipaddress:4444");  // Proxy for browser access
		option.setCapability("Proxy", proxyvalue);
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "/directory/path"); // default Download directory change
		option.setExperimentalOption("prefs", prefs); 
		
		WebDriver driver = new ChromeDriver(option);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().deleteCookieNamed("session");
		
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("C:\\Users\\Ananya Reddy\\screenshot.png"));
		
	}

}
