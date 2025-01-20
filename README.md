# Kinox
Hallo,

mit unserem Programm Kinox verliert man nie den Überblick über seine Filme !

Über unsere Benutzeroberfläche können Attributwerte für ein Film Objekt eingegeben werden (Titel, Genre, etc,...). 
Durch das klicken auf den "Film speichern" Button, wird das jeweilige Film Objekt in die ArrayList "meineFilme" gespeichert 
und auf der TextArea formatiert angezeigt.
Der Zähler über der TextArea verfolgt wie viele Objekte(Filme) sich in der ArrayList befinden und zählt für uns automatisch mit.

Auch das Fitern nach Genres ist möglich. Dafür wird ein Kriterium aus der JcomboBoxFilter ausgewählt und 
abschließend auf den "Filter anwenden" Button gedrückt. Dann wird die TextArea geleert und eine for-each Schleife
durchläuft die ArrayList, mit dem Ziel, nur die Objekte mit dem passendem Genre wieder auf der TextArea zu zeigen
(.append).
Durch einen Klick auf "alle anzeigen" werden wieder alle Objekte auf der TextArea angezeigt. Dafür sorgt ebenfalls
eine for-each Schleife.
Möchte man Filme löschen, klickt man auf den "löschen Knopf". Aber ACHTUNG: Es werden immer alle Filme in der
ArrayList gelöscht. Das wird jedoch abgesichert mit einer YES_NO_OPTION.

Allgemein interagiert unser Programm viel mit dem Benutzer. Es gibt zum Beispiel eine Meldung wenn ein Film gespeichert wurde,
wenn man wichtige Eingabefelder leer lässt und sogar wenn man beim Erscheinungsjahr Buchstaben anstelle von Zahlen angibt. Durch unsere
try-catch Anweisung die if-Anweisungen und eine extra try-catch Anweisung enthällt, wird ein sauberes Exception Handling ermöglicht.

Ob ein Film 3D ist, und die Bewertung, spielen in die Preisberechnung der Filme mit rein. Diese Methode ist in der Film Klasse
aufgeführt und wird ausgibig mithilfe von JUnit Tests getestet.

Wir wünschen euch viel Spaß mit Kinox !

