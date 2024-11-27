package AppiumExamples.Appium_Hardcoded_Examples;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class D_navigationTest extends  C_BaseTest_Emulator_ApiDemosAppTest {

	@Test
	public void navigate( ) throws MalformedURLException, URISyntaxException 
	{
		//D_navigationTest ob= new D_navigationTest(); // 1- This is IMPERATIVE ONLY if you're using the plain by default Java compiler (Public static void main args[])
		                                              // and in this case, this.driver= driver; is to be used.
		startAppiumServer();
		selectEmulator_launch_apiDemosApp();
		
		driver.findElement(AppiumBy.accessibilityId("Preference")).click(); // Will not need: this.driver= driver; since 'driver' is contained in selectEmulator_launch_apiDemosApp();                                                                   // .However; if this is the first line in this method/ test case, then this.driver=driver is needed 
		tearDown();	
	}
	
	/*Based on the above method/ test case:
	 * 
	 * One has to call these 3 methods OR at least the 2 methods (Of starting Appium Server & the tear down one) in
	 * every single future method/ test case. This will render the code unoptimized/ bad for future maintenance [As
	 * the exact same lines of code/ methods are repeated in every single method/ test case !]
	 * 
	 * This is where TestNG annotations come into play [As illustrated in the subsequent branch of this project in GIT]
	 */
	  
	 
}
