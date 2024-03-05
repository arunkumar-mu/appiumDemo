package apppiumtraining;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import org.testng.Assert;

public class eCommerce_t5 extends BaseTest{
	@Test
	
	public void successfulPurchase () throws InterruptedException
	
	{
		
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Austria\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Austria\"]")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Vaishu");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
//      using index [0] because once the first click is done, for the first product text gets changed to added to cart. 
//		So on the second run, the next item will be index[0]
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        // code to wait until the page completely loads
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
        WebElement longPress = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
        longPressAction(longPress);
        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(By.className("android.widget.CheckBox")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
        Thread.sleep(1000);
//      while using hybrid app - we must set context while switching from native to browser - so that we can perform action on Browser
//      Here we are using getContextHandles to get exact context name of browser by using following method
        Set<String> contexts = driver.getContextHandles();
//      After getting list of contexts available for an hybridApp using enhanced for loop we are printing the data
        for(String context: contexts)
        {
        	System.out.println(context);
        }
//      configuring exact context of browser
        driver.context("WEBVIEW_com.androidsample.generalstore"); // configure chrome driver in base test
//      Even though an hybrid app launches browser within app, it is similar to normal browser behaviour. 
//       By selenium concepts we are fetching details of element from web browsers directly- as we are seeing chrome here
        driver.findElement(By.name("q")).sendKeys("Bounteous Technologies");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.context("NATIVE_APP");


	}
	

}
