package AppiumExamples.Appium_Hardcoded_Examples;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AppiumEmulatorBasicsTest {
	
	@Test
	public void appiumEmulatorBasics() throws MalformedURLException, URISyntaxException
	{
		/* Pre-conditions:
		   1-Manually start the Appium server (So that, it is 'listening').
		   2- Launch Android Studio.
		   3- Start the virtual device you want to run this script on.
		   4- Include the android .apk installer under a 'resources' package.   
		   [If any of these 4 steps isn't performed, script will throw an exception].
		   
		   [Note: The first 3 steps will be automated in this method/ test case in future].
		  */
		
		// "AndroidDriver" class to automate an Android App:
		UiAutomator2Options options= new UiAutomator2Options();
		options.setDeviceName("AhmadDevice"); // From Android Studio, where I created an emulator.
		options.setApp("C:\\Users\\AE\\eclipse-workspace\\Appium_Hardcoded_Examples\\src\\test\\java\\resources\\ApiDemos-debug.apk"); 
		//Above: Project-embedded Installer path. App will be installed on emulator the 1st time this line is executed. Path will be made dynamic in future.
		//Plus another 'options' step for specifying device version IF you have another emulator with the same device name. 
		
		AndroidDriver driver= new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options); // URL Syntax as of Java 17.
		// 1st argument: URL of the Server, that's currently running: http://127.0.0.1:4723 (Fixed local machine IP address)
		// Port number: If in doubt, consult the logs when launching the Appium server.
		//2nd argument: Which specific device in Android Studio, this script will run on ?
		
		driver.quit(); // to close the App in the emulator.
		//Now, all related logs will be displayed in the running Appium server Node.js command prompt.
	}

}
