package AppiumExamples.Appium_Hardcoded_Examples;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;

/*                      ************************************** READ ME FIRST ***************************************
 *          Mobile gestures are: Long Pressing, Drag & Drop, Scrolling, Swiping, & Pinching.
 *          
 * Appium library developers have provided excellent documentation with code samples for automating mobile gestures for Android.
 * 
 * It can be found on Appium official website: (Also, web page is saved under this project/ where the pom.xml file is)
 * https://github.com/appium/appium-uiautomator2-driver/blob/master/docs/android-mobile-gestures.md (As of now) or simply google "Appium github gestures"
 * 
 * For one of the gestures, of Long pressing, the following sample code is provided:
 * 
 * 
         ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
              "elementId", ((RemoteWebElement) element).getId()
         ));
 * 
 *  So, according to this sample code, the JavaScript code of:
 * 
 *   "mobile: longClickGesture", ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "duration", 2000) 
 *    has to be injected into our Appium code using the .executeScript() method.
 * 
 * 
 * . Also, this JavaScript code has 2 parameters:
 * 
 *   1st Parameter:    "mobile: longClickGesture"     [Is called an event (The event of long clicking in this case) ]
 *   
 *   2nd Parameter:     ImmutableMap.of("elementId", ((RemoteWebElement) element).getId()
 *                      
 *                      is a map of Key:Value
 *                      
 *                      key:   "elementId"
 *                      Value: ((RemoteWebElement) element).getId()   [On which element we're going to apply the long click,
 *                                                                     where element is identified by either a locator (Any type) or by a coordinate.
 *                                                                     
 *                                                                     
 *   3rd parameter:  (Better to add a 2nd map of Key:Value for how long to press)
 *   
 *                    Key:  "duration"
 *                    Value: in milliseconds 
 * 
 * 
 */
public class G_longPress_javaScriptExecutorTest extends C_BaseTest_Emulator_ApiDemosAppTest {
	
	@Test
	public void longPressGesture() throws MalformedURLException, URISyntaxException
	{
		selectEmulator_launch_apiDemosApp();
		// 1- Click on 'views':
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		//2- Click on 'Expandable Lists':
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		//3- Click on 'Customer Adapter':
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		//4- Long press on 'People Names': [As a result, a pop-up appears].
		
	    WebElement element= driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"People Names\")"));
	    		
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
		    "elementId", ((RemoteWebElement) element).getId(), "duration", 2000
		));  // long press for 2 seconds.
		
		
		
		// Now this method/test case can be improved as illustrated in the below method/test case:==>
	}

}
