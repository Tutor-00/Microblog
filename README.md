# Microblog
![](https://img.shields.io/badge/PROGETTO-SCOLASTICO-green?style=for-the-badge&logo=google-scholar&logoColor=green)

  Progetto di TPI, sviluppato in Java utilizzando Derby come motore database.
  Di default è possibil eregistrarsi solo con ruolo **UTENTE**, per registrarsi con ruolo **ADMIN** è necessario inserire manualmente       _ADMIN_ nel campo **RUOLO** della tabella _BlogUtente_.
  L'utente con ruolo _Utente_ può solo commentare i post inseriti dagli _Admin_. Senza registrazione è possibile solamente visualizzare i   post.
  
## Come usarlo
  Scaricato il progetto e aprirlo con NetBeans (è consigliata la versione 11 o superiore) bisognerà importare il database Microblog ([che si trova nella root del progetto](https://github.com/Tutor-00/Microblog_Restful/tree/master/Microblog)) su Netbeans, andando nella scheda _Services_, _Databases_, _Java DB_ facendo tasto destro su quest'ultimo, cliccando _properties_ e scegliendo come _Database Location_ la cartella del progetto. Infine bisognerà effettuare la connessione al database lasciando i campi username e password **vuoti**. Dopodiché è necessario aggiungere un Application Server al progetto, per effettuare il deploy. Infine bisognerà eseguire il progetto e recarsi tramite browser all'indirizzo  ```http://localhost:8080/Microblog```. 
