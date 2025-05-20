package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryItemPage {
	
	
	@FindBy(xpath ="//button[.='Add to cart']")
	private WebElement addtocartBtn;

	
	@FindBy(xpath ="//button[.='Remove']")
	private WebElement removeBtn;
	
	//Initialization
	
	public InventoryItemPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	
	public WebElement getAddtocartBtn() {
		return addtocartBtn;
	}

	public WebElement getRemoveBtn() {
		return removeBtn;
	}
	//Business library

	public void clickOnAddToCartBtn()
	{
		addtocartBtn.click();
	}
	public void clickOnRemoveBtn()
	{
		removeBtn.click();
	}
}
