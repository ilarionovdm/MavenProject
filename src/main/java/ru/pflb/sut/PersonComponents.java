package ru.pflb.sut;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.pflb.data.Person;

import static com.codeborne.selenide.Selenide.$;


public class PersonComponents {

    public static Person getPerson(SelenideElement person) {
        Person result = new Person();
        String xpath = XpathExecutor.getAbsoluteXPath(person);
        boolean flag = false;
        do {
            try {
                String name = $(By.xpath(xpath + "//div[@class = 'name']")).getText();
                String[] parts = (name + " ").split("\\p{P}?[ \\t\\n\\r]+");
                result.setLastName(parts[0]);
                result.setFirstName(parts[1]);
//                result.setProject($(By.xpath(xpath + "//div[@class = 'project']/span[@class = 'param']")).getText());
//                result.setExpire($(By.xpath(xpath + "//div[@class = 'expire']/span[@class = 'param']")).getText());
//                result.setFuture($(By.xpath(xpath + "//div[@class = 'future']/span[@class = 'param']")).getText());
                flag = false;
            } catch (Throwable t) {
                flag = true;
            }

        } while (flag);
        return result;
    }

    public static void deletePerson(SelenideElement person) {
        String xpath = XpathExecutor.getAbsoluteXPath(person);
        boolean flag = false;
        do {
            try {
                $(By.xpath(xpath + "//div[@title = 'Удалить человека']")).click();
                flag = false;
            } catch (Throwable t) {
                flag = true;
            }

        } while (flag);
        $(By.xpath("//button/span[contains(text(),'Да')]")).click();
    }

}
