import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Electricity {
    WebDriver driver;

    @BeforeEach
    public void testStart() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(800, 600));
        driver.get("https://ebok.gkpge.pl/ebok/faces/profil/logowanie.xhtml");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hiddenLoginForm")));
    }

    @AfterEach
    public void testend() {
        driver.close();
        driver.quit();
    }

    @Test
    public void electricityBill() {
        String username = "aaa";
        String password = "bbb";
        String loggedURL = "https://ebok.gkpge.pl/ebok/index.xhtml";
        driver.findElement(By.id("loginForm:email")).sendKeys(username);
        driver.findElement(By.id("loginForm:haslo")).sendKeys(password);
        driver.findElement(By.id("loginForm:haslo")).sendKeys(Keys.RETURN);
        Assertions.assertFalse(driver.getPageSource().contains("ui-messages-error-summary"), "Incorrect password or login");
        Assertions.assertEquals(loggedURL, driver.getCurrentUrl(), "Incorrect redirection, URL is not: " + loggedURL);

    }
}
