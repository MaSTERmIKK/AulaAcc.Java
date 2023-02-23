use world;

with 

-- nazioni con la percentuale della lingua parlata più alta
maxPerc as 
(SELECT C.Name, MAX(CL.Percentage) as perc
FROM country as C 
JOIN countrylanguage as CL ON C.Code = CL.CountryCode
GROUP BY C.Name
HAVING MAX(CL.Percentage)),

-- lingue parlate per nazione con le percentuali
lngPerc as 
(SELECT C.Name, CL.Language, CL.Percentage as perc
FROM country as C 
JOIN countrylanguage as CL ON C.Code = CL.CountryCode),

-- lingua parlata per nazione con percentuale maggioritaria
clp as 
(SELECT maxPerc.Name, lngPerc.language, maxPerc.perc
FROM maxPerc, lngPerc
where maxPerc.perc = lngPerc.perc AND maxPerc.Name = lngPerc.Name)

-- uniamo clp con country e altri requisiti
select co.Name, co.governmentForm as governo, clp.language, clp.perc
from country as co
INNER JOIN clp ON clp.name = co.name
where co.lifeExpectancy > 70 AND governmentForm LIKE "%Republic%";