package com.musala.healenium.tests;

import org.junit.jupiter.api.Test;

public class NoteTest extends BaseTest {

    @Test
    public void testLogin() throws InterruptedException {

        Thread.sleep(2000);
        loginPage.enterUsername(loginUsername);
        loginPage.enterPassword(loginPassword);
        loginPage.clickLoginButton();
    }
}
