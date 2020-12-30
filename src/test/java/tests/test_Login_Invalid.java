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

public class test_Login_Invalid {
	WebDriver driver = null;
	page_Login pf;

	@Test(priority=0)
	public void no_UsernameTest() throws InterruptedException {
		pf = PageFactory.initElements(driver, page_Login.class);
		pf.setPassword("admin123");
		Thread.sleep(1000);
		pf.clickLogin();
		Thread.sleep(1000);
		pf.assertInvalidLogin();
		Thread.sleep(1000);
		
	}
	
	@Test(priority=1)
	public void invalid_UsernameTest() {
		pf = PageFactory.initElements(driver, page_Login.class);
		pf.LogIn("Memo", "admin123");
		pf.assertInvalidLogin();
	}

	@Test(priority=2)
	public void no_PasswordTest() {
		pf = PageFactory.initElements(driver, page_Login.class);
		pf.setUserName("Admin");
		pf.clickLogin();
		pf.assertInvalidLogin();
	}

	
	@Test(priority=3)
	public void invalid_PasswordTest() {
		pf = PageFactory.initElements(driver, page_Login.class);
		pf.LogIn("Admin", "memo123");
		pf.assertInvalidLogin();
	}
	

	
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com");
	}

	@AfterTest
	public void TearDown() {
		driver.close();
		driver.quit();
	}

}
