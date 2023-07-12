package com.musala.healenium.tests;

import static org.testng.Assert.assertTrue;

import java.util.Random;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.musala.healenium.pages.CreateNotePage;
import com.musala.healenium.pages.DashboardPage;
import com.musala.healenium.pages.RegistrationPage;

public class NoteTest extends BaseTest {
    private final String randomUsername = "testUser" + new Random().nextInt(10000);
    private final String randomEmail = "testEmail" + new Random().nextInt(10000) + "@gmail.com";
    private final String randomPassword = "testPassword" + new Random().nextInt(10000);

    @Test
    public void testLogin() {
        // Enter login data
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.getUsernameInput()));
        loginPage.enterUsername(loginUsername);
        loginPage.enterPassword(loginPassword);
        loginPage.clickLoginButton();

        DashboardPage dashboardPage = new DashboardPage(driver);
        assertTrue(wait.until(ExpectedConditions.visibilityOf(dashboardPage.getCreateNoteMenu())).isDisplayed());
    }

    @Test
    public void testCreateNote() {
        // Login
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.getUsernameInput()));
        login(loginPage, loginUsername, loginPassword);

        // Navigate to Create note page
        DashboardPage dashboardPage = new DashboardPage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(dashboardPage.getCreateNoteMenu()));
        dashboardPage.openCreateNotes();

        // Create note
        CreateNotePage createNotesPage = new CreateNotePage(driver);
        wait.until(ExpectedConditions.elementToBeClickable(createNotesPage.getCreateNoteButton()));
        createNotesPage.createNote("Title test", "Descriprition test");

        // Change the layout
        wait.until(ExpectedConditions.visibilityOf(createNotesPage.getNoteCreatedMessage()));
        wait.until(ExpectedConditions.elementToBeClickable(createNotesPage.getUpdateNoteButton()));
        createNotesPage.changeLayout();

        // Create note after layout is changed
        wait.until(ExpectedConditions.elementToBeClickable(createNotesPage.getCreateNoteButton()));
        createNotesPage.createNote("Title test 2", "Descriprition test 2");
        assertTrue(wait.until(ExpectedConditions.visibilityOf(createNotesPage.getNoteCreatedMessage())).isDisplayed());
    }

    @Test
    public void testRegistration() {
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.getUsernameInput()));
        loginPage.clickRegisterButton();
        RegistrationPage registrationPage = new RegistrationPage(driver);

        // Enter registration data
        wait.until(ExpectedConditions.elementToBeClickable(registrationPage.getUsernameInput()));
        registrationPage.enterUsername(randomUsername);
        registrationPage.enterEmail(randomEmail);
        registrationPage.enterPassword(randomPassword);
        registrationPage.enterConfirmPassword(randomPassword);
        registrationPage.clickRegisterButton();

        assertTrue(wait.until(ExpectedConditions.visibilityOf(registrationPage.getRegistrationConfirmation()))
                .isDisplayed());
    }
}
