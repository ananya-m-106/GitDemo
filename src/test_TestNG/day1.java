package test_TestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day1 {

	@Test
	public void demo() {
		System.out.println("hi");
	}
	
	@Parameters({"URL"})
	@Test
	public void demo2(String URL) {
		System.out.println("Demo2");
		System.out.println(URL);
	}
}
