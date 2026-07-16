package ddt;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterDemoWebShop {

	public static void main(String[] args) throws IOException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demowebshop.tricentis.com/");
		
		//Registration
		
//		driver.findElement(By.linkText("Register")).click();
//		driver.findElement(By.xpath("//label[text()='Male']")).click();
//		driver.findElement(By.name("FirstName")).sendKeys("Robin",Keys.TAB,"Bosch",Keys.TAB,"robinb46@gmail.com",Keys.TAB,"Robin@45",Keys.TAB,"Robin@45",Keys.ENTER);
//		driver.findElement(By.linkText("Log out")).click();
		
		//login
		
		FileInputStream fis=new FileInputStream("D:\\Selenium.properties");
		Properties p=new Properties();
		p.load(fis);
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.name("Email")).sendKeys(p.getProperty("email"),Keys.TAB,p.getProperty("pwd"));
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		
		
		
		
		

	}

}
