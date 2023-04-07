package com.amazon.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.base.Testbase;

public class LoginPage extends Testbase {
	
	By signInLink = By.xpath("//*[@id=\"nav-link-accountList\"]"); 
			//By.xpath("//*[@id=\"nav-flyout-ya-signin\"]/a/span");
	By email = By.name("email");
	By continueBtn = By.xpath("//*[@id=\"continue\"]");
	By password = By.name("password");
	By SignInBtn = By.id("signInSubmit");
	
	public boolean validateLogin(String uname,String pwd)
	{
		//wait(3000);
		driver.findElement(signInLink).click();
		wait(2000);
		driver.findElement(email).sendKeys(uname);
		driver.findElement(continueBtn).click();
		wait(2000);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(SignInBtn).click();
		
		
		boolean actResult = true;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		try 
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]"))); 
		}
		catch(TimeoutException te) 
		{
			actResult = false;
			System.out.println("Screenshot for Login Failure");
			captureScreenshot();
		}
		
		return actResult;
			
	}
}
			
