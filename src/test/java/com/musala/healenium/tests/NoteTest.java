package com.musala.healenium.tests;

import org.junit.jupiter.api.Test;

import com.musala.healenium.pages.LoginPage;

public class NoteTest extends BaseTest {

    @Test
    public void testCounterApp() throws InterruptedException {

      driver.get("https://cyber-notes-c48bf986b15f.herokuapp.com/");
      LoginPage login = new LoginPage(driver);
      Thread.sleep(6000);
      login.enterUsername("bubsyto@gmial.com");
      login.enterPassword("kukuruku");
      login.clickLoginButton();
    }
}
