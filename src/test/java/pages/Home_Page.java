package pages;
import base.appium.BaseAppium;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;


public class Home_Page extends BaseAppium{
    By fullNameInput = By.id("name");
    By button02 = By.id("com.sec.android.app.popupcalculator:id/bt_02");
    By buttonAdd = By.id("com.sec.android.app.popupcalculator:id/bt_add");
    By button03 = By.id("com.sec.android.app.popupcalculator:id/bt_03");
    By buttonEqual = By.id("com.sec.android.app.popupcalculator:id/bt_equal");
    By buttonResult = By.id("com.sec.android.app.popupcalculator:id/txtCalc");


    public Home_Page(AndroidDriver<AndroidElement> driver){
        super(driver);
    }
    public void sumTwoNumbers(){
//        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Echo Box']")));
        waitPresenceOfElementLocated(button02);
        click(button02);
        click(buttonAdd);
        click(button03);
        click(buttonEqual);
//        click(buttonEqual);
    }

}
