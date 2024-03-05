package apppiumtraining;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class iosLongPress extends IosBaseTest

{
	@Test
	public void iosBaseTest()
	

	{
		driver.findElement(AppiumBy.accessibilityId("Steppers")).click();
		WebElement ele = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"Increment\"`][3]"));
		touchAndHold(ele);
		

	
	}
	
	

}
