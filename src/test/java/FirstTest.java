import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import static org.hamcrest.core.Is.is;

/**
 * First test: one successful check
 * */
@Log4j
public class FirstTest extends AbstractSeleniumTest{

    /**
     * Переходим по ссылке
     * Пытаемся найти "Яндекс"
     * Тест должен пройти
     * */
    @Test
    public void success_search(){
        webDriver.get("https://yandex.ru/");
        log.info("Started executing first test. One successful search");
        String text = "Яндекс";
        log.info("Searching 'Яндекс'");
        check(text);
    }


}
