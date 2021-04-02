import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
1. +Pobierz z wikipedii wszystkie ciasteczka i asercją sprawdź czy są wszystkie;
2. +Dodaj swoje ciasteczko i asercją sprawdź że się udało;
3. +Pobierz swoje ciasteczko i asercją potwierdź jego nazwę;
4. +Usuń swoje ciasteczko używając jego nazwy jako parametru i potwierdź, że zostało usunięte;
5. +Usuń jakieś ciasteczko używając jego nazwy jako parametru i potwierdź, że zostało usunięte;
6. Pobierz dowolne istniejące ciasteczko i asercją potwierdź, że domena, ścieżka i ustawienia flagi http
    są takie jak się oczekuje;
 */

public class Homework3_Cookies {
    WebDriver driver;

    @BeforeEach
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize( new Dimension(800, 600));
        driver.get("https://pl.wikipedia.org/wiki/Wikipedia:Strona_g%C5%82%C3%B3wna");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    public void testEnd() {
        driver.close();
        driver.quit();
    }

    @Test
    public void CookiesHomework() {
        Cookie cookie1 = new Cookie("testCookie1", "value", "/");
        Assertions.assertEquals(6, driver.manage().getCookies().size(), "unexpected numer of cookies!");
        driver.manage().addCookie(cookie1);
        Assertions.assertEquals(7, driver.manage().getCookies().size(), "unexpected number of cookies");
        Assertions.assertNotNull(driver.manage().getCookieNamed("testCookie1"), "No cookie " + cookie1);
        driver.manage().deleteCookie(cookie1);
        Assertions.assertNull(driver.manage().getCookieNamed("testCookie1"), "Cookie still present:" + cookie1);
        driver.manage().deleteCookieNamed("GeoIP");
        Assertions.assertEquals(5, driver.manage().getCookies().size(), "Incorrect number of cookies");

        Cookie cookie = driver.manage().getCookieNamed("WMF-Last-Access");
        Assertions.assertEquals("pl.wikipedia.org", cookie.getDomain());
        //Alternatywnie: Assertions.assertEquals("pl.wikipedia.org", driver.manage().getCookieNamed("WMF-Last-Access").getDomain(), "Incorrect Domain");
        Assertions.assertTrue(cookie.isHttpOnly(), "is not!");
        //Alternatywnie: Assertions.assertEquals(true, driver.manage().getCookieNamed("WMF-Last-Access").isHttpOnly(), "Not httponly");
        Assertions.assertEquals("/", cookie.getPath());
        //Alternatywnie: Assertions.assertEquals("/", driver.manage().getCookieNamed("WMF-Last-Access").getPath(), "Incorrect path");
    }
}
