package qa.guru.allure;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.annotation.*;

public class LabelsTest {

    @Test
    @Owner("julia.podolko")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Задачи в репозитории")
    @Story("Просмотр созданных задач в репозитории")
    @DisplayName("Мой любимый тест")
    @Link(value = "Тестинг", url = "https://github.com")
    public void testGithubIssue() {
    }

    @Test
    public void testCode() {
        Allure.label("owner", "julia.podolko");
        Allure.label("severity", SeverityLevel.CRITICAL.value());
        Allure.feature("Задачи в репозитории");
        Allure.story("Просмотр созданных задач в репозитории");
        Allure.link("Тестинг", "https://github.com");
    }

    @Documented
    @Owner("julia.podolko")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Задачи в репозитории")
    @Story("Просмотр созданных задач в репозитории")
    @Target({ElementType.TYPE, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface IssueShow {

    }
}
