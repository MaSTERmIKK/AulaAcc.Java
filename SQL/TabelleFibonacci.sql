-- UTENTI
-- username pk "alla fine della dichiarazione delle colonne = PRIMARY KEY (colum)"
-- password - not null
-- nazionalità - enum (italiana, francese, spagnola, tedesca, marziana, portoricana, americana) default 'marziana'
-- data di nascita - date not null  check(data di nascita <= '2005-01-01')
-- mail - unique not null

-- STATISTICHE
-- username fk "alla fine della dichhiarazione delle colonne - FOREIGN KEY (colum) REFERENCES ref_table(ref_colum)"
-- numero di login - default 0
-- data utlimo login - date not null
-- numero preferito - not null
-- numero di volte che ha generato la sequenza - default 0
-- numero più alto generato - BIGINT default 0
-- numero di volte che ha cercato un numero - default 0
-- numero di volte che ha cercato il numero preferito - default 0
-- numero più alto cercato - BIGINT default 0
-- FOREIGN KEY(username) REFERENCES utenti(username)