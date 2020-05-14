## TicketGuru-tietokanta

- [EER-kaavio tietokannasta](https://github.com/marko-airisto/TicketGuru/blob/master/documentation/images/EER.png)

> ### _age_limits_
> _age_limits-taulu sisältää ikärajaluokat._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> age_limit_id | bigint PK NN | Ikärajaluokan id
> name | varchar(50) |  Ikärajaluokan nimi
> info | varchar(500) | Ikärajaluokan tarkenne
> created | timestamp NN | Aikaleima jolloin tietue on luotu
> invalid | timestamp | Aikaleima jolloin tietue on merkitty poistetuksi

> ### _events_
> _events-taulu sisältää tapahtumat._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> event_id | bigint PK NN | Tapahtuma id
> name | varchar(250) NN |  Tapahtuman nimi
> event_type_id | bigint FK NN | Tapahtuman tyyppi, viittaus [event_types](#event_types)-tauluun
> datetime | datetime NN |  Tapahtuman päivämäärä ja aika
> event_organizer_id | bigint FK NN | Tapahtuman järjestäjä, viittaus [event_organizers](#event_organizers)-tauluun
> venue_id | bigint FK NN | Tapahtuman tapahtumapaikka, viittaus [venues](#venues)-tauluun
> ticket_capacity | bigint NN |  Tapahtumaan maksimissaan myytävien lippujen määrä
> age_limit_id | bigint FK NN | Tapahtuman mahdollinen ikärajaluokka, viittaus [age_limits](#age_limits)-tauluun
> info | varchar(500) |  Tapahtuman lisätiedot tiedot
> created | timestamp NN | Aikaleima jolloin tietue on luotu
> invalid | timestamp | Aikaleima jolloin tietue on merkitty poistetuksi

> ### _event_organizers_
> _event_organizers-taulu sisältää tapahtumajärjestäjät._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> event_organizer_id | bigint PK NN | Tapahtumajärjestäjä id
> name | varchar(100) NN |  Tapahtumajärjestäjän yritysnimi
> street_address | varchar(150) |  Tapahtumajärjestäjän osoite
> postcode_id | varchar(10) FK NN | Tapahtumajärjestäjän postinumero, viittaus [postcodes](#postcodes)-tauluun
> tel | varchar(25) |  Tapahtumajärjestäjän puhelinnumero
> email | varchar(150) |  Tapahtumajärjestäjän sähköpostiosoite
> www | varchar(250) |  Tapahtumajärjestäjän www-osoite
> contact_person | varchar(250) |  Tapahtumajärjestäjän edustajan nimi
> created | timestamp NN | Aikaleima jolloin tietue on luotu
> invalid | timestamp | Aikaleima jolloin tietue on merkitty poistetuksi

> ### _event_tickets_
> _event_tickets-taulu sisältää tapahtumakohtaiset liput._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> event_ticket_id | bigint PK NN | Tapahtumakohtaisen lipun id
> event_id | bigint FK NN | Lippuun liitetty tapahtuma, viittaus [events](#events)-tauluun
> ticket_type_id | bigint FK NN | Lippun lipputyyppi, viittaus [ticket_types](#ticket_types)-tauluun
> ticket_count | bigint |  Myytävänä olevien lippujen määrä
> price | decimal(5) |  Lipun hintatieto
> created | timestamp NN | Aikaleima jolloin tietue on luotu
> invalid | timestamp | Aikaleima jolloin tietue on merkitty poistetuksi

> ### _event_types_
> _event_types-taulu sisältää tapahtumien tyyppiluokat._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> event_type_id | bigint PK NN | Tapahtumatyypin id
> name | varchar(100) NN |  Tapahtumatyypin nimi
> info | varchar(500) | Tapahtumatyypin kuvaus (vaihtoehtoinen)
> created | timestamp NN | Aikaleima jolloin tietue on luotu
> invalid | timestamp | Aikaleima jolloin tietue on merkitty poistetuksi

> ### _postcodes_
> _postcodes-taulu sisältää kaupunkien postinumerot, nimet sekä maat._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> postcode_id | varchar(10) PK NN | Postinumeron id, postinumero
> city | varchar(100) NN |  Postinumeroon liitetty kaupunki
> country | varchar(100) NN |  Maa, jossa postinumero sekä postinumeroon liitetty kaupunki sijaitsee
> created | timestamp NN | Aikaleima jolloin tietue on luotu
> invalid | timestamp | Aikaleima jolloin tietue on merkitty poistetuksi

> ### _sale_events_
> _sale_events-taulu sisältää myyntitapahtumat._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> sale_event_id | bigint PK NN | Myyntitapahtuma id
> user_id | bigint FK NN | Myyntitapahtuman käsittelijätieto, viittaus [users](#users)-tauluun
> created | timestamp NN | Aikaleima jolloin tietue on luotu
> invalid | timestamp | Aikaleima jolloin tietue on merkitty poistetuksi

> ### _sale_rows_
> _sale_rows-taulu sisältää myyntitapahtumien myyntirivit._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> sale_row_id | bigint PK NN | Myyntirivi id
> sale_event_id | bigint FK NN | Myyntitapahtumatiedot, viittaus [sale_events](#sale_events)-tauluun
> discount | bigint |  Myyntirivin mahdollinen hinnan alennus tieto
> created | timestamp NN | Aikaleima jolloin tietue on luotu
> invalid | timestamp | Aikaleima jolloin tietue on merkitty poistetuksi

> ### _tickets_
> _tickets-taulu sisältää yksittäiset liput._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> ticket_id | bigint PK NN | Lippu id
> event_ticket_id | bigint FK NN | Lippuun liitetyt tapahtumakohtaiset lipputiedot, viittaus [event_tickets](#event_tickets)-tauluun
> ricket_status_id | bigint FK NN | Lipun tilanne, viittaus [ticket_statuses](#ticket_statuses)-tauluun
> checksum | varchar(100) |  Lipun tarkastustieto
> sale_row_id | bigint FK NN | Lippuun liitetty myyntirivi, viittaus [sale_rows](#sale_rows)-tauluun
> created | timestamp NN | Aikaleima jolloin tietue on luotu
> invalid | timestamp | Aikaleima jolloin tietue on merkitty poistetuksi

> ### _ticket_statuses_
> _ticket_statuses-taulu sisältää lippujen tilanneluokat._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> ticket_status_id | bigint PK NN | Lipun tilanne id
> name | varchar(50) NN |  Lipun tilanteen nimi
> created | timestamp NN | Aikaleima jolloin tietue on luotu
> invalid | timestamp | Aikaleima jolloin tietue on merkitty poistetuksi

> ### _ticket_types_
> _ticket_types-taulu sisältää lippujen tyyppiluokat._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> ticket_type_id | bigint PK NN | Lipputyypin id
> name | varchar(100) NN |  Lipputyypin nimi
> created | timestamp NN | Aikaleima jolloin tietue on luotu
> invalid | timestamp | Aikaleima jolloin tietue on merkitty poistetuksi

> ### _users_
> _users-taulu sisältää käyttäjät._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> user_id | bigint PK NN | Käyttäjä id
> name | varchar(100) | Käyttäjän nimi
> usermame | varchar(50) NN | Käyttäjätunnus 
> password | varchar(250) NN | Käyttäjän salasana hashattuna
> user_group_id | bigint FK NN |  Käyttäjän käyttäjäryhmä, viittaus [user_groups](#user_groups)-tauluun
> created | timestamp NN | Aikaleima jolloin tietue on luotu
> invalid | timestamp | Aikaleima jolloin tietue on merkitty poistetuksi

> ### _user_groups_
> _user_groups-taulu sisältää käyttäjäryhmätiedot._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> user_group_id | bigint PK NN | Käyttäjäryhmä id
> name | varchar(100) NN |  Käyttäjäryhmän nimi
> created | timestamp NN | Aikaleima jolloin tietue on luotu
> invalid | timestamp | Aikaleima jolloin tietue on merkitty poistetuksi

> ### _venues_
> _venues-taulu sisältää tapahtumapaikat._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> venue_id | bigint PK NN | Tapahtumapaikka id
> venueName | varchar(100) NN |  Tapahtumapaikan nimi
> street_address | varchar(150) NN |  Tapahtumapaikan osoite
> postcode_id | varchar(10) FK NN | Tapahtumajärjestäjän postinumero, viittaus [postcodes](#postcodes)-tauluun
> tel | varchar(25) NN |  Tapahtumapaikan puhelinnumero
> email | varchar(150) NN |  Tapahtumapaikan sähköpostiosoite
> www | varchar(250) |  Tapahtumapaikan www-osoite
> contact_person | varchar(150) NN |  Tapahtumapaikan edustajan nimi
> created | timestamp NN | Aikaleima jolloin tietue on luotu
> invalid | timestamp | Aikaleima jolloin tietue on merkitty poistetuksi