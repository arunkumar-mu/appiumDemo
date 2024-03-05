package apppiumtraining;

import java.io.File;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


public class IosInBuiltAppBaseConfig {
	
	public IOSDriver driver;
	
	public AppiumDriverLocalService service;
	@BeforeClass
	
	public void ConfigureAppium() throws MalformedURLException
	{

		
		XCUITestOptions options = new XCUITestOptions();
		options.setDeviceName("iPhone 15");

		options.setPlatformVersion("17.2");
//		Appium- Webdrvier Agent ->IOS Apps.
		options.setWdaLaunchTimeout(Duration.ofMillis(20));
		
		
		driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
     public void touchAndHold(WebElement ele)
     {
    	 Map <String,Object> params = new HashMap <>();
 		params.put( "elementId", ((RemoteWebElement) ele).getId());
 		params.put("duration", 5);
 		driver.executeScript("mobile:touchAndHold", params);
     }
     
     public void scrollToSelect(WebElement ele)
     {
    	 Map <String,Object> params = new HashMap <>();
 		params.put( "elementId", ((RemoteWebElement) ele).getId());
 		params.put("direction", "down");
 		driver.executeScript("mobile:scroll", params);
     }
	
	@AfterClass
	
	public void TearDown()
	{
		driver.quit();
//		service.stop();
	}

}
