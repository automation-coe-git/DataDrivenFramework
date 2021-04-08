package testBase;


import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import reusableComponents.ReadConfig;

public class TestBase {
	BrowserFactory browserFactory = new BrowserFactory();

	@Parameters("browser")
	@BeforeMethod
	public void LaunchApplication(String browser) throws Exception {
		reusableComponents.ReadConfig readconfig = new reusableComponents.ReadConfig("./Configuration/config.properties");
		String baseURL = readconfig.getValue("baseURL");
		
		DriverFactory.getInstance().setDriver(browserFactory.createBrowserInstance(browser));
		DriverFactory.getInstance().getDriver().manage().window().maximize();
		DriverFactory.getInstance().getDriver().navigate().to(baseURL);
		DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void tearDown() {
		DriverFactory.getInstance().closeBrowser();
	}
	
	static String staticBrowser;
	@Parameters("browser")
	@BeforeTest
	public void intializeReport(String browser) throws IOException {
		staticBrowser=browser;
		reusableComponents.TestListeners report1=new reusableComponents.TestListeners();
		report1.report();
	}
	
	/*
	 @BeforeSuite public void DockerUp() throws InterruptedException {
		 new reusableComponents.CommandPromptUtils("docker-compose up -d");
	 Thread.sleep(20000); }
	 

	 @AfterSuite public void DockerDown() { new
	 reusableComponents.CommandPromptUtils("docker-compose down"); }
	 */
}
