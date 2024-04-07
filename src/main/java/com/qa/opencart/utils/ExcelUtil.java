package com.qa.opencart.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	
	private static final String TEST_DATA_SHEET_PATH = "./src/main/resources/testdata/OpenCartTestData.xlsx";
	private static Workbook book;
	private static Sheet sheet;
	
	public static Object[][] getTestData(String sheetName)
	{
		Object data[][] = null;
		
		try {
			
			FileInputStream fis = new FileInputStream(TEST_DATA_SHEET_PATH);
			book = WorkbookFactory.create(fis);
			sheet = book.getSheet(sheetName);
			
			data =new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			for(int row=0; row<sheet.getLastRowNum(); row++)
			{
				for(int col=0; col<sheet.getRow(0).getLastCellNum(); col++)
				{
					data[row][col] = sheet.getRow(row+1).getCell(col).toString();
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
	}

}
