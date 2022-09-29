package org.example;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;

public class BaseClass {

    static AndroidDriver driver;

    @BeforeTest
    public void setupApk() {
        try {
            DesiredCapabilities cap = new DesiredCapabilities();

            cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1");
            cap.setCapability(MobileCapabilityType.APP, "C:\\Users\\Lenovo\\Downloads\\Android UI Programming_1.0_Apkpure.apk");
            cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");

            URL url = new URL("http://localhost:4723/wd/hub");
            driver = new AndroidDriver(url, cap);
        }
        catch(Exception e){
            System.out.println("Cause is :"+e.getCause());
            System.out.println("Message is :"+e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void Test() {
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.TextView[2]")).click();
        TouchAction action = new TouchAction(driver);
//        Chick corea
        for(int i=0;i<8;i++) {
            WebElement source = driver.findElements(By.id("com.mobeta.android.demodslv:id/drag_handle")).get(i);
            WebElement target = driver.findElements(By.id("com.mobeta.android.demodslv:id/drag_handle")).get(i + 2);
            action.longPress(ElementOption.element(source)).moveTo(ElementOption.element(target)).release().perform();
            System.out.println("Element has dropped at successful location-------"+i);
        }
    }

    @AfterTest
    public void tearDown(){}
}
