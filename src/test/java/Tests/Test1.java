package Tests;

import java.io.IOException;
import java.text.ParseException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.MyLogger;
import testBase.TestBase;


public class Test1 extends TestBase {
	
	LoginPage loginPage = new LoginPage();
	
	@Test(enabled=true)
	public void test1() throws IOException, InterruptedException, ParseException {
		MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		loginPage.clickLogin();
		loginPage.setUsername("admin");
		Thread.sleep(3000);
		loginPage.setPassword("admin123");
		Assert.assertEquals(loginPage.getBtnName(), "Cancel");	
	}
	
	@Test(enabled=true)
	public void test2() throws IOException, InterruptedException, ParseException {
		MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		loginPage.clickLogin();
		loginPage.setUsername("admin");
		Thread.sleep(3000);
		loginPage.setPassword("admin123");
		Assert.assertEquals(loginPage.getBtnName(), "Canel");	
	}

}
