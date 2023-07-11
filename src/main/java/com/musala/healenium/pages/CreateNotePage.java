package com.musala.healenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNotePage {
    protected WebDriver driver;

    @FindBy(css = "#note-title")
    private WebElement noteTitle;

    @FindBy(css = "#note-body")
    private WebElement noteDescription;

    @FindBy(css = "#add-note-origin")
    private WebElement createNoteButton;

    @FindBy(css = "#update-link")
    private WebElement updateNoteButton;

    @FindBy(xpath = "//div[@class='delete-modal']")
    private WebElement noteCreatedMessage;

    public CreateNotePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getNoteTitle() {
        return this.noteTitle;
    }

    public WebElement getNoteDescription() {
        return this.noteDescription;
    }

    public WebElement getCreateNoteButton() {
        return this.createNoteButton;
    }

    public WebElement getUpdateNoteButton() {
        return this.updateNoteButton;
    }

    public WebElement getNoteCreatedMessage() {
        return this.noteCreatedMessage;
    }

    public void changeLayout() {
        getUpdateNoteButton().click();
    }

    public void createNote(String title, String noteDescription) {
        getNoteTitle().sendKeys(title);
        getNoteDescription().sendKeys(noteDescription);
        getCreateNoteButton().click();
    }
}
