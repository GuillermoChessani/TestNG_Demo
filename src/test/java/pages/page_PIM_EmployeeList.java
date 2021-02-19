package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class page_PIM_EmployeeList {
	WebDriver driver;
	@FindBy(id = "btnAdd")	WebElement btn_Add_Employee;
	@FindBy(id = "btnDelete")	WebElement btn_Delete_Employee;
	
	public void clickAddEmployee() {
		btn_Add_Employee.click();
	}
	
	public void clickDeleteEmployee() {
		btn_Delete_Employee.click();
	}
}
