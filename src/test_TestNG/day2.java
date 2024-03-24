package test_TestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class day2 {

	@Test(enabled = true)
	public void WebLoginCarLoan() {
		System.out.println("Web Login Car");
	}
	
	@Test(timeOut= 4000)
	public void MobileLoginCarLoan() {
		System.out.println("Mobile Login Car");
	}
	
	@Parameters({"URL"})
	@Test(dependsOnMethods= {"WebLoginCarLoan"})
	public void APILoginCarLoan(String URL) {
		System.out.println("API Login Car");
		System.out.println(URL);
		System.out.println("Merge change to Git");
	}
}
