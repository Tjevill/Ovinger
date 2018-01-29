

-- Slipper å tenke på drop-rekkefølge med linje 4 og 6.
SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS kandidat,kval_idOGkand_id, historikk, kvalifikasjon,oppdrag,bedrift;
SET FOREIGN_KEY_CHECKS = 1;

-- Lager tabellen kandidat
CREATE TABLE kandidat(
  fornavn VARCHAR(30),
  etternavn VARCHAR(30),
  kandidat_id INTEGER NOT NULL AUTO_INCREMENT,
  telefon INTEGER,
  epost VARCHAR(30),
  CONSTRAINT kandidat_pk PRIMARY KEY (kandidat_id)
);

-- Lager tabellen bedrift
CREATE TABLE bedrift(
  bedrift_id INTEGER NOT NULL AUTO_INCREMENT,
  navn VARCHAR(30),
  tlf INTEGER NOT NULL,
  epost VARCHAR(30),
  CONSTRAINT bedrift_pk PRIMARY KEY(bedrift_id)
);

-- Lager tabellen oppdrag
CREATE TABLE oppdrag(
  oppdrag_id INTEGER NOT NULL AUTO_INCREMENT,
  bedrift_id INTEGER,
  kvalifikasjon VARCHAR(30),
  startdato DATE,
  sluttdato DATE,
  CONSTRAINT vikartjeneste_pk PRIMARY KEY (oppdrag_id)
);

-- Lager tabellen kvalifikasjon
CREATE TABLE kvalifikasjon(
  kvalifikasjon VARCHAR (30),
  kvalifikasjon_id INTEGER NOT NULL AUTO_INCREMENT,
  kandidat_id INTEGER,
  CONSTRAINT kvalifikasjon_pk PRIMARY KEY (kvalifikasjon_id)
);

-- Lager tabellen kval_idOGkand_id
CREATE TABLE kval_idOGkand_id(
  kandidat_id INTEGER NOT NULL AUTO_INCREMENT,
  kvalifikasjon_id INTEGER NOT NULL,
  CONSTRAINT kval_idOGkand_id_pk PRIMARY KEY (kandidat_id, kvalifikasjon_id)
);

-- Lager tabellen historikk
CREATE TABLE historikk(
  historikk_id INTEGER NOT NULL AUTO_INCREMENT,
  kandidat_id INTEGER NOT NULL,
  oppdrags_id INTEGER NOT NULL,
  startdato DATE,
  sluttdato DATE,
  ant_timer INTEGER ,
  CONSTRAINT historikk_pk PRIMARY KEY (historikk_id)
);
-- Foreign key historikk
ALTER TABLE historikk
  ADD CONSTRAINT historikk_fk FOREIGN KEY (oppdrags_id) REFERENCES oppdrag(oppdrag_id);

-- Foreign key oppdrag
ALTER TABLE oppdrag
  ADD CONSTRAINT oppdrag_fk FOREIGN KEY (bedrift_id) REFERENCES bedrift(bedrift_id);

-- Foreign key kval_idOGkand_id
ALTER TABLE kval_idOGkand_id
    ADD CONSTRAINT kval_idOGkand_id_fk FOREIGN KEY (kandidat_id) REFERENCES kandidat(kandidat_id),
    ADD CONSTRAINT kval_idOGkand_id_fk2 FOREIGN KEY (kvalifikasjon_id) REFERENCES kvalifikasjon(kvalifikasjon_id);

-- Bedrift
INSERT INTO bedrift(navn, tlf, epost) VALUES ("Simons vikarbyrå",48104122,"svikarbyrå@getVikar.no");
INSERT INTO bedrift(navn, tlf, epost) VALUES ("Christians vikarbyrå",98765432,"chrvikar@getVikar.no");
INSERT INTO bedrift(navn, tlf, epost) VALUES ("Ole's vikarbyrå",92384811,"olevikar@getVikar.no");

-- Kandidater
INSERT INTO kandidat(fornavn, etternavn, telefon, epost) VALUES ("Markus","Svendsen",91234567,"markus@svendsen.no");
INSERT INTO kandidat(fornavn, etternavn, telefon, epost) VALUES ("Sirrup","Loffestad",41234567,"markus@svendsen.no");
INSERT INTO kandidat(fornavn, etternavn, telefon, epost) VALUES ("Christian","Dalseth",98765432,"christian@dalseth.no");
INSERT INTO kandidat(fornavn, etternavn, telefon, epost) VALUES ("Martin","Moan",75510221,"martin@moan.no");

-- Kvalifikasjoner
INSERT INTO kvalifikasjon (kvalifikasjon, kandidat_id) VALUES ("Ingen",1);
INSERT INTO kvalifikasjon (kvalifikasjon, kandidat_id) VALUES ("Barnepedagog",2);
INSERT INTO kvalifikasjon (kvalifikasjon, kandidat_id) VALUES ("Tømrer",2);
INSERT INTO kvalifikasjon (kvalifikasjon, kandidat_id) VALUES ("Systemutvikler",4);
INSERT INTO kvalifikasjon (kvalifikasjon, kandidat_id) VALUES ("Maler",3);
INSERT INTO kvalifikasjon (kvalifikasjon, kandidat_id) VALUES ("IT-ekspert",3);

-- Oppdrag
-- DATE ('YYYY-MM-DD')
INSERT INTO oppdrag (bedrift_id, kvalifikasjon, startdato, sluttdato) VALUES (1,1,DATE ('2018-01-27'),DATE ('2018-02-09'));
INSERT INTO oppdrag (bedrift_id, kvalifikasjon, startdato, sluttdato) VALUES (2,3,DATE ('2018-01-29'),DATE ('2018-02-12'));
INSERT INTO oppdrag (bedrift_id, kvalifikasjon, startdato, sluttdato) VALUES (3,4,DATE ('2018-01-26'),DATE ('2018-02-15'));
INSERT INTO oppdrag (bedrift_id, kvalifikasjon, startdato, sluttdato) VALUES (3,6,DATE ('2018-02-02'),DATE ('2018-03-06'));

-- Historikk
INSERT INTO historikk (kandidat_id, oppdrags_id, startdato, sluttdato, ant_timer) VALUES (1,4,DATE('2017-11-1'),DATE('2018-01-02'),128 );
INSERT INTO historikk (kandidat_id, oppdrags_id, startdato, sluttdato, ant_timer) VALUES (2,3,DATE('2017-09-1'),DATE('2018-01-01'),128 );
INSERT INTO historikk (kandidat_id, oppdrags_id, startdato, sluttdato, ant_timer) VALUES (3,2,DATE('2017-05-18'),DATE('2018-01-01'),128 );
INSERT INTO historikk (kandidat_id, oppdrags_id, startdato, sluttdato, ant_timer) VALUES (2,1,DATE('2017-05-18'),DATE('2018-01-01'),128 );





-- Lag en liste over alle bedriftene. Navn, telefon og epost til bedriften skal skrives ut.
SELECT navn,tlf,epost
FROM bedrift;

-- Lag en liste over alle oppdragene.
-- Om hvert oppdrag skal du skrive ut oppdragets nummer samt navn og telefonnummer til bedriften som tilbyr oppdraget.
SELECT oppdrag_id,oppdrag.bedrift_id, bedrift.navn, tlf,epost
FROM oppdrag, bedrift
WHERE oppdrag.bedrift_id = bedrift.bedrift_id;

-- Lag en liste over kandidater og kvalifikasjoner.
-- Kandidatnavn og kvalifikasjonsbeskrivelse skal med i utskriften
-- i tillegg til løpenumrene som identifiserer kandidat og kvalifikasjon.
SELECT fornavn,etternavn,kandidat.kandidat_id, kvalifikasjon.kvalifikasjon
FROM kandidat, kvalifikasjon
WHERE kandidat.kandidat_id = kvalifikasjon.kandidat_id;

-- Skriv ut jobbhistorikken til en bestemt vikar, gitt kandidatnr.
-- Vikarnavn, sluttdato, oppdragsnr og bedriftsnavn skal med.
SELECT kandidat.fornavn,kandidat.etternavn, historikk.sluttdato, bedrift.navn FROM kandidat
  LEFT JOIN historikk
  INNER JOIN bedrift
    ON bedrift.bedrift_id = oppdrags_id
    ON historikk.kandidat_id = kandidat.kandidat_id
WHERE kandidat.kandidat_id = 2;

























