import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class CalculatorTest1 {
    //    static AppiumDriver driver;
    static AndroidDriver<MobileElement> driver;
//    private static final String APP = "https://github.com/cloudgrey-io/the-app/releases/download/v1.9.0/TheApp-v1.9.0.apk";
//    private static final String APP = "D:/Cursos/linkedin/testing/1-Mobile Testing With Appium/TheApp-v1.9.0.apk";
    private static final String APP = "..";

    private static String appiumServer = "http://localhost:4723/wd/hub";
    public static void main(String[] args){
        try {
            openCalculator();
        } catch (Exception e) {
            System.out.println("cause:  " + e.getCause());
            System.out.println("message:  " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void openCalculator() throws Exception{
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "4.4.2");
        caps.setCapability("deviceName", "Sarita");
        caps.setCapability("udid", "192.168.0.6:5555");
        caps.setCapability("automationName", "UiAutomator1");
        caps.setCapability("appPackage", "com.sec.android.app.popupcalculator");
        caps.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
//        caps.setCapability("app", APP);
//        driver = new AppiumDriver(new URL(appiumServer),caps);
        driver = new AndroidDriver<MobileElement>(new URL(appiumServer),caps);
//        driver = new AndroidDriver(new URL(APPIUM), caps);
        System.out.println("start Calculator ........");

//        MobileElement two = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_02"));
        MobileElement twoB = driver.findElement(MobileBy.AccessibilityId("2"));
        MobileElement plus = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_add"));
        MobileElement three = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_03"));
        MobileElement equals = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_equal"));
        MobileElement result = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/txtCalc"));

        twoB.click();
        plus.click();
        three.click();
        equals.click();
        String res = result.getText();
        System.out.println("result " + res);

    }
}
