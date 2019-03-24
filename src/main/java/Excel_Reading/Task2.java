package Excel_Reading;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Task2 {

	public static void readExcel(String sheetName, String rowName, String colNum) throws Throwable {

		XSSFCell cell;
		XSSFRow row;
		int col_Num = -1;
		File src = new File(
				"C:\\\\Users\\\\DELL\\\\eclipse-workspace\\\\PracticeTest\\\\src\\\\main\\\\java\\\\Data\\\\HW_DATA.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet(sheetName);
		int numRows = sheet.getLastRowNum() + 1;
		int numCols = sheet.getRow(0).getLastCellNum();
		row = sheet.getRow(0);
		
		// Create a loop to read the column number from which user want to read.
		for (int i = 0; i < numCols; i++) {
			if (row.getCell(i).getStringCellValue().trim().equals(colNum.trim()))
				col_Num = i;
		}

		for (int j = 1; j <= numRows; j++) {
			if (rowName.equals(sheet.getRow(j).getCell(0).getStringCellValue())) {
				cell = sheet.getRow(j).getCell(col_Num);
				System.out.println("Value are :- " + cell);

				// String Value = sheet.getRow(j).getCell(col_Num).getStringCellValue();
				// System.out.println("values are :- "+ Value );
				break;
			}

		}

	}

	public static void main(String[] args) throws Throwable {

		readExcel("HW", "TC6", "Roll");
		readExcel("HW", "TC10", "Name");
		readExcel("HW", "TC10", "Department");
		readExcel("HW", "TC10", "Year of Pass");

	}

}
