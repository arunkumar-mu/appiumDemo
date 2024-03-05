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

public class BrowserBaseTest {
	
	public AndroidDriver driver;
	
	public AppiumDriverLocalService service;
	@BeforeClass
	
	public void ConfigureAppium() throws MalformedURLException
	{
		
		UiAutomator2Options options = new UiAutomator2Options();
		
		options.setDeviceName("ArunPhone");
		options.setChromedriverExecutable("/Users/arunkumar.muniasekaran/Library/CloudStorage/OneDrive-Bounteous/Documents/chromedriver_mac_arm64/chromedriver");
		options.setCapability("browserName", "Chrome");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public Double getFormattedAmount(String amount)
	{
		Double price = Double.parseDouble(amount.substring(1));
		return price;
	}
	
	@AfterClass
	
	public void TearDown()
	{
		driver.quit();
//		service.stop();
	}

}
