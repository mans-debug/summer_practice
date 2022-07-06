import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import static org.hamcrest.core.Is.is;

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
     * */
    @Test()
    public void four_failures_and_one_success(){
        webDriver.get("https://yandex.ru/");
        collector.checkSucceeds(() -> TextFinder.find(webDriver, "Куплю гараж"));
        collector.checkSucceeds(() -> TextFinder.find(webDriver, "Возьму в ипотеку под 1%"));
        collector.checkSucceeds(() -> TextFinder.find(webDriver, "Какой-то нелепый текст"));
        collector.checkSucceeds(() -> TextFinder.find(webDriver, "У меня кончилась фантазия"));
        collector.checkSucceeds(() -> TextFinder.find(webDriver, "Почта"));
    }

}
