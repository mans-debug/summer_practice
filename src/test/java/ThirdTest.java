import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import static org.hamcrest.core.Is.is;

public class ThirdTest extends AbstractSeleniumTest{
    @Test
    public void failure_search_1(){
        webDriver.get("https://yandex.ru/");
        String text = "Куплю гаража";
        collector.checkThat(text, is(TextFinder.find(webDriver, text).getText()));
    }
     @Test
    public void failure_search_2(){
        webDriver.get("https://yandex.ru/");
        String text = "Возьму в ипотеку под 1%";
         collector.checkThat(text, is(TextFinder.find(webDriver, text).getText()));
    }
     @Test
    public void failure_search_3(){
        webDriver.get("https://yandex.ru/");
        String text = "Какой-то нелепый текст";
         collector.checkThat(text, is(TextFinder.find(webDriver, text).getText()));
    }
     @Test
    public void failure_search_4(){
        webDriver.get("https://yandex.ru/");
        String text = "У меня кончилась фантазия";
         collector.checkThat(text, is(TextFinder.find(webDriver, text).getText()));
    }
     @Test
    public void success_search_1(){
        webDriver.get("https://yandex.ru/");
        String text = "найти товар по фото";
        collector.checkThat(text, is(TextFinder.find(webDriver, text).getText()));
    }

}
