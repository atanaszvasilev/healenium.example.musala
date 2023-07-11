package com.musala.healenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
    protected WebDriver driver;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@id='confirmpassword']")
    private WebElement confirmpasswordInput;

    @FindBy(xpath = "//div[@class='btn btn--primary']")
    private WebElement registerButton;

    @FindBy(xpath = "//div[@data-text='CyberNotes']")
    private WebElement registrationConfirmartion;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getUsernameInput() {
        return this.usernameInput;
    }

    public WebElement getEmailInput() {
        return this.emailInput;
    }

    public WebElement getPasswordInput() {
        return this.passwordInput;
    }

    public WebElement getConfirmpasswordInput() {
        return this.confirmpasswordInput;
    }

    public WebElement getRegisterButton() {
        return this.registerButton;
    }

    public WebElement getRegistrationConfirmation() {
        return this.registrationConfirmartion;
    }

    public void enterUsername(String username) {
        getUsernameInput().sendKeys(username);
    }

    public void enterEmail(String email) {
        getEmailInput().sendKeys(email);
    }

    public void enterPassword(String password) {
        getPasswordInput().sendKeys(password);
    }

    public void enterConfirmPassword(String confirmpassword) {
        getConfirmpasswordInput().sendKeys(confirmpassword);
    }

    public void clickRegisterButton() {
        getRegisterButton().click();
    }
}
