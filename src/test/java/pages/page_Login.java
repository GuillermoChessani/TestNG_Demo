package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class page_Login {
	WebDriver driver;
	@FindBy(id = "txtUsername")	WebElement txt_Username;
	@FindBy(id = "txtPassword")	WebElement txt_Password;
	@FindBy(name = "Submit") WebElement btnLogin;
	@FindBy(id = "welcome")	WebElement lblWelcome;
	@FindBy(id = "spanMessage")	WebElement lblInvalidCredentials;

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

	public void clickLogin() {
		btnLogin.click();
	}
	
	public void assertValidLogin() {
		lblWelcome.isDisplayed();
	}
	
	public void assertInvalidLogin() {
		lblInvalidCredentials.isDisplayed();
	}
	
	
	}
