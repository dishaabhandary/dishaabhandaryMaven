package com.Vtiger.GenericUtilities;

import java.util.Date;
import java.util.Random;


public class javaUtility {
	
	
	
	
	/**
	 *   used to generate the random data with in 1000 limit
	 * @return random data in the from of String 
	 */
	public  String getRanDomData() {
		Random random = new Random();
		int ranInt = random.nextInt(2000);
		return ""+ranInt;
	}
	
	/**
	 * used to get the current system Data
	 * @return
	 */
	public  String getCurrentSystemDate() {
          Date date = new Date();
             String currentDate = date.toString();
		return currentDate;
	}


	

}
