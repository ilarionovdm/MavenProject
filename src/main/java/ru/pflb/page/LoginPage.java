package ru.pflb.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.screenshot;

public class LoginPage extends ParentPage {

    @FindBy(id = "login-username")
    private SelenideElement login;

    @FindBy(id = "login-password")
    private SelenideElement password;

    @FindBy(id = "login-button")
    private SelenideElement loginButton;

    public MainPage authenticationUser(String u, String p){
        log.info("Выполняю вход");
        login.setValue(u);
        log.info("Введен логин: " + u);
        screenshot("login");
        password.setValue(p);
        screenshot("password");
        loginButton.click();
        log.info("вход выполнен логином " + u);
        return page(MainPage.class);
    }



}
