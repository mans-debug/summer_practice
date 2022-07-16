import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import lombok.extern.log4j.Log4j;
import org.apache.log4j.Appender;
import org.apache.log4j.FileAppender;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Abstract class which is used for all tests
 */
@Log4j
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
        log.info("Creating webdriver");
        WebDriverManager.firefoxdriver().setup();
        webDriver = new FirefoxDriver();
    }

    /**
     * Closes all tabs, browser and web driver after each test
     */
    @After
    public void tearDown() {
        log.info("Shutting down web driver");
        webDriver.quit();
        log.info("Collecting and writing errors to a file");
        logErrors();
        log.info("Attaching error logs to allure report");
        injectTestLogsIntoAllure();
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
            try (PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(logsDirPath + logName), StandardCharsets.UTF_16))) {
                for (Throwable collectedException : collectedExceptions) {
                    if (collectedException instanceof NotFoundException) {
                        String currentTime = ((NotFoundException) collectedException).getTimeThrown()
                                .format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
                        printWriter.println(currentTime + "[ERROR]-NotFoundException\t" + collectedException.getMessage());
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
    public byte[] injectTestLogsIntoAllure() {

        String logName = logsDirPath + "log-" + this.getClass().getName() + ".txt";
        try {
            return Files.readAllBytes(Paths.get(logName));
        } catch (IOException e) {
            return null;
        }
    }

    @Attachment(value = "Step log")
    public String injectStepLogs(NotFoundException e) {
        return e.getMessage();
    }

    protected void check(String text) {
        try {
            TextFinder.find(webDriver, text);
        } catch (NotFoundException e) {
            log.error("Could not find phrase " + text, e);
            collector.addError(e);
            injectStepLogs(e);
        }
    }
}
