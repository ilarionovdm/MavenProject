package ru.pflb;


import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import ru.pflb.page.LoginPage;
import ru.pflb.page.MainPage;

import static com.codeborne.selenide.Selenide.open;


public class Test1 extends BaseTest{

    public static Logger log = Logger.getLogger(Test1.class.getName());
    @Test
    public void testCreateUser() throws Exception {
        log.info("Выполняю вход");
        LoginPage loginPage = open("http://at.pflb.ru/matrixboard2", LoginPage.class);
        log.info("вход выполнен");
        //TODO @dilarionov вернуть пользователь - пароль
        MainPage mainPage = loginPage.authenticationUser("*****", "*****");
        mainPage.clickAddPerson(context);
        mainPage.checkContainsUser(context);
    }
}
