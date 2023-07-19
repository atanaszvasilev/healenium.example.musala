package com.musala.healenium.settings.drivers;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.musala.healenium.constants.BrowserType;
import com.musala.healenium.settings.IDriverInterface;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.AutomationName;

public class ProxyDriver implements IDriverInterface {
    private RemoteWebDriver driver;

    @Override
    public WebDriver setDriver(BrowserType browserType, Object options) throws MalformedURLException {
        switch (browserType) {
        case APPIUM:
            this.driver = new AppiumDriver(new URL("http://" + LOCALHOST + ":8085"), (Capabilities) options);
            return this.driver;
        default:
            this.driver = new RemoteWebDriver(new URL("http://" + LOCALHOST + ":8085"), (Capabilities) options);
            return this.driver;
        }
    }

    @Override
    public Object useChrome() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        return options;
    }

    @Override
    public Object useFirefox() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        return options;
    }

    @Override
    public Object useEdge() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        return options;
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
