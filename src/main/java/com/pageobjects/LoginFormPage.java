package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginFormPage {
    private WebDriver driver;

    @FindBy(id = "user-name")
    private WebElement inputUsername;

    @FindBy(id = "password")
    private WebElement inputPassword;

    @FindBy(id = "login-button")
    private WebElement btnLogin;

    public final String url = "https://www.saucedemo.com";

    public LoginFormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getUrl() {
        return url;
    }

    public void loginUser(String username, String password) {
        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
        btnLogin.click();
    }
}
