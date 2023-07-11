package com.musala.healenium.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.musala.healenium.constants.BrowserType;
import com.musala.healenium.constants.DriverType;
import com.musala.healenium.pages.LoginPage;
import com.musala.healenium.settings.DriverContext;

public class BaseTest {
    static protected WebDriver driver;
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
        driver = new DriverContext(DriverType.LOCAL).getDriver(BrowserType.CHROME);

        driver.manage().window().setSize(new Dimension(1200, 800));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        driver.get(pageUrl);
    }

    @BeforeMethod
    public void setUpTest() throws InterruptedException {
        driver.get(pageUrl);
        loginPage = new LoginPage(driver);
        Thread.sleep(1000);
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
