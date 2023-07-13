package com.musala.healenium.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.musala.healenium.constants.BrowserType;
import com.musala.healenium.constants.DriverType;
import com.musala.healenium.pages.LoginPage;
import com.musala.healenium.settings.DriverContext;

public class BaseTestAndroid {
    static protected WebDriver driver;
    static protected WebDriverWait wait;
    static protected String pageUrl;
    static protected String loginUsername;
    static protected String loginPassword;
    static protected LoginPage loginPage;

    @BeforeClass
    static public void setUp() throws FileNotFoundException, IOException {
        // Set up properties
        pageUrl = getProperty("page.url");
        loginUsername = getProperty("login.username");
        loginPassword = getProperty("login.password");

        // Set up driver
        driver = new DriverContext(DriverType.LOCAL).getDriver(BrowserType.APPIUM);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void setUpTest() throws InterruptedException {
        driver.get(pageUrl);
        loginPage = new LoginPage(driver);
    }

    @AfterClass
    static public void afterAll() {
        if (driver != null) {
            driver.quit();
        }
    }

    private static String getProperty(String property) throws FileNotFoundException, IOException {
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/test/resources/test.config.properties"));

        return prop.getProperty(property);
    }

    protected static void login(LoginPage loginPage, String loginUsername, String loginPassword) {
        loginPage.enterUsername(loginUsername);
        loginPage.enterPassword(loginPassword);
        loginPage.clickLoginButton();
    }
}
