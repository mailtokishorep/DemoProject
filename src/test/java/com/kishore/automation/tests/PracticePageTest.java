package com.kishore.automation.tests;

import com.kishore.automation.pages.PracticePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticePageTest extends BaseTest {
    private PracticePage practicePage;

    @BeforeMethod
    public void openPracticePage() {
        practicePage = new PracticePage(driver).open();
    }

    @Test
    public void shouldOpenPracticePage() {
        Assert.assertEquals(practicePage.title(), "Automation Testing Practice");
    }

    @Test
    public void shouldFillPersonalDetails() {
        practicePage.enterPersonalDetails("Kishore", "kishore@example.com", "9876543210");

        Assert.assertEquals(practicePage.nameValue(), "Kishore");
        Assert.assertEquals(practicePage.emailValue(), "kishore@example.com");
        Assert.assertEquals(practicePage.phoneValue(), "9876543210");
    }

    @Test
    public void shouldSelectGenderDayAndCountry() {
        practicePage.selectGenderAndDay();
        practicePage.selectCountry("India");

        Assert.assertTrue(practicePage.isMaleSelected());
        Assert.assertTrue(practicePage.isMondaySelected());
        Assert.assertEquals(practicePage.selectedCountry(), "India");
    }

    @Test
    public void shouldShowAlertMessage() {
        practicePage.clickAlertButton();

        Assert.assertEquals(driver.switchTo().alert().getText(), "I am an alert box!");
        driver.switchTo().alert().accept();
    }
}
