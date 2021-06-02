package com.w2a.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.w2a.base.baseclass;
import com.w2a.utilities.XLUtility;

import listeners.custlisteners;



@Listeners(custlisteners.class)
public class AllCustomerLogin extends baseclass {
	
	
@BeforeTest
public void AddCus() throws InterruptedException {
	
	driver.findElement(By.cssSelector(or.getProperty("custL"))).click();
	Thread.sleep(2000);
	
}
	
	@Test(dataProvider = "customerdata")
	public void open1(String customer, String exp) throws InterruptedException {
	
		
	WebElement cust=driver.findElement(By.xpath(or.getProperty("custname")));
	//cust.clear();
	cust.click();
	Thread.sleep(2000);
	cust.sendKeys(customer,Keys.ENTER);
	Thread.sleep(1000);
	driver.findElement(By.xpath(or.getProperty("loginbtn"))).click();
	Thread.sleep(2000);
	
	driver.findElement(By.xpath(or.getProperty("withdb"))).click();
	driver.findElement(By.xpath(or.getProperty("witha"))).sendKeys("1000");
	Thread.sleep(1000);
	
	WebElement withdrawbutton=driver.findElement(By.xpath(or.getProperty("withb")));
	System.out.println(withdrawbutton.getText());
	withdrawbutton.click();
	
	Thread.sleep(1000);
	
	driver.findElement(By.xpath(or.getProperty("depositb"))).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath(or.getProperty("deposita"))).sendKeys("1000");
	Thread.sleep(1000);
	WebElement depositbutton=driver.findElement(By.xpath(or.getProperty("depositbb")));
	depositbutton.click();
	System.out.println(depositbutton.getText());
	Thread.sleep(1000);
	
	
	driver.findElement(By.xpath(or.getProperty("withdb"))).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath(or.getProperty("witha"))).sendKeys("500");
	Thread.sleep(1000);
	WebElement withdrawbutton1=driver.findElement(By.xpath(or.getProperty("withb")));
	withdrawbutton1.click();
	System.out.println(withdrawbutton1.getText());
	Thread.sleep(1000);
	
	driver.findElement(By.xpath(or.getProperty("tranb"))).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath(or.getProperty("tranbb"))).click();
	Thread.sleep(1000);
	
	driver.findElement(By.xpath(or.getProperty("logout"))).click();
	Thread.sleep(2000);
	
	
	
}
	
	@DataProvider(name="customerdata")
	public Object [][] opendata() throws IOException{
	
	String path=".\\datafiles\\custmername.xlsx";
	XLUtility excel=new XLUtility(path);
	
	int rows=excel.getRowCount("sheet1");
	int cols=excel.getCellCount("sheet1", 1);
	
	Object [][] loginData1=new Object[rows][cols];
			
	for(int i=1;i<=rows;i++) {
		for(int j=0;j<cols;j++) {
			
			loginData1[i - 1][j]=excel.getCellData("sheet1", i, j);
		}
		
	}
	
	return loginData1;		
}


}
