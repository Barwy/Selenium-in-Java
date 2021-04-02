package Notes;
public class XPath {
}

/* ściezka bezwzględna:
np. div/span/input - element input w span w div - Nalezy tu podać całą ścieżke od "najgłowniejszego" elementu.*/

/* ścieżka względna:
//div/span/input - wyszukiwanie odbywa sie w całym dokumencie. Wyszukany zostanie input pod spandem pod divem. */

/* Zapis:
.//input[@id='name'] - nazwa taga po której określamy w [] poszukiwany element;
.//*[@id='name'] - gwiazdka oznacza dowolny element;
.//input[@id='name']/* - znajdź wszystkie dowolne elementy (*) po input id='name';
.//input[@id='name' and @type='band'] - jeden element z 2 atrybutami;
@ przed ciągiem znaków onacza, że będzie to atrybut.
. na samym poczatku oznacza aktualny węzeł. Wyszukiwanie zadziała też bez kropki, ale pozwala ona szukać xpathów wewnatrz xpathów:
driver.findelement(By.xpath(xpath)).findElement(By.xpath(jakiś inny xpath));
 */

/* Atrybut zawiera:
.//button[contains(@class, 'primary')] - element button którego klasa zawiera słowo "primary";
Atrybut zaczyna sie ciągiem znaków:
.//button[starts-with(@class, 'btn')] - button którego klasa zaczyna sie na "btn"
Szukanie po tekście:
.//button[text()='ciąg znaków'] - wyszukany zostanie tekst "ciąg znaków" nie dajemy @ bo jest to atrybut;
Tekst elementu zawiera ciąg znaków:
.//button[contains(text(), 'Submit')] - zamiast atrybutu podajemy wyszukiwany tekst. Tak samo mozna zrobic ze starts-with;
Atrybut nie zawier:
.//not(@id='button') lub .//a[not(contains(@id, 'xx'))] - znajdzie wyrażenie nie zawierające czegoś; */

//------------------------------------------
/* Lokalizowanie dzieci:
.//span[@class='email']/input - tag input jest dzieckiem taga span.
.//div/span[1]/input - [1] oznacza, że interesuje nas pierwszy span pod divem.
.//div/*[1]/input - *[1] to pierwsze dziecko, dowolny element pod tagiem div. */

/* Potomkowie:
.//div//input[1] - potomków oznaczamy //; tu wskazane zostaną elementy o tagu input, które są najwyżej w hierarchii;
.//div//input[@id='email'] - tu wyszukiwane są tagi input o konkretnych id. */

/* Rodzeństwo:
.//label[@class='required']/following-sibling::input - /following-sibling:: mówi jakiego rodzaju rodzeństwa taga szukamy;
/following-sibling::* - tu szukamy dowolnego rodzeństwa;
/following-sibling::*[1] - tu znajdziemy dowolne pierwsze rodeństwo wskazanego taga; */

/* Rodzice (zawsze jest jeden konkretny):
.//label[@class='required']/.. - selektor xpath wnawiguje się poziom wyżej od wskazanego elementu;
.//label[@class='required']/parent::span - wskazuje konkretny wyższy element który chcemy wskazać;
.//label[@class='required']/parent::* - wskazuje rodzica o dowolnym elemencie. */

/* Przodkowie (dowolny element znajdujący się w hierarchii powyżej naszego):
.//label[@class='required']/ancestor::* - znaleziony zostanie każdy przodek;
/ancestor::div - wskazany zostanie każdy przodek, który jest divem. */

/* Przykłady:
.//div/img - wszystkie elementy o tagu div znajdujące się pod tagiem div;
.//div[@id='gw-card-layout']/div[2]/following-sibling::div[1] - div, który jest pierwszym dzieckiem diva dziecka;
.//div[@id='gw-card-layout']/div[2]/ancestor::* - wynik 6 oznacza, że div ma nad sobą 6 poziomów
    (od samej góry do rodzica włacznie). */