package Excel_Reading;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Task1
{
	
	public static void readExcel() throws Throwable
	{
		File src = new File("C:\\Users\\DELL\\eclipse-workspace\\PracticeTest\\src\\main\\java\\Data\\HW_DATA.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("HW");
		int rowcount = sheet.getLastRowNum();
		System.out.println(rowcount);			
	}
		
	public static void main(String[] args) throws Throwable
	{
		
		readExcel();
	

	}
}
