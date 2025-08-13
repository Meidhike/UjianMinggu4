package com.juaracoding.ecom;

import com.juaracoding.ecom.utils.DriverUtil;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Arrays;

public class AppTest {
    private AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DriverUtil driverUtil = new DriverUtil();
        driver = driverUtil.getDriver();
    }

    private void pinchOut(AndroidDriver driver, WebElement element) {
        int centerX = element.getRect().x + element.getRect().width / 2;
        int centerY = element.getRect().y + element.getRect().height / 2;

        int startOffset = 50;
        int endOffset = 150;

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");

        Sequence seq1 = new Sequence(finger1, 0)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),
                        centerX - startOffset, centerY - startOffset))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger1.createPointerMove(Duration.ofMillis(300), PointerInput.Origin.viewport(),
                        centerX - endOffset, centerY - endOffset))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        Sequence seq2 = new Sequence(finger2, 0)
                .addAction(finger2.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),
                        centerX + startOffset, centerY + startOffset))
                .addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger2.createPointerMove(Duration.ofMillis(300), PointerInput.Origin.viewport(),
                        centerX + endOffset, centerY + endOffset))
                .addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(seq1, seq2));
    }

    private void pinchIn(AndroidDriver driver, WebElement element) {
        int centerX = element.getRect().x + element.getRect().width / 2;
        int centerY = element.getRect().y + element.getRect().height / 2;

        int offset = 100;

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");

        Sequence seq1 = new Sequence(finger1, 0)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),
                        centerX - offset, centerY - offset))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger1.createPointerMove(Duration.ofMillis(300), PointerInput.Origin.viewport(),
                        centerX, centerY))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        Sequence seq2 = new Sequence(finger2, 0)
                .addAction(finger2.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),
                        centerX + offset, centerY + offset))
                .addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger2.createPointerMove(Duration.ofMillis(300), PointerInput.Origin.viewport(),
                        centerX, centerY))
                .addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(seq1, seq2));
    }

    @Test
    public void testZoomImage() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("test-Username")).sendKeys("standard_user");
        driver.findElement(AppiumBy.accessibilityId("test-Password")).sendKeys("secret_sauce");
        driver.findElement(AppiumBy.accessibilityId("test-LOGIN")).click();

        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Sauce Labs Backpack']")).click();
        Thread.sleep(2000);

        WebElement productImage = driver.findElement(AppiumBy.xpath("(//android.widget.ImageView)[6]"));

        pinchOut(driver, productImage);
        Thread.sleep(2000);

        pinchIn(driver, productImage);
        Thread.sleep(2000);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
