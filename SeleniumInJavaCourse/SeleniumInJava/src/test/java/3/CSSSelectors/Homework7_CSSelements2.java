import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//https://fakestore.testelka.pl/wyszukiwanie-elementow-poprzez-relacje/

public class Homework7_CSSelements2 {
    WebDriver driver;

    @BeforeEach
    public void testStart(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1280, 800));
        driver.get("https://fakestore.testelka.pl/wyszukiwanie-elementow-poprzez-relacje/");
    }

    @AfterEach
    public void testEnd(){
        driver.close();
        driver.quit();
    }

    @Test
    public void CSSTest2(){
        //pole do wpisania imienia w pierwszym formularzu; --> dd#name-element>input#name
        driver.findElement(By.cssSelector("dd>input#name"));
        //pole do wpisania adresu email w trzecim formularzu;
        driver.findElement(By.cssSelector("div.second-div>input#email"));
        //pole do wpisania adresu email w trzecim formularzu używając selektorów pseudoklas; --> div.second-div>input:nth-child(3)
        driver.findElement(By.cssSelector("div.second-div>input:first-of-type"));
        //przycisk „Subscribe” w piątym formularzu; --> div.second-div>div.div>input#submit
        driver.findElement(By.cssSelector("div.second-div input#submit"));
        //przycisk „Subscribe” w piątym formularzu używając selektorów pseudoklas;
        driver.findElement(By.cssSelector("div.second-div input:last-child"));
        //przycisk „Subscribe” w drugim formularzu; --> div:not([class])>button#submit
        driver.findElement(By.cssSelector("div:not(.second-div)>button#submit"));
        //przycisk „Subscribe” w drugim formularzu używając selektorów pseudoklas;
        driver.findElement(By.cssSelector("div:not(.second-div)>button:only-of-type"));
    }
}
