package com.musala.healenium.settings.drivers;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.musala.healenium.settings.IDriverInterface;

public class ProxyDriver implements IDriverInterface {
    private RemoteWebDriver driver;

    @Override
    public WebDriver setDriver(Object options) throws MalformedURLException {
        this.driver = new RemoteWebDriver(new URL("http://" + LOCALHOST + ":8085"), (Capabilities) options);
        return this.driver;
    }

    @Override
    public Object useChrome() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.setCapability("enableVNC", true);
        return options;
    }

    @Override
    public Object useFirefox() {
        FirefoxOptions options = new FirefoxOptions();

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
        MutableCapabilities capabilities = new MutableCapabilities();

        return capabilities;
    }
}
