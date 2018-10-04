package org.westagilelabs.framework;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import exceptionhadnle.Exceptions;
import pageclasses.LoginPage;

public class LoginTest {
	
	public static Exceptions ex;
	
	public static LoginPage page;
    
	@Test
	public void myTest()
	{	
		try
		{
		page= new LoginPage();
		page.init();
		page.Login();
	}
		catch(Exception e)
		{
			ex.createIssue();
		}
	}
	
	@AfterMethod
	public void close()
	{
		
	}

}
