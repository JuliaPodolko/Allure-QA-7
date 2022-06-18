package qa.guru.allure;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class LambdaStepTest {
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE_NUMBER = 76;
    @Test
    public void testGithubIssue() {
//        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем главную страницу", ()-> {
            open("https://github.com");
        });
        step("Ищем репозиторий " + REPOSITORY, ()-> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Переходим по ссылке репозитория " + REPOSITORY, ()-> {
            $(linkText(REPOSITORY)).click();
        });
        step("Кликаем на таб Issues", ()-> {
            $(partialLinkText("Issues")).click();
        });
        step("Проверяем что существует Issue с номером " + ISSUE_NUMBER, ()-> {
            $(withText("#76")).should(Condition.visible);
        });

    }
}
