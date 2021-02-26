import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSSelectors {
    WebDriver driver;

    @BeforeEach
    public void testStart() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(800, 600));
        driver.get("https://www.amazon.com");
    }

    @AfterEach
    public void testEnd() {
        driver.close();
        driver.quit();
    }

    @Test
    public void CSSTest() {
        driver.findElement(By.cssSelector("[id=twotabsearchtextbox]"));
    }
}
