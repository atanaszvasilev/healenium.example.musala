package com.musala.healenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    protected WebDriver driver;

    @FindBy(css = "#user")
    private WebElement usernameInput;

    @FindBy(css = "#password")
    private WebElement passwordInput;

    @FindBy(xpath = "//div[@class='login']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[@href='/Signup']")
    private WebElement registerButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getUsernameInput() {
        return this.usernameInput;
    }

    public WebElement getPasswordInput() {
        return this.passwordInput;
    }

    public WebElement getLoginButton() {
        return this.loginButton;
    }

    public WebElement getRegisterButton() {
        return this.registerButton;
    }

    public void enterUsername(String username) {
        getUsernameInput().sendKeys(username);
    }

    public void enterPassword(String password) {
        getPasswordInput().sendKeys(password);
    }

    public void clickLoginButton() {
        getLoginButton().click();
    }

    public void clickRegisterButton() {
        getRegisterButton().click();
    }
}
