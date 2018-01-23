-- Utgave tilpasset MySQL

-- Sletter tabeller
-- Fjern før første kjøring.

DROP TABLE bok_forfatter;
DROP TABLE forfatter;
DROP TABLE bok;
DROP TABLE forlag;
DROP TABLE konsulent;

-- Oppretter tabeller med entitetsintegritet (primærnøkkel)

CREATE TABLE forlag(
  forlag_id INTEGER NOT NULL AUTO_INCREMENT,
  forlag_navn VARCHAR(30),
  adresse VARCHAR(30),
  telefon CHAR(15),
  CONSTRAINT forlag_pk PRIMARY KEY(forlag_id));

CREATE TABLE bok(
  bok_id INTEGER NOT NULL AUTO_INCREMENT,
  tittel VARCHAR(30),
  utgitt_aar INTEGER,
  forlag_id INTEGER,
  CONSTRAINT bok_pk PRIMARY KEY(bok_id));

CREATE TABLE forfatter(
  forfatter_id INTEGER NOT NULL AUTO_INCREMENT,
  fornavn VARCHAR(20),
  etternavn VARCHAR (30),
  fode_aar INTEGER,
  dod_aar INTEGER,
  nasjonalitet VARCHAR(20),
  CONSTRAINT forfatter_pk PRIMARY KEY(forfatter_id));

CREATE TABLE bok_forfatter(
  bok_id INTEGER NOT NULL,
  forfatter_id INTEGER NOT NULL,
  CONSTRAINT bok_forfatter_pk PRIMARY KEY(bok_id, forfatter_id));

CREATE TABLE konsulent(
  kons_id INTEGER NOT NULL AUTO_INCREMENT,
  fornavn VARCHAR(20),
  etternavn VARCHAR (30),
  epost VARCHAR(30),
  CONSTRAINT konsulent_pk PRIMARY KEY(kons_id));

-- Legger på referanseintegritet (fremmednøkler)

ALTER TABLE bok
  ADD CONSTRAINT bok_fk FOREIGN KEY(forlag_id)REFERENCES forlag(forlag_id);

ALTER TABLE bok_forfatter
  ADD CONSTRAINT bok_forfatter_fk1 FOREIGN KEY(bok_id)REFERENCES bok(bok_id);

ALTER TABLE bok_forfatter
  ADD CONSTRAINT bok_forfatter_fk2 FOREIGN KEY(forfatter_id)REFERENCES forfatter(forfatter_id);

-- Legger inn data i tabellene

INSERT INTO forlag VALUES(DEFAULT,'Tapir','Trondheim', '73590000');
INSERT INTO forlag VALUES(DEFAULT,'Gyldendal','Oslo', '22220000');
INSERT INTO forlag VALUES(DEFAULT,'Cappelen','Oslo', '22200000');
INSERT INTO forlag VALUES(DEFAULT,'Universitetsforlaget','Oslo', '23230000');
INSERT INTO forlag VALUES(DEFAULT,'Achehaug','Oslo', '22000000');
INSERT INTO forlag VALUES(DEFAULT,'Oktober','Oslo', '22002200');
INSERT INTO forlag VALUES(DEFAULT,'Tiden','Oslo', '22232223');
INSERT INTO forlag VALUES(DEFAULT,'Harper Collins','USA',NULL);

INSERT INTO bok VALUES(DEFAULT,'Tåpenes',1995,7);
INSERT INTO bok VALUES(DEFAULT,'Rebecca',1981,3);
INSERT INTO bok VALUES(DEFAULT,'Gutter er gutter',1995,5);
INSERT INTO bok VALUES(DEFAULT,'Microserfs',1991,8);
INSERT INTO bok VALUES(DEFAULT,'Generation X',1995,8);
INSERT INTO bok VALUES(DEFAULT,'Klosterkrønike',1982,3);
INSERT INTO bok VALUES(DEFAULT,'Universet',1988,3);
INSERT INTO bok VALUES(DEFAULT,'Nålen',1978,3);
INSERT INTO bok VALUES(DEFAULT,'Markens grøde',1917,2);
INSERT INTO bok VALUES(DEFAULT,'Victoria',1898,2);
INSERT INTO bok VALUES(DEFAULT,'Sult',1890,2);
INSERT INTO bok VALUES(DEFAULT,'Benoni',1908,2);
INSERT INTO bok VALUES(DEFAULT,'Rosa',1908,2);
INSERT INTO bok VALUES(DEFAULT,'Et skritt',1997,2);
INSERT INTO bok VALUES(DEFAULT,'Den femte',1996,2);
INSERT INTO bok VALUES(DEFAULT,'Villspor',1995,2);
INSERT INTO bok VALUES(DEFAULT,'Silkeridderen',1994,2);
INSERT INTO bok VALUES(DEFAULT,'Den hvite hingsten',1992,2);
INSERT INTO bok VALUES(DEFAULT,'Hunder',1992,2);
INSERT INTO bok VALUES(DEFAULT,'Bridget Jones',1995,5);
INSERT INTO bok VALUES(DEFAULT,'Se terapeuten',1998,3);
INSERT INTO bok VALUES(DEFAULT,'Sa mor',1996,3);
INSERT INTO bok VALUES(DEFAULT,'Jubel',1995,3);
INSERT INTO bok VALUES(DEFAULT,'Tatt av kvinnen',1993,3);
INSERT INTO bok VALUES(DEFAULT,'Supernaiv',1996,3);

INSERT INTO forfatter VALUES(DEFAULT,'John','Tool',1937, 1969, 'USA');
INSERT INTO forfatter VALUES(DEFAULT,'Ken','Follet',NULL, NULL, 'Britisk');
INSERT INTO forfatter VALUES(DEFAULT,'Stephen','Hawking',NULL, NULL, 'Britisk');
INSERT INTO forfatter VALUES(DEFAULT,'Jose','Saramago',1942, NULL, 'Portugisisk');
INSERT INTO forfatter VALUES(DEFAULT,'Douglas','Coupland',1961, NULL, 'Canadisk');
INSERT INTO forfatter VALUES(DEFAULT,'Nick','Hornby',1857, NULL, 'Britisk');
INSERT INTO forfatter VALUES(DEFAULT,'Knut','Hamsun',1859, 1952, 'Norsk');
INSERT INTO forfatter VALUES(DEFAULT,'Henning','Mankell',1948, NULL, 'Svensk');
INSERT INTO forfatter VALUES(DEFAULT,'Helen','Fielding',NULL, NULL, 'Britisk');
INSERT INTO forfatter VALUES(DEFAULT,'Hal','Sirowitz',NULL, NULL, 'USA');
INSERT INTO forfatter VALUES(DEFAULT,'Lars S.','Christensen',NULL, NULL, 'Norsk');
INSERT INTO forfatter VALUES(DEFAULT,'Erlend','Loe',NULL, NULL, 'Norsk');

INSERT INTO bok_forfatter VALUES(1, 1);
INSERT INTO bok_forfatter VALUES(2, 2);
INSERT INTO bok_forfatter VALUES(3, 6);
INSERT INTO bok_forfatter VALUES(4, 5);
INSERT INTO bok_forfatter VALUES(5, 5);
INSERT INTO bok_forfatter VALUES(6, 4);
INSERT INTO bok_forfatter VALUES(7, 3);
INSERT INTO bok_forfatter VALUES(8, 2);
INSERT INTO bok_forfatter VALUES(9, 7);
INSERT INTO bok_forfatter VALUES(10, 7);
INSERT INTO bok_forfatter VALUES(11, 7);
INSERT INTO bok_forfatter VALUES(12, 1);
INSERT INTO bok_forfatter VALUES(13, 1);
INSERT INTO bok_forfatter VALUES(14, 8);
INSERT INTO bok_forfatter VALUES(15, 8);
INSERT INTO bok_forfatter VALUES(16, 8);
INSERT INTO bok_forfatter VALUES(17, 8);
INSERT INTO bok_forfatter VALUES(18, 8);
INSERT INTO bok_forfatter VALUES(19, 8);
INSERT INTO bok_forfatter VALUES(20, 9);
INSERT INTO bok_forfatter VALUES(21, 10);
INSERT INTO bok_forfatter VALUES(22, 10);
INSERT INTO bok_forfatter VALUES(23, 11);
INSERT INTO bok_forfatter VALUES(24, 12);
INSERT INTO bok_forfatter VALUES(25, 12);

INSERT INTO konsulent VALUES(DEFAULT, 'Anne', 'Hansen', 'anne.hansen@xxx.com');
INSERT INTO konsulent VALUES(DEFAULT, 'Bjørn', 'Jensen', 'bjornj@yyy.com');
INSERT INTO konsulent VALUES(DEFAULT, 'Anne', 'Ås', 'anne.as@zzz.com');


-- a)
-- Lag en SQL-spørring som utfører operasjonene seleksjon og projeksjon på tabellen Bok.
SELECT * FROM bok WHERE bok_id>=10;
SELECT DISTINCT bok_id, tittel, utgitt_aar
FROM bok WHERE bok_id>=10 && bok.bok_id<=20;

-- b)
-- Lag en SQL-spørring som utfører operasjonen produkt på tabellene Forlag og Bok.
-- Beskriv resultatet med egne ord.
SELECT *  FROM forlag, bok;

-- c)
-- Lag SQL-spørringer som utfører operasjonene likhetsforening (equijoin) og naturlig forening (natural join) på tabellene Forlag og Bok.
-- Hva forteller resultatet?

SELECT * FROM forlag, bok
WHERE forlag.forlag_id = bok.forlag_id;
-- Resultatet fra koden over forener tabellene forlag og bok hvor forlag_id er lik. Du får to søyler med samme forlag_id.
SELECT * FROM forlag NATURAL JOIN bok;
-- Resultater fra koden over forener tabellen forlag og bok hvor forlag_id er lik. Med natural join får du kun en søyle med forlag_id.


-- d)
-- Finn eksempler på attributter eller kombinasjoner av attributter som er unionkompatible.
-- Hvilke relasjonsoperasjoner krever at operandene er unionkompatible?
-- Sett opp SQL-spørringer som utfører disse operasjonene, et eksempel på hver. Beskriv med egne ord hva spørringene gir deg svaret på.

SELECT forlag_navn, forlag_id FROM forlag
UNION
SELECT tittel, forlag_id from bok;
-- usikker på hva som skjer her.



-- Oppgave 2

-- a)
-- Bruk SQL til å finne navnene til alle forlagene.
-- Hvilken eller hvilke operasjoner fra relasjonsalgebraen brukte du?

SELECT forlag_navn
FROM forlag;

-- b)
-- Bruk SQL til å finne eventuelle forlag (forlag_id er nok) som ikke har gitt ut bøker.
-- Hvilken eller hvilke operasjoner fra relasjonsalgebraen brukte du?

SELECT forlag.forlag_id, forlag.forlag_navn
FROM forlag
LEFT JOIN bok ON bok.forlag_id=forlag.forlag_id
WHERE bok.forlag_id IS NULL ;

-- c)
-- Bruk SQL til å finne forfattere som er født i 1948.
-- Hvilken eller hvilke operasjoner fra relasjonsalgebraen brukte du?

SELECT forfatter.fode_aar, forfatter.fornavn, forfatter.etternavn
FROM forfatter
WHERE fode_aar=1948;

-- d)
-- Bruk SQL til å finne navn og adresse til forlaget som har gitt ut boka 'Generation X'.
-- Hvilken eller hvilke operasjoner fra relasjonsalgebraen brukte du?

SELECT forlag.forlag_navn, forlag.adresse
FROM forlag
LEFT JOIN bok ON bok.forlag_id = forlag.forlag_id
WHERE bok.tittel = "Generation X";

-- e)
-- Bruk SQL til å finne titlene på bøkene som Hamsun har skrevet.
-- Hvilken eller hvilke operasjoner fra relasjonsalgebraen brukte du?

SELECT tittel
FROM bok
WHERE bok_id IN(
SELECT bok_id
FROM bok_forfatter
WHERE forfatter_id
IN (SELECT forfatter_id
FROM forfatter
WHERE forfatter.etternavn = "Hamsun"));


-- f)
-- Bruk SQL til å finne informasjon om bøker og forlagene som har utgitt dem.
-- Én linje i oversikten skal inneholde bokas tittel og utgivelsesår, samt forlagets navn, adresse og telefonnummer.
-- Forlag som ikke har gitt ut noen bøker skal også med i listen. Hvilken eller hvilke operasjoner fra relasjonsalgebraen brukte du?
--
SELECT bok.tittel, bok.utgitt_aar, forlag.forlag_navn, forlag.adresse, forlag.telefon
FROM forlag
LEFT JOIN bok ON bok.forlag_id = forlag.forlag_id;

