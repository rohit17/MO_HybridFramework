package com.learnAutomation.util;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider 
{
	// declaring object global since this will be used outside of the constructor i.e. inside different methods.
	XSSFWorkbook wb;
	
	// Constructor which load excel file as soon as the object of this class is created
	public ExcelDataProvider()
	{
		File src=new File("./testdata/dataengine.xlsx");
		
		// keeping code in try get, in case file is not found at the location - we should be notified with the proper message
		try
		{
			FileInputStream fis=new FileInputStream(src);
			wb=new XSSFWorkbook(fis);
		}
		
		catch(Exception e)
		{
			System.out.println("Unable to read excel file"+e.getMessage());
		}
	}
	
	// Method Overloading 
	public String getStringData(int sheetIndex,int row,int column)
	{
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
	}
	
	//Method Overloading
	public String getStringData(String sheetName,int row,int column)
	{
		return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
	}
	
	//Returns numeric data
	public double getNumericData(String sheetName,int row,int column)
	{
		return wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
	}
	
}
