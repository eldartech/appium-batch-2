package android.pages.generalStore;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import org.apache.tools.ant.Main;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter
public class MainPage {
    public MainPage(AndroidDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id = "android:id/text1")
    private AndroidElement countryDropDown;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(text(\"Brazil\"));")
    private AndroidElement brazil;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    private AndroidElement nameInput;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    private AndroidElement letsShopButton;

    @AndroidFindBy(uiAutomator = "text(\"ADD TO CART\")")
    private List<AndroidElement> productList;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
    private AndroidElement cart;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
    private AndroidElement proceedButton;
}
