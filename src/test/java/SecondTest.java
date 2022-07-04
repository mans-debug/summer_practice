import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import static org.hamcrest.core.Is.is;

/**
 * Second test: one unsuccessful check
 * */
public class SecondTest extends AbstractSeleniumTest{

    /**
     * Unsuccessful check with word "найти товар по фото"
     * */
    @Test(expected = NoSuchElementException.class)
    public void failure_search(){
        webDriver.get("https://yandex.ru/");
        String text = "Продам гараж";
        collector.checkSucceeds(() -> TextFinder.find(webDriver, text));
    }
}
