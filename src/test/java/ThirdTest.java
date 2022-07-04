import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import static org.hamcrest.core.Is.is;

/**
 * Third test: one successful check and four unsuccessful ones
 */
public class ThirdTest extends AbstractSeleniumTest {
    /**
     * Unsuccessful check with word "Куплю гараж"
     */
    @Test(expected = NoSuchElementException.class)
    public void failure_search_1() {
        webDriver.get("https://yandex.ru/");
        String text = "Куплю гараж";
        collector.checkSucceeds(() -> TextFinder.find(webDriver, text));

    }

    /**
     * Unsuccessful check with word "Возьму в ипотеку под 1%"
     */
    @Test(expected = NoSuchElementException.class)
    public void failure_search_2() {
        webDriver.get("https://yandex.ru/");
        String text = "Возьму в ипотеку под 1%";
        collector.checkSucceeds(() -> TextFinder.find(webDriver, text));
    }

    /**
     * Unsuccessful check with word "Какой-то нелепый текст"
     */
    @Test(expected = NoSuchElementException.class)
    public void failure_search_3() {
        webDriver.get("https://yandex.ru/");
        String text = "Какой-то нелепый текст";
        collector.checkSucceeds(() -> TextFinder.find(webDriver, text));
    }

    /**
     * Unsuccessful check with word "У меня кончилась фантазия"
     */
    @Test(expected = NoSuchElementException.class)
    public void failure_search_4() {
        webDriver.get("https://yandex.ru/");
        String text = "У меня кончилась фантазия";
        collector.checkSucceeds(() -> TextFinder.find(webDriver, text));
    }

    /**
     * Successful check with word "Браузер"
     */
    @Test
    public void success_search_1() {
        webDriver.get("https://yandex.ru/");
        String text = "Браузер";
        collector.checkSucceeds(() -> TextFinder.find(webDriver, text));
    }

}
