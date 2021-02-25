import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {
    WebDriver driver;

    @BeforeEach
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize( new Dimension(800, 600));
    }

    @AfterEach
    public void testEnd() {
        driver.quit();
    }

    @Test
    //adnotacja mówiąca, że pod nią znajduje sie metoda testowa
    public void demoTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //path to driver
        WebDriver driver = new ChromeDriver();
        //webdriver to interfejs, a chromedriver to jedna z klas implementujących ten interfejs.
        driver.manage().window().setSize (new Dimension(  800, 600));
        String googleURL = "https://www.google.pl";
        driver.navigate().to( "https://google.pl");
        Assertions.assertEquals(googleURL, driver.getCurrentUrl(), "Adresses are not the same!");
        //Sprawdzamy, czy google przekieruje nas na www.google.pl (googleURL).
    }

    @Test
    public void getTitleTest() {
        String googleTitle = "Google";
        //Tytuł strony można znaleźć w "Elements" strony po otwarciu narzędzi deweloperskich w przeglądarce.
        driver.get("https://google.pl");
        Assertions.assertEquals(googleTitle, driver.getTitle(), "Titles do not match");
    }

    @Test
    public void getSource() {
        String imageSource = "/images/branding/googleg/1x/googleg_standard_color_128dp.png";
        driver.get("https://www.google.pl");
        Assertions.assertTrue(driver.getPageSource().contains(imageSource),"Image not found!");
        //Sprawdzamy w źródle "source" strony dowolny fragment kodu.
        //Czy to, co podajemy znajduje się na stronie docelowej.
    }



}
