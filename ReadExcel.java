package utility;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
public static String[][] readExcelData(String excelFileName) throws IOException {
//	1. Go to foler and open the file 	
	XSSFWorkbook book = new XSSFWorkbook("./data/"+excelFileName+".xlsx");
	//2. slect sheet name
	// 1)XSSFSheet sheet = book.getSheet("Sheet1");
	XSSFSheet sheet=book.getSheetAt(0);
	//3. you need to iterate over row-row count
	int rowCount = sheet.getLastRowNum();
	System.out.println(rowCount);
	XSSFRow headerRow = sheet.getRow(0);
    int colCount=headerRow.getLastCellNum();
    System.out.println(colCount);
    String[][] array = new String[rowCount][colCount];
    for (int i = 1; i <=rowCount; i++) {
    	XSSFRow row= sheet.getRow(i);
    	for (int j = 0; j <colCount; j++) {
    		XSSFCell cell = row.getCell(j);	
    	      String data =cell.getStringCellValue();
    	      array[i-1][j]=data;
    		System.out.println(data);
    		//System.out.println(array[i-1][j]);
		}
		
	}
	return array;
	
	
	}
	
	

}
