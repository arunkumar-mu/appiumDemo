package apppiumtraining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import org.testng.Assert;

public class eCommerce_t1 extends BaseTest{
	@Test
	
	public void fillform() throws InterruptedException
	
	{
		
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Austria\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Austria\"]")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Vaishu");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
//	for capturing toast message  - there is a default tag name to build xpath which is android.widget.Toast - Use getAtrribute("name) - name stands here
//		text present in toast message. PS: getText wont work here, as we are manually configuring
//		String toastName = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
//		Assert.assertEquals(toastName, "Please enter your name");
		
		
		Thread.sleep(2000);

		
	}
	
	
	
	

}
