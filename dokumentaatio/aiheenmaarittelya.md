Taitaa jäädä tohon hold'em käsien vertailuun alussa.

**Aihe**: Ohjelma, joka laskee suhteita voitolle [hold'emissä](https://fi.wikipedia.org/wiki/Texas_hold_%E2%80%99em), kun vastustajan käsi arvataan. Laskentaa on seuraavissa tilanteissa:**
```
-Suhteet flopilla, kun floppia ei tiedetä.
```
```
-Suhteet turnilla, kun floppia eikä turnia tiedetä.
```
```
-Suhteet turnilla, kun floppi tiedetään.
```

**Käyttäjät**: Minä. Ehkä.

**Käyttäjän toiminnot**: 
```
-Omien korttien lisääminen
-Vastustajan korttien lisääminen
-Flopin asettaminen
-Laskettavan tilanteen valitseminen
```

**Kuvaus rakenteesta**:
```
Card-luokka hoitaa kortit.
```
```
Deck-luokassa muodostetaan kortti pakkoja. Luokassa oma metodi, jossa luodaan 52 erilaisen Card:in pakka. Metodeja korttien poistamiseen yms.
```
```
Draw-luokka arpoo kortteja pakasta, mutta luokkaa ei käytetä tässä vaiheessa.
```
```
PlayersCards-luokassa asetaan pelaajien käsiin Card-luokan mukaiset kortit ja poistetaan 52 Card:n Deck:stä.
```
```
Compare-luokka laskee kumpi PlayersCards-luokan käsistä on johdolla kussakin pelin tilanteessa.
```
```
Values-luokassa luokan avulla luodaan pokerikäsille arvot.
```
```
HandsValues-luokka toimii Values-luokan apuna pokerikäsien arvojen asettamiseen. 
```
 

**Luokkakaavio**: 

![Luokkakaavio](https://github.com/pidrmasiin/omahahelp/blob/master/dokumentaatio/Luokkakaavio.png)
