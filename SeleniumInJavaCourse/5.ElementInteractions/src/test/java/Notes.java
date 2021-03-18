public class Notes {
}
//TIMEOUTS
/*Pozwalają na poczekanie.
driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); - ta linijka zawarta w @BeforeEach sprawi, że driver
    będzie czekał do 5 sekund na załadowanie każdego sprawdzanego elementu w @Test, który jest poprzedzony
    findelement(By by) oraz sindElements(By by) domyślna wartośc to 0 sekund.
    Nie znalezienie elementu w wyznaczonym czasie skutkuje błędem "NoSuchelementException".

driver.manage().timeouts().pageLoadTimeout(10, timeUnit.SECONDS); - czas jaki driver zaczeka na zaladowanie sie strony,
    domyslnie jest to 300 sekund. Warto zmniejszyć tę wartośc, żeby skrócić czas oczekiwania na waynik.
    Jeśli strona nie załaduje się w wyznaczonym czasie, to dostaniemy "timeoutException". */
