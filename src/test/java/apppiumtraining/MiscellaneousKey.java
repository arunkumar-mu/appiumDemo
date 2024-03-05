package apppiumtraining;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
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


public class MiscellaneousKey extends BaseTest{
	@Test
	
	public void WifiSettingsName () throws MalformedURLException, InterruptedException 
	{
		
//    MAC- To locate exact page - adb shell dumpsys window | grep -E 'mCurrentFocus' 
//		Activity activity = new Activity("io.appium.android.api", "io.appium.android.apis.preference.PreferenceDependencies");
//		driver.startActivity(activity); - it is no longer workable by Appium - follow the below one to execute desired pages
		
	 ((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent", "io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"));
		
//		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
//		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\'3. Preference dependencies\']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
//		DeviceRotation landscape = new DeviceRotation(0,0,90);
//		driver.rotate(landscape);
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String readtext = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(readtext, "WiFi settings");
		Thread.sleep(2000);
		driver.setClipboardText(readtext);
		Thread.sleep(1000);
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		Thread.sleep(2000);
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.HOME));

		
	}
}
