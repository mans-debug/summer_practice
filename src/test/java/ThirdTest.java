import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.qameta.allure.model.Status;
import org.junit.Test;

/**
 * Third test: one successful check and four unsuccessful ones
 */
public class ThirdTest extends AbstractSeleniumTest {
    /**
     * Переходим по ссылке
     * Пытаемся найти слова:
     * "Куплю гараж", "Возьму в ипотеку под 1%", "Какой-то нелепый текст", "У меня кончилась фантазия"
     * "Почта"
     * В первых четырех должна вылететь ошибка, последний должен пройти
     */
    @Test(expected = Exception.class)
    @Step("Third test")
    public void four_failures_and_one_success() {
        webDriver.get("https://yandex.ru/");
        first_failure("Куплю гараж");
        second_failure("Возьму в ипотеку под 1%");
        third_failure("Какой-то нелепый текст");
        fourth_failure("У меня кончилась фантазия");
        first_success("Почта");
    }



    @Step(value = "Fail #1")
    private void first_failure(String text) {
        collector.checkSucceeds(() -> TextFinder.find(webDriver, text));
        markStepAsFailed();
    }

    private void markStepAsFailed() {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.setStatus(Status.FAILED));
        Allure.getLifecycle().stopStep();
    }

    @Step(value = "Fail #2")
    private void second_failure(String text) {
        collector.checkSucceeds(() -> TextFinder.find(webDriver, text));
        markStepAsFailed();
    }

    @Step(value = "Fail #3")
    private void third_failure(String text) {
        collector.checkSucceeds(() -> TextFinder.find(webDriver, text));
        markStepAsFailed();
    }

    @Step(value = "Fail #4")
    private void fourth_failure(String text) {
        collector.checkSucceeds(() -> TextFinder.find(webDriver, text));
        markStepAsFailed();
    }

    @Step(value = "Success #1")
    private void first_success(String text) {
        collector.checkSucceeds(() -> TextFinder.find(webDriver, text));
    }

}
