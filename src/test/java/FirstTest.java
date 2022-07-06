import org.junit.Test;
import org.openqa.selenium.WebElement;

import static org.hamcrest.core.Is.is;

/**
 * First test: one successful check
 * */
public class FirstTest extends AbstractSeleniumTest{

    /**
     * successful check
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
