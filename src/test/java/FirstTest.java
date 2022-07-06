import org.junit.Test;
import org.openqa.selenium.WebElement;

import static org.hamcrest.core.Is.is;

/**
 * First test: one successful check
 * */
public class FirstTest extends AbstractSeleniumTest{

    /**
     * Переходим по ссылке
     * Пытаемся найти "Яндекс"
     * Тест должен пройти
     * */
    @Test
    public void success_search(){
        webDriver.get("https://yandex.ru/");
        String text = "Яндекс";
        WebElement element = TextFinder.find(webDriver, text);
        String res = element.getText();
        collector.checkSucceeds(() -> TextFinder.find(webDriver, text));
    }


}
