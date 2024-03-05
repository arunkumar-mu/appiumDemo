package apppiumtraining;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class iosBasics extends IosBaseTest

{
	@Test
	public void iosBaseTest()
	

	{
//		Xpath, ClassName, IOS, iosClassChain, IOSPredicateString, accessibilityId, Id
		
		driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \'Text Entry\'`]")).click();
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeAlert")).sendKeys("Bounteous");
		driver.findElement(AppiumBy.accessibilityId("OK")).click();
//		IOS predicate and iosClassChain string is most commonly used to speed up the execution
//		ways to determine predicateString
//		driver.findElement(AppiumBy.iOSNsPredicateString("type = 'XCUIElementTypeStaticText' AND value = 'Confirm / Cancel'"));
		driver.findElement(AppiumBy.iOSNsPredicateString("type = 'XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Confirm'")).click();
		
//		driver.findElement(AppiumBy.iOSNsPredicateString("type = 'XCUIElementTypeStaticText' AND value ENDSWITH 'Cancel'")).click();
		String text = driver.findElement(AppiumBy.iOSNsPredicateString("value BEGINSWITH[A] 'A message '")).getText();
		System.out.println(text);
		driver.findElement(AppiumBy.iOSNsPredicateString("name == \'Confirm\'")).click();
		
		

	
	}
	
	

}
