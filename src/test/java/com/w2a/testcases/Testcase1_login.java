package com.w2a.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.w2a.base.TestBase;

public class Testcase1_login extends TestBase
{
 @Test
 public void managerLogin()
 {
	 driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
	
	
 }
}
