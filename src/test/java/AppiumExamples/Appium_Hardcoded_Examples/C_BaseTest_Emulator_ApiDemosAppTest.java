package AppiumExamples.Appium_Hardcoded_Examples;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


// A base class (To start Appium Server & launch the emulator [AhmadDevice] to automate app [ApiDemos]) of our test cases.
public class C_BaseTest_Emulator_ApiDemosAppTest {
	
	public  AndroidDriver driver;
	public  AppiumDriverLocalService service;
	
	@BeforeClass   
	public  void startAppiumServer() 
	{
	    service= new AppiumServiceBuilder().withAppiumJS(new File("\\Users\\AE\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build(); 
		service.start(); 
		
	}
	
	
	
	public  void selectEmulator_launch_apiDemosApp() throws MalformedURLException, URISyntaxException
	{
		// "AndroidDriver" class to automate an Android App:
				UiAutomator2Options options= new UiAutomator2Options();
				options.setDeviceName("AhmadDevice");
				options.setApp("\\Users\\AE\\eclipse-workspace\\Appium_Hardcoded_Examples\\src\\test\\java\\resources\\ApiDemos-debug.apk"); 
			    driver= new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options); }
	
	// Add a future method to select a simulator and launch a specific app on it.
	
	
	@AfterMethod
	public void quitApp() 
	{
		driver.quit();  // Close the app in the emulator.
	}

	
	@AfterClass
	public void stopAppiumServer()
	{
		service.stop();   // Stopping the Appium Server. Port '4723' will no longer be blocked   
	}
 
}
	
	
	
	

