package genericUtilities;

import java.io.File;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class consists of generic methods related to selenium
 * @author suneetha vedantam
 * 
 */

public class SeleniumUtility {
	
	/**
	 * This method will maximize window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method will minimize window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * This method add 10 seconds will implicitly wait for find elements
	 * @param driver
	 */
	public void addImplicilytWait(WebDriver driver)
	
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * This method will wait for 10 seconds for elements to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementsToBeVisible(WebDriver driver , WebElement element)
	
	{
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOf(element));

	}
	
	/**
	 * This method will wait for 10 seconds for elements to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver , WebElement element)
	{
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method will handle Dropdown by index
	 * @param element
	 * @param index
	 */
	public void handleDropDownByIndex(WebElement element, int index)
	{
		Select s= new Select(element);
		s.selectByIndex(index);
	}
	
	/**
	 * This method will handling dropdown by value
	 * @param element
	 * @param value
	 */
	public void handlingByValue(String value,WebElement element)
	{
		Select s= new Select(element);
		s.selectByValue(value);
	}
	
	/**
	 * This method will handling dropdown by visible text
	 * @param element
	 * @param text
	 */
	public void handlingByVisibleText(WebElement element, String text)
	{
		Select s= new Select(element);
		s.selectByVisibleText(text);
	}
	
	/**
	 * This method will perform to click and hold the element
	 * @param driver
	 * @param element 
	 */
	public void clickAndHold(WebElement element, WebDriver driver)
	{
		Actions a=new Actions(driver);
		a.clickAndHold(element).perform();		
	}
	
	/**
	 * This method will perform to click and hold the element
	 * @param driver
	 * @param element 
	 */
	public void mouseHoverActions(WebElement element, WebDriver driver)
	{
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();		
	}
	
	/**
	 * This method is used to drag and drop the element
	 * @param driver
	 * @param srcelement
	 * @param tarelement
	 */
	public void dragAndDrop(WebDriver driver,WebElement srcelement,WebElement tarelement)
	{
		Actions a=new Actions(driver);
		a.dragAndDrop(srcelement,tarelement).perform();		
	}
	
	/**
	 * This method is used to right click
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver,WebElement element)
	{
		Actions a=new Actions(driver);
		a.contextClick(element).perform();
	}
	
	/**
	 * This method is useful to scroll to element
	 * @param driver
	 * @param element
	 */
	public void scroll(WebDriver driver,WebElement element)
	{
		Actions a=new Actions(driver);
		a.scrollToElement(element).perform();
	}
	
	/**
	 * This method is used to double click
	 * @param driver
	 * @param element
	 */
	public void doubletClick(WebDriver driver,WebElement element)
	{
		Actions a=new Actions(driver);
		a.doubleClick(element).perform();
	}
	
	/**
	 * This method will handle Frame by Index
	 * @param driver
	 * @param frameIndex
	 */
	public void handleFrame(WebDriver driver,int frameIndex)
	{
		driver.switchTo().frame(frameIndex);
	}
	
	/**
	 * This method will handle Frame by name or id
	 * @param driver
	 * @param frameName or id
	 */
	public void handleFrame(WebDriver driver,String frameNameOrId)
	{
		driver.switchTo().frame(frameNameOrId);
	}
	
	/**
	 * This method will handle Frame by web element
	 * @param driver
	 * @param frameElement
	 */
	public void handleFrame(WebDriver driver,WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
	
	/**
	 * This method will accept the alert pop up
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will dismiss the alert pop up
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method will enter data to the the alert pop up
	 * @param driver
	 * @param text
	 */
	public void enterAlert(WebDriver driver, String text)
	{
		driver.switchTo().alert().sendKeys(text);
	}
	
	/**
	 * This method will capture text from alert pop up
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	
	/**
	 * This method will switch from one window to another
	 * @param driver
	 * @param windowId
	 */
	public void handleWindow(WebDriver driver,String windowId)
	{
		driver.switchTo().window(windowId);
	}
	
	/**
	 * This method will capture screenshot and return the path to caller
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws IOException 
	 */
	public String captureScreenShot(WebDriver driver,String screenshotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src =ts.getScreenshotAs(OutputType.FILE);
		File dst =new File(".\\Screenshots\\"+screenshotName+".png");
		FileHandler.copy(src, dst);
		
		return dst.getAbsolutePath();	//For extent report	
	}
	
}
