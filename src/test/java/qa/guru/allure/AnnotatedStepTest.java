package qa.guru.allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class AnnotatedStepTest {
    private static final String REPOSITORY = "JuliaPodolko/Allure-QA-7";
    private static final String TITLE = "Comment";
    @Test
    public void testGithubIssue() {
       SelenideLogger.addListener("allure", new AllureSelenide());
       WebSteps steps = new WebSteps();

       steps.openMainPage();
       steps.searchForRepository(REPOSITORY);
       steps.clickOnRepositoryLink(REPOSITORY);
       steps.openIssueTab();
       steps.shouldSeeIssueWithText(TITLE);

    }
}
