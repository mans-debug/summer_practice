import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;

/**
 * Abstract class which is used for all tests
 */
public abstract class AbstractSeleniumTest {
    protected WebDriver webDriver;
    /**
     * Has to be changed to a directory where log files should be stored
     */
    private String logsDirPath = "/home/mansur/IdeaProjects/summer_practice/errors/";

    @Rule
    public final ErrorCollector collector = new ErrorCollector();

    /**
     * Initializes web-driver before each test
     */
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }

    /**
     * Closes all tabs, browser and web driver after each test
     */
    @After
    public void tearDown() {
        webDriver.quit();
        logErrors();
        injectLogsIntoAllure();
    }

    private void logErrors() {
        Class<ErrorCollector> clazz = ErrorCollector.class;
        try {
            Field errors = clazz.getDeclaredField("errors");
            errors.setAccessible(true);
            List<Throwable> collectedExceptions = (List<Throwable>) errors.get(collector);
            String logName = "log-" + this.getClass().getName() + ".txt";
            if (collectedExceptions.isEmpty())
                return;
//            String currentTime = new SimpleDateFormat().format(LocalDateTime.now());
            try (PrintWriter printWriter = new PrintWriter(logsDirPath +  logName)) {
                for (Throwable collectedException : collectedExceptions) {
                    if (collectedException instanceof NotFoundException){
                        String currentTime = ((NotFoundException) collectedException).getTimeThrown()
                                .format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
                        printWriter.println(currentTime + "\t" + collectedException.getMessage());
                    }
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Attachment(value = "Test report", type = "text/plain")
    public byte[] injectLogsIntoAllure() {

        String logName = logsDirPath + "log-" + this.getClass().getName() + ".txt";
        try {
            return Files.readAllBytes(Paths.get(logName));
        } catch (IOException e) {
            return null;
        }
    }
}
