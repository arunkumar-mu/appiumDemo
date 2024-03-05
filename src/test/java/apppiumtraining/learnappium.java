package apppiumtraining;


import io.appium.java_client.AppiumBy;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.Assert;

//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.options.UiAutomator2Options;
//import io.appium.java_client.service.local.AppiumDriverLocalService;
//import io.appium.java_client.service.local.AppiumServiceBuilder;
//import java.io.File;
//import java.net.MalformedURLException;
//import java.net.URL;

import org.testng.annotations.Test;


public class learnappium extends BaseTest{
	@Test
	
	public void WifiSettingsName () throws MalformedURLException 
	{
		
//		actual automation code
//		accessibilityId, Xpath, id, classname, AndroidUIAutomator
//		for classname(recommended by Appium), accessibilityId and AndroidUIAutomator use AppiumBy. for other we can simply use By.
		
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\'3. Preference dependencies\']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		
//		Validate available values using assertion
		
		String readtext = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(readtext, "WiFi settings");
		driver.findElement(By.id("android:id/edit")).sendKeys("my first code");
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		
	}
}
