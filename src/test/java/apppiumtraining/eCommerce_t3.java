package apppiumtraining;

import java.time.Duration;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import org.testng.Assert;

public class eCommerce_t3 extends BaseTest{
	@Test
	
	public void validateSumOfCart () throws InterruptedException
	
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
//        using findelements to locate 'id' which are more than 1 in the page
//        WebElement is used to store data got by below - using List since we are fetching more than one element from the page
        List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));	
//        storing as int - using size to get count of elements on page load - which is 2
        int Count = productPrices.size();
//       use this to sum in loop
        double totalSum = 0;
        
        for(int i=0; i<Count; i++)
        {
        	String amountString = productPrices.get(i).getText(); // first iteration i=1 which get price of first product using getText followed by i=2 
//      getFormattedAmount will come from base class - it deals with changing string to double
        	double individualprice = getFormattedAmount(amountString); 
        	totalSum = totalSum + individualprice; // 1st iteration totalSum = 0+ 160.97, 2nd iteration 160.97+120.0
        }
        
         String sumValue =  driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
         double finalValue  = getFormattedAmount(sumValue);
         Assert.assertEquals(finalValue, totalSum );
//        
	}
	

}
