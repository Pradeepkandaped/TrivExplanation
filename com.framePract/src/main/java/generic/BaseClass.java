package generic;

import java.net.URI;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import fileUtility.PropertiesClass;
import javaUtility.DriverManager;

public class BaseClass {
	
	public WebDriver driver;
	public WebDriverWait wait;
	public String excelPath;
	
	public final String pptFiles="config.properties";
	@Parameters({"env"})
	@BeforeClass
	public  void preCondition(@Optional(pptFiles) String env) {
		
		
		
		String xml_Path="./"+env;
		
		
		
		Reporter.log("Read data from :"+xml_Path,true);
		String GRID=PropertiesClass.getProperty(xml_Path, "GRID");
		String GRID_URL=PropertiesClass.getProperty(xml_Path, "GRIDURL");
		String BROWSER=PropertiesClass.getProperty(xml_Path, "BROWSER");
		String APP = PropertiesClass.getProperty(xml_Path, "APP");
		 int  ITO = Integer.parseInt(PropertiesClass.getProperty(xml_Path, "ITO"));
		 int  ETO = Integer.parseInt(PropertiesClass.getProperty(xml_Path, "ETO"));
	     excelPath = ("./"+PropertiesClass.getProperty(xml_Path,"Excel"));
	     
	     
		 
		 if(GRID.equals("yes")) {
			 
			 
			 if(BROWSER.equals("chrome")) {
				 Reporter.log("Open chrome browser in remote", true);
				 try {
				 ChromeOptions options = new ChromeOptions();
				 URI uri = new URI(GRID_URL);
				 driver= new RemoteWebDriver(uri.toURL(),options);
				 DriverManager.setDriver(driver);
				 }
				 
				 catch(Exception e) {
					 e.printStackTrace();
				 }
			 }
				 else if(BROWSER.equals("edge")){
				   try {
					 EdgeOptions options = new EdgeOptions();
					 URI uri= new URI(GRID_URL);
					 driver=new RemoteWebDriver(uri.toURL(),options);
					 DriverManager.setDriver(driver);
				   }
				   catch(Exception e) {
					   e.printStackTrace();
				   }
				 }
			 }
		 
		 
		 else {
			 
			 if(BROWSER.equals("chrome"))
			{
				 Reporter.log("Open chrome browser in Locally", true);
				 Reporter.log("The given path is :" +excelPath,true);
			   driver= new ChromeDriver();
			   DriverManager.setDriver(driver);
			   
			 }
			   else if(BROWSER.equals("edge")) {
				   Reporter.log("Open chrome browser in Locally", true);
				   driver= new EdgeDriver();
				   DriverManager.setDriver(driver);
			   }
		 
	}
	
	 driver.manage().window().maximize();
	 driver.get(APP);
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ITO));
	 wait = new WebDriverWait(driver,Duration.ofSeconds(ETO));
	 
	 
	 

}
	
	@AfterClass
	 public void postCondition() {
		 driver.quit();
	 }
}
