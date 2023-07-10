package com.musala.healenium.tests;

import java.net.MalformedURLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import com.musala.healenium.constants.BrowserType;
import com.musala.healenium.constants.DriverType;
import com.musala.healenium.settings.DriverContext;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javafx.util.Duration;

public class BaseTest {
    static protected WebDriver driver;
    static protected WebDriverWait wait;

    @BeforeAll
    static public void setUp() throws MalformedURLException {
        driver = new DriverContext(DriverType.LOCAL).getDriver(BrowserType.CHROME);

        driver.manage().window().setSize(new Dimension(1200, 800));
    
    }

    @AfterAll
    static public void afterAll() {
        if (driver != null) {
            driver.quit();
        }
    }
}
