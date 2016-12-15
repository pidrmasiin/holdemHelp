Taitaa jäädä tohon hold'em käsien vertailuun alussa.

**Aihe**: Omaha-avustaja, mutta voi olla, että joudun tyytymään vastaavan hold'em-avustajaan. Katsotaan mihin taidot riittää. Toteutetaan siis järjestelmä, jonka avulla voidaan laskea todennäköisyys voitolle
 [omahassa](https://fi.wikipedia.org/wiki/Omaha_hold_%E2%80%99em) tai [hold'emissä](https://fi.wikipedia.org/wiki/Texas_hold_%E2%80%99em), kun vastustajan kortit arvataan. Arvausta olisi hyvä pystyä vaihtamaan pelin edetessä. 

Ainakin alussa asetettujen hold'em käsien vertailun uskon pystyväni hoitamaan. 

**Käyttäjät**: Minä. Ehkä.

**Käyttäjän toiminnot**: 
```
-Omien korttien lisääminen
-Vastustajan korttien lisääminen
```

**Kuvaus rakenteesta**:
```
Card-luokka hoitaa kortit.
```
Deck-luokassa muodostetaan kortti pakkoja. Luokassa oma metodi, jossa luodaan 52 erilaisen Card:in pakka. Metodeja korttien poistamiseen yms.
```
Draw-luokka arpoo kortteja pakasta, mutta luokkaa ei käytetä tässä vaiheessa.
```
PlayersCards-luokassa asetaan pelaajien käsiin Card-luokan mukaiset kortit ja poistetaan 52 Card:n Deck:stä.
```
Compare-luokka laskee kumpi PlayersCards-luokan käsistä on johdolla kussakin pelin tilanteessa.
```
Values-luokassa luokan avulla luodaan pokerikäsille arvot.
```
HandsValues-luokka toimii Values-luokan apuna pokerikäsien arvojen asettamiseen. 
```
 

**Luokkakaavio**: 

![Luokkakaavio](https://github.com/pidrmasiin/omahahelp/blob/master/dokumentaatio/Luokkakaavio.png?raw=true)
