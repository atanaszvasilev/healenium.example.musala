package com.musala.healenium.settings.drivers;

import java.net.MalformedURLException;
import java.net.URI;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.epam.healenium.SelfHealingDriver;
import com.musala.healenium.settings.IDriverInterface;

public class RemoteDriver implements IDriverInterface {

    private SelfHealingDriver driver;

    @Override
    public WebDriver setDriver(Object capabilities) throws MalformedURLException {
        RemoteWebDriver delegate = new RemoteWebDriver(URI.create("http://" + SELENOID + ":4444/wd/hub").toURL(),
                (Capabilities) capabilities);
        this.driver = SelfHealingDriver.create(delegate);

        return this.driver;
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
        MutableCapabilities capabilities = new MutableCapabilities();
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("nativeWebScreenshot", true);

        return capabilities;
    }
}
