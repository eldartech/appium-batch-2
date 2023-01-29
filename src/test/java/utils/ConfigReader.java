package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;
    static FileInputStream input;
    static{
        String fileName = "configuration.properties";
        try{
            input = new FileInputStream(fileName);
            properties = new Properties();
            properties.load(input);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static  String getProperty(String key){
        return properties.getProperty(key);
    }
}
