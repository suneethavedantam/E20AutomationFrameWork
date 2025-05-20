package inventoryTests;

import java.io.IOException;

import javax.swing.SortOrder;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
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

public class AddLowestPriceProduct extends BaseClass{

	@Test(groups = "RegressionSuite")
	public void tc_02_AddLowestpriceProductToCartTest() throws IOException
	{
		
		//Read data from excel file
		String PRODUCTNAME = fUtil.readDataFromExcelfile("Sheet1",4,3);//runtime data
		String SORTOPTION = fUtil.readDataFromExcelfile("Sheet1",4,2);

		//Click on a product// Dynamic Xpath
		InventoryPage ip=new InventoryPage(driver);
		ip.clickOnLowestPriceProduct(driver,SORTOPTION,PRODUCTNAME);

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
	/*	if(ProductIncart.equals(PRODUCTNAME))
		{
			System.out.println("PASS");
			System.out.println(ProductIncart);
		}
		else
		{
			System.out.println("FAIL");
		}*/
	}

}
