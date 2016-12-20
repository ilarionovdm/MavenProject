package ru.pflb;

import org.testng.annotations.Test;
import ru.pflb.data.Person;
import ru.pflb.page.MainPage;

import static com.codeborne.selenide.Selenide.page;


public class Test2 extends BaseTest{

    @Test
    public void testDeleteUser() throws Exception {
        Test1 test1 = new Test1();
        test1.testCreateUser();
        MainPage mainPage = page(MainPage.class);
        mainPage.deleteUser((Person)context.get("person"));
    }
}
