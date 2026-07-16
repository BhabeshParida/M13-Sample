package ddt;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Cell;		//In Selenium, Apache POI is mainly used for Data-Driven Testing (DDT) to read test data from Excel files.
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;					//ss --> spreadsheet   ---> for excel
import org.apache.poi.ss.usermodel.Workbook;				//sl--->slideshow      ---> for powerpoint
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadingDataFromExcelSheetFile {

	public static void main(String[] args) throws  IOException {
		FileInputStream fis=new FileInputStream("D:\\Selenium.xlsx");
		Workbook wb=WorkbookFactory.create(fis);  //WorkbookFactory.create() used to open both .xls and .xlsx files
		Sheet sh=wb.getSheet("sheet1");
		Row r=sh.getRow(1);
		Cell c = r.getCell(0);
		String c1 = c.toString();	//Converts the cell value into a String. Why convert to String? bcoz--Excel stores data as a Cell object.
		System.out.println(c1);
		
		String c2=wb.getSheet("sheet1").getRow(1).getCell(1).toString();
		System.out.println(c2);
		
		String c3=wb.getSheet("sheet1").getRow(1).getCell(2).toString();
		System.out.println(c3);
		
		String c4=wb.getSheet("sheet1").getRow(1).getCell(3).toString();
		System.out.println(c4);
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(c1);
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.name("Email")).sendKeys(c2,Keys.TAB,c3,Keys.ENTER);
		driver.findElement(By.name("q")).sendKeys(c4,Keys.ENTER);
		
		wb.close();
		fis.close();
		driver.quit();
	}

}
