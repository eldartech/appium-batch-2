package android.tests;

import android.pages.HomePage;
import android.pages.ViewsPage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AndroidCapabilityUtil;
import utils.AndroidElementUtil;

import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GestureTest {

    private static final String APPIUM = "http://localhost:4723/wd/hub";
    //                                   protocol://host:port/path
    private static final String APP = "src/test/resources/AppiumPractice.apk";
    AndroidDriver<AndroidElement> driver;
    HomePage homePage;
    TouchAction action;
    ViewsPage viewsPage;
    WebDriverWait wait;
    ViewsPage.ExpandableList expandableList;
    @Before
    public void setCapabilities() throws MalformedURLException {
        URL appiumServer = new URL(APPIUM);
        driver = new AndroidDriver(appiumServer, AndroidCapabilityUtil.getCapabilities("tech", APP));
        //implicit wait
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //explicit wait
        wait=new WebDriverWait(driver,3);
        homePage = new HomePage(driver);
        viewsPage = new ViewsPage(driver);
        action = new TouchAction(driver);
        expandableList = new ViewsPage.ExpandableList(driver);
    }

    @Test
    public void touchActionIntroTest() {
        action.tap(TapOptions.tapOptions().withElement(ElementOption.element(homePage.getViews()))).perform();
        List<String> expectedList = List.of("API Demos", "Animation", "Auto Complete", "Buttons", "Chronometer",
                "Controls", "Custom", "Date Widgets", "Drag and Drop", "Expandable Lists", "Focus", "Gallery",
                "Game Controller Input", "Grid");
        Assert.assertEquals(expectedList, AndroidElementUtil.getTexts(viewsPage.getViewsOptions()));
    }

    @Test
    public void touchActionTest() {
        action.tap(TapOptions.tapOptions().withElement(ElementOption.element(homePage.getViews()))).perform();
        action.tap(TapOptions.tapOptions().withElement(ElementOption.element(wait.until(ExpectedConditions.visibilityOf(viewsPage.getExpandableLists()))))).perform();
        action.tap(TapOptions.tapOptions().withElement(ElementOption.element(wait.until(ExpectedConditions.visibilityOf(expandableList.getCustomAdapter()))))).perform();
        action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(expandableList.getPeopleNames()))).perform();
        Assert.assertEquals(Arrays.asList("Sample menu", "Sample action"),AndroidElementUtil.getTexts(expandableList.getPeopleNamesOptions()));
    }
}
