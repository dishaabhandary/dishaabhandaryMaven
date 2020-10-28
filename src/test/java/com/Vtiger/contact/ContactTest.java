package com.Vtiger.contact;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.Vtiger.GenericUtilities.WebDriverUtility;
import com.Vtiger.GenericUtilities.javaUtility;
/**
 * Test Script for Contact Module
 * @author Dishaa Bhandary
 *
 */

public class ContactTest {
	
	WebDriverUtility wib = new WebDriverUtility();
	javaUtility javautil = new javaUtility();
	
	@Test
	public void createContact() throws Throwable
	{
		/* read the test data */
		String orgName="Test Yantra-"+javautil.getRanDomData(); 
		String lastName="Deepak";
		String orgSearchOption="Organization Name";
		String leadSource="Partner";
		
		/* Step1: Login to application */
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://localhost:8888");
		
		/* Step1: Login to app*/
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		/* Step1: navigate to org module */
		driver.findElement(By.linkText("Organizations")).click();
		
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		/* Step1: create organization */
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		/* Step1: navigate to contact module */
		
		WebElement ele=driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		
		wib.waitforElement(ele);
		
	
		driver.findElement(By.linkText("Contacts")).click();
	
		
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		
		/* Step1: create contact name*/
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		
		
		
		/* Step 1: Click on the organization look up window*/ 
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@alt='Select']")).click();
		
		/* Step 1: Switch to the organization look up window  to select organization */ 
		wib.getAllWindowHandles(driver, "4294967297");
		
			
		/* Step1: Search the organization name and select it */
		
	
	
		  driver.findElement(By.name("search_text")).sendKeys(orgName);

		driver.findElement(By.xpath("//input[@name='search']")).click();
		

		  driver.findElement(By.xpath("//a[.='"+orgName+"']")).click();
		

		/* Switch back to the parent window*/
		driver.switchTo().window("18");
		
		
		/* Click on Save Contact */
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		
		
		/* logout*/

	}

}
