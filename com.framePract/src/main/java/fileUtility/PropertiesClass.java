package fileUtility;

import java.util.Properties;
import java.io.*;
public class PropertiesClass {
	static String value;
	public static String getProperty(String path,String key) {
		try {
		Properties p= new Properties();
		p.load(new FileInputStream(path));
		value=p.getProperty(key);
		
	}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return value;

}
}
