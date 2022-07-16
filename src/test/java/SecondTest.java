import lombok.extern.log4j.Log4j;
import org.apache.log4j.Appender;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertNotNull;


/**
 * Second test: one unsuccessful check
 * */
@Log4j
public class SecondTest extends AbstractSeleniumTest{

    /**
     * Переходим по ссылке
     * Пытаемся найти "Продам гараж""
     * Тест не должен пройти
     * */
    @Test(expected = Exception.class)
    public void failure_search(){
        log.info("Started executing second test. One unsuccessful search");
        webDriver.get("https://yandex.ru/");
        log.info("Searching for 'Продам гараж'");
        String text = "Продам гараж";
        check(text);
    }




}
