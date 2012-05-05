package com.blogspot.sassylog.helloandroid.nativedriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.google.android.testing.nativedriver.client.AndroidNativeDriver;
import com.google.android.testing.nativedriver.client.AndroidNativeDriverBuilder;

import junit.framework.TestCase;

public class HelloAndroidNativedriverTest extends TestCase {

    private AndroidNativeDriver driver;

    protected AndroidNativeDriver getDriver() {
        return new AndroidNativeDriverBuilder().withDefaultServer().build();
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        driver = getDriver();
        driver.startActivity("com.blogspot.sassylog.helloandroid.HelloAndroidActivity");
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        driver.quit();
    }

    public void test01() {
        WebElement textView = driver.findElement(By.id("textView"));
        assertNotSame("Hello", textView.getText());
        driver.findElement(By.id("button")).click();
    }
}
