package android.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
@Getter
public class ViewsPage {
    public ViewsPage(AndroidDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(className = "android.widget.TextView")
    private List<AndroidElement> viewsOptions;

    @AndroidFindBy(accessibility = "Expandable Lists")
    private AndroidElement expandableLists;

    @Getter
    public static class ExpandableList{
        public ExpandableList(AndroidDriver driver){
            PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        }
        @AndroidFindBy(accessibility = "1. Custom Adapter")
        private AndroidElement customAdapter;

        @AndroidFindBy(uiAutomator = "text(\"People Names\")")
        private AndroidElement peopleNames;

        @AndroidFindBy(className = "android.widget.TextView")
        private List<AndroidElement> peopleNamesOptions;
    }
}
