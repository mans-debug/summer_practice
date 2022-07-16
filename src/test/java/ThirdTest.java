import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.qameta.allure.model.Status;
import lombok.extern.log4j.Log4j;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;

/**
 * Third test: one successful check and four unsuccessful ones
 */
@Log4j
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

        log.info("Started executing third test. Four unsuccessful searches and one successful");
        webDriver.get("https://yandex.ru/");
        log.info("Searching for 'Куплю гараж'");
        first_failure("Куплю гараж");

        log.info("Searching for 'Возьму в ипотеку под 1%'");
        second_failure("Возьму в ипотеку под 1%");

        log.info("Searching for 'Какой-то нелепый текст'");
        third_failure("Какой-то нелепый текст");

        log.info("Searching for 'У меня кончилась фантазия'");
        fourth_failure("У меня кончилась фантазия");

        log.info("Searching for 'Почта'");
        first_success("Почта");
    }


    @Step(value = "Fail #1")
    private void first_failure(String text) {
        check(text);
        markStepAsFailed();
    }

    private void markStepAsFailed() {
        Allure.getLifecycle().updateStep(stepResult -> stepResult.setStatus(Status.FAILED));
        Allure.getLifecycle().stopStep();
    }

    @Step(value = "Fail #2")
    private void second_failure(String text) {
        check(text);
        markStepAsFailed();
    }

    @Step(value = "Fail #3")
    private void third_failure(String text) {
        check(text);
        markStepAsFailed();
    }

    @Step(value = "Fail #4")
    private void fourth_failure(String text) {
        check(text);
        markStepAsFailed();
    }

    @Step(value = "Success #1")
    private void first_success(String text) {
        check(text);
    }
}
