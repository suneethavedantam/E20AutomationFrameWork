package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PlaceAnOrder {

	public static void main(String[] args)
	{
		/*1.open the browser. 
		2.Enter the
		URL-https://www.saucedemo.com/ 
		3.welcome page should be     displayed.
		4. Login with valid username-standard_user and password-secret_sauce.Click on login button.
		5.Verify Product page is displayed.
		6.Click on  products and add to cart
		7.Check the products are added to cart
		8.Click on checkout give the credentials and click on continue and go to finish button
		9.Click on logout button*/
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/ ");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		driver.findElement(By.xpath("//button[@id='checkout']")).click();
		driver.findElement(By.id("first-name")).sendKeys("abc");
		driver.findElement(By.id("last-name")).sendKeys("def");
		driver.findElement(By.id("postal-code")).sendKeys("123");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.xpath("//button[@id='finish']")).click();
		driver.close();


	}

}
