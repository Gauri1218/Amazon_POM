package com.amazon.testscenario;

import org.testng.annotations.Test;

import com.amazon.base.Testbase;
import com.amazon.pages.LoginPage;

import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Placeorder extends Testbase {
  @Test
  public void LoginTest() {
	  
	  LoginPage loginpage = new LoginPage();
	  boolean actResult = loginpage.validateLogin("kulkarnigauri.1218@gmail.com", "Gauri@12");
	  Assert.assertTrue(actResult);
	  
  }
  
  @Test
  public void SearchprodctTest() {
  }
  
  @Test
  public void SelectproductTest() {
  }
  
  @Test
  public void AddtocartTest() {
  }
  
  @Test
  public void MakepaymentTest() {
  }
  
  @Test
  public void LogoffTest() {
  }
  
  
  @BeforeClass
  public void beforeClass() {
	
	  launchBrowser();
	  navigateToURL();
  }


@AfterClass
  public void afterClass() {
  }

}
