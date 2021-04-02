import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

    /*
1. +Ustaw rozmiar przeglądarki na 854x480;
2. +Ustaw pozycje przeglądarki na 445x30;
3. +Pobierz rozmiar okna i wykonaj asercję;
4. +Pobierz pozycję okna i wykonaj asercję;
5. Zmaksymalizuj okno przeglądarki;
6. Ustaw przeglądarke na fullscreen;
 */

public class Homework4_WindowOptions {
    WebDriver driver;

    @BeforeEach
    public void sessionStart() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(854, 480));
        driver.manage().window().setPosition(new Point(445, 30));
    }

    @AfterEach
    public void sessionEnd() {
        driver.close();
        driver.quit();
    }

    @Test
    public void windowTest() {
        Dimension size = driver.manage().window().getSize();
        Assertions.assertEquals(new Dimension(854, 480), size, "Incorrect size!");
        Point position = driver.manage().window().getPosition();
        Assertions.assertEquals(new Point(445, 30), position, "Incorrect position");
        driver.manage().window().maximize();
        driver.manage().window().fullscreen();
    }
}

/*
    @Test
    public void rozwiazanieTestelki() {
    Dimension size = new Dimension(845, 480);
    driver.manage().window().setSize(size);
    Point position = new Point(445, 30);
    driver.manage().window().setPosition(position);
    Assertions.assertEquals(size, driver.manage().window().getSize(),
            "Size of the window is not: (" + size.width + ", "+ size.height + "). ");
    Assertions.assertEquals(position, driver.manage().window().getPosition(),
            "Position of the window is not (" + position.x + ", "+ position.y +" )");
    driver.manage().window().maximize();
    driver.manage().window().fullscreen();
}
 */
