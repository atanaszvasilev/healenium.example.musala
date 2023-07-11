package com.musala.healenium.tests;

import static org.testng.Assert.assertTrue;

import java.util.Random;

import org.testng.annotations.Test;

import com.musala.healenium.pages.CreateNotePage;
import com.musala.healenium.pages.DashboardPage;
import com.musala.healenium.pages.RegistrationPage;

public class NoteTest extends BaseTest {
    private final String randomUsername = "testUser" + new Random().nextInt(10000);
    private final String randomEmail = "testEmail" + new Random().nextInt(10000) + "@gmail.com";
    private final String randomPassword = "testPasword" + new Random().nextInt(10000);

    @Test
    public void testLogin() throws InterruptedException {
        // Enter login data
        loginPage.enterUsername(loginUsername);
        loginPage.enterPassword(loginPassword);
        loginPage.clickLoginButton();

        DashboardPage dashboardPage = new DashboardPage(driver);
        assertTrue(dashboardPage.getCreateNoteMenu().isDisplayed());
    }

    @Test
    public void testCreateNote() throws InterruptedException {
        // Login
        login(loginPage, loginUsername, loginPassword);
        Thread.sleep(2000);

        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.openCreateNotes();

        CreateNotePage createNotesPage = new CreateNotePage(driver);
        Thread.sleep(1000);
        createNotesPage.createNote("Titel test", "Descriprion Test");

        // Change the layout
        Thread.sleep(1000);
        createNotesPage.changeLayout();
        Thread.sleep(1000);
        createNotesPage.createNote("Titel test2", "Descriprion Test");
    }

    @Test
    public void testRegistration() throws InterruptedException {
        loginPage.clickRegisterButton();
        RegistrationPage registrationPage = new RegistrationPage(driver);

        // Enter registration data
        Thread.sleep(1000);
        registrationPage.enterUsername(randomUsername);
        registrationPage.enterEmail(randomEmail);
        registrationPage.enterPassword(randomPassword);
        registrationPage.enterConfirmPassword(randomPassword);
        registrationPage.clickRegisterButton();

        Thread.sleep(1000);
        assertTrue(registrationPage.getRegistrationConfirmation().isDisplayed());
    }
}
