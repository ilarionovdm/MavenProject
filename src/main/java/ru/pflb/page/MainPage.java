package ru.pflb.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import ru.pflb.data.Person;
import ru.pflb.objects.AddPerson;
import ru.pflb.objects.PersonsList;
import ru.pflb.sut.PageNavigator;
import ru.pflb.sut.PersonComponents;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.screenshot;

public class MainPage {

    @FindBy(id = "add-person")
    private SelenideElement addPerson;

    @FindBy(xpath = "//a[contains(@href, 'page')]")
    private List<SelenideElement> pages;

    private Person person;

    public Person getPerson() {
        return person;
    }

    public MainPage clickAddPerson(Map<String, Object> context){
        addPerson.click();
        screenshot("addPerson");
        person = page(AddPerson.class).fillRandom();
        context.put("person", person);
        return page(MainPage.class);
    }

    public void checkContainsUser(Map<String, Object> context) {
        Person person = (Person) context.get("person");
        int pageCount = pages.size()/2;
        for (int i = 0; i < pageCount; i++){
            PageNavigator.clickPage(pages, i);
            PersonsList personsList;
            List<Person> persons;
            do {
                personsList = page(PersonsList.class);
                persons = personsList.getPersons();
            }while(persons.size() < 1);
            for (int j = 0; j < persons.size(); j++) {
                if (person.equals(persons.get(j))) {
                    return;
                }
            }
        }
        throw new RuntimeException("Не удалось найти пользователя");
    }

    public void deleteUser(Person person) {
        PersonsList personsList;
        List<Person> persons;
        do {
            personsList = page(PersonsList.class);
            persons = personsList.getPersons();
        }while(persons.size() < 1);
        for (int j = 0; j < persons.size(); j++) {
            if (person.equals(persons.get(j))) {
                personsList.deletePerson(persons.get(j));
                return;
            }
        }
    }
}
