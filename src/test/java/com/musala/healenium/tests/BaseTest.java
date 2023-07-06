package com.musala.healenium.tests;

import java.net.MalformedURLException;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.epam.healenium.SelfHealingDriver;
import com.musala.healenium.constants.BrowserType;
import com.musala.healenium.constants.DriverType;
import com.musala.healenium.settings.DriverContext;

import io.qameta.allure.Attachment;

public class BaseTest {
    static protected WebDriver driver;

    @BeforeClass
    static public void setUp() throws MalformedURLException {
        driver = new DriverContext(DriverType.LOCAL).getDriver(BrowserType.CHROME);

        driver.manage().window().setSize(new Dimension(1200, 800));
    }

    @AfterClass
    static public void afterAll() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] screenshot() {
        return ((TakesScreenshot) ((SelfHealingDriver) driver).getDelegate()).getScreenshotAs(OutputType.BYTES);
    }
}
