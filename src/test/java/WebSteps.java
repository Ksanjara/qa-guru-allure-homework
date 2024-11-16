import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps{

    @Step("Открыть главную страницу гитхаб")
    public void openMainPage() {
        open("");
    }

    @Step("Найти репозиторий {repo}")
    public void searchForRepository(String repo) {
        $(".header-search-button").click();
        $("#query-builder-test").sendKeys(repo);
        $("#query-builder-test").submit();
    }

    @Step("Кликнуть по ссылке репозитория {repo}")
    public void clickOnRepositoryLink(String repo) {
        $(linkText(repo)).click();
    }

    @Step("Открыть таб Issues")
    public void openIssuesTab() {
        $("#issues-tab").click();
    }

    @Step("Проверить наличие Issue с названием {issue}")
    public void shouldSeeIssueWithNumber(String issue) {
        $(withText(issue)).should(Condition.exist);
    }
}
