package com.musala.healenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNotePage {

    private WebDriver driver;

    @FindBy(css = "#note-title")
    public WebElement noteTitle;

    @FindBy(css = "#note-body")
    public WebElement noteDescription;

    @FindBy(css = "#add-note-origin")
    private WebElement createNoteButton;


    @FindBy(css = "#update-link")
    public WebElement updateNoteButton;

    public CreateNotePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void changeLayout() {
        updateNoteButton.click();
    }

    public void createNote(String title, String noteDescription) {
        this.noteTitle.sendKeys(title);
        this.noteDescription.sendKeys(noteDescription);
        createNoteButton.click();
    }
}