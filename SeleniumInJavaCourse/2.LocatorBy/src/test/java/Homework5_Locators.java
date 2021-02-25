import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
Znajdz Elementy:
1. +Szukajka w prawym górnym rogu;
2. +Pole do wpisania nazwy użytkownika;
3. +Pole do wpisania hasła;
4. +Przycisk logowania;
5. +Checkbox do zapamiętania hasła;
6. +Link do odzyskiwania hasła;
7. Link do kategorii "żeglarstwo"
 */

public class Homework5_Locators {
    WebDriver driver;

    @BeforeEach
    public void testStart() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(800, 600));
        driver.navigate().to("https://fakestore.testelka.pl/moje-konto/");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    public  void testEnd(){
        driver.close();
        driver.quit();
    }

    @Test
    public void selectorsTest(){
        //int numberOfElements = driver.findElements(By.className("woocommerce-LostPassword")).size();
        driver.findElement(By.tagName("img"));
        int imageCount = driver.findElements(By.tagName("img")).size();
        Assertions.assertTrue(imageCount == 1, "Na stronie znajduje się zbyt wiele obrazków!");

        driver.findElements(By.id("woocommerce-product-search-field-0"));
        driver.findElement(By.name("s"));

        driver.findElement(By.className("search-field"));

        driver.findElement(By.name("username"));
        driver.findElement(By.id("username"));

        driver.findElement(By.name("password"));
        driver.findElement(By.id("password"));

        driver.findElement(By.name("login"));

        driver.findElement(By.name("rememberme"));
        driver.findElement(By.name("rememberme"));

        driver.findElement(By.linkText("Nie pamiętasz hasła?"));
        driver.findElement(By.partialLinkText("Nie pamiętasz"));

        driver.findElement(By.linkText("Żeglarstwo"));
    }
}
