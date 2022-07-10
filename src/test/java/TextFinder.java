import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Класс для поиска элементов по тексту
 * */
public class TextFinder {
//  //text()[contains(.,'СМИ')]
    /**
     * Выбрасывает NoSuchElementException если элемент не был найден*/
    public static WebElement find(WebDriver driver, String text) {
        try {
            return driver.findElement(By.xpath(String.format("//*[text() = '%s']", text)));
        } catch (NoSuchElementException e){
            throw new NotFoundException(text);
        }
    }
}
