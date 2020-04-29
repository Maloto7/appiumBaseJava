package base.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.URL;

public class BaseAppium {

    private WebDriverWait wait;
    private AndroidDriver<AndroidElement> driver = null;
    private static String appiumServer = "http://localhost:4723/wd/hub";

    public BaseAppium(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
    }

    public AppiumDriver androidDriverConnection(String platformVersion, String deviceName,String udid,
                                                String automationName,String appPackage,String appActivity ){
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", "Android");
            caps.setCapability("platformVersion", platformVersion);
            caps.setCapability("deviceName", deviceName);
            caps.setCapability("udid", udid);
            caps.setCapability("automationName", automationName);
            caps.setCapability("appPackage", appPackage);
            caps.setCapability("appActivity", appActivity);
            //      caps.setCapability("app", APP);
            driver = new AndroidDriver<AndroidElement>(new URL(appiumServer), caps);
            this.wait = new WebDriverWait(driver,20);
        }
        catch(Exception e)
        {
            System.out.println("Cause is: " + e.getCause());
            System.out.println("Message is: " + e.getMessage());
            e.printStackTrace();
        }
        return driver;
    }
    public void waitPresenceOfElementLocated(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void click(By locator){
        driver.findElement(locator).click();
    }
}
