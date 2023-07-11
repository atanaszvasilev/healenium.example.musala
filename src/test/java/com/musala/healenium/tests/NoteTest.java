package com.musala.healenium.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.musala.healenium.pages.CreateNotePage;
import com.musala.healenium.pages.DashboardPage;

public class NoteTest extends BaseTest {

    @Test
    public void testLogin() throws InterruptedException {
        loginPage.enterUsername(loginUsername);

        loginPage.enterPassword(loginPassword);
        loginPage.clickLoginButton();
        DashboardPage dashboardPage = new DashboardPage(driver);
        assertTrue(dashboardPage.getCreateNoteMenu().isDisplayed());
    }

  
    @Test
    public void testCreateNote() throws InterruptedException {

      DashboardPage dashboardPage = new DashboardPage(driver);
      dashboardPage.openCreateNotes();

      CreateNotePage createNotesPage = new CreateNotePage(driver);
      Thread.sleep(1000);
      createNotesPage.createNote("Titel test", "Descriprion Test");

      //Change the layout
      createNotesPage.changeLayout();
      Thread.sleep(1000);
      createNotesPage.createNote("Titel test2", "Descriprion Test");
    }
}
