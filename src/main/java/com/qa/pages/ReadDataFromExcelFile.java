package com.qa.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

public class ReadDataFromExcelFile {
	public void readData(String sheetName, String data) throws Exception {

		File src = new File(
				"C:\\Users\\krishnendusaha\\eclipse-workspace\\PracticeTest\\src\\main\\java\\Data\\TestData.xlsx");
		FileInputStream fis;
		XSSFWorkbook wb;
		fis = new FileInputStream(src);
		wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet(sheetName);
		int rowcount = sheet.getLastRowNum();
		for (int i = 0; i <= rowcount + 1; i++) {
			Column column;
			Row row = sheet.getRow(i);
			String value = row.getCell(i).getStringCellValue();
			if (value == data) {
				for (int j = 0; j < row.getLastCellNum(); j++) {
					System.out.print(row.getCell(j).getStringCellValue() + " | ");
				}
			}
		}
		// String data =
		// sheet.getRow(row).getCell(column+1).getStringCellValue();
		// String d1 = data;
		// return d1;
		wb.close();
	}

	public static void main(String[] args) throws Exception {

		// ReadDataFromExcelFile readf = new ReadDataFromExcelFile();
		// readf.readData("loginData","valid User");

		File src = new File(
				"C:\\Users\\krishnendusaha\\eclipse-workspace\\PracticeTest\\src\\main\\java\\Data\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("loginData");
		String data = "valid User";
		int count = 0;
		int rowcount = sheet.getLastRowNum(); // Count number of Rows

		for (int i = 0; i <= rowcount + 1; i++) {
			Row row = sheet.getRow(i);
			String rData = row.getCell(i).getStringCellValue();
			if (data == rData) {
				for (int j = i + 1; j < row.getLastCellNum(); j++) {
					System.out.print(row.getCell(j).getStringCellValue() + " | ");
					break;
				}
			} else if (count > rowcount) {
				System.out.println("Data Not Found...");
			}
			count = count + 1;
		}
		
		wb.close();

	}
}
