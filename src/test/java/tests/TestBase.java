package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    @BeforeEach
    void beforeEach() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://testjmb.alfabank.ru/";
    }

    @AfterEach
    void afterEach() {
        Selenide.closeWebDriver();
    }
}
