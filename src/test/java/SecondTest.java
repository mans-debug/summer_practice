import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class SecondTest extends AbstractSeleniumTest{
    @Test
    public void failure_search(){
        webDriver.get("https://yandex.ru/");
        String text = "Продам гараж";
        collector.checkThat(text, is(TextFinder.find(webDriver, text).getText()));
    }
}
