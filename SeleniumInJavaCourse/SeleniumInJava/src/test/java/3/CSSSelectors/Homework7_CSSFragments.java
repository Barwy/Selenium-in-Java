import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework7_CSSFragments {
    WebDriver driver;

    @BeforeEach
    public void teststart() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1280, 1024));
        driver.get("https://fakestore.testelka.pl/cwiczenia-z-selektorow-fragmenty-wartosci-atrybutow/");
    }

    @AfterEach
    public void testEnd() {
        driver.close();
        driver.quit();
    }

    @Test
    public void partsOfCSS() {
        //1. Button1, Button 2, Btn 3, Btn 4
        driver.findElement(By.cssSelector("a[class^='button']"));
        //2. Btn 3, Btn 4, Btn -> [title*='Btn'];[id|='btn']
        driver.findElement(By.cssSelector("[title^='Btn']"));
        //3. Btn 3, Btn 7 -> [style*='background-color: #db456f']
        driver.findElement(By.cssSelector("[style$='background-color: #db456f']"));
        //4. Button1, Button 2, Button 5
        driver.findElement(By.cssSelector("[title^='Button ']"));
        //5. Button1, Btn 3, Button 5 -> .accent
        driver.findElement(By.cssSelector("[class~='accent']"));
        //6. Button 2, Button6, Btn 7 -> .primary; [class*='primary test']
        driver.findElement(By.cssSelector("[class|='button primary test']"));
        //7. Button1, Btn 3, Btn 4, Button 5
        driver.findElement(By.cssSelector("[class*='accent']"));
    }
}