package fileUtility;
import java.io.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
public class Excel {
    
    static Object data[][];
	public static Object[][] getExcelData(String path){
		try {
		FileInputStream fis = new FileInputStream(path);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet=wb.getSheetAt(0);
		int rowCount = sheet.getPhysicalNumberOfRows();
		int colCount = sheet.getRow(0).getLastCellNum();
		data= new Object[rowCount-1][colCount];
		DataFormatter formatter = new DataFormatter();
		for(int i=1; i<rowCount; i++) {
			Row row = sheet.getRow(i);
			for(int j=0; j<colCount; j++) {
				Cell cell=sheet.getRow(i).getCell(j);
				data[i-1][j]= formatter.formatCellValue(cell);
			}
			
			
		}
	  }
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return data;
	}
	
	

}
