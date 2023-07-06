package com.musala.healenium.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class CounterAppTest extends BaseTest {

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("XPath with special characters")
    public void testCounterApp() {

        driver.get("https://ncnjgq-3000.csb.app/");
        driver.findElement(By.xpath("//*[@class='btn btn-secondary']")).click();
    }
}
