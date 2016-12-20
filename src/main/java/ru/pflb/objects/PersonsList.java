package ru.pflb.objects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import ru.pflb.data.Person;
import ru.pflb.sut.PersonComponents;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class PersonsList {

    @FindBy(className = "person")
    private List<SelenideElement> persons;

    public List<Person> getPersons() {
        List<Person> result = new ArrayList<>();
        persons = $$(By.className("person"));
        for (int i = 0; i < persons.size(); i++) {
            result.add(PersonComponents.getPerson(persons.get(i)));
        }
        return result;
    }

    public void deletePerson(Person person) {
        List<Person> personsL = this.getPersons();
        for (int j = 0; j < personsL.size(); j++) {
            if (person.equals(personsL.get(j))) {
                PersonComponents.deletePerson(persons.get(j));
            }
        }
    }
}
