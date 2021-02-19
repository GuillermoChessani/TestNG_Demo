package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

	public void setEmail(String email) {
		txtAuthentication_userName.sendKeys(email);
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
