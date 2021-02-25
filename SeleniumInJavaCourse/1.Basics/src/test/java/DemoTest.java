import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoTest {
    WebDriver driver;

    @BeforeEach
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().window().setSize(new Dimension(800, 600));
    }

    @AfterEach
    public void testEnd() {
        this.driver.quit();
    }

    @Test
    public void demoTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(800, 600));
        String googleURL = "https://www.google.pl/";
        driver.navigate().to("https://google.pl");
        Assertions.assertEquals(googleURL, driver.getCurrentUrl(), "Adresses are not the same!");
    }

    @Test
    public void getTitleTest() {
        String googleTitle = "Google";
        this.driver.get("https://google.pl");
        Assertions.assertEquals(googleTitle, this.driver.getTitle(), "Titles do not match");
    }

    @Test
    public void getSource() {
        String imageSource = "/images/branding/googleg/1x/googleg_standard_color_128dp.png";
        this.driver.get("https://www.google.pl");
        Assertions.assertTrue(this.driver.getPageSource().contains(imageSource), "Image not found!");
    }
}
