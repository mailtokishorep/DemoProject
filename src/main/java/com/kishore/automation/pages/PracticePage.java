package com.kishore.automation.pages;

import com.kishore.automation.config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class PracticePage extends BasePage {
    private static final By NAME = By.id("name");
    private static final By EMAIL = By.id("email");
    private static final By PHONE = By.id("phone");
    private static final By MALE = By.id("male");
    private static final By MONDAY = By.id("monday");
    private static final By COUNTRY = By.id("country");
    private static final By ALERT_BUTTON = By.id("alertBtn");

    public PracticePage(WebDriver driver) {
        super(driver);
    }

    public PracticePage open() {
        driver.get(ConfigReader.get("base.url"));
        return this;
    }

    public String title() {
        return driver.getTitle();
    }

    public void enterPersonalDetails(String name, String email, String phone) {
        type(NAME, name);
        type(EMAIL, email);
        type(PHONE, phone);
    }

    public String nameValue() {
        return driver.findElement(NAME).getAttribute("value");
    }

    public String emailValue() {
        return driver.findElement(EMAIL).getAttribute("value");
    }

    public String phoneValue() {
        return driver.findElement(PHONE).getAttribute("value");
    }

    public void selectGenderAndDay() {
        click(MALE);
        click(MONDAY);
    }

    public boolean isMaleSelected() {
        return isSelected(MALE);
    }

    public boolean isMondaySelected() {
        return isSelected(MONDAY);
    }

    public void selectCountry(String country) {
        new Select(wait.until(
                org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated(COUNTRY)))
                .selectByVisibleText(country);
    }

    public String selectedCountry() {
        return new Select(driver.findElement(COUNTRY)).getFirstSelectedOption().getText();
    }

    public void clickAlertButton() {
        click(ALERT_BUTTON);
    }
}
