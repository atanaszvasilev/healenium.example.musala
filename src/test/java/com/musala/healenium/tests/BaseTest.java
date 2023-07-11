package com.musala.healenium.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.musala.healenium.constants.BrowserType;
import com.musala.healenium.constants.DriverType;
import com.musala.healenium.pages.LoginPage;
import com.musala.healenium.settings.DriverContext;

public class BaseTest {
    static protected WebDriver driver;
    static protected WebDriverWait wait;
    static protected String pageUrl;
    static protected String loginUsername;
    static protected String loginPassword;

    static protected LoginPage loginPage;

    @BeforeAll
    static public void setUp() throws FileNotFoundException, IOException {

        // Set up properties
        pageUrl = getProperty("page.url");
        loginUsername = getProperty("login.username");
        loginPassword = getProperty("login.password");

        // Set up driver
        driver = new DriverContext(DriverType.LOCAL).getDriver(BrowserType.CHROME);

        driver.manage().window().setSize(new Dimension(1200, 800));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)) ;

        driver.get(pageUrl);

        // Set up pages
        loginPage = new LoginPage(driver);
    }

    @AfterAll
    static public void afterAll() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static String getProperty(String property) throws FileNotFoundException, IOException {

        Properties prop = new Properties();

        prop.load(new FileInputStream("src/test/resources/test.config.properties"));

        return prop.getProperty(property);
    }
}
