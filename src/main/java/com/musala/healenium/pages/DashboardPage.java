package com.musala.healenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
    protected WebDriver driver;

    @FindBy(css = "#create-note")
    private WebElement createNoteMenu;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getCreateNoteMenu() {
        return this.createNoteMenu;
    }

    public void openCreateNotes() {
        this.createNoteMenu.click();
    }
}
