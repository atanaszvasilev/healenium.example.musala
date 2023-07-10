package com.musala.healenium.tests;

import java.util.Random;

import org.junit.jupiter.api.Test;

public class NoteTest extends BaseTest {

    private final String randomUsername = "testUser" + new Random().nextInt(10000);
    private final String randomEmail = "testEmail" + new Random().nextInt(10000) + "@gmail.com";
    private final String randomPassword = "testPasword" + new Random().nextInt(10000);

    @Test
    public void testLogin() throws InterruptedException {

        Thread.sleep(2000);
        loginPage.enterUsername(loginUsername);
        loginPage.enterPassword(loginPassword);
        loginPage.clickLoginButton();
    }

    @Test
    public void testRegistration() throws InterruptedException {

        Thread.sleep(2000);
        loginPage.clickRegisterButton();
        Thread.sleep(2000);
        registrationPage.enterUsername(randomUsername);
        registrationPage.enterEmail(randomEmail);
        registrationPage.enterPassword(randomPassword);
        registrationPage.enterConfirmPassword(randomPassword);
        registrationPage.clickRegisterButton();
    }
}
