package AppiumExamples.Appium_Hardcoded_Examples;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class D_navigationTest extends  C_BaseTest_Emulator_ApiDemosAppTest {

	// Below a method/ test case to click on the "Preference" button.
	@Test
	public void navigateToPreferenceButton( ) throws MalformedURLException, URISyntaxException 
	{
		selectEmulator_launch_apiDemosApp();
		driver.findElement(AppiumBy.accessibilityId("Preference")).click(); // Will not need: this.driver= driver; since 'driver' is contained in selectEmulator_launch_apiDemosApp();                                                                   // .However; if this is the first line in this method/ test case, then this.driver=driver is needed 

	}
	
	
	//below a method/test case to click on the "Graphics" button.
	@Test
	public void navigateToGraphicsButton() throws MalformedURLException, URISyntaxException
	{
		selectEmulator_launch_apiDemosApp();
		driver.findElement(AppiumBy.accessibilityId("Graphics")).click();
		 
	}
	
	
	 
}
