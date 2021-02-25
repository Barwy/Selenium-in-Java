import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;

public class Homework1 {

    WebDriver driver;

    @BeforeEach
    public void driverSetup(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterEach
    public void DriverQuit() {
        driver.close();
        driver.quit();
    }

    @Test
    public void homework1() {
        driver.navigate().to("https://pl.wikipedia.org/wiki/Wikipedia:Strona_g%C5%82%C3%B3wna");
        //driver.get("www.wiki.pl") - alternatywa
        driver.navigate().to("https://nasa.gov");
        driver.navigate().back();
        String wikiURL = "https://pl.wikipedia.org/wiki/Wikipedia:Strona_g%C5%82%C3%B3wna";
        Assertions.assertEquals(wikiURL, driver.getCurrentUrl(), "URL is incorrect");
        driver.navigate().forward();
        String nasaURL = "https://nasa.gov";
        Assertions.assertEquals(nasaURL, driver.getCurrentUrl(), "URL is incorrect");
    }

}
