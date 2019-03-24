package Excel_Reading;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;

import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Task1 {

	public static Object[][] readExcel() throws Throwable {

		XSSFCell cell;
		File src = new File("C:\\Users\\DELL\\eclipse-workspace\\PracticeTest\\src\\main\\java\\Data\\HW_DATA.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("HW");
		int numRows = sheet.getLastRowNum() + 1;
		int numCols = sheet.getRow(0).getLastCellNum();
		Object[][] ob = new Object[numRows][numCols];

		// Create a loop to read the row values
		for (int i = 0; i < numRows; i++) {
			Row row = sheet.getRow(i);

			// Create a loop to read cell values in a row
			for (int j = 0; j < numCols; j++) {

				cell = (XSSFCell) row.getCell(j);
				// System.out.print(cell + "|");
				ob[i][j] = cell;
			}
		}
		return ob;
	}

	public static void main(String[] args) throws Throwable {

		Object r[][] = readExcel();
		System.out.println(r[4][2]);

	}
}
