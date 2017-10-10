package com.appium.example;

import com.utils.PropertyLoader;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;

public class BaseAppium {

    public static AppiumDriverLocalService service;
    public static AndroidDriver<WebElement> driver;

    public void init() throws Exception {
        PropertyLoader loadproperty = new PropertyLoader();
        File app = new File(loadproperty.loadProperties().getProperty("apkDir"), loadproperty.loadProperties().getProperty("apkName"));

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
        desiredCapabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

        DesiredCapabilities clientCapabilities = new DesiredCapabilities();
        clientCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        clientCapabilities.setCapability(MobileCapabilityType.UDID, loadproperty.loadProperties().getProperty("udid"));
        clientCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");

        try {
            // Appium service
            AppiumServiceBuilder builder = new AppiumServiceBuilder().withCapabilities(desiredCapabilities)
                    .withIPAddress(loadproperty.loadProperties().getProperty("IPAddress"))
                    .usingPort(Integer.valueOf(loadproperty.loadProperties().getProperty("Port")).intValue());
            service = builder.build();
            service.start();

            // Driver
            driver = new AndroidDriver(service.getUrl(), clientCapabilities);

        } catch (Exception e) {
            throw new Exception ("Error connecting to Appium service : " + e.getMessage());
        }
    }

    public void tearDown() {
        if(driver != null) {
            driver.quit();
        }
    }


}
