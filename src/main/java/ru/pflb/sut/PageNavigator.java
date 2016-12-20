package ru.pflb.sut;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

public class PageNavigator {

    public static void clickPage(List<SelenideElement> pages, int pageNumber) {
        boolean flag = false;
        do {
            try {
                pages.get(pageNumber).click();
                flag = false;
            } catch (Throwable t) {
                flag = true;
            }
        } while (flag);
        flag = true;
        do {
            try{
                if (pages.get(pageNumber).isDisplayed()) flag = false;
            } catch (Throwable t) {
                flag = false;
            }
        } while (flag);
    }
}
