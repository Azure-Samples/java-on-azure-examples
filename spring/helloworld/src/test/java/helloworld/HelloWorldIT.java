package helloworld;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.microsoft.playwright.*;

public class HelloWorldIT {
    
    @Test
    public void testHelloWorld() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
              .setHeadless(true));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("http://localhost:8080/");
            // Assert that "Hello World" is found on the page
            assertTrue(page.content().contains("Hello World"));
          }
    }
}
