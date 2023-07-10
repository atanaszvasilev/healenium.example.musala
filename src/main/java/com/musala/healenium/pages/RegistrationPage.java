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

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        usernameInput.sendKeys(username);
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void enterConfirmPassword(String confirmpassword) {
        confirmpasswordInput.sendKeys(confirmpassword);
    }

    public void clickRegisterButton() {
        registerButton.click();
    }
}
