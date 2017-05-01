package com.wbl.HelperPackage;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilMacys {

	static Logger logger = LogManager.getLogger(ExcelUtilMacys.class);
	public static Object[][] getExcelData(String fileName){
		Object[][] data = null;
		XSSFWorkbook wb=null;
		try {
			wb = new XSSFWorkbook(new FileInputStream(IConstants.LOCATION+"\\testData\\"+fileName));
			XSSFSheet sheet = wb.getSheet("signdata");
			int noOfRows = sheet.getLastRowNum();
			data= new Object[noOfRows][];
			for(int i=1;i<=noOfRows;i++){
				XSSFRow row =sheet.getRow(i);
				int noOfColumns=row.getLastCellNum();
				String [] strData = new String[noOfColumns];
				for (int j=0;j<noOfColumns;j++){
					strData[j]=row.getCell(j).getStringCellValue();
				}
				data[i-1]=strData;
			}

		} catch (IOException e) {
			logger.error("issue reading file");
		}finally{
			if(null!=wb){
				try {
					wb.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}			

		return data;
	}

}

