package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class page_Login {
	WebDriver driver;
	public static String URL = "https://opensource-demo.orangehrmlive.com";
	@FindBy(id = "txtUsername")	WebElement txt_Username;
	@FindBy(id = "txtPassword")	WebElement txt_Password;
	@FindBy(name = "Submit") WebElement btnLogin;
	@FindBy(id = "welcome")	WebElement lblWelcome;
	@FindBy(css = "#div.fadable")	WebElement lblReset;
	@FindBy(id = "spanMessage")	WebElement lblInvalidCredentials;
	@FindBy(partialLinkText = "Forgot your password?") WebElement linkForgotPassword;
	@FindBy(id = "securityAuthentication_userName") WebElement txtAuthentication_userName;
	@FindBy(id = "btnSearchValues") WebElement btn_Reset;
	@FindBy(id = "btnCancel") WebElement btn_Cancel;
	
	public void LogIn(String username, String password) {
		this.setUserName(username);
		this.setPassword(password);
		this.clickLogin();
	}
	
	public void setUserName(String username) {
		txt_Username.sendKeys(username);
	}

	public void setPassword(String password) {
		txt_Password.sendKeys(password);
	}

	public void setEmail(String password) {
		txtAuthentication_userName.sendKeys(password);
	}
	
	public void clickForgotPassword() {
		linkForgotPassword.click();
	}
	
	public void clickSubmitReset() {
		btn_Reset.click();
	}
	
	public void clickCancelReset() {
		btn_Cancel.click();
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	public void assertValidLogin() {
		lblWelcome.isDisplayed();
	}
	
	public void assertValidReset() {
		lblReset.isDisplayed();
	}
	
	public void assertInvalidLogin() {
		lblInvalidCredentials.isDisplayed();
	}
	
	
	}
