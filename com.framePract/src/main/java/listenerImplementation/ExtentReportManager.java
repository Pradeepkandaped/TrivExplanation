package listenerImplementation;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import fileUtility.PropertiesClass;
import generic.BaseClass;
import javaUtility.DriverManager;

public class ExtentReportManager extends BaseClass implements ITestListener {
	
	ExtentSparkReporter sparkReporter;
	ExtentReports reports;
	ExtentTest test;
	public String reportPath;
	public String documentTitle;
	public String reportName;
	public String browserInfo;
	public String environmentInfo;
	public String testerInfo;
	public String report_Path;
	String report_PathSet="./report.properties";
	
	
	
	
	public void onStart(ITestContext context) {
		
		reportPath=("./"+PropertiesClass.getProperty(report_PathSet,"PATH"));
	    documentTitle=PropertiesClass.getProperty(report_PathSet, "DOCUMENTTITLE");
	    reportName=PropertiesClass.getProperty(report_PathSet, "REPORTNAME");
	    browserInfo = PropertiesClass.getProperty(report_PathSet, "BROWSER");
	    environmentInfo=PropertiesClass.getProperty(report_PathSet,"ENVIRONMENT");
	    testerInfo=PropertiesClass.getProperty(report_PathSet, "TESTERNAME");
	    //report_Path=("./"+PropertiesClass.getProperty(xml_Path, "ReportPath"));
	    
		 sparkReporter = new ExtentSparkReporter(reportPath);
		 
		 sparkReporter.config().setDocumentTitle(documentTitle);
		 sparkReporter.config().setReportName(reportName);
		 sparkReporter.config().setTheme(Theme.STANDARD);
		 
		 reports = new ExtentReports();
		 reports.attachReporter(sparkReporter);
		 
		 reports.setSystemInfo("Browser Info", browserInfo);
		 reports.setSystemInfo("Environment Info", environmentInfo);
		 reports.setSystemInfo("Tester Infor", testerInfo);
		 
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		test=reports.createTest(result.getName());
		test.log(Status.FAIL,"The test is failed :"+result.getTestName());
		test.log(Status.FAIL, "The test is failed :"+result.getThrowable());
		try {
		WebDriver driver = DriverManager.getDriver();
		TakesScreenshot t =(TakesScreenshot)driver;
		File src=t.getScreenshotAs(OutputType.FILE);
		File dest=new File("./reportsss/report.png");
		FileUtils.copyFile(src, dest);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
		test=reports.createTest(result.getName());
		test.log(Status.SKIP,"The test is skipped"+result.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
		reports.flush();
	}

	public void onTestSuccess(ITestResult result) {
		 
		test=reports.createTest(result.getName());
		test.log(Status.PASS,"The test is passed :"+result.getTestName());
	}
	
	
	
}	    


