package com.w2a.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.w2a.base.baseclass;

import listeners.custlisteners;


@Listeners(custlisteners.class)
public class gotohomepage extends baseclass {
	
	
	@Test
	public void setup2() throws InterruptedException {
		
		driver.findElement(By.cssSelector(or.getProperty("home"))).click();
		Thread.sleep(2000);
		
	}
	
	

}
