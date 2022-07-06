import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
/**
 * Abstract class which is used for all tests
 * */
public abstract class AbstractSeleniumTest {
    protected WebDriver webDriver;

    @Rule
    public final ErrorCollector collector = new ErrorCollector();

    /**
     * Initializes web-driver before each test
     * */
    @Before
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        webDriver = new FirefoxDriver();
    }

    /**
     * Closes all tabs, browser and web driver after each test
     * */
    @After
    public void tearDown() {
        webDriver.close();
        webDriver.quit();
    }
}
