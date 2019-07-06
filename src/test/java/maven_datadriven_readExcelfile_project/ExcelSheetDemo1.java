package maven_datadriven_readExcelfile_project;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSheetDemo1 {

	XSSFWorkbook wb;
    XSSFSheet Sheet;
		public void excelsheet(String file) throws IOException
		{
			FileInputStream fis=new FileInputStream(file);
			wb=new XSSFWorkbook(fis);
			
		}
		
		public int getRowCount(String Sheetname)
		{
			Sheet=wb.getSheet(Sheetname);
			int row=Sheet.getLastRowNum();
			int rowcount=row+1;
			return rowcount;
			
		}
		
		public int getcolumnCount(String Sheetname)
		{
			Sheet=wb.getSheet(Sheetname);
			int rows1=Sheet.getLastRowNum();
			int columns=Sheet.getRow(rows1).getLastCellNum();
			return columns;
			
		}
		
		public String getdata(String Sheetname,int row,int column)
		{
			Sheet=wb.getSheet(Sheetname);
			String data=Sheet.getRow(row).getCell(column).getStringCellValue();
			return data;
			
		}
}
