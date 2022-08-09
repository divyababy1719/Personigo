package com.crm.Mobicentrum.GenericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * generic class is developed using Apache POI libraries , which used to handle Microsoft Excel sheet
 * @author JOLLU KISHORE
 *
 */
public class ExcelUtility implements Iconstant {

	/**
	 * it is used to read the data from  Microsoft Excel sheet based on these below arguments
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @return data
	 * @throws throwable
	 */

	public String getDataFromExcel(String sheetName , int rowNum, int celNum) throws Throwable {
		FileInputStream fis  =new  FileInputStream(excelpath);
		Workbook wb = WorkbookFactory.create(fis);
	Cell cell = wb.getSheet(sheetName).getRow(rowNum).getCell(celNum);
	DataFormatter fr=new DataFormatter();
	String data = fr.formatCellValue(cell);
		wb.close();
		return data;
	}

	/**it is used to write the data to  Microsoft Excel sheet based on these below arguments
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @param data
	 * @throws throwable
	 */
	public void setDataToExcel(String sheetName , int rowNum, int celNum,String data) throws Throwable {
		FileInputStream fis  =new  FileInputStream(excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		//DataFormatter fr=new DataFormatter();
		Cell cell = wb.getSheet(sheetName).getRow(rowNum).createCell(celNum);
		cell.setCellValue(data);
		FileOutputStream fo=new FileOutputStream(excelpath);
		wb.write(fo);
		wb.close();
	}
	
	/**
	 * used to get the last used row number on specified Sheet
	 * @paramsheetName
	 * @return
	 * @throwsThrowable
	 */
	public int getRowCount(String sheetName) throws Throwable {
		FileInputStream fis  =new FileInputStream(excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		wb.close();
		return sh.getLastRowNum();
	}
	/**
	 * used to get the last used cell number on specified Sheet
	 * @param sheetName
	 * @param  rowNum
	 * @return
	 * @throwsThrowable
	 */
	public int getCellCount(String sheetName,int rowNum) throws Throwable {
		FileInputStream fis  =new FileInputStream(excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		 Row rw = wb.getSheet(sheetName).getRow(rowNum);
		wb.close();
		return rw.getLastCellNum();
	}


}


