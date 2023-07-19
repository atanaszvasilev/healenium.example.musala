package com.musala.healenium.settings.drivers;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.epam.healenium.SelfHealingDriver;
import com.musala.healenium.constants.BrowserType;
import com.musala.healenium.settings.IDriverInterface;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.AutomationName;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LocalDriver implements IDriverInterface {
    private SelfHealingDriver driver;

    @Override
    public WebDriver setDriver(BrowserType browserType, Object delegate) {
        switch (browserType) {
        case APPIUM:
            AppiumDriver driverDelegate = new AppiumDriver((Capabilities) delegate);
            return driver = SelfHealingDriver.create((WebDriver) driverDelegate);
        default:
            driver = SelfHealingDriver.create((WebDriver) delegate);
            return driver;
        }
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
        capabilities.setCapability("platformName", Platform.ANDROID.name());
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("automationName", AutomationName.ANDROID_UIAUTOMATOR2);
        capabilities.setCapability("browserName", Browser.CHROME.browserName());
        capabilities.setCapability("chromedriverDisableBuildCheck", true);
        capabilities.setCapability("chromedriverUseSystemExecutable", true);

        return capabilities;
    }
}
