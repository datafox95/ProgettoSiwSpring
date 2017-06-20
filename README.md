# ProgettoSiwSpring
Progetto finale per l'esame di Sistemi informativi su Web

Realizzatore e curatore: Bigini Daniele

Tecnologie usate: PostgreSql, SpringMVC, Spring Boot, Thymeleaf

Descrizione:

Il progetto riguarda la realizzazione di un sistema informativo per la gestione di una galleria d'arte.

La galleria può essere navigata attraverso una barra di navigazione che permette l'accesso alle varie sezioni della galleria.

Struttura della galleria:

-sezione artisti: in quest'area possono essere navigati gli artisti inseriti nella galleria attraverso i loro nomi. Navigando un'artista è possibile accedere alle informazioni riguardanti l'artista nonchè le opere realizzate dallo stesso. Attraverso la navigazione dei titoli delle opere è possibile accedere alle informazioni dell'opera

-sezione opere: in quest'area è possibile visualizzare le opere inserite nella galleria. Navigando il titolo di un'opera è possibile visualizzare le informazioni relative all'opera.

-sezione stanze: in quest'area sono visualizzare le stanze della galleria. Le stanze sono delle esposizioni di opere. Navigando il nome di una stanza è possibile visualizzare le opere al suo interno. I titoli delle opere sono sempre navigabili.

-sezione area riservata: questa sezione è la più importante perche contiene tutta la logica di gestione della galleria. L'area dovrebbe poter essere acceduta solo dagli amministratori dopo essersi identificati loggandosi.

Casi d'uso:

-UC1: inserimento artista

-UC2: cancellazione artista

-UC3: modifica artista

-UC4: inserimento opera

-UC5: cancellazione opera

-UC6: inserimento stanza

-UC7: cancellazione stanza

-UC8: aggiunta di un amministratore
