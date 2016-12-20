package ru.pflb;

import com.codeborne.selenide.Configuration;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;

import java.util.HashMap;
import java.util.Map;


public class BaseTest {

    public static Map<String, Object> context = new HashMap<>();

    @BeforeTest
    public void before() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/main/java/ru/pflb/core/chromedriver.exe");
        Configuration.browser = "chrome";
    }
}
