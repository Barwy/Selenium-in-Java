package Notes;

public class Notes { }

//Czekanie na elementy
/* driver.manage().timeouts().implicitlyWait(5, timeUnit.SECONDS);
Dzieki temu timeoutowi, selenium poczeka wskazaną ilość czasu na pojawienie sie elementu wskazanego w
driver.findelement, jesli uzywamy driver.findelements - poczeka na pojawienie sie chociaż jednego z elementów
Domyslna wartośc to 0 więc test nie czeka na pojawienie się elementów.
Jesli element nie zostanie znaleziony w okreslonym czasie, pojawi się NoSuchElementException*/

/* driver.manage().timeouts().pageLoadTimeout(10, timeUnit.SECONDS);
Wskazuje czas jaki dajemy stronie na załadowanie się. Domyslnie jest to 300 sekund, co przedłuża testy.
Jesli strona nie zaladuje sie w okreslonym czasie, to pojawi się TimeoutException. */

//------------------------

//Klikanie elementów strony
/* driver.findElement(By.cssSelector("Selector")).click(); <- Symuluje kliknięcie lewym przyciskiem myszy na element
element musi byc "klikalny" żeby był widoczny efekt. */

/* driver.findElement(By.cssSelector("Selector")).submit(); <- metoda działająca wyłącznie na formularzach (obiekt form)
i pojedynczych pola formularza. */

// driver.findElement(By.cssSelector("Selector")).clear(); <- metoda czyszcząca pole tekstowe;

/* driver.findElement(By.cssSelector("Selector")).sendKeys("jakiś tekst"); <- wprowadza tekst w pole;
driver.findElement(By.cssSelector("Selector")).sendKeys(Keys.chord(Keys.CONTROL, "a")); <- kombinacja klawiszy. */

//-------------------------

/* Uploadowanie plików dasie automatyzować gdy tag i jego atrybut type wygladają co najmniej tak: <input type="file"
Test nie symuluje w 100% zachowania użytkownik:

public void fileUpload() {
    WebElement uploadFileInput = driver.findElement(By.cssSelector("input[type='file']"));
    String expectedFileName = "rakieta.png";
    String path = "c:\\dev\\pliki\\rakieta.png";
    uploadFileInput.sendKeys(path);

    String ActualFName = driver.findElement fileName = driver.findElement(By.cssSelector("selecotr")).getText();
    Assertions.assertEquals(expectedFileName, actualFileName, "Uploaded file's name does not match the expected one");
} */

//---------------------------

/*  String userdisplayedName = "Geralt";
    String myAccountContent = driver.findElement(By.cssSelector("div[class='woocommerce-MyAccount-content']>p")).getText();
    Assertions.assertTrue(myAccountContent.contains(userDisplayName), "Name displayed is not " + userdisplayedName); */
