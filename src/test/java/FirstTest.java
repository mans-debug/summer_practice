import org.hamcrest.core.*;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import static java.util.Objects.isNull;
import static org.hamcrest.core.Is.is;

public class FirstTest extends AbstractSeleniumTest{

    @Test
    public void success_search(){
        webDriver.get("https://yandex.ru/");
        String text = "Яндекс";
        collector.checkThat(text, is(TextFinder.find(webDriver, text).getText()));
    }


}
