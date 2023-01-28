package android.tests;

import android.pages.HomePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.AndroidCapabilityUtil;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HomePageTest {

    private static final String APPIUM = "http://localhost:4723/wd/hub";
    //                                   protocol://host:port/path
    private static final String APP = "src/test/resources/AppiumPractice.apk";
    AndroidDriver<AndroidElement> driver;
    HomePage homePage;
    @Before
    public void setCapabilities() throws MalformedURLException {
        URL appiumServer = new URL(APPIUM);
        driver = new AndroidDriver(appiumServer, AndroidCapabilityUtil.getCapabilities("tech",APP));
        homePage=new HomePage(driver);
    }
    //XPath
    @Test
    public void firstAppiumAndroidTest() {
        Assert.assertEquals("App",homePage.getApp().getText());
    }
    //ID
    @Test
    public void locatorIDTest(){
        Assert.assertTrue(homePage.getActionBar().isDisplayed());
    }
    //AccessibilityID
    @Test
    public void locatorAccessibilityIDTest(){
        Assert.assertEquals("Accessibility",homePage.getAccessibility().getText());
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
