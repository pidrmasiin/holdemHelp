**Käyttöohjeet**

Alla on kuvankaappaus ohjelmasta. Siitä voi tarkistaa kuvauksen mukaisesti, mihin mitäkin tulee syöttää ja mihin laskenta tulostuu.

![Luokkakaavio](https://github.com/pidrmasiin/omahahelp/blob/master/dokumentaatio/Kuvakaappaus-ohjelmasta.png)

```
Kun käyttäjä haluaa tietää suhteet flopilla, kun floppia ei tiedetä:
```

Käyttäjä syöttää kortit muodossa x of SUIT. X:n on oltava numeroarvo väliltä 2-14 ja 14 tarkoittaa ässää.
SUIT:in on oltava muodossa HEARTS, DIAMONDS, CLUBS tai SPADES. Jos siis käyttäjän kortit ovat pataässä ja pata-akka, käyttäjän tulee syöttää alla ohjelmaan toiseen "Korttisi (x of SUIT)"-kohtaan "14 of SPADES" ja toiseen "12 of SPADES". "Korttisi (x of SUIT)"-kohdissa on oletuksena syötetty jokin kakkonen. Valitettavasti en ehtinyt koodata käyttäjäystävällisempää tapaa asettaa kortteja. Kun kortteja asetetaan, on huomioitava, että pelissä on kutakin korttia vain yksi kappale.

Vastaavasti kohtiin "Vastus(x of SUIT)" syötetään kortit, jotka vastustajalla arvataan olevan. Tämä tapahtuu samalla tavalla kuin omia kortteja syötettäessä. Näissäkin oletus syötteenä on kakkonen.

Kun käyttäjä on syöttänyt omat ja vastustajan kortit, hän voi painaa nappia "Näytä suhteet flopilla, kun floppia ei tiedetä". Napin painalluksen seurauksena ohjelma käy läpi kaikki mahdolliset flopit ja vertaa jokaisen flopin kohdalla pelaajien käsien arvoja toisiinsa. Kun tämä on tehty, ohjelman kohtaan, jossa lukee "Voittosi" muodostuu osuus niistä flopeista, jolloin kätesi oli vahvempi kuin vastaustajan käsi. Vastaavasti kohtaan "Vastustajan voitot" muodostuu osuus niistä flopeista, jollois vastustajan käsi oli vahvempi ja "Tasurit"-kohtaa muodostuu osuus niistä flopeista, jolloin tilanne oli tasan.

```
Kun käyttäjä haluaa tietää suhteet turnilla, kun floppia eikä turnia tiedetä:
```
Käyttäjä asettaa omat ja vastustajan kortit kuten tapauksessa "Kun käyttäjä haluaa tietää suhteet flopilla, kun floppia ei tiedetä" ja painaa nappia "HIDASTA PUUHAA! Näytä suhteet turnilla, kun floppia ei tiedetä". Ohjelma laskee suhteet kuten "Kun käyttäjä haluaa tietää suhteet flopilla, kun floppia ei tiedetä" -kohdassa ja näyttää tuloksen samassa paikassa. Varautuksen sanan, että tässä kestää kauan!
```
Kun käyttäjä haluaa tietää suhteet turnilla, kun floppi tiedetään:
```
Käyttäjä asettaa flopin samalla kaavalla kuin asettaisi omia tai vastustajan kortteja. Taas on huomioitava, että pelissä on kutakin korttia vain yksi kappale. Painamalla nappia "Aseta floppi ja näytä suhteet ennen riveriä" ohjelma käy läpi kaikki mahdolliset turnit ja katsoo aina kumpi käsi on vahvempi tai ovatko ne yhtä vahvoja. Tulos näytetään taas kohdissa "Voittosi", "Tasurit" ja "Vastustajan voitot"





