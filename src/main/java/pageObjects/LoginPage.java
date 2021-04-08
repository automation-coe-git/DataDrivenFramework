package pageObjects;

import java.text.ParseException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testBase.DriverFactory;
import testBase.MyLogger;
import testBase.TestBase;

public class LoginPage extends TestBase {

	private static int intflag = 0;

	By btnLogin = By.xpath("//button[text()='Login']");
	By txtUsername = By.xpath("//input[@name='uname']");
	By txtPassword = By.xpath("//input[@name='psw']");
	By btnCancel = By.xpath("//button[@class='cancelbtn']");


	public void clickLogin() {
		MyLogger.info("Clicking on Login Button");
		DriverFactory.getInstance().getDriver().findElement(btnLogin).click();
	}

	public void setUsername(String uname) {
		MyLogger.info("Entering username in Textbox");
		DriverFactory.getInstance().getDriver().findElement(txtUsername).sendKeys(uname);
	}
	
	public void setPassword(String password) {
		MyLogger.info("Entering username in Textbox");
		DriverFactory.getInstance().getDriver().findElement(txtPassword).sendKeys(password);
	}
	
	public String getBtnName() {
		return DriverFactory.getInstance().getDriver().findElement(btnCancel).getText();
	}

	
}
