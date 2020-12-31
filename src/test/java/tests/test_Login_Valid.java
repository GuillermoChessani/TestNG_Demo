package tests;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.page_Login;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;

public class test_Login_Valid {
	WebDriver driver = null;
	page_Login pf;

	@Test(priority=1)
	public void validLoginTest() {
		pf = PageFactory.initElements(driver, page_Login.class);
		driver.get(page_Login.URL);
		pf.LogIn("Admin", "admin123");
		pf.assertValidLogin();
	}

	@Test(priority=0)
	public void validResetPasswordTest() {
		pf = PageFactory.initElements(driver, page_Login.class);
		pf.clickForgotPassword();
		pf.setEmail("admin@email.com");
		pf.clickSubmitReset();
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
