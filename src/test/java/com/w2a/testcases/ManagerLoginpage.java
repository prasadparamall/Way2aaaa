package com.w2a.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.w2a.base.baseclass;

import listeners.custlisteners;


@Listeners(custlisteners.class)
public class ManagerLoginpage extends baseclass {

	
	@Test
	public void setup1() throws InterruptedException {
		
		driver.findElement(By.xpath(or.getProperty("mngloinbtn"))).click();
		//Thread.sleep(1000);
		
		
	}
	
	
	
			


}
