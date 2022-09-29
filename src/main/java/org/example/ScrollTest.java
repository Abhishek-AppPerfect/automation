package org.example;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;

public class ScrollTest {

    static AndroidDriver driver;

    @BeforeTest
    public void setupApk() {
        try {
            DesiredCapabilities cap = new DesiredCapabilities();

            cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1");
            cap.setCapability(MobileCapabilityType.APP, "C:\\Users\\Lenovo\\Downloads\\API Demos for Android_1.9.0_Apkpure.apk");
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
    public void test(){
        driver.findElement(By.id("com.touchboarder.android.api.demos:id/buttonDefaultPositive")).click();
        driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.ListView/android.widget.TextView[2]")).click();
        driver.findElements(By.id("android:id/text1")).get(12).click();
        WebElement list=driver.findElement(By.id("android:id/text1"));
        WebElement listitem = driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(" + "new UiSelector().text(\"Switches\"));"));
        System.out.println(listitem.getLocation());
        listitem.click();
    }
    @AfterTest
    public void tearDown(){}
}
