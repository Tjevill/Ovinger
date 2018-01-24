DROP TABLE IF EXISTS historikk;
DROP TABLE IF EXISTS kvalifikasjon;
DROP TABLE IF EXISTS kandidat;
DROP TABLE IF EXISTS oppdrag;
DROP TABLE IF EXISTS bedrift;



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

CREATE TABLE historikk(
  historikk_id INTEGER NOT NULL AUTO_INCREMENT,
  kandidat_id INTEGER NOT NULL,
  oppdrags_id INTEGER NOT NULL,
  startdato DATE,
  sluttdato DATE,
  ant_timer INTEGER ,
  CONSTRAINT historikk_pk PRIMARY KEY (historikk_id)
);