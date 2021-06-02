package com.w2a.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class baseclass {
	
	public static WebDriver driver;
	public static WebElement driver1;
	public static Properties pro;
	public static Properties or;
	public static FileInputStream fis;
	public static String browser;
	public static Logger log=Logger.getLogger("devpinoyLogger");
	
	
	
	@BeforeSuite
	public WebDriver Propertiefile() throws InterruptedException {
		
		
		if (driver == null) {
			
			try {
				
				fis= new FileInputStream("C:\\Users\\BOSU\\eclipse-workspace\\Way2aaaa\\configurations\\config.properties");
				pro=new Properties();
				pro.load(fis);
				log.debug("pro file loaded  ...");
				String ss=pro.getProperty("browser");
				System.out.println(ss);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				
				fis= new FileInputStream("C:\\Users\\BOSU\\eclipse-workspace\\Way2aaaa\\configurations\\OR.properties");
				or=new Properties();
				or.load(fis);
				log.debug("or file loaded  ...");
				String ss=or.getProperty("mngloinbtn");
				System.out.println(ss);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			if(pro.getProperty("browser").equals("chrome")) {
				
				System.setProperty("webdriver.chrome.driver","C:\\Users\\BOSU\\eclipse-workspace\\Way2aaaa\\Drivers\\chromedriver.exe");
				driver = new ChromeDriver();
				log.debug("chrome Launched  ...");
			}else if(pro.getProperty("browser").equals("firefox")) {
				
				System.setProperty("webdriver.gecko.driver","C:\\Users\\BOSU\\eclipse-workspace\\Way2aaaa\\Drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
				log.debug("chrome Launched  ...");
			}else if(pro.getProperty("browser").equals("ie")) {
				
				System.setProperty("webdriver.ie.driver","C:\\Users\\BOSU\\eclipse-workspace\\Way2aaaa\\Drivers\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				log.debug("chrome Launched  ...");
		}
		    
			driver.manage().window().maximize();
			driver.get(pro.getProperty("url"));
			log.debug("Open Url  ...");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//Thread.sleep(1000);
			
	}
		return driver;
		
	
	}
	
	public void screenS(String methodname) {
		
		File tc =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(tc, new File("C:\\Users\\BOSU\\eclipse-workspace\\Way2aaaa\\Screenshorts\\"+methodname+ "_"+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/*
	@AfterSuite
	public void closeBrowser() {
		
		if(driver!= null) {
		driver.quit();
		}
		log.debug(" close browser  ...");
		
	}*/
}
	

