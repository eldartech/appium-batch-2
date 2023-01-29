package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class AndroidCapabilityUtil {
    static AndroidDriver<AndroidElement> driver;

    public static DesiredCapabilities getCapabilities(String deviceName,String app){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        File apkFile = new File(app);
        capabilities.setCapability(MobileCapabilityType.APP,apkFile.getAbsolutePath());
        return capabilities;
    }

    public static DesiredCapabilities getBrowserCapabilities(String deviceName){
        DesiredCapabilities capabilities = new DesiredCapabilities();
       // capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        capabilities.setBrowserName(BrowserType.CHROME);
        File chromeDriver = new File("/Users/techtorialacademy/IdeaProjects/appium-batch-2/src/test/resources/drivers/chromedriver 2");
        capabilities.setCapability("chromedriverExecutable",chromeDriver.getAbsolutePath());
        return capabilities;
    }
}
