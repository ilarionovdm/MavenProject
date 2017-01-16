package ru.pflb;

import org.testng.annotations.Test;
import ru.pflb.page.LoginPage;
import ru.pflb.page.MainPage;
import static com.codeborne.selenide.Selenide.open;


public class Test1 extends BaseTest{

    @Test
    public void testCreateUser() throws Exception {

        LoginPage loginPage = open("http://at.pflb.ru/matrixboard2", LoginPage.class);
        //TODO @dilarionov вернуть пользователь - пароль
        MainPage mainPage = loginPage.authenticationUser("", "");
        mainPage.clickAddPerson(context);
        mainPage.checkContainsUser(context);

    }
}
