package ru.pflb.objects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.pflb.data.Person;

import java.util.Map;

import static com.codeborne.selenide.ex.ErrorMessages.screenshot;


public class AddPerson {

    @FindBy(id = "person-last-name")
    private SelenideElement lastName;

    @FindBy(id = "person-first-name")
    private SelenideElement firstName;

    @FindBy(id = "person-patronymic-name")
    private SelenideElement patronymic;

    @FindBy(id = "person-position")
    private SelenideElement position;

    @FindBy(id = "person-project")
    private SelenideElement project;

    @FindBy(id = "person-expire")
    private SelenideElement expire;

    @FindBy(id = "person-future")
    private SelenideElement future;

    @FindBy(id = "person-nickname")
    private SelenideElement nickname;

    @FindBy(id = "person-fired")
    private SelenideElement fired;

    @FindBy(className = "ui-dialog-buttonset")
    private SelenideElement ok;

    public Person fillRandom() {
        Person person = Person.getNewRandomPerson();
        lastName.setValue(person.getLastName());
        firstName.setValue(person.getFirstName());
        patronymic.setValue(person.getPatronymic());
        position.exists();
        project.setValue(person.getProject());
        expire.setValue(person.getExpire());
        future.setValue(person.getFuture());
        nickname.setValue(person.getNickname());
        fired.exists();
        screenshot("newPerson");
        ok.click();
        return person;
    }

}
