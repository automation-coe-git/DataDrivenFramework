package Tests;

import java.io.IOException;
import java.text.ParseException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pageObjects.LoginPage;
import testBase.ExtentFactory;
import testBase.ExtentReportNG;
import testBase.MyLogger;
import testBase.TestBase;


public class Test1 extends TestBase {
	
	LoginPage loginPage = new LoginPage();
	
	@Test(enabled=true)
	public void LoginPassed() throws IOException, InterruptedException, ParseException {
		MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		loginPage.clickLogin();
		ExtentFactory.getInstance().getExtent().log(Status.INFO,"Login Button Clicked");
		loginPage.setUsername("admin");
		ExtentFactory.getInstance().getExtent().log(Status.INFO,"Username Entered");
		Thread.sleep(3000);
		loginPage.setPassword("admin123");
		ExtentFactory.getInstance().getExtent().log(Status.INFO,"Password Entered");
		Assert.assertEquals(loginPage.getBtnName(), "Cancel");	
	}
	
	@Test(enabled=false)
	public void LoginFailed() throws IOException, InterruptedException, ParseException {
		MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		loginPage.clickLogin();
		ExtentFactory.getInstance().getExtent().log(Status.INFO,"Login Button Clicked");
		loginPage.setUsername("admin");
		ExtentFactory.getInstance().getExtent().log(Status.INFO,"Username Entered");
		Thread.sleep(3000);
		loginPage.setPassword("admin123");
		ExtentFactory.getInstance().getExtent().log(Status.INFO,"Password Entered");
		Assert.assertEquals(loginPage.getBtnName(), "Canel");	
	}

}
