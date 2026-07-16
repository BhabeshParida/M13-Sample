package ddt;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WritingDataBackToExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData1.XLSX");
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet("Sheet1").createRow(0).createCell(5).setCellValue("C_Pwd");
		wb.getSheet("Sheet1").getRow(1).createCell(5).setCellValue("Casey45@123");
		
		// Save the workbook
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\TestData1.XLSX");
		wb.write(fos);
		
		
		wb.close();
	    fis.close();
	    fos.close();
		
	    System.out.println("Data written successfully");

	}

}
