package test_TestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day3 {

	@Test
	public void WebLoginHomeLoan() {
		System.out.println("Web Login Home");
	}
	
	@Parameters({"URL"})
	@Test
	public void MobileLoginHomeLoan(String URL) {
		System.out.println("Mobile Login Home");
		System.out.println(URL);
	}
	
	@Test
	public void APILoginHomeLoan() {
		System.out.println("API Login Home");
	}
}
