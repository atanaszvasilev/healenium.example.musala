package com.musala.healenium.settings;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;

public interface IDriverInterface {

    static final String LOCALHOST = "localhost";
    static final String SELENOID = "10.6.223.91";
    static final String APPIUM = "localhost:8085";

    WebDriver setDriver(Object delegate) throws MalformedURLException;

    Object useChrome();

    Object useFirefox();

    Object useEdge();

    Object useAppium();
}
