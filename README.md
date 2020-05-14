## TicketGuru - lipunmyyntijärjestelmä

Projektin tarkoituksena on tuottaa TicketGuru -niminen lipunmyyntijärjestelmä. Toimitsija toimii projektin aloittaessa kivijalkaliike-periaatteella, mutta toimitsijan tarkoituksena on jatkokehittää ja laajentaa palveluitaan myös verkkokaupan suuntaan, jonka myötä asiakkaat voivat itse ostaa ja tulostaa lippuja suoraan järjestelmän verkkokaupasta.

Toimitsijan tulee pystyä määrittelemään järjestelmään tapahtumat tietoineen (tapahtuma, lippukapasiteetti, lipputyypit, aika ja paikka, jne.), joihin lippuja myydään. Liput tulee pystyä tulostamaan järjestelmästä asiakkaalle myynnin yhteydessä. Lisäksi, ennakkomyynnin loputtua, jäljellä olevien lippujen tulostus, ovella myynti sekä lippujen tarkastaminen ovella lipulla olevan koodin perusteella tulee mahdollistaa järjestelmän kautta. Järjestelmästä on myös pystyttävä myyntiraportti halutusta tilaisuudesta ja tarkempi myyntitapahtuma listaus samaisen tapahtuman myyntitapahtumista.

TicketGurun tilaaman lipunmyyntijärjestelmän tarkoituksena on koota tiedot järjestettävistä tilaisuuksista (tilaisuuden laji, paikka, ikärajat, lippuryhmät, jne.) yhden ja saman tietojärjestelmän sisälle, joka mahdollistaa lippumyynnin helposti.

Lipunmyyntijärjestelmä on tarkoitettu aluksi käytettäväksi myyntipisteissä työntekijöiden toimesta.

Toteutus- ja toimintaympäristö:

- Java

- SpringBoot

- React

- PostgreSQL

Järjestelmä on tarkoitettu käytettäväksi selaimen kautta päätteellä, ja sen on tarkoitus olla selainriippumaton.

## Järjestelmän määrittely

- TicketGuru-järjestelmän käyttäjinä ovat pääasiassa lippupisteiden jälleenmyyjät sekä lippupisteiden myyntikoordinaattorit: jälleenmyyjät toimivat kivijalkaliikkeessä myynnin puolella, myyntikoordinaattorit puolestaan toimivat linkkinä tapahtumien järjestäjiin, syöttäen tapahtumat ja niiden tiedot järjestelmään. Järjestelmän tarjoamat raportit ovat myös tärkeitä myyntikoordinaattoreille.

* [User case diagram](https://github.com/marko-airisto/TicketGuru/blob/master/TicketGuruUsercase%20copy.pdf)

### Käyttäjätarinat:

- Myyjänä haluan, että saan esille tapahtumien listauksen, jotta näen koko valikoiman

- Myyjänä haluan, että saan tapahtumien listan järjestetty eri tavalla, jotta saan valita tarvittavan

- Myyjänä haluan, että saan esille valitun tapahtuman tiedot, jotta voin selvittää myyntiehdot

- Myyjänä haluan, että saan luoda uuden myyntitapahtuman (Osto), jotta voin aloittaa asiakaspalvelun

- Myyjänä haluan, että saan lisätä tapahtumalle eri tapahtumien liput, jotta valmistan asiakkaan ostoskorin

- Myyjänä haluan, että pystyn muokkaamaan ja poistamaan tapahtumissa olevat liput, jotta kykenen korjaamaan asiakkaan ostoskorin

- Myyjänä haluan, että pystyn siirtymään helposti yhdestä napista takaisin edelliseen näkymään.

- Myyjänä haluan, että valmistan (tallennan, vahvistan) myyntitapahtuman asiakkaan ostoskorista, jotta suoritan maksun ja tulostan liput

- Myyjänä haluan, että jo olleet tapahtumat eivät näy myyntinäkymässä, mutta voin silti tarvittaessa etsiä myös vanhoja tapahtumia.

- Asiakkaana haluan, että saan maksetut liput tulostettuna myyjältä, jotka esitän tarkastajalle

- Tarkastajana haluan, että liput voidaan yksinkertaisesti ja yksiselitteisesti tarkista tapahtumaan sisäänpääsyä varten

- Myyjänä haluan, että saan ostotapahtuman peruttua, jos ostaja peruu kaupan, tai myyjänä teen virheen.

- Myyntikoordinaattorina haluan, että saan tapahtumia tallennettu järjestelmään, jotta lippuja ko. tapahtumiin voidaan myydä jälleenmyyntipisteessä

- Myyntikoordinaattorina haluan, että myyntipisteissä ei voida muuttaa tapahtumien tietoja, jottei myyntiprosessi keskeydy.

- Myyntikoordinaattorina haluan, että pystyn syöttämään tietoja massana (excel, csv), jottei jokaista tapahtumaa pidä syöttää rivi kerrallaan.

- Myyntikoordinaattorina haluan, että saada järjestelmästä myyntiraportin, josta näen haluamani tapahtuman lipputyyppien myyntimäärät ja summat sekä yhteisumman.

- Myyntikoordinaattorina haluan, että saada järjestelmästä myyntiraportista listauksen kaikista myyntitapahtumista (sis. timestamp, myyntitapahtuma nro ja summa), jotta näen ko. myyntitapahtuman sisällön.

## Käyttöliittymä

Alkuperäinen UI wireframe dokumentti, josta näkyy perus toiminallisuus.

- [UI Wireframes](https://github.com/marko-airisto/TicketGuru/blob/master/TicketGuru_UI.pdf)

Esimerkillinen kuvakollaasi mahdollisesta front endin ulkonäöstä ja toiminnalisuudesta.

- [UI](https://github.com/marko-airisto/TicketGuru/blob/master/documentation/images/UI_examples.pdf)


## Tietokantadokumentaatio

- [Tietohakemisto](https://github.com/marko-airisto/TicketGuru/blob/master/documentation/DB/README.md)

## REST API dokumentaatio

- [REST API](https://github.com/marko-airisto/TicketGuru/tree/master/documentation/API)

## Asennustiedot

### Kehitysympäristön käyttöönotto

-   TicketGuru kehitysympäristön saa käyttöönsä kloonaamalla projektin (git clone https://github.com/marko-airisto/TicketGuru.git)
    -   Projektin voi avata joko Visual Studio Codella tai Eclipsellä (VSCode riittää ticketguru_backend kansion avaaminen, eclipsellä pitää import toiminnolla tuota sama kansio muokattavaksi).
-   Ajonaikaisen tietokannan valinta tapahtuu ticketguru_backend/src/main/java/fi/rbmk/resources kansiossa olevaa application.properties tiedostoa muokkaamalla.
    -   Poista kommentti haluamastasi tietokannasta. Kehitysympäristössä käytössä on H2 muistinvarainen tietokanta, johon syötetään esimerkkidataa sample_data.sql tiedostolla.

### Järjestelmän asentaminen tuotantoympäristöön

-   Tuotantokäyttöön tarkoitettu tietokanta otetaan käyttöön poistamalla application.properties tiedostosta kommentointi Production -kohdista
-   pom.xml tiedostosta kannattaa ottaa seuraavat riippuvuudet pois ennen ohjelman kääntämistä tuotantokäyttöön:
    -   spring-boot-devtools
    -   h2
-   Tietokantana toimii PostgreSQL -tietokanta (> V9)
-   Tietokantayhteyteen tarvittavat tiedot määritellään seuraavilla ympäristömuuttujilla käyttöjärjestelmässä:
    -   JDBC_DATABASE_URL   (muodossa postgresql://<käyttäjätunnus>:<salasana>:<yhteysosoite>:<portti>/<tietokannan nimi> tai postgresql://<yhteysosoite>:<portti>/<tietokannan nimi)
    -   JDBC_DATABASE_USERNAME (tarvitaan vain jos ylemmässä ei ole määritelty käyttäjänimeä)
    -   JDBC_DATABASE_PASSWORD (tarvitaan vain jos ylemmässä ei ole määritelty salasanaa)
-   Tietokannan taulut voidaan joko luoda projektitiedostojen mukana olevan pqSchema.sql tiedoston tuomalla tai antamalla ohjelman itse generoida se.
-   Jos järjestelmässä ei ole käyttäjiä, ensimmäisestä kirjautuvasta käyttäjästä luodaan pääkäyttäjä (/api/login POST kutsu)

## Käynnistys- ja käyttöohje

Järjestelmä pyörii Heroku -sovelluspalvelimella.
Sovelluksen käynnistykseen riittää allaolevan kirjautumisosoitteen avaaminen.
(REST API)
https://rbmk-ticketguru-backend.herokuapp.com/api/login
  
(Referenssitoteutus UI:sta)
https://ticketguru-heroku.herokuapp.com/auth/login
  
Järjestelmään kirjaudutaan sisään joko pääkäyttäjätason tai myyntihenkilön tunnuksilla.

Järjestelmää käytetään joko REST API:n kautta. Dokumentaatio API-kutsuista löytyy täältä: [Tietohakemisto](https://github.com/marko-airisto/TicketGuru/blob/master/documentation/DB/README.md)
