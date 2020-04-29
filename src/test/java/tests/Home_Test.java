package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.Home_Page;

public class Home_Test {
    private AndroidDriver<AndroidElement> driver;
    Home_Page TestHomePage;
    private String platformVersion = "4.4.2";
    private String deviceName = "Tablet";
    private String udid = "192.168.0.6:5555";
    private String automationName = "UiAutomator1";
    private String appPackage = "com.sec.android.app.popupcalculator";
    private String appActivity = "com.sec.android.app.popupcalculator.Calculator";

    @Before
    public void setUp(){
        TestHomePage = new Home_Page(driver);



        driver = (AndroidDriver<AndroidElement>) TestHomePage.androidDriverConnection(platformVersion,deviceName,udid,
                automationName,appPackage,appActivity);

//        url = "https://formy-project.herokuapp.com/switch-window";
//        FormyScrollElementPage.goTo(url);
    }

    @Test
    public void test() throws InterruptedException {
        System.out.println("test calculator");
        TestHomePage.sumTwoNumbers();

    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
