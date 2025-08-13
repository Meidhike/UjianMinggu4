package com.juaracoding.ecom.utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverUtil {

     AndroidDriver driver;
     DesiredCapabilities capabilities;

    public DriverUtil() throws MalformedURLException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:deviceName", "RR8T90084BR");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:appPackage", "com.swaglabsmobileapp");
        capabilities.setCapability("appium:appActivity", "com.swaglabsmobileapp.MainActivity");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.hideKeyboard();
    }

    public AndroidDriver getDriver() {
        return driver;
    }

    public void quitApp() {
        driver.quit();
    }
}
