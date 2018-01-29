DROP TABLE world;

CREATE TABLE world(
  name VARCHAR(50) NOT NULL,
  continent VARCHAR(60),
  area DECIMAL(10),
  population DECIMAL(11),
  gdp DECIMAL(14),
  PRIMARY KEY (name)
);

CREATE INDEX world_region ON world(continent);

insert into world values ('Afghanistan','South Asia',652225,26000000,NULL);
insert into world values ('Albania','Europe',28728,3200000,6656000000);
insert into world values ('Algeria','Middle East',2400000,32900000,75012000000);
insert into world values ('Andorra','Europe',468,64000,NULL);
insert into world values ('Angola','Africa',1250000,14500000,14935000000);
insert into world values ('Antigua and Barbuda','Americas',442,77000,770000000);
insert into world values ('Argentina','South America',2800000,39300000,146196000000);
insert into world values ('Armenia','Europe',29743,3000000,3360000000);
insert into world values ('Australia','Asia-Pacific',7700000,20300000,546070000000);
insert into world values ('Austria','Europe',83871,8100000,261630000000);
insert into world values ('Azerbaijan','Europe',86600,8500000,NULL);
insert into world values ('Bahamas','Americas',13939,321000,4789320000);
insert into world values ('Bahrain','Middle East',717,754000,9357140000);
insert into world values ('Bangladesh','South Asia',143998,152600000,67144000000);
insert into world values ('Barbados','Americas',430,272000,2518720000);
insert into world values ('Belarus','Europe',207595,9800000,20776000000);
insert into world values ('Belgium','Europe',30528,10300000,319609000000);
insert into world values ('Belize','Americas',22965,266000,NULL);
insert into world values ('Benin','Africa',112622,7100000,3763000000);
insert into world values ('Bhutan','South Asia',38364,2400000,1824000000);
insert into world values ('Bolivia','South America',1100000,9100000,NULL);
insert into world values ('Bosnia-Hercegovina','Europe',51129,4200000,8568000000);
insert into world values ('Botswana','Africa',581730,1800000,7812000000);
insert into world values ('Brazil','South America',8550000,182800000,564852000000);
insert into world values ('Brunei','Asia-Pacific',5765,374000,NULL);
insert into world values ('Bulgaria','Europe',110994,7800000,21372000000);
insert into world values ('Burkina Faso','Africa',274200,13800000,4968000000);
insert into world values ('Burma','Asia-Pacific',676552,50700000,NULL);
insert into world values ('Burundi','Africa',27816,7300000,NULL);
insert into world values ('Cambodia','Asia-Pacific',181035,14800000,4736000000);
insert into world values ('Cameroon','Africa',465458,16600000,13280000000);
insert into world values ('Canada','North America',9900000,32000000,908480000000);
insert into world values ('Cape Verde','Africa',4033,482000,853140000);
insert into world values ('Central African Republic','Africa',622984,3900000,NULL);
insert into world values ('Chad','Africa',1280000,9100000,2366000000);
insert into world values ('Chile','South America',756096,16200000,79542000000);
insert into world values ('China','Asia-Pacific',9600000,1300000000,1677000000000);
insert into world values ('Colombia','South America',1140000,45600000,NULL);
insert into world values ('Comoros','Africa',1862,812000,NULL);
insert into world values ('Costa Rica','Americas',51100,4300000,NULL);
insert into world values ('Croatia','Europe',56594,4400000,28996000000);
insert into world values ('Cuba','Americas',110860,11300000,NULL);
insert into world values ('Cyprus','Europe',9250,807000,14187060000);
insert into world values ('Czech Republic','Europe',78866,10200000,93330000000);
insert into world values ('Democratic Republic of Congo','Africa',2340000,56000000,6720000000);
insert into world values ('Denmark','Europe',43098,5400000,219510000000);
insert into world values ('Djibouti','Africa',23200,721000,NULL);
insert into world values ('Dominica','Americas',751,71000,259150000);
insert into world values ('Dominican Republic','Americas',48072,9000000,NULL);
insert into world values ('East Timor','Asia-Pacific',14609,857000,NULL);
insert into world values ('Ecuador','South America',272045,13400000,NULL);
insert into world values ('Egypt','Middle East',1000000,74900000,98119000000);
insert into world values ('El Salvador','Americas',21041,6700000,15745000000);
insert into world values ('Equatorial Guinea','Africa',28051,521000,484530000);
insert into world values ('Eritrea','Africa',117400,4561599,NULL);
insert into world values ('Estonia','Europe',45227,1300000,9113000000);
insert into world values ('Ethiopia','Africa',1130000,74200000,8162000000);
insert into world values ('Fiji','Asia-Pacific',18376,854000,NULL);
insert into world values ('Finland','Europe',338145,5200000,170508000000);
insert into world values ('Former Yugoslav Republic of Macedonia','Europe',25713,2000000,4700000000);
insert into world values ('France','Europe',543965,60700000,1826463000000);
insert into world values ('Gabon','Africa',267667,1400000,NULL);
insert into world values ('Georgia','Europe',69700,5000000,5200000000);
insert into world values ('Germany','Europe',357027,82500000,2484900000000);
insert into world values ('Ghana','Africa',238533,21800000,8284000000);
insert into world values ('Greece','Europe',131957,11000000,182710000000);
insert into world values ('Grenada','Americas',344,103000,NULL);
insert into world values ('Guatemala','Americas',108890,13000000,NULL);
insert into world values ('Guinea','Africa',245857,8800000,4048000000);
insert into world values ('Guinea-Bissau','Africa',36125,1600000,256000000);
insert into world values ('Guyana','South America',214969,768000,NULL);
insert into world values ('Haiti','Americas',27750,8500000,NULL);
insert into world values ('Honduras','Americas',112492,7200000,7416000000);
insert into world values ('Hungary','Europe',93030,9800000,81046000000);
insert into world values ('Iceland','Europe',103000,294000,11354280000);
insert into world values ('India','South Asia',3100000,1100000000,682000000000);
insert into world values ('Indonesia','Asia-Pacific',1900000,225300000,256842000000);
insert into world values ('Iran','Middle East',1650000,70700000,162610000000);
insert into world values ('Iraq','Middle East',438317,26500000,NULL);
insert into world values ('Ireland','Europe',70182,4000000,137120000000);
insert into world values ('Israel and Palestinian territories','Middle East',20770,3800000,4256000000);
insert into world values ('Italy','Europe',301338,57200000,1494064000000);
insert into world values ('Ivory Coast','Africa',322462,17100000,13167000000);
insert into world values ('Jamaica','Americas',10991,2700000,7830000000);
insert into world values ('Japan','Asia-Pacific',377864,127900000,4755322000000);
insert into world values ('Jordan','Middle East',89342,5700000,12198000000);
insert into world values ('Kazakhstan','Asia-Pacific',2700000,15400000,NULL);
insert into world values ('Kenya','Africa',582646,32800000,15088000000);
insert into world values ('Kiribati','Asia-Pacific',810,85000,82450000);
insert into world values ('Kuwait','Middle East',17818,2700000,48519000000);
insert into world values ('Kyrgyzstan','Asia-Pacific',199900,5300000,NULL);
insert into world values ('Laos','Asia-Pacific',236800,5900000,2301000000);
insert into world values ('Latvia','Europe',64589,2300000,NULL);
insert into world values ('Lebanon','Middle East',10452,3800000,18924000000);
insert into world values ('Lesotho','Africa',30355,1800000,1332000000);
insert into world values ('Liberia','Africa',99067,3600000,396000000);
insert into world values ('Libya','Africa',1770000,5800000,25810000000);
insert into world values ('Liechtenstein','Europe',160,34000,NULL);
insert into world values ('Lithuania','Europe',65300,3400000,19516000000);
insert into world values ('Luxembourg','Europe',2586,465000,26146950000);
insert into world values ('Madagascar','Africa',587041,18400000,5520000000);
insert into world values ('Malawi','Africa',118484,12600000,2142000000);
insert into world values ('Malaysia','Asia-Pacific',329847,25300000,NULL);
insert into world values ('Mali','Africa',1250000,13800000,4968000000);
insert into world values ('Malta','Europe',316,397000,4863250000);
insert into world values ('Marshall Islands','Asia-Pacific',181,57000,135090000);
insert into world values ('Mauritania','Middle East',1040000,3100000,1302000000);
insert into world values ('Mauritius','Africa',2040,1200000,5568000000);
insert into world values ('Mexico','North America',1960000,106400000,720328000000);
insert into world values ('Micronesia','Asia-Pacific',700,111000,NULL);
insert into world values ('Moldova','Europe',33800,4300000,3053000000);
insert into world values ('Monaco','Europe',2,32000,NULL);
insert into world values ('Mongolia','Asia-Pacific',1560000,2700000,NULL);
insert into world values ('Morocco','Middle East',710850,31600000,48032000000);
insert into world values ('Mozambique','Africa',812379,19500000,4875000000);
insert into world values ('Namibia','Africa',824292,2000000,4740000000);
insert into world values ('Nauru','Asia-Pacific',21,9900,NULL);
insert into world values ('Nepal','South Asia',147181,26300000,6838000000);
insert into world values ('New Zealand','Asia-Pacific',270534,4000000,81240000000);
insert into world values ('Nicaragua','Americas',120254,5700000,4503000000);
insert into world values ('Niger','Africa',1270000,12900000,2967000000);
insert into world values ('Nigeria','Africa',923768,130200000,50778000000);
insert into world values ('North Korea','Asia-Pacific',122762,22900000,NULL);
insert into world values ('Norway','Europe',323759,4600000,239338000000);
insert into world values ('Oman','Middle East',309500,3000000,23670000000);
insert into world values ('Pakistan','South Asia',796095,161100000,96660000000);
insert into world values ('Palau','Asia-Pacific',508,20000,NULL);
insert into world values ('Panama','Americas',75517,3200000,NULL);
insert into world values ('Papua New Guinea','Asia-Pacific',462840,5900000,3422000000);
insert into world values ('Paraguay','South America',406752,6200000,NULL);
insert into world values ('Peru','South America',1280000,28000000,NULL);
insert into world values ('Poland','Europe',312685,38500000,234465000000);
insert into world values ('Portugal','Europe',92345,10500000,150675000000);
insert into world values ('Qatar','Middle East',11437,628000,NULL);
insert into world values ('Republic of Congo','Africa',342000,3039126,NULL);
insert into world values ('Romania','Europe',238391,22200000,64824000000);
insert into world values ('Russia','Europe',17000000,141500000,482515000000);
insert into world values ('Rwanda','Africa',26338,8600000,1892000000);
insert into world values ('Samoa','Asia-Pacific',2831,182000,NULL);
insert into world values ('San Marino','Europe',61,27000,NULL);
insert into world values ('Sao Tome and Principe','Africa',1001,169000,62530000);
insert into world values ('Saudi Arabia','Middle East',2240000,25600000,267008000000);
insert into world values ('Senegal','Africa',196722,10600000,7102000000);
insert into world values ('Serbia and Montenegro','Europe',102173,10500000,27510000000);
insert into world values ('Seychelles','Africa',455,76000,NULL);
insert into world values ('Sierra Leone','Africa',71740,5300000,1060000000);
insert into world values ('Singapore','Asia-Pacific',660,4400000,106568000000);
insert into world values ('Slovakia','Europe',49033,5400000,34992000000);
insert into world values ('Slovenia','Europe',20273,2000000,29620000000);
insert into world values ('Solomon Islands','Asia-Pacific',27556,504000,277200000);
insert into world values ('Somalia','Africa',637657,10700000,NULL);
insert into world values ('South Africa','Africa',1220000,45300000,164439000000);
insert into world values ('South Korea','Asia-Pacific',99313,48200000,673836000000);
insert into world values ('Spain','Europe',505988,44100000,935361000000);
insert into world values ('Sri Lanka','South Asia',65610,19400000,19594000000);
insert into world values ('St Kitts and Nevis','Americas',269,46000,NULL);
insert into world values ('St Lucia','Americas',616,152000,655120000);
insert into world values ('St Vincent and the Grenadines','Americas',389,121000,441650000);
insert into world values ('Sudan','Middle East',2500000,35000000,18550000000);
insert into world values ('Surinam','South America',163265,442000,NULL);
insert into world values ('Swaziland','Africa',17364,1100000,1826000000);
insert into world values ('Sweden','Europe',449964,8900000,318353000000);
insert into world values ('Switzerland','Europe',41284,7100000,342433000000);
insert into world values ('Syria','Middle East',185180,18600000,22134000000);
insert into world values ('Taiwan','Asia-Pacific',36188,22700000,302364000000);
insert into world values ('Tajikistan','Asia-Pacific',143100,6300000,NULL);
insert into world values ('Tanzania','Africa',945087,38400000,NULL);
insert into world values ('Thailand','Asia-Pacific',513115,64100000,162814000000);
insert into world values ('The Gambia','Africa',11295,1500000,NULL);
insert into world values ('The Maldives','South Asia',298,338000,848380000);
insert into world values ('The Netherlands','Europe',41864,16300000,516710000000);
insert into world values ('The Philippines','Asia-Pacific',300000,82800000,96876000000);
insert into world values ('Togo','Africa',56785,5100000,1938000000);
insert into world values ('Tonga','Asia-Pacific',748,106000,NULL);
insert into world values ('Trinidad and Tobago','Americas',5128,1300000,NULL);
insert into world values ('Tunisia','Middle East',164150,10000000,26300000000);
insert into world values ('Turkey','Europe',779452,73300000,274875000000);
insert into world values ('Turkmenistan','Asia-Pacific',488100,5000000,NULL);
insert into world values ('Tuvalu','Asia-Pacific',26,10000,NULL);
insert into world values ('Uganda','Africa',241038,27600000,7452000000);
insert into world values ('Ukraine','Europe',603700,47800000,60228000000);
insert into world values ('United Arab Emirates','Middle East',77700,3100000,NULL);
insert into world values ('United Kingdom','Europe',242514,59600000,2022824000000);
insert into world values ('United States of America','North America',9800000,295000000,12213000000000);
insert into world values ('Uruguay','South America',176215,3500000,NULL);
insert into world values ('Uzbekistan','Asia-Pacific',447400,26900000,NULL);
insert into world values ('Vanuatu','Asia-Pacific',12190,222000,297480000);
insert into world values ('Vatican','Europe',0,NULL,NULL);
insert into world values ('Venezuela','South America',881050,26600000,NULL);
insert into world values ('Vietnam','Asia-Pacific',329247,83600000,45980000000);
insert into world values ('Yemen','Middle East',536869,21500000,12255000000);
insert into world values ('Zambia','Africa',752614,11000000,4950000000);
insert into world values ('Zimbabwe','Africa',390759,12900000,6192000000);

SELECT name FROM world
WHERE name LIKE 'N%';

-- Summerer populasjon fra tabellen world hvor kontinent = Europe.
SELECT SUM(population) FROM world
WHERE continent LIKE 'Europe';

SELECT continent, SUM(population)AS ant_innbyggere
FROM world
WHERE continent = 'Europe';

SELECT continent, sum(population)AS ant_innbyggere
FROM world
GROUP BY continent;

SELECT continent,SUM(population)AS ant_innbyggere
FROM world
GROUP BY continent
HAVING SUM(population)> 80000000;

SELECT max(population)AS ant_innbyggere
FROM world;

SELECT continent
FROM world
WHERE population < (SELECT max(population)AS ant_innbyggere FROM world);