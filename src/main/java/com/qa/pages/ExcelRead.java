package com.qa.pages;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	public static void main(String[] args) throws IOException 
	{
		File src = new File("E:\\Selenium\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(1);
		int rowcount = sheet.getLastRowNum();
		System.out.println("Total row count :- " + rowcount);
		
		//Create a loop over all the rows of excel file to read it
		for (int i=0;i<rowcount+1;i++)
		{
			Row row = sheet.getRow(i);
			
			//Create a loop to print cell values in a row
			for (int j=1; j<row.getLastCellNum(); j++)
			{
				System.out.print(row.getCell(j).getStringCellValue()+" | ");
			}
			
			System.out.println();
		}
		wb.close();
	}
}

//String s1 = sheet1.getRow(6).getCell(0).getStringCellValue();
//System.out.println("Data read :- " + s1);
