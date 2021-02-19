package tests;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.page_Dashboard;
import pages.page_Dashboard_ApplyLeave;
import pages.page_Login;
import pages.page_PIM_Add_Employee;
import pages.page_PIM_EmployeeList;
import utils.ExcelUtility;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;

public class test_PIM_Add_Employee {
	WebDriver driver = null;
	page_Login pf;
	page_Dashboard pd;
	page_PIM_EmployeeList pel;
	page_PIM_Add_Employee pae;
	ExcelUtility ex;
	String File_Path = "C:/Users/dperez/eclipse-workspace/TestNG_Demo/src/test/resources/users.xlsx";
	
	@DataProvider(name = "testdata")
	public String[][] testDataExample() {
		ExcelUtility configuration = new ExcelUtility(File_Path);
		int rows = configuration.getRowCount(0);
		String[][] users_info = new String[rows][5];

		for (int i = 1; i <= rows-1; i++) {
			users_info[i][0] = configuration.getDataString(0, i, 0); // 0 First Name
			users_info[i][1] = configuration.getDataString(0, i, 1); // 1 Middle Name
			users_info[i][2] = configuration.getDataString(0, i, 2); // 2 Name Name
			users_info[i][3] = configuration.getDataString(0, i, 3); // 3 UserName
			users_info[i][4] = configuration.getDataString(0, i, 4); // 4 Password
		}
		return users_info;
	}

	@Test(dataProvider = "testdata")
	public void TestUser(String users_info[][]) throws InterruptedException {
		for (int i = 1; i <= 4; i++) {
			System.out.println(users_info[i][0]);
			System.out.println(users_info[i][1]);
			System.out.println(users_info[i][2]);
			System.out.println(users_info[i][3]);
			System.out.println(users_info[i][4]+"\n");
		}
	}
	
	//@Test(dataProvider = "testdata")
	public void addNewUser(String users_info[][]) throws InterruptedException {
		users_info = new String[5][5];
		// Page: Login
		pf = PageFactory.initElements(driver, page_Login.class);
		driver.get(page_Login.URL);
		pf.LogIn("Admin", "admin123");
		pf.assertValidLogin();
		// Page: Dashboard
		pd = PageFactory.initElements(driver, page_Dashboard.class);
		pd.clickPIM();
		// -- Page PIM - Employee List
		pel = PageFactory.initElements(driver, page_PIM_EmployeeList.class);
		pel.clickAddEmployee();
		// -- Form: Add New Employee
		Thread.sleep(1000);
		pae = PageFactory.initElements(driver, page_PIM_Add_Employee.class);
		
		for (int i = 1; i <= 4; i++) {
			System.out.println(users_info[i][0].toString());
			System.out.println(users_info[i][1].toString());
			System.out.println(users_info[i][2].toString());
			System.out.println(users_info[i][3].toString());
			System.out.println(users_info[i][4].toString());
			System.out.println(users_info[i][0].toString()+"\n");
			
//			pae.setFirstName(users_info[i][0].toString());
//			pae.setMiddleName(users_info[i][1].toString());
//			pae.setLastName(users_info[i][2].toString());
//			pae.checkLogin();
//			pae.setUserName(users_info[i][3].toString());
//			pae.setPassword(users_info[i][4].toString());
//			pae.setPasswordConfirm(users_info[i][4].toString());
//			pae.clickSave();
		}

	}

	//@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(page_Login.URL);
	}

	//@AfterTest
	public void TearDown() {
		driver.close();
		driver.quit();
	}

}
