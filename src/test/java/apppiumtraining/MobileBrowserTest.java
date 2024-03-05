package apppiumtraining;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileBrowserTest extends BrowserBaseTest

{
	@Test

	public void browserTest()
	{
//		driver.get("https://www.google.com");
//		driver.findElement(By.name("q")).sendKeys("Bounteous Technologies");
//	    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");	
		driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
//		actual link - a[routerlink='/products'] - used * to find best match and to eliminate '/'
		driver.findElement(By.cssSelector("a[routerlink*='products']")).click(); 
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)", "");
		String text = driver.findElement(By.cssSelector("a[href='/angularAppdemo/products/3']")).getText(); 
		Assert.assertEquals(text,"Devops");
	
	
	}
	
}
