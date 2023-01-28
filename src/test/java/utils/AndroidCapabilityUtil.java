package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
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
}
