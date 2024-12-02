package AppiumExamples.Appium_Hardcoded_Examples;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;

                /////////////////////////// UNDER CONSTRUCTION/ BRAINSTORMING ///////////////////////////
public class H_JavaHeavy_validationsTest extends  C_BaseTest_Emulator_ApiDemosAppTest {
	
	@Test
	public void javaHeavyValidations() throws MalformedURLException, URISyntaxException
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
		
		//5-   Do all of the above:  A- with regular plain Java (Non- optimized code)  &   2- with optimized code utilizing JavaStreams.
		       //1- Ensure that pop-up contains the text of 'Sample menu'. 
		      // 2- In the pop-up, ensure that it ONLY contains the options of "Sample menu" & "Sample action" (In the exact same order).
		     //  3- Then, with no consideration for order.
		    //   4- Then, in the pop-up, ensure it AT LEAST contains "Sample menu" & "Sample action" with the additional value(s), if any, not being null.
		   //    5- Then, pop-up does Not contain any null value
		  //     6- Ensure that there are 2 elements with the exact same texts. (Plus, at least 2, more than 2, etc.) 
		  
		
		List<String> expected_arrayList= Arrays.asList("Sample action","Sample menu");
		ArrayList<String> actual_arrayList= new ArrayList<String>();
		
		List<WebElement> elements= driver.findElements(By.xpath("//android.widget.TextView[@resource-id='android:id/title']"));
		for(int i=0; i< elements.size(); i++)
		{
			String popUpText= elements.get(i).getText();
			actual_arrayList.add(popUpText);   // separate reminder:   System.out.println(actual_arrayList)  displayed elements with [] brackets.
		}
		
		// 1-   
		String expectedText= "Sample menu";
		Assert.assertTrue(actual_arrayList.contains(expectedText), "Pop-up does NOT contain the text of: '" + expectedText + "' .It instead contains: "+ actual_arrayList);
		//Checkout the below methods + the related unlisted others:===>
        //Assert.assertListContains(null, null, expectedText)   
        //Assert.assertListNotContains(null, null, expectedText)
	
		
		//2-
		Assert.assertEquals(actual_arrayList,expected_arrayList, "The actual list does NOT match with the expected one" ); // Order is considered.
		
		
		
		/* Below to look at at the end:
		String expected_firstOption= "Sample menu";;
		String actual_firstOption= driver.findElement(By.xpath("(//android.widget.TextView[@resource-id='android:id/title'])[1]")).getText();
		Assert.assertEquals(actual_firstOption, expected_firstOption, "In 'People Name' pop-up, text displayed is the wrong one");  */
	
		
	}

}
