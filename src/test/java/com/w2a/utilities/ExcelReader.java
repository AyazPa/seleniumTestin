package com.w2a.utilities;


	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;

	import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class ExcelReader 
	{
		static XSSFWorkbook workbook = null;
		static XSSFSheet sheet = null;
		static XSSFRow row = null;
		static XSSFCell cell = null;
		static FileInputStream fis = null;
		static String path;
		
		
		
		public ExcelReader(String path) {
			this.path = path;
			try {
				fis = new FileInputStream(path);
				workbook = new XSSFWorkbook(fis);
				sheet = workbook.getSheetAt(0);
			} catch (Exception e) {
			
				e.printStackTrace();
			} 
		}

		
		public int getRowCount(String sheetName)
		{
			int index = workbook.getSheetIndex(sheetName);
			
			if (index == -1)
			{
				return 0;
			}else
			{
				sheet =workbook.getSheetAt(index);
				int row_count =sheet.getLastRowNum()+1;
					return row_count;	
			}
		}
		
		public int getColumnCount()
		{
			row = sheet.getRow(0);
			int col_count = row.getLastCellNum();
			return col_count;
		}
		
		public String getCellData(String sheetName, int rownum, int cellnum)
		{
			sheet =workbook.getSheet(sheetName);
			 row = sheet.getRow(rownum);
			cell = row.getCell(cellnum);
			String cellvalue = null;
			if(cell.getCellType()== cell.CELL_TYPE_STRING)
			{
				 cellvalue =cell.getStringCellValue();
				

			}
			else if (cell.getCellType()== cell.CELL_TYPE_NUMERIC)
			{
				 cellvalue=String.valueOf(cell.getNumericCellValue());
			
			}
			return cellvalue;
			
		
		}
	}



