package inventoryTests;

import static org.testng.Assert.fail;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.FileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.CartPage;
import objectRepository.InventoryItemPage;
import objectRepository.InventoryPage;
import objectRepository.LoginPage;

@Listeners(genericUtilities.ListenersImplementation.class)

public class AddProductToCartTest extends BaseClass {

	@Test(groups= "SmokeSuite")
	
	public void tc_01_AddProductToCartTest () throws IOException
	{
				//Read data from excel file
			 
				//Read data from excel file
				String PRODUCTNAME = fUtil.readDataFromExcelfile("Sheet1",1,2);//runtime data
				
				//Click on a product// Dynamic Xpath
				InventoryPage ip=new InventoryPage(driver);
				ip.clickOnAProduct(driver,PRODUCTNAME);

				//Click on Add to cart
				InventoryItemPage iip= new InventoryItemPage(driver);
			    iip.clickOnAddToCartBtn();
				
				//Navigate to cart
				ip.clickOnCartContainer();
				
				//Validate the product in cart
				CartPage cp= new CartPage(driver);
				String ProductIncart=cp.captureItemName();
				
				Assert.assertEquals(ProductIncart ,PRODUCTNAME);
				Assert.assertTrue(ProductIncart.equals(PRODUCTNAME));
				
				/*if(ProductIncart.equals(PRODUCTNAME))
				{
					System.out.println("PASS");
					System.out.println(ProductIncart);
				}
				else
				{
					System.out.println("FAIL");
				}*/
				
	}
	@Test
	
	public void sampleTest()
	{
		//Assert.fail();
		System.out.println("Sample");
	}

}
