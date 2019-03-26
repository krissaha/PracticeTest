package Excel_Reading;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Task2 {

	public static String readExcel(String sheetName, String rowName, String colNum) throws Throwable {

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
		String ret = "";
		
		// Create a loop to read the column number from which user want to read.
		for (int i = 0; i < numCols; i++) {
			if (row.getCell(i).getStringCellValue().trim().equals(colNum.trim()))
				col_Num = i;
		}

		for (int j = 1; j <= numRows; j++) {
			if (rowName.equals(sheet.getRow(j).getCell(0).getStringCellValue())) {
				cell = sheet.getRow(j).getCell(col_Num);
				
				if (cell.getCellType() == Cell.CELL_TYPE_STRING)
				{
					ret =  cell.getStringCellValue();
					
				}
				
				else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC || cell.getCellType() == Cell.CELL_TYPE_FORMULA) {

					String cellText = String.valueOf(cell.getNumericCellValue());
					if (HSSFDateUtil.isCellDateFormatted(cell)) {
						// format in form of M/D/YY
						double d = cell.getNumericCellValue();

						Calendar cal = Calendar.getInstance();
						cal.setTime(HSSFDateUtil.getJavaDate(d));
						cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
						cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.MONTH) + 1 + "/" + cellText;
						ret = cellText;
					}
					
			}
		}
			
	}
		return ret;
	}
	public static void main(String[] args) throws Throwable {

	String s1=readExcel("HW", "TC6", "Roll");
	System.out.println(s1);
//		readExcel("HW", "TC10", "Name");
//		readExcel("HW", "TC10", "Department");
		String s2 =readExcel("HW", "TC10", "Year of Pass");

	}

}
