package week5;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public String[][] readData(String filePath, String sheet) throws IOException {
		// to open Excel file
		XSSFWorkbook book = new XSSFWorkbook(filePath); 	
		// to open sheet from Excel file
		//XSSFSheet sh = book.getSheetAt(0);
		XSSFSheet sh = book.getSheet(sheet);
		// to find row count
		int rowCount = sh.getLastRowNum();
		System.out.println("Row Count::"+rowCount);
		//to find column count
		int columnCount = sh.getRow(0).getLastCellNum();
		System.out.println("Column Count::"+columnCount);
		
		//Creating a 2 dim String data to read and return to data provider method
		String[][] data = new String[rowCount][columnCount];
		
		for(int i=1;i<=rowCount;i++) {
			XSSFRow row = sh.getRow(i);
			for(int j=0;j<columnCount;j++){
				XSSFCell cell = row.getCell(j);
				String val = cell.getStringCellValue();
				
				//storing data to String array
				data[i-1][j]=val;
				//System.out.println(val);
			}
		}
		book.close();
		return data;
	}

}