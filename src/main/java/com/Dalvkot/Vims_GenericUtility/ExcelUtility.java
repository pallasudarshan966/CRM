package com.Dalvkot.Vims_GenericUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *This class is used to maintain All specific common methods
 *@author Sudarshan palla
 *
 */

public class ExcelUtility {

	/**
	 * This Method is used to Fetch the Data from Excel Sheet
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 */
	public String getDataFromExcel(String sheetName,int rowNum,int cellNum) throws Throwable
	{
		
		FileInputStream fis =new FileInputStream("./src/main/resources/CommanData/TestData.xls");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		Row row=sh.getRow(rowNum);
		Cell cel=row.getCell(cellNum);
		String data = cel.getStringCellValue();
		wb.close();
		return data;
	}
	/**
	 * This Method is used to get the Numeric and String Data from the Excel
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws Throwable
	 */
    public String getDataFromTheExcel(String Sheetname,int rownum,int cellnum ) throws Throwable {
    	
    	FileInputStream fis =new FileInputStream("./src/main/resources/CommanData/TestData.xls");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(Sheetname);
		DataFormatter format=new DataFormatter();
		String data = format.formatCellValue(sh.getRow(rownum).getCell(cellnum));
		return data;	
		
	}
    /**
     * This Method is used to Get the Numeric Data from the Excel Sheet
     * @param sheetName
     * @param rowNum
     * @param cellNum
     * @return
     * @throws Throwable
     */
	public double getintDataFromExcel(String sheetName,int rowNum,int cellNum) throws Throwable
	{
		
		FileInputStream fis =new FileInputStream("./src/main/resources/CommanData/TestData.xls");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		Row row=sh.getRow(rowNum);
		Cell cel=row.getCell(cellNum);
		double data = cel.getNumericCellValue();
		
		wb.close();
		return data;
	}
	
	
	 /**
	  * This method is used to get the Last Number of Specicified Sheet
	  * @param sheetName
	  * @return
	  * @throws Throwable
	  */
	
	public int getRowCount(String sheetName) throws Throwable
	{
		FileInputStream fis=new FileInputStream("D:\\Eclipse\\com.Dalvkot.vsshhms2\\src\\main\\resources");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		wb.close();
		return sh.getLastRowNum();
	}
	
	 /**
	  * This method used to Write Data inside the Sheet
	  * @param sheetName
	  * @param rowNum
	  * @param celNum
	  * @param data
	  * @throws Throwable
	  */
	
	public void setDataExcel(String sheetName,int rowNum,int celNum,String data) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./src/main/resources/CommanData/TestData.xls");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		Row row=sh.getRow(rowNum);
		Cell cel=row.createCell(celNum);
		cel.setCellValue(data);
		FileOutputStream fos=new FileOutputStream("./");
		wb.write(fos);
		wb.close();
		
	}
	/**
	* This method is used to fetch the multiple data from the excel sheet
	* @param sheetName
	* @return
	 * @throws Throwable
	*/
	public  Object[][] getMultipleDataFromExcel( String sheetName) throws Throwable {
		
		FileInputStream fis = new FileInputStream("./src/main/resources/CommanData/TestData.xls");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Object[][] arr = new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
		for (int i = 0; i < sh.getLastRowNum(); i++) {
			for (int j = 0; j < sh.getRow(i).getLastCellNum(); j++) {
				arr[i][j] = sh.getRow(i + 1).getCell(j).getStringCellValue();
			}
		}
		return arr;
	}
	
	
//	public class ExcelDataProvider extends InitMethod {
//	    @DataProvider(name = "multiSheetExcelRead")
//	    public static Object[][] multiSheetExcelRead(Method method) throws Exception {
//	        File file = new File("./src/test/resources/Excel Files/TestData.xlsx");
//	        String SheetName = method.getName();
//	        System.out.println(SheetName);
//	        return ExcelUtils.getTableArray(file.getAbsolutePath(), SheetName);
//	    }
//
//	    @DataProvider(name = "excelSheetNameAsMethodName")
//	    public static Object[][] excelSheetNameAsMethodName(Method method) throws Exception {
//	        File file = new File("src/test/resources/Test Data/Excel Files/" + method.getName() + ".xlsx");
//	        System.out.println("Opening Excel File:" + file.getAbsolutePath());
//	        return ExcelUtils.getTableArray(file.getAbsolutePath());
//	    }
}