package org.westagilelabs.framework;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import pageclasses.LoginPage;

public class LoginTest {
	
	public static LoginPage page;
    
	@Test
	public void myTest()
	{	
		page= new LoginPage();
		page.init();
		page.Login();
	}
	
	@AfterMethod
	public void close()
	{
		
	}

}
