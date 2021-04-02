package Part_3_CSSSelectors;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
Zlokalizuj za pomocą lokatorów CSS:
1. +okienko użytkownik/email;
2. +okienko hasło;
3. +okienko adres email;
4. +okienko hasło
5. +przyciks zaloguj;
6. +checkbox zapamietaj;
7. +link "nie pamiętasz hasła?";
8. +przycisk zarejestruj się;
9. +link do kategorii "Wspinaczka"
 */

public class Homework6_CSSSelectors1 {
    WebDriver driver;

    @BeforeEach
    public void testStart() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(800, 600));
        driver.get("https://fakestore.testelka.pl/moje-konto/");
    }

    @AfterEach
    public void testEnd() {
        driver.close();
        driver.quit();
    }

    @Test
    public void CSSTest(){
        //Existing - User/email address field; -> input#username;
        driver.findElement(By.cssSelector("input[id='username']"));
        //Existing - Password field; -> input#password;
        driver.findElement(By.cssSelector("input[type='password'][id='password']"));
        //register - email address -> ;
        driver.findElement(By.cssSelector("input[id='reg_email']"));
        //register - password;
        driver.findElement(By.cssSelector("input[id='reg_password']"));
        //"Log in" button -> button[name='login'];
        driver.findElement(By.cssSelector("button[name='login']"));
        //"Remember me" checkbox -> [name='rememberme'];
        driver.findElement(By.cssSelector("input[id='rememberme'][value='forever']"));
        //"Forgot password?" link -> .lost_password>a;
        driver.findElement(By.cssSelector("a[href='https://fakestore.testelka.pl/moje-konto/zapomniane-haslo/']"));
        //"Register" button; Avoid values that may change in other languages! -> [name='register']
        driver.findElement(By.cssSelector("button[name='register']"));
        //"Wspinaczka" category link -> a[href='address'] - order of elements may change so it's the safest option;
        //Another solution: .cat-item-16>a;
        driver.findElement(By.cssSelector("li[class='cat-item cat-item-16']"));



    }
}
