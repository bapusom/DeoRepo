package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest()  {
		super();
		loginpage = new LoginPage();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		
	}
	@AfterMethod
	public void tearDown(){
		d.quit();
	}
	
	@Test(priority=1)
	public void loginPageTitletest() {
		String acttitle = loginpage.validateLoginPageTitle();
		Assert.assertEquals(acttitle, "#1 Free CRM software in the cloud for sales and service");	
	}
	
	@Test (priority=2)
	public void crmLogoImageTest() {
		boolean flag = loginpage.validateCRMImage();
		Assert.assertTrue(flag);
		//throw new SkipException("skipped message1");
	}
	
	@Test (priority=3)
	public void loginTest() throws InterruptedException {
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("psssword"));
		//throw new SkipException("skipped message2");
	}

}
