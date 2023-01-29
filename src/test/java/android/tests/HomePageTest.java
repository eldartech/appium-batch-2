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

    @Test
    public void locatorAccessibilityIDTest(){
        Assert.assertEquals("Accessibility",homePage.getAccessibility().getText());
    }



}
