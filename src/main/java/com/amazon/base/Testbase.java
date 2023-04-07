package com.amazon.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testbase 
{

	public static WebDriver driver;
	FileInputStream fis;
	Properties prop;

	
	public void launchBrowser() 
	{
		String fileName = ".\\src\\main\\resources\\config\\Config.properties";
		try 
		{
			fis = new FileInputStream(fileName);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		prop = new Properties();
		
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (prop.getProperty("Browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (prop.getProperty("Browser").equalsIgnoreCase("edge")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
	}
	
	public void navigateToURL() {
		driver.get(prop.getProperty("URL"));
	}

	public void wait(int msec) 
	{
		try {
		Thread.sleep(msec);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
		
		public String captureScreenshot() 
		
		{
			
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy_HH_mm_ss"); // yyyy-MM-dd
			String dateTime = sdf.format(date);
			String fileName = "screenshot_" + dateTime + ".png";

			TakesScreenshot scrShot = (TakesScreenshot) driver;
			File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
			File destFile = new File(".\\src\\main\\resources\\Screenshot\\" + fileName);
			try {
				FileUtils.copyFile(srcFile, destFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return fileName;
			
		}

}
