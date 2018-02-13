DROP TABLE ordredetalj;
DROP TABLE prisinfo;
DROP TABLE ordrehode;
DROP TABLE delinfo;
DROP TABLE levinfo;

CREATE TABLE delinfo(
delnr       INTEGER,
beskrivelse VARCHAR(30) NOT NULL,
CONSTRAINT delinfo_pk PRIMARY KEY(delnr));

CREATE TABLE levinfo(
levnr   INTEGER,
navn    VARCHAR(20) NOT NULL,
adresse VARCHAR(20) NOT NULL,
levby   VARCHAR(20) NOT NULL,
fylke   VARCHAR(20) NOT NULL,
postnr  INTEGER NOT NULL,
CONSTRAINT levinfo_pk PRIMARY KEY(levnr));

CREATE TABLE ordrehode(
ordrenr INTEGER,
dato    DATE NOT NULL,
levnr   INTEGER NOT NULL,
status  CHAR(1) NOT NULL,
CONSTRAINT ordrehode_pk PRIMARY KEY(ordrenr),
CONSTRAINT ordrehode_fk FOREIGN KEY(levnr) REFERENCES levinfo(levnr));

CREATE TABLE ordredetalj(
ordrenr    INTEGER,
delnr        INTEGER NOT NULL,
kvantum   INTEGER NOT NULL,
CONSTRAINT ordredetalj_pk PRIMARY KEY(ordrenr,delnr),
CONSTRAINT ordredetalj_fk1 FOREIGN KEY(ordrenr) REFERENCES ordrehode(ordrenr),
CONSTRAINT ordredetalj_fk2 FOREIGN KEY(delnr) REFERENCES delinfo(delnr));

CREATE TABLE prisinfo(
delnr     INTEGER,
levnr     INTEGER,
katalognr CHAR(6),
pris      REAL,
CONSTRAINT prisinfo_pk PRIMARY KEY(delnr, levnr),
CONSTRAINT prisinfo_fk1 FOREIGN KEY(delnr)REFERENCES delinfo(delnr),
CONSTRAINT prisinfo_fk2 FOREIGN KEY(levnr)REFERENCES levinfo(levnr));

insert into delinfo(delnr, beskrivelse) values(51173,'Binders');
insert into delinfo(delnr, beskrivelse) values(1,'Kontorstol');
insert into delinfo(delnr, beskrivelse) values(51200,'Linjalsett');
insert into delinfo(delnr, beskrivelse) values(3,'Pult');
insert into delinfo(delnr, beskrivelse) values(4,'Skrivebord');
insert into delinfo(delnr, beskrivelse) values(1909,'Skriveunderlag');
insert into delinfo(delnr, beskrivelse) values(201,'Svarte kulepenner');
insert into delinfo(delnr, beskrivelse) values(202,'Blå kulepenner');

insert into levinfo(levnr, navn, adresse, levby, fylke, postnr) values(6,'Kontorekspressen AS','Skolegata 3','Oslo','Oslo',1234);
insert into levinfo(levnr, navn, adresse, levby, fylke, postnr) values(82,'Kontordata AS','Åsveien 178','Trondheim','S-Trøndelag',7023);
insert into levinfo(levnr, navn, adresse, levby, fylke, postnr) values(9,'Kontorutstyr AS','Villa Villekulla','Ås','Østfold',1456);
insert into levinfo(levnr, navn, adresse, levby, fylke, postnr) values(44,'Billig og Bra AS','Aveny 56','Oslo','Oslo',1222);
insert into levinfo(levnr, navn, adresse, levby, fylke, postnr) values(12,'Mister Office AS','Storgt 56','Ås','Østfold',1456);
insert into levinfo(levnr, navn, adresse, levby, fylke, postnr) values(81,'Kontorbutikken AS','Gjennomveien 78','Ål','Telemark',3345);

insert into ordrehode(ordrenr, dato, levnr, status)  values(11,'1986-05-10',6,'c');
insert into ordrehode(ordrenr, dato, levnr, status)  values(12,'1986-07-17',82,'c');
insert into ordrehode(ordrenr, dato, levnr, status)  values(13,'1986-09-13',44,'p');
insert into ordrehode(ordrenr, dato, levnr, status)  values(14,'1986-12-17',44,'p');
insert into ordrehode(ordrenr, dato, levnr, status)  values(15,'1987-01-03',44,'p');
insert into ordrehode(ordrenr, dato, levnr, status)  values(16,'1987-01-31',6,'c');
insert into ordrehode(ordrenr, dato, levnr, status)  values(17,'1987-05-14',6,'c');
insert into ordrehode(ordrenr, dato, levnr, status)  values(18,'1987-05-12',82,'p');


insert into ordredetalj(ordrenr, delnr, kvantum) values(11,1,5);
insert into ordredetalj(ordrenr, delnr, kvantum) values(11,201,100);
insert into ordredetalj(ordrenr, delnr, kvantum) values(11,202,100);
insert into ordredetalj(ordrenr, delnr, kvantum) values(11,1909,6);
insert into ordredetalj(ordrenr, delnr, kvantum) values(11,51200,20);
insert into ordredetalj(ordrenr, delnr, kvantum) values(12,3,2);
insert into ordredetalj(ordrenr, delnr, kvantum) values(12,201,50);
insert into ordredetalj(ordrenr, delnr, kvantum) values(12,202,60);
insert into ordredetalj(ordrenr, delnr, kvantum) values(13,51173,20);
insert into ordredetalj(ordrenr, delnr, kvantum) values(14,201,100);
insert into ordredetalj(ordrenr, delnr, kvantum) values(14,202,100);
insert into ordredetalj(ordrenr, delnr, kvantum) values(14,51173,30);
insert into ordredetalj(ordrenr, delnr, kvantum) values(15,201,100);
insert into ordredetalj(ordrenr, delnr, kvantum) values(15,202,100);
insert into ordredetalj(ordrenr, delnr, kvantum) values(16,201,50);
insert into ordredetalj(ordrenr, delnr, kvantum) values(16,202,50);
insert into ordredetalj(ordrenr, delnr, kvantum) values(16,51173,20);
insert into ordredetalj(ordrenr, delnr, kvantum) values(16,1909,10);
insert into ordredetalj(ordrenr, delnr, kvantum) values(17,1,10);
insert into ordredetalj(ordrenr, delnr, kvantum) values(17,3,1);
insert into ordredetalj(ordrenr, delnr, kvantum) values(17,4,5);
insert into ordredetalj(ordrenr, delnr, kvantum) values(18,3,2);
insert into ordredetalj(ordrenr, delnr, kvantum) values(18,4,8);

insert into prisinfo(delnr, levnr, katalognr, pris) values(51173,6,'37S',0.57);
insert into prisinfo(delnr, levnr, katalognr, pris) values(51173,44,'312/2',0.44);
insert into prisinfo(delnr, levnr, katalognr, pris) values(51173,82,'300021',0.35);
insert into prisinfo(delnr, levnr, katalognr, pris) values(1,6,'97s',120.00);
insert into prisinfo(delnr, levnr, katalognr, pris) values(1,9,'x120',219.99);
insert into prisinfo(delnr, levnr, katalognr, pris) values(51200,6,'54s',7.35);
insert into prisinfo(delnr, levnr, katalognr, pris) values(1909,9,'X7770',3.00);
insert into prisinfo(delnr, levnr, katalognr, pris) values(201,44,'100/1',1.60);
insert into prisinfo(delnr, levnr, katalognr, pris) values(201,6,'21s',1.90);
insert into prisinfo(delnr, levnr, katalognr, pris) values(202,44,'101/1',1.50);
insert into prisinfo(delnr, levnr, katalognr, pris) values(202,9,'22s',1.76);
insert into prisinfo(delnr, levnr, katalognr, pris) values(3,82,'2077',1299.00);
insert into prisinfo(delnr, levnr, katalognr, pris) values(4,82,'2177',899.00);
insert into prisinfo(delnr, levnr, katalognr, pris) values(201,82,'3140',2.60);
insert into prisinfo(delnr, levnr, katalognr, pris) values(202,82,'3141',1.50);
insert into prisinfo(delnr, levnr, katalognr, pris) values(3,6,'34P',1199.00);
insert into prisinfo(delnr, levnr, katalognr, pris) values(4,6,'67P',550.00);
insert into prisinfo(delnr, levnr, katalognr, pris) values(1909,6,'53P',0.85);
insert into prisinfo(delnr, levnr, katalognr, pris) values(202,6,'345u',6.50);
insert into prisinfo(delnr, levnr, katalognr, pris) values(3,9,'a48',1050.00);


-- 1. List ut all informasjon (ordrehode og ordredetalj) om ordrer for leverandør nr 44.
SELECT * from ordredetalj
NATURAL JOIN ordrehode
WHERE levnr = 44;

-- 2. Finn navn og by ("LevBy") for leverandører som kan levere del nummer 1.
SELECT navn, levby
FROM levinfo
NATURAL JOIN prisinfo
WHERE delnr = 1;

-- 3. Finn nummer, navn og pris for den leverandør som kan levere del nummer 201 til billigst pris.
SELECT levinfo.levnr, levinfo.navn, prisinfo.pris
FROM levinfo
NATURAL JOIN prisinfo
WHERE delnr = 201
ORDER BY pris
LIMIT 1;

-- 4. Lag fullstendig oversikt over ordre nr 16, med ordrenr, dato, delnr, beskrivelse, kvantum, (enhets-)pris og beregnet beløp (=pris*kvantum).
SELECT ordrenr,dato,delnr,beskrivelse,kvantum, concat(pris*ordredetalj.kvantum) AS Totalbeløp
FROM ordrehode
NATURAL JOIN ordredetalj NATURAL JOIN prisinfo NATURAL JOIN delinfo
  WHERE ordrenr = 16;

-- 5. Finn delnummer og leverandørnummer for deler som har en pris som er høyere enn prisen for del med katalognr X7770.
SELECT delnr, levnr
FROM prisinfo
WHERE pris > (SELECT pris FROM prisinfo WHERE katalognr = 'X7770');

-- 6
-- i)
-- Tenk deg at tabellen levinfo skal deles i to.
-- Sammenhengen mellom by og fylke skal tas ut av tabellen.
-- Det er unødvendig å lagre fylketilhørigheten for hver forekomst av by.
-- Lag én ny tabell som inneholder byer og fylker. Fyll denne med data fra levinfo.
-- Lag også en tabell som er lik levinfo unntatt kolonnen Fylke. (Denne splittingen av tabellen levinfo gjelder bare i denne oppgaven.
-- I resten av oppgavesettet antar du at du har den opprinnelige levinfo-tabellen.)
CREATE TABLE nySplittet AS
SELECT DISTINCT levby,fylke
  FROM levinfo;

CREATE TABLE nySplittet2 AS
SELECT levnr,navn,adresse,levby,postnr
  FROM levinfo;

-- ii)
-- Lag en virtuell tabell (view) slik at brukerne i størst mulig grad kan jobbe på samme måte mot de to nye tabellene som den gamle.
-- Prøv ulike kommandoer mot tabellen (select, update, delete, insert). Hvilke begrensninger, hvis noen, har brukerne i forhold til tidligere?
CREATE VIEW virtuellNySplittet AS
  SELECT * FROM nySplittet;

CREATE VIEW virtuellNySplittet2 AS
SELECT * FROM nySplittet2;

UPDATE nySplittet
SET levby = 'Bodø'
WHERE fylke = 'Oslo';

UPDATE virtuellNySplittet
SET levby = 'Oslo'
WHERE fylke='Oslo';

INSERT INTO virtuellNySplittet VALUES ('Bodø','Nordland');

--  7. Anta at en vurderer å slette opplysningene om de leverandørene som ikke er representert i Prisinfo-tabellen.
--  Finn ut hvilke byer en i tilfelle ikke får leverandør i. (Du skal ikke utføre slettingen.) (Tips: Svaret skal bli kun én by, "Ål".)
SELECT levby
FROM levinfo
WHERE levby NOT IN (SELECT levby from prisinfo NATURAL JOIN levinfo);

-- Oppgave 2

-- A)
-- Sett opp en SELECT-setning som er UNION mellom alle forlag med Oslo-nummer (telefonnummer begynner med 2) og alle som ikke er Oslo-nummer.
-- Får du med forlaget med NULL-verdi på telefonnummer? Hvis ikke, utvid unionen med en mengde til.
SELECT * FROM forlag WHERE telefon LIKE '2%'
UNION
  SELECT * FROM forlag;

-- B)
-- Sett opp SQL-setninger som finner gjennomsnittlig alder på forfattere der fødselsåret er oppgitt.
-- For forfattere der dødsåret ikke er oppgitt, skal du kun ta med de som er født etter 1900.  Tips for å få ut året i år:
-- MySQL: SELECT YEAR(CURRENT_DATE) FROM ... hvilken tabell som helst ..
SELECT AVG(forfatter.dod_aar-forfatter.fode_aar)
FROM forfatter
WHERE dod_aar IS NOT NULL;

SELECT AVG(YEAR(current_date)-forfatter.fode_aar) FROM forfatter
WHERE dod_aar IS NULL AND fode_aar>1900;

-- C)
-- Sett opp SQL-setninger som finner hvor stor andel av forfatterne som ble med i beregningene under b).
CREATE VIEW dead1 AS SELECT forfatter_id,forfatter.dod_aar-forfatter.fode_aar
                     FROM forfatter
                     WHERE dod_aar IS NOT NULL;

CREATE VIEW dead2 AS SELECT forfatter_id, YEAR(current_date)-forfatter.fode_aar FROM forfatter
WHERE dod_aar IS NULL AND fode_aar>1900;

CREATE VIEW forf_age AS
  SELECT * FROM dead1
  UNION
  SELECT * FROM dead2;

SELECT (SELECT count(forfatter_id) FROM forf_age) / (SELECT count(forfatter_id) FROM forfatter)*100;
