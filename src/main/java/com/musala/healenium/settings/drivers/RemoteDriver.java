package com.musala.healenium.settings.drivers;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.epam.healenium.SelfHealingDriver;
import com.musala.healenium.constants.BrowserType;
import com.musala.healenium.settings.IDriverInterface;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.AutomationName;

public class RemoteDriver implements IDriverInterface {

    private SelfHealingDriver driver;

    @Override
    public WebDriver setDriver(BrowserType browserType, Object capabilities) throws MalformedURLException {
        switch (browserType) {
        case APPIUM:
            AppiumDriver appiumDelegate = new AppiumDriver(new URL("http://" + APPIUM), (Capabilities) capabilities);
            this.driver = SelfHealingDriver.create(appiumDelegate);
            return this.driver;
        default:
            RemoteWebDriver remoteDelegate = new RemoteWebDriver(
                    URI.create("http://" + SELENOID + ":4444/wd/hub").toURL(), (Capabilities) capabilities);
            this.driver = SelfHealingDriver.create(remoteDelegate);
            return this.driver;
        }
    }

    @Override
    public Object useChrome() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "97.0");
        capabilities.setCapability("enableVNC", true);

        return capabilities;
    }

    @Override
    public Object useFirefox() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "firefox");
        capabilities.setCapability("browserVersion", "95.0");
        capabilities.setCapability("enableVNC", true);

        return capabilities;
    }

    @Override
    public Object useEdge() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "edge");
        capabilities.setCapability("browserVersion", "98.0");
        capabilities.setCapability("enableVNC", true);

        return capabilities;
    }

    @Override
    public Object useAppium() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", Platform.ANDROID.name());
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("automationName", AutomationName.ANDROID_UIAUTOMATOR2);
        capabilities.setCapability("browserName", Browser.CHROME.browserName());
        capabilities.setCapability("chromedriverDisableBuildCheck", true);
        capabilities.setCapability("chromedriverUseSystemExecutable", true);

        return capabilities;
    }
}
