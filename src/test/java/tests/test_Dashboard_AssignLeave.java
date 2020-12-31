package tests;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.page_Dashboard;
import pages.page_Dashboard_AssignLeave;
import pages.page_Login;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;

public class test_Dashboard_AssignLeave {
	WebDriver driver = null;
	page_Login pf;
	page_Dashboard pd;
	page_Dashboard_AssignLeave al;

	@Test
	public void AssignLeave() {
		// Page: Login
		pf = PageFactory.initElements(driver, page_Login.class);
		driver.get(page_Login.URL);
		pf.LogIn("Admin", "admin123");
		pf.assertValidLogin();
		// Page: Dashboard
		pd = PageFactory.initElements(driver, page_Dashboard.class);
		pd.clickAssignLeave();
		// -- Page Form: Assign Leave
		al = PageFactory.initElements(driver, page_Dashboard_AssignLeave.class);
		al.setEmployeeName();
		al.selectLeaveType();
		al.setDateFrom();
		al.setDateTo();
		al.setComments();
		al.submitLeave();
	}

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(page_Login.URL);
	}

	@AfterTest
	public void TearDown() {
		driver.close();
		driver.quit();
	}

}
