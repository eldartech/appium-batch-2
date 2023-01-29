package utils;

import io.appium.java_client.android.AndroidElement;

import java.util.ArrayList;
import java.util.List;

public class AndroidElementUtil {
    public static List<String> getTexts(List<AndroidElement> elements){
        List<String> result = new ArrayList<>();
        for (AndroidElement element: elements){
            result.add(element.getText());
        }
        return result;
    }
}
