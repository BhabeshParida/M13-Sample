package ddt;

import java.io.FileInputStream;
import java.io.IOException;
													//ExcelFile-->Workbook-->Sheet-->Row-->Cell
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingDataFromExcelDemo {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TC-1.xlsx");
//		XSSFWorkbook wb=new XSSFWorkbook(fis);
//		XSSFSheet sh=wb.getSheet("Sheet1");  //only for .xlsx file
		
//		----------------------OR----------------------
		Workbook wb=WorkbookFactory.create(fis);   //Supports both .xls and .xlsx files
//		Sheet sh=wb.getSheet("Sheet1");
		Sheet sh=wb.getSheetAt(0);// index based
		
		int totalRows = sh.getLastRowNum();
		int totalCells =sh.getRow(0).getLastCellNum();
		System.out.println("Total Number of Rows: "+totalRows); //starts from 0
		System.out.println("Total Number of Cells: "+totalCells); //starts from 1
		
		for(int r=0;r<=totalRows;r++)
		{
			Row currectRow=sh.getRow(r);
			
			for(int c=0;c<totalCells;c++)
			{
				Cell cell=currectRow.getCell(c);
//				System.out.print(cell.toString()+"\t");
				System.out.printf("%-20s",cell.toString());  //for formatting
			}
			System.out.println();
		}

	}

}
