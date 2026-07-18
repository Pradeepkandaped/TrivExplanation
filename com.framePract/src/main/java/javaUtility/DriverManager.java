package javaUtility;
import org.openqa.selenium.WebDriver;
public class DriverManager {
	
	 private static WebDriver driver;

	    public static void setDriver(WebDriver dr) {
	        driver = dr;
	    }

	    public static WebDriver getDriver() {
	        return driver;
	    }

}




