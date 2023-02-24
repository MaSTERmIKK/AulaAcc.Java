/*
ATTORI (CodAttore, Nome, AnnoNascita, Nazionalità);
RECITA (CodAttore*, CodFilm*)
FILM (CodFilm, Titolo, AnnoProduzione, Nazionalità, Regista, Genere)
PROIEZIONI (CodProiezione, CodFilm*, CodSala*, Incasso, DataProiezione)
SALE (CodSala, Posti, Nome, Città)
*/

-- ****************************************************************************************************
-- Il titolo e l'anno di produzione dei film di fantascienza giapponesi o francesi prodotti dopo il 1990
SELECT titotlo, annoProduzione
FROM film
WHERE nazionalità in ('giappone', 'francia') AND annoProduzione > 1990 AND genere LIKE ('fatntascienza');
-- WHERE (nazionalità LIKE ('giappone') or nazionalità LIKE ('francia')) AND annoProduzione > 1990 AND genere LIKE ('fatntascienza');
-- WHERE (nazionalità = 'giappone' or nazionalità = 'francia') AND annoProduzione > 1990 AND genere = 'fatntascienza';

-- ****************************************************************************************************
-- I nomi delle sale di Napoli in cui il giorno di Natale 2004 è stato proiettato un film con l'attore R.Williams
SELECT s.nome
FROM sale as s, recita as r, film as f, proiezioni as p, attori as a
WHERE s.codSala = p.codSala AND p.codFilm = f.codFilm AND f.codFilm = r.codFilm AND r.codAttore = a.codAttore -- collemanti
	  AND s.città = 'Napoli' AND p.dataproiezione = '2004-12-24' AND a.attore = 'R.Williams';
      
SELECT s.nome
FROM sale as s
 -- collemanti
JOIN proiezioni as p ON s.codSala = p.codSala
JOIN film as f ON p.codFilm = f.codFilm
JOIN recita as r ON f.codFilm = r.codFilm
JOIN attori as a ON r.codAttore = a.codAttore
-- condizione
WHERE s.città = 'Napoli' AND p.dataproiezione = '2004-12-24' AND a.attore = 'R.Williams';

SELECT Nome
From Sale
WHERE exists (
SELECT DataProiezione, Nome
FROM Proiezioni, Attori
WHERE DataProiezione like '2004-12-25' and Nome LIKE 'R%Williams')
AND Città like 'Napoli';

-- ****************************************************************************************************
-- Per ogni città, il numero di sale con più di 60 posti
SELECT s.città, count(*) AS NumSale
FROM sale as s
WHERE s.posti > 60
GROUP BY s.città;

-- ****************************************************************************************************
-- Per ogni regista, il numero di film diretti dopo il 1990
SELECT f.regista, count(*) AS NumFilmDiretti
FROM film as f
WHERE f.annoProduzion > 1960
GROUP BY f.regista;

-- ****************************************************************************************************
-- Per ogni film prodotto dopo il 2000, il codice, il titolo e l’incasso totale di tutte le sue proiezioni
SELECT f.codFilm, f.titolo, sum(p.incasso) as incassoTotale
FROM film as f, proiezioni as p
WHERE f.codFIlm = p.codFilm AND f.annoProduzion > 2000
GROUP BY f.codFilm, f.titolo
ORDER BY incassoTotale;

SELECT f.codFilm, f.titolo, sum(p.incasso) AS incassoTotale
FROM film as f
INNER JOIN proiezioni as p ON s.CodFilm = p.CodFilm
WHERE f.AnnoProduzione > 2000
GROUP BY f.CodFilm, f.Titolo;