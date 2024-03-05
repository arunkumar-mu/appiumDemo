package apppiumtraining;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import org.testng.Assert;

public class eCommerce_t2 extends BaseTest{
	@Test
	
	public void addToCart() throws InterruptedException
	
	{
		
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Austria\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Austria\"]")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Vaishu");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Jordan 6 Rings\"));"));
        int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
        
        for(int i=0; i<productCount; i++)
        {
        	String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
        if(productName.equalsIgnoreCase("Jordan 6 Rings"))
        {
        	driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
        }
        	
        }
       
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        
       WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
       
       wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
       
        String cartPageProduct = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
        Assert.assertEquals(cartPageProduct, "Jordan 6 Rings");
		Thread.sleep(2000);

		
	}
	

}
