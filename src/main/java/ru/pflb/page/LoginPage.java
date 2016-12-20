package ru.pflb.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.screenshot;

public class LoginPage {

    @FindBy(id = "login-username")
    private SelenideElement login;

    @FindBy(id = "login-password")
    private SelenideElement password;

    @FindBy(id = "login-button")
    private SelenideElement loginButton;

    public MainPage authenticationUser(String u, String p){
        login.setValue(u);
        screenshot("login");
        password.setValue(p);
        screenshot("password");
        loginButton.click();
        return page(MainPage.class);
    }



}
