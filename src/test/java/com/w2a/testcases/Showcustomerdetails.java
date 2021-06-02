package com.w2a.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.w2a.base.baseclass;

import listeners.custlisteners;



@Listeners(custlisteners.class)
public class Showcustomerdetails extends baseclass {
	
	
	@Test
	public void setup3() throws InterruptedException {
		
		driver.findElement(By.xpath(or.getProperty("Cust"))).click();
		Thread.sleep(3000);
		
		try {
		
		 WebElement tableElement= driver.findElement(By.xpath(or.getProperty("move")));  
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true)", tableElement);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath(or.getProperty("openA"))).click();
		Thread.sleep(2000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		//delete account
		/*WebElement delet=driver.findElement(By.xpath(or.getProperty("dltcust")));
		delet.click();
		System.out.println("Delete customer successfully " + delet);
		Thread.sleep(10000);*/
		
		
		
	}
	
	

}
