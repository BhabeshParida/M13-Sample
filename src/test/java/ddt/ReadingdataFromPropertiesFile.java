package ddt;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadingdataFromPropertiesFile {
	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("D:\\Selenium.properties");  //open the file for reading
		Properties p=new Properties();	//creates a properties object to store key and value pair
		p.load(fis);	//Loads all data from the properties file into the Properties object.
		String url=p.getProperty("Url"); //Fetches the values corresponding to the keys 
		String prod= p.getProperty("product_name");
		System.out.println(url);
		System.out.println(prod);
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		WebElement w=driver.findElement(By.id("small-searchterms"));
		w.sendKeys(prod);
		w.click();
		driver.quit();
		
		
	}
}
