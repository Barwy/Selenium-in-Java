package Part_3_CSSSelectors;

public class CSSFragments {
}
/* Pełnym element: <button class="btn btn-primary btn-register" name="register">
Można wyszukać fragmentu atrybutu np. klasy na następujące sposoby:

Klasa zawiera podany ciąg znaków:
[class*='btn']
[class*='primary btn']

Klasa zaczyna się podanym ciągiem znaków:
[class^='btn']
[class^='bt']

Klasa kończy się podanym ciągiem znaków:
[class$='btn-register']
[class$='register']

Element: <button class="btn btn-primary btn-register btn-register-main">

Wszystkie elementy rozdzielone spacjami:
[class~='btn'] -> .btn
[class~='btn-primary'] -> .btn.primary

Pierwszy element na liście rozdzielonej myślnikami (lista oddzielona myślnikami o danym pierwszym elemencie przed myślnikiem):
[class|='btn btn']



*/
