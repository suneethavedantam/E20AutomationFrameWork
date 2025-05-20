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

import genericUtilities.FileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.LoginPage;

public class AddProductToCartWithUtilities
{
	
	public static void main(String[] args)throws IOException
	{
		
		//create object of all utilities
		FileUtility fUtil =new FileUtility();
		JavaUtility jUtil = new JavaUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
		
		//Read common data
		String URL = fUtil.readDataFromPropertyfile("url");
	    String USERNAME = fUtil.readDataFromPropertyfile("username");
		String PASSWORD = fUtil.readDataFromPropertyfile("password");
		
		//Read data from excel file
		String PRODUCTNAME = fUtil.readDataFromExcelfile("Sheet1",1,2);//runtime data
		
		
		//Launch the Browser
		WebDriver driver=new FirefoxDriver();
		sUtil.maximizeWindow(driver);
		sUtil.addImplicilytWait(driver);

		//Load the URL
		driver.get(URL);
		
		//Login to Application
		//driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		//driver.findElement(By.id("password")).sendKeys(PASSWORD);
		//driver.findElement(By.id("login-button")).click();
		
		//Login through POM
		LoginPage lp = new LoginPage(driver);
		//lp.getUsernameText().sendKeys(USERNAME);
		//lp.getPasswordText().sendKeys(PASSWORD);
		//lp.getLoginBtn().click();
		
		lp.loginToApp(USERNAME, PASSWORD);
		
		//Click a product// Dynamic Xpath
		WebElement ele = driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']"));
		String productname=ele.getText();
		ele.click();
		
		//Add to cart
		driver.findElement(By.id("add-to-cart")).click();
		
		//capture screenshot
		String screenshotName ="addProductToCart-"+jUtil.getSystemDate();
		String path = sUtil.captureScreenShot(driver, screenshotName);
		System.out.println(path);
		
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
