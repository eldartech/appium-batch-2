package android.tests.generalStore;

import android.pages.apiDemos.HomePage;
import android.pages.apiDemos.ViewsPage;
import android.pages.generalStore.MainPage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AndroidCapabilityUtil;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MainPageTest {
    private static final String APPIUM = "http://localhost:4723/wd/hub";
    private static final String APP = "src/test/resources/Store.apk";
    AndroidDriver<AndroidElement> driver;
    TouchAction action;
    WebDriverWait wait;
    MainPage mainPage;
    @Before
    public void setCapabilities() throws MalformedURLException {
        URL appiumServer = new URL(APPIUM);
        driver = new AndroidDriver(appiumServer, AndroidCapabilityUtil.getCapabilities("tech", APP));
        //implicit wait
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //explicit wait
        wait=new WebDriverWait(driver,3);
        action = new TouchAction(driver);
        mainPage = new MainPage(driver);
    }

    @Test
    public void storeTest1() throws InterruptedException {
        action.tap(TapOptions.tapOptions().withElement(ElementOption.element(mainPage.getCountryDropDown()))).perform();
        action.tap(TapOptions.tapOptions().withElement(ElementOption.element(mainPage.getBrazil()))).perform();
        mainPage.getNameInput().click();
        mainPage.getNameInput().setValue("appium");
        driver.hideKeyboard();
        action.tap(TapOptions.tapOptions().withElement(ElementOption.element(mainPage.getLetsShopButton()))).perform();
        action.tap(TapOptions.tapOptions().withElement(ElementOption.element(mainPage.getProductList().get(0)))).perform();
        action.tap(TapOptions.tapOptions().withElement(ElementOption.element(mainPage.getCart()))).perform();
        action.tap(TapOptions.tapOptions().withElement(ElementOption.element(mainPage.getProceedButton()))).perform();
        System.out.println(driver.getContext());
        Thread.sleep(600);
        System.out.println(driver.getContextHandles());




    }


}
