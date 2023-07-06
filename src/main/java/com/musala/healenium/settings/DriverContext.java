package com.musala.healenium.settings;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;

import com.musala.healenium.constants.BrowserType;
import com.musala.healenium.constants.DriverType;
import com.musala.healenium.settings.drivers.LocalDriver;
import com.musala.healenium.settings.drivers.ProxyDriver;
import com.musala.healenium.settings.drivers.RemoteDriver;

public class DriverContext {

    private WebDriver driver;
    private IDriverInterface context;

    public DriverContext(DriverType local) {
        switch (local) {
        case LOCAL:
            this.context = new LocalDriver();
            break;
        case PROXY:
            this.context = new ProxyDriver();
            break;
        case REMOTE:
            this.context = new RemoteDriver();
            break;
        }

    }

    public WebDriver getDriver(BrowserType browser) throws MalformedURLException {
        switch (browser) {
        case CHROME:
            this.driver = context.setDriver(context.useChrome());
            break;
        case FIREFOX:
            this.driver = context.setDriver(context.useFirefox());
            break;
        case IE:
            this.driver = context.setDriver(context.useEdge());
            break;
        }
        return this.driver;
    }
}
