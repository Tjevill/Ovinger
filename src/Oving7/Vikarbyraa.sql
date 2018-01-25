
SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS kandidat,kval_idOGkand_id, historikk, kvalifikasjon,oppdrag,bedrift;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE kandidat(
  fornavn VARCHAR(30),
  etternavn VARCHAR(30),
  kandidat_id INTEGER NOT NULL AUTO_INCREMENT,
  telefon INTEGER,
  epost VARCHAR(30),
  CONSTRAINT kandidat_pk PRIMARY KEY (kandidat_id)
);

CREATE TABLE bedrift(
  bedrift_id INTEGER NOT NULL AUTO_INCREMENT,
  navn VARCHAR(30),
  tlf INTEGER NOT NULL,
  epost VARCHAR(30),
  CONSTRAINT bedrift_pk PRIMARY KEY(bedrift_id)
);

CREATE TABLE oppdrag(
  oppdrag_id INTEGER NOT NULL AUTO_INCREMENT,
  bedrift_id INTEGER,
  kandidat_id INTEGER ,
  kvalifikasjon VARCHAR(30),
  startdato DATE,
  sluttdato DATE,
  CONSTRAINT vikartjeneste_pk PRIMARY KEY (oppdrag_id)
);

CREATE TABLE kvalifikasjon(
  kvalifikasjon VARCHAR (30),
  kvalifikasjon_id INTEGER NOT NULL AUTO_INCREMENT,
  kandidat_id INTEGER,
  CONSTRAINT kvalifikasjon_pk PRIMARY KEY (kvalifikasjon_id)
);

CREATE TABLE kval_idOGkand_id(
  kandidat_id INTEGER NOT NULL AUTO_INCREMENT,
  kvalifikasjon_id INTEGER NOT NULL,
  CONSTRAINT kval_idOGkand_id_pk PRIMARY KEY (kandidat_id, kvalifikasjon_id)
);

CREATE TABLE historikk(
  historikk_id INTEGER NOT NULL AUTO_INCREMENT,
  kandidat_id INTEGER NOT NULL,
  oppdrags_id INTEGER NOT NULL,
  startdato DATE,
  sluttdato DATE,
  ant_timer INTEGER ,
  CONSTRAINT historikk_pk PRIMARY KEY (historikk_id)
);

ALTER TABLE historikk
  ADD CONSTRAINT historikk_fk FOREIGN KEY (oppdrags_id) REFERENCES oppdrag(oppdrag_id);

ALTER TABLE oppdrag
  ADD CONSTRAINT oppdrag_fk FOREIGN KEY (bedrift_id) REFERENCES bedrift(bedrift_id),
  ADD CONSTRAINT oppdrag_fk2 FOREIGN KEY (kandidat_id)REFERENCES kandidat(kandidat_id);

ALTER TABLE kval_idOGkand_id
    ADD CONSTRAINT kval_idOGkand_id_fk FOREIGN KEY (kandidat_id) REFERENCES kandidat(kandidat_id),
    ADD CONSTRAINT kval_idOGkand_id_fk2 FOREIGN KEY (kvalifikasjon_id) REFERENCES kvalifikasjon(kvalifikasjon_id);

-- Bedrift
INSERT INTO bedrift(navn, tlf, epost) VALUES ("Simons vikarbyrå",48104122,"svikarbyrå@getVikar.no");

-- Kandidater
INSERT INTO kandidat(fornavn, etternavn, telefon, epost) VALUES ("Markus","Svendsen",91234567,"markus@svendsen.no");
INSERT INTO kandidat(fornavn, etternavn, telefon, epost) VALUES ("Sirrup","Loffestad",41234567,"markus@svendsen.no");






















