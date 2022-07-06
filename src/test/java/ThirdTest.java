import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import static org.hamcrest.core.Is.is;

/**
 * Third test: one successful check and four unsuccessful ones
 */
public class ThirdTest extends AbstractSeleniumTest {
    /**
     * 4 unsuccessful 1 successful check
     */
    @Test
    public void four_failures_and_one_success(){
        webDriver.get("https://yandex.ru/");
        collector.checkSucceeds(() -> TextFinder.find(webDriver, "Куплю гараж"));
        collector.checkSucceeds(() -> TextFinder.find(webDriver, "Возьму в ипотеку под 1%"));
        collector.checkSucceeds(() -> TextFinder.find(webDriver, "Какой-то нелепый текст"));
        collector.checkSucceeds(() -> TextFinder.find(webDriver, "У меня кончилась фантазия"));
        collector.checkSucceeds(() -> TextFinder.find(webDriver, "Почта"));
    }

}
