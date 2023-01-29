package android.tests.apiDemos;

import android.pages.apiDemos.HomePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utils.AndroidCapabilityUtil;

import java.net.MalformedURLException;
import java.net.URL;

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
