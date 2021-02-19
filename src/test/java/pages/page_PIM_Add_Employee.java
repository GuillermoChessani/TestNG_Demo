package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class page_PIM_Add_Employee {
	WebDriver driver;
	@FindBy(xpath = "//input[@id='firstName']")	WebElement txt_firstName;
	@FindBy(name = "middleName")	WebElement txt_middleName;
	@FindBy(name = "lastName")	WebElement txt_lastName;
	@FindBy(id = "chkLogin")	WebElement chk_Login;
	@FindBy(id = "user_name")	WebElement txt_userName;
	@FindBy(id = "user_password")	WebElement txt_Password;
	@FindBy(id = "re_password")	WebElement txt_PasswordConfirm;
	@FindBy(xpath = "//input[@id='btnSave']")	WebElement btn_Save;
	
	public void setFirstName(String first_name) {
		txt_firstName.sendKeys(first_name);
	}

	public void setMiddleName(String middle_name) {
		txt_middleName.sendKeys(middle_name);
	}

	public void setLastName(String last_name) {
		txt_lastName.sendKeys(last_name);
	}
	
	public void checkLogin() {
		chk_Login.click();
	}

	public void setUserName(String username) {
		txt_userName.sendKeys(username);
	}

	public void setPassword(String password) {
		txt_Password.sendKeys(password);
	}

	public void setPasswordConfirm(String password) {
		txt_PasswordConfirm.sendKeys(password);
	}
		
	public void clickSave() {
		btn_Save.click();
	}
	
	
}
