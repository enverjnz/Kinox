# Kinox
Hallo,

mit unserem Programm Kinox verliert man nie den Überblick über seine Filme!

Über unsere Benutzeroberfläche können Attributwerte für ein Film-Objekt eingegeben werden (Titel, Genre, etc.).
Durch das Klicken auf den "Film speichern"-Button wird das jeweilige Film-Objekt in die ArrayList "meineFilme" gespeichert und auf der TextArea formatiert angezeigt.
Der Zähler über der TextArea verfolgt, wie viele Objekte (Filme) sich in der ArrayList befinden, und zählt automatisch mit.

Auch das Filtern nach Genres ist möglich. Dafür wird ein Filterkriterium aus der JComboBoxFilter ausgewählt und
abschließend auf den "Filter anwenden"-Button gedrückt. Dann wird die TextArea geleert, und eine for-each-Schleife
durchläuft die ArrayList mit dem Ziel, nur die Objekte mit dem passenden Genre wieder auf der TextArea anzuzeigen (.append).
Durch einen Klick auf "Alle anzeigen" werden wieder alle Objekte auf der TextArea dargestellt. Dafür sorgt ebenfalls
eine for-each-Schleife.

Möchte man Filme löschen, klickt man auf den "Löschen"-Knopf. Aber ACHTUNG: Es werden immer alle Filme in der
ArrayList gelöscht. Das wird jedoch mit einer YES_NO_OPTION abgesichert.

Allgemein interagiert unser Programm viel mit dem Benutzer. Es gibt zum Beispiel eine Meldung, wenn ein Film gespeichert wurde,
wenn man wichtige Eingabefelder leer lässt und sogar, wenn man beim Erscheinungsjahr Buchstaben anstelle von Zahlen angibt.
Dank unserer try-catch-Anweisung, if-Anweisungen und einer extra try-catch-Anweisung wird ein sauberes Exception-Handling ermöglicht.

Ob ein Film 3D ist und wie die Bewertung ausfällt, spielt in die Preisberechnung der Filme mit hinein. Diese Methode ist in der Film-Klasse
aufgeführt und wird ausgiebig mithilfe von JUnit-Tests getestet.

Wir wünschen euch viel Spaß mit Kinox!

