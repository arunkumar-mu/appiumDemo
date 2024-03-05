package apppiumtraining;


import io.appium.java_client.AppiumBy;
import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.options.UiAutomator2Options;
//import io.appium.java_client.service.local.AppiumDriverLocalService;
//import io.appium.java_client.service.local.AppiumServiceBuilder;
//import java.io.File;
//import java.net.MalformedURLException;
//import java.net.URL;

import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;


public class LongPressAction extends BaseTest{
	@Test
	
	public void LongPressGesture () throws MalformedURLException, InterruptedException 
	{
		
//		actual automation code
//		accessibilityId, Xpath, id, classname, AndroidUIAutomator
//		for classname(recommended by Appium), accessibilityId and AndroidUIAutomator use AppiumBy. for other we can simply use By.
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Expandable Lists\"]")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		
// Java for long press - taken from https://github.com/appium/appium-uiautomator2-driver/blob/master/docs/android-mobile-gestures.md
//		Storing the element which needs to be long pressed in variable using WebElement
		
		WebElement firstOne = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		
//		Calling long press action from base test
		longPressAction(firstOne);
		
//		Assertion to check values present after long press action
		
		String MenuName = driver.findElement(By.id("android:id/title")).getText();
		Assert.assertEquals(MenuName, "Sample menu");
		Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
		
		
	}
}
