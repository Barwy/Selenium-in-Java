package Part_3_CSSSelectors;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSSelectors {
    WebDriver driver;

    @BeforeEach
    public void testStart() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(800, 600));
        driver.get("https://www.amazon.com");
    }

    @AfterEach
    public void testEnd() {
        driver.close();
        driver.quit();
    }

    @Test
    public void CSSTest() {
        driver.findElement(By.cssSelector("[id=twotabsearchtextbox]"));
    }
}

//selektor można wyszukać w kosoli przeglądarki wpisując $$("szukany_selektor")

/*
id i szukanie w zakładce elements:
#id -> #twotabsearchtextbox;
typ elementu i jego id -> input#twotabsearchtextbox;
input[id='twotabsearchtextbox']
*/

/*
class i szukanie w zakładce elements:
. i nazwa klasy -> .a-cardui-body -> znajdowane są wszystkie elementy zawierające tę klasę;
tag i nazwa klasy -> div.a-cardui-body;
tagi o danej klasie -> div[class='a-cardui-body'];
*/

/*
Szukanie elementów z 2 klasami (zakładka elements):
wyszukiwany jest dokładnie taki zestaw klas -> [class='a-image-container a-dynamic-image-container'];
z nazwą taga -> div[class='a-image-container a-dynamic-image-container'];
*/


/*
Szukanie po atrybucie: [alt='wartość atrybutu']
Lączenie atrybutów (kolejność nie ma znaczenia):
[class='jakaś-klasa'][height='wartość atrybutu']
.jakaś-klasa[height='wartość atrybutu']
#jakieś-id[title='wartość atrybutu']
#jakieś-id.kajaś-klasa

driver.findElement(By.cssSelector("li[class='cat-item cat-item-18']"));
li - tag;
class - atrybut;

'cat-item cat-item-18' - wartości atrybutu 1 i 2;
a[aria-label='0 items in cart'][tabindex='65']#nav-cart -> przykład z amazon.com
na początku znajduje sie tag "a" mówiący jakiego typu jest to obiekt (tag nie jest obowiązkowy).
*/
