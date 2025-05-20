package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AddToCart {

	public static void main(String[] args) throws IOException 
	{
		//Read common data
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String URL=p.getProperty("url");
	    String USERNAME=p.getProperty("username");
		String PASSWORD=p.getProperty("password");
		
		//Read data from excel file
		FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fise);
		Sheet sh=wb.getSheet("Sheet1");
		Row rw=sh.getRow(1);
		Cell cl=rw.getCell(2);
		String PRODUCTNAME=cl.getStringCellValue();//runtime data
		
		
		//Launch the Browser
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//Load the URL
		driver.get(URL);
		
		//Login to Application
		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login-button")).click();
		
		//Click a product// Dynamic Xpath
		WebElement ele = driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']"));
		String productname=ele.getText();
		ele.click();
		
		//Add to cart
		driver.findElement(By.id("add-to-cart")).click();
		
		//Navigate to cart
		driver.findElement(By.id("shopping_cart_container")).click();
		
		//Validate the product in cart
		String productInCart = driver.findElement(By.className("inventory_item_name")).getText();
		if(productInCart.equals(productname))
		{
			System.out.println("PASS");
			System.out.println(productInCart);
		}
		else
		{
			System.out.println("FAIL");
		}
		
		//Logout
		
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.linkText("Logout")).click();
		//driver.close();

	}

}
