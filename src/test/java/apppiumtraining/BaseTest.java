package apppiumtraining;

import java.io.File;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

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
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	
	public AndroidDriver driver;
	
	public AppiumDriverLocalService service;
	@BeforeClass
	
	public void ConfigureAppium() throws MalformedURLException
	{
//		code to run appium server automatically - not working check with peers
		
		
//		AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
//		.withIPAddress("127.0.0.1").usingPort(4723).build();
		
//		service.start();
		
		UiAutomator2Options options = new UiAutomator2Options();
		
		options.setDeviceName("ArunPhone");
		options.setChromedriverExecutable("/Users/arunkumar.muniasekaran/Library/CloudStorage/OneDrive-Bounteous/Documents/chromedriver_mac_arm64/chromedriver");
		
//		options.setApp("//Users//arunkumar.muniasekaran//eclipse-workspace//appium//src//test//java//utils//ApiDemos-debug.apk");
		options.setApp("//Users//arunkumar.muniasekaran//eclipse-workspace//appium//src//test//java//utils//General-Store.apk");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
//	Long press action - pre-defined code given by Appium
	
	public void longPressAction(WebElement ele)
	{
	
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) ele).getId(), "duration", 2000));
	}
	
//	When we don't know to where to scroll or no prior idea
	public void scrollToEndAction()
	{
		boolean canScrollMore = true;
		do
		{
		canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
		    "left", 500, "top", 500, "width", 600, "height", 600,
		    "direction", "down",
		    "percent", 25.0
		));
		}while (canScrollMore);
	}
	
//	to select element while scrolling - check with experts
	
//	public void scrollToEndAndClickElement(String elementLocator) 
//	{
//	    boolean elementFound = false;
//	    
//	    boolean canScrollMore = true; // Declare canScrollMore variable outside the loop
//	    do {
//	        // Execute scroll gesture
//	        canScrollMore = (Boolean)((JavascriptExecutor)driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
//	                "left", 500, "top", 500, "width", 600, "height", 600,
//	                "direction", "down",
//	                "percent", 50.0
//	        ));
//
//	        // Check if the element is found
//	        if (!elementFound && canScrollMore) { // Check if canScrollMore is true before trying to find the element
//	            try {
//	                // Find the element
//	                WebElement element = driver.findElement(By.xpath(elementLocator));
//
//	                // Click on the element
//	                element.click();
//
//	                // Set elementFound to true to exit the loop
//	                elementFound = true;
//	            } catch (NoSuchElementException e) {
//	                // Log the exception or print a message for debugging
//	                System.out.println("Element not found: " + e.getMessage());
//	                // Element not found, continue scrolling
//	            }
//	        }
//	    } while (!elementFound && canScrollMore); // Loop until the element is found and can still scroll
//	}
	
	public Double getFormattedAmount(String amount)
	{
		Double price = Double.parseDouble(amount.substring(1));
		return price;
	}

	public void swipeAction(WebElement ele, String direction)
	{
		// Swipe - Java - from Appium github
		
	    ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
	    		"elementId", ((RemoteWebElement)ele).getId(),
	        "direction", direction,
	        "percent", 0.25
	    ));
	}
	
	@AfterClass
	
	public void TearDown()
	{
		driver.quit();
//		service.stop();
	}

}
