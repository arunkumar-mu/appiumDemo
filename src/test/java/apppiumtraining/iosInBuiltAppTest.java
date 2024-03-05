package apppiumtraining;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import org.testng.Assert;

public class iosInBuiltAppTest extends IosInBuiltAppBaseConfig

{
	@Test
	public void iosDefualtApp() 
	

	{
		Map<String,String> params = new HashMap<String,String>();
		params.put("bundleId", "com.apple.mobileslideshow");
		driver.executeScript("mobile:launchApp",params);
        driver.findElement(AppiumBy.iOSNsPredicateString("label == 'All Photos'")).click();
        List <WebElement> allphotos = driver.findElements(AppiumBy.iOSClassChain("**/XCUIElementTypeCell"));
        System.out.println(allphotos.size());
        driver.findElement(AppiumBy.xpath("//XCUIElementTypeCell[1]")).click();
        
        for(int i=0; i<allphotos.size(); i++)
        {
        System.out.println(driver.findElement(AppiumBy.xpath("//XCUIElementTypeNavigationBar")).getAttribute("name"));
        Map<String,Object> params1 = new HashMap<String,Object>();
        params1.put("direction", "left");
//      params1.put("element",((RemoteWebElement)ele.getid()); - we are not using this, as we are not looking for any specific element
        driver.executeScript("mobile:swipe", params1);
        }
        driver.navigate().back();
        driver.findElement(AppiumBy.accessibilityId("Albums")).click();
	}
	
	

}
