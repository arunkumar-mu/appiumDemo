package apppiumtraining;


import io.appium.java_client.AppiumBy;
import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.testng.annotations.Test;
import com.google.common.collect.ImmutableMap;


public class ScrollAction extends BaseTest{
	@Test
	
	public void scrollAction () throws MalformedURLException, InterruptedException 
	{
		
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
//		scrollToEndAndClickElement("//android.widget.TextView[@content-desc=\"ImageView\"]");
//		scrollToEndAction();
		
//		Where to scroll is known prior then use the below one - if not pulling java code from base test to performing scrolling
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"WebView\"));"));
		Thread.sleep(2000);
		

	}
}
