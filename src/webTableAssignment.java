import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class webTableAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		int noOfRows = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr")).size();
		int noOfColumns = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr/th")).size();

		System.out.println("No of Rows in Courses Table are " + noOfRows);
		System.out.println("No of Columns in Courses table are " + noOfColumns);
		int rowtoRetrieve = 3;
		for (int i = 0; i < noOfRows; i++) {
			if (i == rowtoRetrieve) {
				for (int j = 1; j <= noOfColumns; j++) {
					System.out.println(driver.findElement(By.xpath("//table[@name='courses']/tbody/tr[" + rowtoRetrieve + "]/td[" + j + "]")).getText());
				}
			}
		}

	}

}
