/*1. Wejdź na http://wikipedia.pl
2. 3 Asercje:
- porównaj tytuł strony z oczekiwanym;
- porównaj url strony z oczekiwanym;
- znajdź w kodzie strony informację o języku którego używa i sprawdź, czy tak jest;
3. Zmień język strony na hiszpański (By.cssSelector("a(title='hiszpański')"));
4. 3 kolejne asercje:
- porównaj strony z oczekiwanym;
- porównaj url strony  oczekiwanym;
- Znajdź fragment kodu mówiący o tym jakiego języka używa strona i użyj go do asercji;*/

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework2 {
    WebDriver driver;

    @BeforeEach
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize( new Dimension( 800, 600));
    }

    @AfterEach
    public void testEnd() {
        driver.quit();
    }

    @Test
    public void homework2Test() {
        String wikiTitle = "Wikipedia, wolna encyklopedia";
        String wikiURL = "https://pl.wikipedia.org/wiki/Wikipedia:Strona_g%C5%82%C3%B3wna";
        String wikiLangPL = "lang=\"pl\"";
        driver.get("http://pl.wikipedia.org");
        Assertions.assertEquals(wikiTitle, driver.getTitle(), "Tytuł to nie " + wikiTitle);
        Assertions.assertEquals(wikiURL, driver.getCurrentUrl(), "Adres strony to nie :" + wikiURL);
        Assertions.assertTrue(driver.getPageSource().contains(wikiLangPL), "Błędny język: " + wikiLangPL);
        driver.findElement(By.cssSelector("a[title='hiszpański']")).click();
        String wikiTitleES = "Wikipedia, la enciclopedia libre";
        String wikiURLES = "https://es.wikipedia.org/wiki/Wikipedia:Portada";
        String wikiLangES = "lang=\"es\"";
        Assertions.assertEquals(wikiTitleES, driver.getTitle(), "Tytuł to nie: " + wikiTitleES);
        Assertions.assertEquals(wikiURLES, driver.getCurrentUrl(), "Adres strony to nie" + wikiURLES);
        Assertions.assertTrue(driver.getPageSource().contains(wikiLangES), "Błędny język:" + wikiLangES);
    }

}
