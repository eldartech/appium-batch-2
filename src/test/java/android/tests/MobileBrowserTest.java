package android.tests;

import android.pages.generalStore.MainPage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AndroidCapabilityUtil;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MobileBrowserTest {
    private static final String APPIUM = "http://localhost:4723/wd/hub";
    AndroidDriver<AndroidElement> driver;

    @Before
    public void setCapabilities() throws MalformedURLException {
        URL appiumServer = new URL(APPIUM);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "tech");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,600);
        capabilities.setBrowserName(BrowserType.CHROME);
        File chromeDriver = new File("/Users/techtorialacademy/IdeaProjects/appium-batch-2/src/test/resources/drivers/chromedriver");
        capabilities.setCapability("chromedriverExecutable",chromeDriver.getAbsolutePath());
        driver = new AndroidDriver(appiumServer, capabilities);
    }
    @Test
    public void amazonTest(){
        driver.navigate().to("https://amazon.com");
        Assert.assertEquals("",driver.getTitle());
    }
}
