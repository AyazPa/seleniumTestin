package com.w2a.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class Testcase2_AddCustomerData extends TestBase
{
	@Test(dataProvider = "getData")
 public void addCustomerData(String firstname, String lastname, String postalcode, String alerttext) throws InterruptedException
 {
		
		logger.debug("Running Add coustmer Data Testcase");
	 driver.findElement(By.cssSelector(OR.getProperty("addCstBtn"))).click();
	 logger.debug("Clicked on Add Coustmer Button");
	 driver.findElement(By.cssSelector(OR.getProperty("firstname"))).sendKeys(firstname);
	 logger.debug("Enterred First name");
	 driver.findElement(By.cssSelector(OR.getProperty("lastname"))).sendKeys(lastname);
	 logger.debug("Enterred Last name");
	 driver.findElement(By.cssSelector(OR.getProperty("postalcode"))).sendKeys(postalcode);
	 logger.debug("Enterred Post code");
	 driver.findElement(By.cssSelector(OR.getProperty("addbtn"))).click();
	 logger.debug("Clicked on Add Coustmer Button");
	 
	 
	 
	Alert alert=wait.until(ExpectedConditions.alertIsPresent());
    alert.accept();
	 logger.debug("Coustmer added Succesfully");
	 
	 
 }
	
	@DataProvider
	public Object[][] getData()
	{
		String SheetName = "Testcase2_AddCustomerData";
		int rows =excel.getRowCount(SheetName);
		System.out.println(rows);
		int cols = excel.getColumnCount();
		System.out.println(cols);
		Object[][] data = new Object[rows-1][cols];
		for (int i = 1; i<rows; i++)
		{
			
			
			for(int j =0; j<cols-1; j++)
			{
			data[i-1][j] = excel.getCellData(SheetName, i, j);
			
			}
			
		}
		 return data;
		
	}
}
