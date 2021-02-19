package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class page_Dashboard {
	WebDriver driver;
	public static String URL = "https://opensource-demo.orangehrmlive.com";
	@FindBy(xpath = "//span[.='Assign Leave']")	WebElement btn_AssignLeave;
	@FindBy(xpath = "//span[.='Apply Leave']")	WebElement btn_ApplyLeave;
	@FindBy(id = "menu_pim_viewPimModule")	WebElement menu_PIM;

	public void clickAssignLeave() {
		btn_AssignLeave.click();
	}

	public void clickApplyLeave() {
		btn_ApplyLeave.click();
	}
	
	public void clickPIM() {
		menu_PIM.click();
	}
}
