package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

	public static void main(String[] args)
	{

		/*1.open the browser. 
		2.Enter the
		URL-https://www.saucedemo.com/ 
		3.welcome page should be     displayed.
		4. Login with valid username-standard_user and password-secret_sauce.
		5.Click on login button
		6.Verify Product page is displayed.
		7.Click on logout button*/
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/ ");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		driver.close();

	}

}
