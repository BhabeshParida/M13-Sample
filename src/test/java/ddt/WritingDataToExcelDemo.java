package ddt;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WritingDataToExcelDemo {

	public static void main(String[] args) throws IOException {
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\TC-2.xlsx");  //it will create a new File inside resources named as TC-2
//		If the file doesn't exist, Java creates it.
//		If the file already exists, its contents will be overwritten.
		Workbook wb=WorkbookFactory.create(true);  //true → creates an .xlsx workbook (XSSF)  false → creates an .xls workbook (HSSF)
		Sheet sh=wb.createSheet("TestData");
		Row row1=sh.createRow(0);
			row1.createCell(0).setCellValue("Bhabesh"); //String value
			row1.createCell(1).setCellValue(25); //double value
			row1.createCell(2).setCellValue("30/03/2001"); //String value
		Row row2=sh.createRow(1);
			row2.createCell(0).setCellValue("Casey");
			row2.createCell(1).setCellValue(20);
			row2.createCell(2).setCellValue("26/06/2004");
		Row row3=sh.createRow(2);
			row3.createCell(0).setCellValue("Ella");
			row3.createCell(1).setCellValue(22);
			row3.createCell(2).setCellValue("18/09/2003");
			
			wb.write(fos);
			wb.close();
			fos.close();
			System.out.println("Data written successfully");
	}

}
