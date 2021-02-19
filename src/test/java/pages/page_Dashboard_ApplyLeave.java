package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class page_Dashboard_ApplyLeave {
	@FindBy(id = "applyleave_txtLeaveType")	WebElement cmb_LeaveType;
	@FindBy(id = "applyleave_txtFromDate")	WebElement cal_FromDate;
	@FindBy(id = "//*[@for='applyleave_txtFromDate']")	WebElement lbl_FromDate;
	@FindBy(id = "applyleave_txtToDate")	WebElement cal_ToDate;
	@FindBy(id = "//*[@for='applyleave_txtToDate']")	WebElement lbl_ToDate;
	@FindBy(id = "applyleave_txtComment")	WebElement txt_Comment;
	@FindBy(id = "applyBtn")	WebElement btn_SubmitAssignLeave;

	public void selectLeaveType() {
		Select drp_LeaveType = new Select(cmb_LeaveType);
		drp_LeaveType.selectByVisibleText("US - Personal");
	}

	public void setDateFrom() {
		cal_FromDate.click();
		cal_FromDate.sendKeys("07-10-2020");
		cal_FromDate.sendKeys(Keys.TAB);
	}

	public void setDateTo() {
		cal_ToDate.click();
		cal_ToDate.sendKeys("14-10-2020");
		cal_ToDate.sendKeys(Keys.TAB);
	}

	public void setComments() {
		txt_Comment.sendKeys("Summer Vacation");
	}

	public void submitLeave() {
		btn_SubmitAssignLeave.click();
	}
}
