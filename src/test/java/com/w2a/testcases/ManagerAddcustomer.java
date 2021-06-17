package com.w2a.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.w2a.base.baseclass;
import com.w2a.utilities.XLUtility;

import listeners.custlisteners;

@Listeners(custlisteners.class)
public class ManagerAddcustomer extends baseclass {
	
	
@BeforeTest
public void AddCus() throws InterruptedException {
	
	driver.findElement(By.xpath(or.getProperty("Addcus"))).click();
	//Thread.sleep(2000);
	
}
	
	@Test(dataProvider = "LoginData")
	public void excelR(String fname,String lname,String postcode) throws InterruptedException {
		
		try {
		
		WebElement ftxt=driver.findElement(By.xpath(or.getProperty("fname")));
		ftxt.clear();
		ftxt.sendKeys(fname);
		
		WebElement ltxt=driver.findElement(By.xpath(or.getProperty("lname")));
		ltxt.clear();
		ltxt.sendKeys(lname);
		
		WebElement post=driver.findElement(By.xpath(or.getProperty("postcode")));
		post.clear();
		post.sendKeys(postcode);
		
		driver.findElement(By.xpath(or.getProperty("addbtn"))).click();

		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	@DataProvider(name="LoginData")
	public String [][] getdata() throws IOException{
		
		String path="C:\\Users\\BOSU\\git\\Way2aaaa\\datafiles\\loginData.xlsx";
		XLUtility excel=new XLUtility(path);
		
		int rows=excel.getRowCount("sheet1");
		int cols=excel.getCellCount("sheet1", 1);
		
		String [][] loginData=new String[rows][cols];
				
		for(int i=1;i<=rows;i++) {
			for(int j=0;j<cols;j++) {
				
				loginData[i - 1][j]=excel.getCellData("sheet1", i, j);
			}
			
		}
		
		return loginData;		
	}

}
