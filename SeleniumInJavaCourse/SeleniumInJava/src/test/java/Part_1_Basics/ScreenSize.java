import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenSize {
    WebDriver driver;

    @BeforeEach
    public void startup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension( 800, 600));
        driver.manage().window().setPosition(new Point(6, 30));
    }

    @AfterEach
    public void finish() {
        driver.close();
        driver.quit();
    }

    @Test
    public void sizeTest() {
        Point position = driver.manage().window().getPosition();
        Assertions.assertEquals(new Point(6, 30), position, "Unexpected window position!");
        Dimension size = driver.manage().window().getSize();
        Assertions.assertEquals(new Dimension(800, 600), size, "Incorrect window size!");
        driver.manage().window().fullscreen();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.manage().window().maximize();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}