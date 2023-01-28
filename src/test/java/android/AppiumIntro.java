package android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class AppiumIntro {
    private static final String APPIUM = "http://localhost:4723/wd/hub";
    //                                   protocol://host:port/path
    private static final String APP = "src/test/resources/AppiumPractice.apk";
    AndroidDriver<AndroidElement> driver;
    @Before
    public void setCapabilities() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "tech");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        File apkFile = new File(APP);
        capabilities.setCapability("app",apkFile.getAbsolutePath());
        // same as capabilities.setCapability("app",new File(APP));
        URL appiumServer = new URL(APPIUM);
        driver = new AndroidDriver(appiumServer,capabilities);
    }
    //XPath
    @Test
    public void firstAppiumAndroidTest() {
        System.out.println(driver.getConnection());
        System.out.println(driver.getPageSource());
        WebElement app = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='App']"));
        System.out.println(app.getText());
        Assert.assertEquals("App",app.getText());
    }
    //ID
    @Test
    public void locatorIDTest(){
        WebElement apiDemos = driver.findElementById("android:id/action_bar_container");
        System.out.println(apiDemos.getText());
        Assert.assertTrue(apiDemos.isDisplayed());
    }
    //AccessibilityID
    @Test
    public void locatorAccessibilityIDTest(){
        WebElement accessibility = driver.findElementByAccessibilityId("Accessibility");
        System.out.println(accessibility.getText());
        Assert.assertEquals("Accessibility",accessibility.getText());
    }

    // AndroidUIAutomator
    @Test
    public void locatorAndroidUIAutomatorTest(){
        driver.findElementByAccessibilityId("App").click();
        WebElement actionBar = driver.findElementByAndroidUIAutomator("text(\"Action Bar\")");
        System.out.println(actionBar.getText());
        Assert.assertEquals("Action Bar",actionBar.getText());
    }

    //class name
    @Test
    public void locatorClassNameTest(){
        driver.findElementByAccessibilityId("App").click();
        List<AndroidElement> options = driver.findElementsByClassName("android.widget.TextView");
        List<String> optionTexts = new ArrayList<>();
        for (AndroidElement option:options){
            optionTexts.add(option.getText());
        }
        List<String> expectedOptionTexts = List.of("API Demos", "Action Bar", "Activity", "Alarm", "Alert Dialogs", "Device Admin", "Fragment", "Launcher Shortcuts", "Loader", "Menu", "Notification", "Search", "Service", "Text-To-Speech");
        Assert.assertEquals(expectedOptionTexts,optionTexts);

    }
}
