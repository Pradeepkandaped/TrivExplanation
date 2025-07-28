package scripts;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import fileUtility.Excel;
import generic.BaseClass;
import objectRepository.OrangehrmLoginPage;



public class OrangehrmLogin extends BaseClass{
	Object[][] value;
	
	@DataProvider()
	public Object[][] getData(){
		
		 value = Excel.getExcelData(excelPath);
		 return value;
		
	}
	
	@Test(dataProvider=("getData"))
	public void loginScript(String un,String pwd) {
		//Reporter.log("This is the report path of :"+report_Path, true);
		OrangehrmLoginPage lp = new OrangehrmLoginPage(driver);
		lp.enterUsername(un);
		lp.enterPassword(pwd);
		lp.clearUsername();
		lp.clearPassword();
		
		try {
		Thread.sleep(3000);
		
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
//	@Test(dataProvider=("getData"))
//	public void log(String un, String pwd) {
//		
//		Reporter.log("The given path is :" +excelPath,true);
//		
//		for(int i=0; i<value.length;i++) {
//			
//			for(int j=0; j<value[i].length; j++) {
//				 
//				 System.out.print(value[i][j]+" ");
//			}
//			
//			System.out.println();
//		}
//	}
	}

