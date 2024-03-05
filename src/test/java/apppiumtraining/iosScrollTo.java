package apppiumtraining;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import org.testng.Assert;

public class iosScrollTo extends IosBaseTest

{
	@Test
	public void iosBaseTest() throws InterruptedException
	

	{
		WebElement ele = driver.findElement(AppiumBy.accessibilityId("Web View"));
		scrollToSelect(ele);
		driver.findElement(AppiumBy.accessibilityId("Web View")).click();
		Thread.sleep(2000);
	    driver.findElement(By.xpath("//XCUIElementTypeButton[@name='UIKitCatalog']")).click();
		driver.findElement(AppiumBy.accessibilityId("Picker View")).click();
		driver.findElement(AppiumBy.accessibilityId("Red color component value")).sendKeys("30");
		driver.findElement(AppiumBy.accessibilityId("Green color component value")).sendKeys("215");
		driver.findElement(AppiumBy.accessibilityId("Blue color component value")).sendKeys("130");
        String text = driver.findElement(AppiumBy.accessibilityId("Blue color component value")).getText();
        Assert.assertEquals(text, "130");




	
	}
	
	

}
