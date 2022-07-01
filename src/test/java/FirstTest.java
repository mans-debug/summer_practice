import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import static org.junit.Assert.*;
public class FirstTest extends AbstractSeleniumTest{

    @Test
    public void success_search(){
        webDriver.get("https://yandex.ru/");
        assertNotNull(TextFinder.find(webDriver, "Яндекс"));
    }

    @Test
    public void failure_search(){
        webDriver.get("https://yandex.ru/");
        assertThrows(NoSuchElementException.class, () -> TextFinder.find(webDriver, "длвомдлоыв"));
    }
}
