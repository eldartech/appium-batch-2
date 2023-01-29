package android.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
@Getter
public class HomePage {
    public HomePage(AndroidDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @FindBy(xpath = "//android.widget.TextView[@content-desc='App']")
    private WebElement app;

    @FindBy(id = "android:id/action_bar_container")
    private WebElement actionBar;

    @AndroidFindBy(accessibility = "Accessibility")
    private AndroidElement accessibility;

    @AndroidFindBy(uiAutomator = "text(\"Views\")")
    private AndroidElement views;

}
