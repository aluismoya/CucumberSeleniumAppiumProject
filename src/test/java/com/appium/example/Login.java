package com.appium.example;

import bean.User;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login extends BaseAppium {

    public void login(User user) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.example.mkim.aut:id/email_sign_in_button")));

        MobileElement userElement = (MobileElement) driver.findElementById("com.example.mkim.aut:id/email");
        userElement.sendKeys(user.getUser());
        MobileElement passwordElement = (MobileElement) driver.findElementById("com.example.mkim.aut:id/password");
        passwordElement.sendKeys(user.getPassword());
        MobileElement buttonLogin = (MobileElement) driver.findElementById("com.example.mkim.aut:id/email_sign_in_button");
        buttonLogin.click();
    }

    public boolean isUserLogged() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.example.mkim.aut:id/Logout")));

        MobileElement buttonLogout = (MobileElement) driver.findElementById("com.example.mkim.aut:id/Logout");
        return buttonLogout.isDisplayed();
    }

    public void logout() {
        MobileElement buttonLogout = (MobileElement) driver.findElementById("com.example.mkim.aut:id/Logout");
        buttonLogout.click();
    }
}
