package com.Vtiger.GenericUtilities;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriverUtility {
	
	/**
	 * 
	 * Gives the address of all the windows opened by selenium
	 * @param driver
	 * @param address
	 */
		
		public void getAllWindowHandles( WebDriver driver,String address)
		{
			Set<String> allwin = driver.getWindowHandles();
						 
			for( String win : allwin)
			{
				System.out.println(win);
			}
			
			driver.switchTo().window(address);
		
		}
			
		/**
		 * used to wait & click for expected element in GUI
		 * @param element
		 * @throws Throwable
		 */
		public void waitAndClick( WebElement element) throws Throwable {
			  int count = 0;
		        while(count < 40) {
				   try {
					   element.click();
				     break;
				   }catch (Throwable e) {
					Thread.sleep(500);
					count++;
				   }
		        }
		}
		
		
		/**
		 * used to wait for expected element in GUI
		 * @param element
		 * @throws Throwable
		 */
		public void waitforElement( WebElement element) throws Throwable {
			  int count = 0;
		        while(count < 40) {
				   try {
					   element.isDisplayed();
				     break;
				   }catch (Throwable e) {
					Thread.sleep(500);
					count++;
				   }
		        }
		}

	

}
