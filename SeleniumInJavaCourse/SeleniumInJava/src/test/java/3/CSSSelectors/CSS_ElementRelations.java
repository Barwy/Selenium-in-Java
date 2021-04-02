public class CSS_ElementRelations {
}
/*
<div id="first-section">
    <button class="btn secondary">Button 1<button>
</div>
<div id="second-section"> (rodzic)
    <button class="btn secondary">Button 2<button> (dziecko)
        <p> cokolwiek </p> (potomek)
</div>  */

//<div  id=         "second-section">
//<tag   atrybut=   "wartość atrybutu">
//

//Do wszystkiego mozna dodawać atrybuty - klasy id itd, żeby łatwiej okreslać, to czego szukamy.
//Wyszukujemy elementów wzgledem innych elementów:
//div.a-cardui-header>div.a-cardui-body;

//div.second-section --> po kropce podajemy wartość dowolnego atrybutu klasy taga <div id="second-section">;

/*Dzieci:
div>button --> Znajdź button który jest dzieckiem diva;
div[class='button test']>button.btn --> j.w. (znajdź button o klasie button, który ma rodzica diva o klasie button test)

Selektory pseudo-klas w css - przed ":" określamy tag szukanego elementu, numerujemy od 1, nie od 0;
p:first-child --> szukane są wszystkie elementy typu "p", które są pierwszym dzieckiem rodzica ( to, co: p:nth-child(1));
div:nth-child(3) --> tag szukanego element, po ":" mówimy znajdź iii element w hierarchii diva w dół,
                liczone są wszystkie dzieci, niezaleznie od typu/taga, jesli jest to div, to jest on zwracany.
div:nth-last-child(2) --> j.w tylko szukamy od końca hierarchii - "drugie dziecko od końca";
button:last-child --> szukamy ostatniego w hierarchii elementu o danym tagu - działa jak div:nth-last-child(1);
:last-child() --> ostatnie dziecko elementu, jeśli przed ":" dodamy tag, to znajdzie ostatni element otym tagu, np. div;
div:nth-of-type(2) --> sprawdzny jest typ elementu, znalezione zostanie ii dziecko, które jest divem;
div:nth-last-of-type(2) --> j.w. tylko liczone od końca chirarchii;

button:first-of-type --> znajdzie pierwszy button, który jest tego typu elementem pod swoim rodzicem;
button:last-of-type --> znajdzie button, który jest ostatnim tego typu elementem pod swoim rodzicem;
p:only-of-type --> znajdzie elementy o tagu "p" które są jedynym takim elementem tego typu pod swoim rodzicem;
*/

/*Rodzeństwo:
div+button --> znajdź buttony, które są bezpośrednio po divie (są na tym samym poziomie hierarchii co div i znajdują się ponim);
div[class='button test']+button.btn --> j.w
div~button --> znajdź wszystkie elementy nastepujące po divie, które znajdują się na jego poziomie w hierarchii;
*/

/* Potomkowie:
div button --> znajdź buttony, które są potomkami (także dziećmi) elementu div, znajduje się dowolnie głęboko w hierarchii.
div[class='button test'] button.btn --> j.w
*/

/*Przykłady:
div[class='nav-right']:nth-last-child(2) == div.nav-right:nth-last-child(2)
div.nav-left>a:only-of-type --> . używamy gdy mamy do czynienia z klasą;
div#nav-belt a:only-of-type --> # używamy gdy mamy do czynienia z id;
 */

/*Negacja (!=) pozwala zapisać, że znaleziony CSS ma nie zawierać czegoś. 3 sposoby użycia:
:not()
span:not(#name)
span:not([id]) --> w [] anzjduje sie atrybut, którego ne chcemy
Przykład: div:not(.second-div)>button:only-of-type */