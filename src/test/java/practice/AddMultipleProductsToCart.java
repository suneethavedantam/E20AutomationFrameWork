package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddMultipleProductsToCart {

	public static void main(String[] args)
	{

	  /*1.open the browser. 
		2.Enter the
		URL-https://www.saucedemo.com/ 
		3.welcome page should be     displayed.
		4. Login with valid username-standard_user and password-secret_sauce.Click on login button.
		5.Verify Product page is displayed.
		6.Click on multiple products and add to cart
		7.Check the products are added to cart
		8.Click on logout button*/
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/ ");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']")).click();
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")).click();
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']")).click();
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-onesie']")).click();
		driver.findElement(By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")).click();
		driver.close();


	}

}
