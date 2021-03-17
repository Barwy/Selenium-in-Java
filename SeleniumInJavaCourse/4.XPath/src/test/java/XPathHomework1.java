import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathHomework1 {
    WebDriver driver;

    @BeforeEach
    public void testStart() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1280, 800));
        driver.get("https://fakestore.testelka.pl/cwiczenia-z-selektorow-atrybuty-w-xpath/");
    }

    @AfterEach
    public void testEnd() {
        driver.close();
        driver.quit();
    }

    @Test
    public void XPathTest() {
        //Przyciski 1, 2, 5, 6. --> .//*[contains(@title, 'Button')];
        driver.findElement(By.xpath(".//div/*[text()='Button']"));
        //Przyciski 3 i 7. --> .//*[contains(@style, 'background-color: #db456f')];
        driver.findElement(By.xpath(".//div/*[contains(@style, '#db456f')]"));
        //Przyciski 3, 4, 7. --> .//*[contains(text(), 'Btn')] lub .//*[contains(@id(), 'btn')]
        driver.findElement(By.xpath(".//div/*[contains(@title, 'Btn ')]"));
        //Przyciski 1, 2, 5. --> .//*[contains(@id, 'button-')
        driver.findElement(By.xpath(".//div/*[contains(@id, 'button-') and contains(@title, 'Button')]"));
        //Przyciski 2, 6, 7. --> .//*[@class='button primary test']
        driver.findElement(By.xpath(".//div/*[contains(@class, 'button primary test')]"));
        //Przyciski 1, 3, 4, 5. --> .//*[contains(@class, 'button accent')]
        driver.findElement(By.xpath(".//div/*[starts-with(@class, 'button accent')]"));
        //Przyciski 1, 3, 5. --> .//*[contains(@class, 'accent') and not(contains(@class, 'accent-test'))]
        driver.findElement(By.xpath(".//div[@class='entry-content']/div/div/*[not(contains(@class, 'test'))]"));
        //Przyciski 1 i 5. --> .//*[text()='Button' and contains(@class, 'button accent')]
        driver.findElement(By.xpath(".//div[@class='entry-content']/div/div/*[not(contains(@class, 'button primary')) and not(contains(@title, 'Btn'))]"));
    }
}
