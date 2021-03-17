import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathHomework2 {
    WebDriver driver;

    @BeforeEach
    public void testStart() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1280, 800));
        driver.get("https://fakestore.testelka.pl/cwiczenia-z-selektorow-xpath/");
    }

    @AfterEach
    public void testEnd() {
        driver.close();
        driver.quit();
    }

    @Test
    public void XPathTest2() {
        //Adres nabywcy --> .//strong[text()='nabywca']/.. lub .//strong[text()='nabywca']/parent::td
        driver.findElement(By.xpath(".//thead/tr[2]/td[2]"));
        driver.findElement(By.xpath(".//thead/tr/following-sibling::*[1]/*/following-sibling::*[1]"));
        //100 (ilość) --> .//*[text()='Bloczek samoprzylepny']/../td[2]
        driver.findElement(By.xpath(".//tbody/tr[2]/td[2]"));
        driver.findElement(By.xpath("//tbody/tr[2]/td/following-sibling::*[1]"));
        //10.00 (cena jedn.)
        driver.findElement(By.xpath(".//tbody/tr[2]/td[3]"));
        //1000.00 (Koszt)
        driver.findElement(By.xpath(".//tbody/tr[2]/td[4]"));
    }
}
