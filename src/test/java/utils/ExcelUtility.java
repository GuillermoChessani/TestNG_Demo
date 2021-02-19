package utils;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	XSSFWorkbook work_book;
	XSSFSheet sheet;

	public ExcelUtility(String excelfilePath) {

		try {
			File s = new File(excelfilePath);
			FileInputStream stream = new FileInputStream(s);
			work_book = new XSSFWorkbook(stream);
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String getDataString(int sheetnumber, int row, int column) {
		sheet = work_book.getSheetAt(sheetnumber);
		String data = sheet.getRow(row).getCell(column).getStringCellValue();
		return data;
	}

	public Object getDataObject(int sheetnumber, int row, int column) {
		sheet = work_book.getSheetAt(sheetnumber);
		Object data = sheet.getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	
	public String getDataNumeric(int sheetnumber, int row, int column) {
		sheet = work_book.getSheetAt(sheetnumber);
		String data = "" + sheet.getRow(row).getCell(column).getNumericCellValue();
		return data;
	}

	public int getRowCount(int sheetIndex) {
		int row = work_book.getSheetAt(sheetIndex).getLastRowNum();
		row = row + 1;
		return row;
	}
	
	public static void main(String[] args) {
		String File_Path = "C:/Users/dperez/eclipse-workspace/TestNG_Demo/src/test/resources/users.xlsx";
		
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
		
		for (int i = 1; i <= 4; i++) {
			System.out.println(users_info[i][0]);
			System.out.println(users_info[i][1]);
			System.out.println(users_info[i][2]);
			System.out.println(users_info[i][3]);
			System.out.println(users_info[i][4]+"\n");
		}
	}
	


}