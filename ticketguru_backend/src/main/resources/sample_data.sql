
-- USER GROUPS

INSERT INTO user_groups
    (name)
VALUES
    ('user');
INSERT INTO user_groups
    (name
    )
VALUES
    ('admin');
INSERT INTO user_groups
    (name
    )
VALUES
    ('boss');

-- USERS

INSERT INTO users
    (password, username, name, user_group_id, active)
VALUES
    ('$2a$10$/..0qbQN09s20ZVao53j0..hr2dgkS52zVn68b0ZlGcZBzczkoH.y', 'pepe', 'pepe', 1, 1);
INSERT INTO users
    (password, username, name, user_group_id, active)
VALUES
    ('$2a$10$K.vSuwrxuG7arNO7nGkAyuPs0Op4JCDxd7hdhiwpF/egYpePZWYay', 'john', 'john', 2, 1);
INSERT INTO users
    (password, username, name, user_group_id, active)
VALUES
    ('$2a$10$tG3a9iRmIpPH3Hkj/EwLYetL8i/A6jBJIF4OQZS.UPV14sOmQB9Nq', 'kuningas', 'kuningas', 3, 1);


-- EVENTTYPES

INSERT INTO event_types
    (name, info)
VALUES
    ('Teatteri', 'Silkkaa teatteria'
);

-- AGELIMITS

INSERT INTO age_limits
    (name, info)
VALUES
    ('K7', 'Tapahtuma ei sovellu alle 7-vuotiaille');

INSERT INTO age_limits
    (name, info)
VALUES
    ('K13', 'Tapahtuma ei sovellu alle 13-vuotiaille');
    
INSERT INTO age_limits
    (name, info)
VALUES
    ('K16', 'Tapahtuma ei sovellu alle 16-vuotiaille');
    
INSERT INTO age_limits
    (name, info)
VALUES
    ('K18', 'Tapahtuma ei sovellu alle 18-vuotiaille');
    
INSERT INTO age_limits
    (name, info)
VALUES
    ('S', 'Ikärajaton tapahtuma, sopii kaikenikäisille');

-- POSTCODES

INSERT INTO postcodes
    (postcode_id, city, country)
VALUES
    ('00002', 'Helsinki', 'Finland');
INSERT INTO postcodes
    (postcode_id, city, country
    )
VALUES
    ('00100', 'Helsinki', 'Finland');
INSERT INTO postcodes
    (postcode_id, city, country
    )
VALUES
    ('00130', 'Helsinki', 'Finland'
);
INSERT INTO postcodes
    (postcode_id, city, country
    )
VALUES
    ('00140', 'Helsinki', 'Finland'
);
INSERT INTO postcodes
    (postcode_id, city, country
    )
VALUES
    ('00150', 'Helsinki', 'Finland'
);
INSERT INTO postcodes
    (postcode_id, city, country
    )
VALUES
    ('00160', 'Helsinki', 'Finland'
);

-- VENUES

INSERT INTO venues
    (name, street_address, postcode_id, tel, email, www, contact_person)
VALUES
    ('Helsingin Teatteri', 'Kekkosenkatu 3', '00140', '09 1234566', 'teatteri@teatteri.fi', 'www.helsinginteatteri.com', 'John Wayne');

-- EVENTORGANIZERS

INSERT INTO event_organizers
    (name, street_address, postcode_id, tel, email, www, contact_person)
VALUES
    ('GREAT EVENTS OY', 'Tapahtumakatu 16 a 78', '00150', '09 7865566', 'great@events.fi', 'www.greatevents.com', 'Texas Ted');

-- EVENTS

INSERT INTO events
    (name, event_type_id, datetime, event_organizer_id, venue_id, ticket_capacity, age_limit_id, info)
VALUES
    (
        'Koodari Kemut 2020', 1, '2020-03-01 20:00:00', 1, 1, 1500, 2, 'Mika koodaa ja muut kattelee. Kannattaa tulla kauempaakin'
    );
    INSERT INTO events
    (name, event_type_id, datetime, event_organizer_id, venue_id, ticket_capacity, age_limit_id, info)
VALUES
    (
        'Olut festarit', 1, '2020-04-01 09:15:00', 1, 1, 700, 2, 'Paljon erilaisia oluita tarjolla'
    );
     INSERT INTO events
    (name, event_type_id, datetime, event_organizer_id, venue_id, ticket_capacity, age_limit_id, info)
VALUES
    (
        'Black Metal festarit', 1, '2020-04-04 18:30:00', 1, 1, 666, 2, 'Pelkkää bläkkistä. Tiukkaa tykittelyä.'
    );
     INSERT INTO events
    (name, event_type_id, datetime, event_organizer_id, venue_id, ticket_capacity, age_limit_id, info)
VALUES
    (
        'Lappeenranta Kiljufest 2020', 1, '2020-04-13 07:00:00', 1, 1, 15, 2, 'Juo kiljua ja piereskele.'
    );
     INSERT INTO events
    (name, event_type_id, datetime, event_organizer_id, venue_id, ticket_capacity, age_limit_id, info)
VALUES
    (
        'Postimekkijamboree', 1, '2020-04-17 10:00:00', 1, 1, 15, 2, 'Liimaile postimerkkejä'
    );
     INSERT INTO events
    (name, event_type_id, datetime, event_organizer_id, venue_id, ticket_capacity, age_limit_id, info)
VALUES
    (
        'Mökkitikan SM:t', 1, '2020-04-20 09:030:00', 1, 1, 15, 2, 'Heitä tikkaa pikkusievässä'
    );
    
-- TICKETTYPES

INSERT INTO ticket_types
    (name)
VALUES
    (
        'Aikuinen'
    );
INSERT INTO ticket_types
    (name)
VALUES
    (
        'Lapsi 7-16v'
    );
    
INSERT INTO ticket_types
    (name)
VALUES
    (
        'Eläkeläinen'
    );
    
INSERT INTO ticket_types
    (name)
VALUES
    (
        'Varus- tai siviilipalvelusmies'
    );
    
INSERT INTO ticket_types
    (name)
VALUES
    (
        'Työtön'
    );

-- TICKETSTATUSES

INSERT INTO ticket_statuses (name) VALUES ('Voimassa');

INSERT INTO ticket_statuses (name) VALUES ('Käytetty');

INSERT INTO ticket_statuses (name) VALUES ('Peruttu');

INSERT INTO ticket_statuses (name) VALUES ('Maksettu');

INSERT INTO ticket_statuses (name) VALUES ('Hyväksymätön');

INSERT INTO ticket_statuses (name) VALUES ('Epäonnistui');

INSERT INTO ticket_statuses (name) VALUES ('Hylätty');

-- EVENTTICKETS

INSERT INTO event_tickets
    (event_id, ticket_type_id, ticket_count, price)
VALUES
    (
        1, 2, 1000, 20
    );

-- SALEEVENTS

INSERT INTO sale_events (user_id) VALUES (3);

-- SALEROWS

INSERT INTO sale_rows (discount, sale_event_id) VALUES (0, 1);

-- TICKETS

INSERT INTO tickets (checksum, event_ticket_id, ticket_status_id, sale_row_id) VALUES ('Testi_1', 1, 1, 1);

INSERT INTO tickets (checksum, event_ticket_id, ticket_status_id, sale_row_id) VALUES ('Testi_2', 1, 1, 1);

INSERT INTO tickets (checksum, event_ticket_id, ticket_status_id, sale_row_id) VALUES ('Testi_3', 1, 2, 1);

INSERT INTO tickets (checksum, event_ticket_id, ticket_status_id, sale_row_id) VALUES ('Testi_4', 1, 3, 1);

INSERT INTO tickets (checksum, event_ticket_id, ticket_status_id, sale_row_id) VALUES ('Testi_5', 1, 4, 1);

INSERT INTO tickets (checksum, event_ticket_id, ticket_status_id, sale_row_id) VALUES ('Testi_6', 1, 5, 1);

INSERT INTO tickets (checksum, event_ticket_id, ticket_status_id, sale_row_id) VALUES ('Testi_7', 1, 6, 1);
