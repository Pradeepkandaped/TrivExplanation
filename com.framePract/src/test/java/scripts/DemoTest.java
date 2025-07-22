package scripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class DemoTest {
    
	@Test
	public void logTerms() {
		Reporter.log("Helps to retrieve the data", true);
	}
}
