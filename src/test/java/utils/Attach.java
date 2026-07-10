package utils;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Attach {

    @Attachment(
            value = "{attachName}",
            type = "image/png",
            fileExtension = ".png"
    )
    public static byte[] screenshotAs(String attachName) {
        return Selenide.screenshot(OutputType.BYTES);
    }

    @Attachment(
            value = "Page source",
            type = "text/html",
            fileExtension = ".html"
    )
    public static byte[] pageSource() {
        return getWebDriver()
                .getPageSource()
                .getBytes(StandardCharsets.UTF_8);
    }

    @Attachment(
            value = "Browser console logs",
            type = "text/plain",
            fileExtension = ".txt"
    )
    public static String browserConsoleLogs() {
        return getWebDriver()
                .manage()
                .logs()
                .get("browser")
                .getAll()
                .stream()
                .map(Object::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    @Attachment(
            value = "Video",
            type = "text/html",
            fileExtension = ".html"
    )
    public static String addVideo() {
        String sessionId = ((RemoteWebDriver) getWebDriver())
                .getSessionId()
                .toString();

        return """
                <html>
                    <body>
                        <video width="100%%" height="100%%" controls autoplay>
                            <source src="https://selenoid.autotests.cloud/video/%s.mp4"
                                    type="video/mp4">
                        </video>
                    </body>
                </html>
                """.formatted(sessionId);
    }
}