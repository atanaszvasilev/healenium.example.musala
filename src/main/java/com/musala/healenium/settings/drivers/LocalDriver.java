package com.musala.healenium.settings.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.epam.healenium.SelfHealingDriver;
import com.musala.healenium.settings.IDriverInterface;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.AutomationName;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LocalDriver implements IDriverInterface {
    private SelfHealingDriver driver;

    @Override
    public WebDriver setDriver(Object delegate) {
        driver = SelfHealingDriver.create((WebDriver) delegate);

        return driver;
    }

    @Override
    public Object useChrome() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);

        WebDriver delegate = new ChromeDriver(options);
        return delegate;
    }

    @Override
    public Object useFirefox() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(false);

        WebDriver delegate = new FirefoxDriver(options);
        return delegate;
    }

    @Override
    public Object useEdge() {
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();

        WebDriver delegate = new EdgeDriver(options);
        return delegate;
    }

    @Override
    public Object useAppium() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("automationName", AutomationName.ANDROID_UIAUTOMATOR2);
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("chromedriverDisableBuildCheck", true);
        capabilities.setCapability("chromedriverUseSystemExecutable", true);

        AppiumDriver delegate = new AppiumDriver(capabilities);
        return delegate;
    }
}
