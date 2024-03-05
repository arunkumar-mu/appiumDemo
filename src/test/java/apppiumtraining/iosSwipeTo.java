package apppiumtraining;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import org.testng.Assert;

public class iosSwipeTo extends IosBaseTest

{
	@Test
	public void iosSwipe() throws InterruptedException
	

	{
		WebElement slider = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSlider[`name == \'AppElem\'`]"));
		slider.sendKeys("o%");
		Assert.assertEquals("0%",slider.getAttribute("value"));
		Thread.sleep(3000);
		slider.sendKeys("1%");
		Assert.assertEquals("100%",slider.getAttribute("value"));

		
		


	
	}
	
	

}
