package com.w2a.testcases;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.w2a.base.baseclass;
import com.w2a.utilities.XLUtility;

import listeners.custlisteners;

@Listeners(custlisteners.class)
public class openAccount extends baseclass {
		
		
		@Test(dataProvider = "data")
		public void open(String customer,String currency) throws InterruptedException {
			
			try {
			
			WebElement cust=driver.findElement(By.id(or.getProperty("idcustomer")));
			//cust.clear();
			cust.click();
			//Thread.sleep(1000);
			cust.sendKeys(customer,Keys.ENTER);
			
			WebElement curr=driver.findElement(By.id(or.getProperty("idcurrency")));
			//curr.clear();
			curr.click();
			//Thread.sleep(1000);
			curr.sendKeys(currency,Keys.ENTER);
			
			driver.findElement(By.xpath(or.getProperty("process"))).click();
			//Thread.sleep(1000);
			Alert alert = driver.switchTo().alert();
			String details=driver.switchTo().alert().getText();
			System.out.println(details);
			
			alert.accept();
			Thread.sleep(1000);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}

		
		
		@DataProvider(name="data")
		public Object [][] opendata() throws IOException{
			
			String path=".\\datafiles\\opendata.xlsx";
			XLUtility excel=new XLUtility(path);
			
			int rows=excel.getRowCount("sheet1");
			int cols=excel.getCellCount("sheet1", 1);
			
			Object [][] loginData=new Object[rows][cols];
					
			for(int i=1;i<=rows;i++) {
				for(int j=0;j<cols;j++) {
					
					loginData[i - 1][j]=excel.getCellData("sheet1", i, j);
				}
				
			}
			
			return loginData;		
		}
		
@AfterTest
public void checkAccNum() throws InterruptedException {
	
	driver.findElement(By.xpath(or.getProperty("Cust"))).click();
	Thread.sleep(1000);
	
	 WebElement tableElement= driver.findElement(By.xpath(or.getProperty("move")));  
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("arguments[0].scrollIntoView(true)", tableElement);
	Thread.sleep(1000);
	
	
}
}
	
	


