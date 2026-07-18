package javaUtility;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
public class GenerateRandom {
	
	public String generateRandomString(String prefix,int length) {
		
		String characters ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder result= new StringBuilder(prefix);
		Random rand = new Random();
		
		for(int i=0; i<length;i++) {
			result.append(characters.charAt(rand.nextInt(characters.length()))); // using stribg builder object, we are appending the characters.
			// how these characters are appended is through rand function, we have a method nextInt, where we define the lenght of chraacters.
		}
		
		return result.toString();
	}
	
	public static int generateRandomNumbers(int min,int max) {
		
		return ThreadLocalRandom.current().nextInt(min,max+1); // helps u to generate random number, ThreadLocalRandom is very helpful in case of multithread
	}
	
	public static String generateRandomEmail(String domain) {
		String uuid=UUID.randomUUID().toString().replaceAll("-","").substring(0, 8); // Here UUID makes use of random.uuid to create a unique and generate
		//string, using toString method we convert the object to the String , we replace the '-' to "" and finally we define the index to pick
		
		return "pradeep"+uuid+"@"+domain;
	}
	
	public static String generateRandomDate(int startYear, int endYear) {
	    long startMillis = new Date(startYear - 1900, 0, 1).getTime();
	    long endMillis = new Date(endYear - 1900, 11, 31).getTime();
	    long randomMillis = ThreadLocalRandom.current().nextLong(startMillis, endMillis);

	    Date randomDate = new Date(randomMillis);
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    return formatter.format(randomDate);
	}
	
	public static String generateCurrentDate() {
		return null;
		
	}

	
	

}
