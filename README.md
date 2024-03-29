
# Battleship [![Docker Build & Push](https://github.com/softeng2223-inf-uniba/progetto2223-dongarra/actions/workflows/docker_build&push.yml/badge.svg)](https://github.com/softeng2223-inf-uniba/progetto2223-dongarra/actions/workflows/docker_build&push.yml)

La struttura della repository si presenta nel seguente modo:

```plaintext
|-- .github
|    |-- workflows
|    |      |-- docker_build&push.yml
|    |      |-- gradle_build.yml
|-- build
|    |-- reports
|    |      |-- checkstyle
|    |      |-- spotbugs
|    |      |-- tests/test
|–– config
|    |–– checkstyle
|    |–– pmd
|–– docs
|    |–– img manuale utente
|    |–– img
|    |–– Assegnazione progetto.md
|    |–– Guida per lo studente.md
|    |–– CODE_OF_CONDUCT.md
|    |–– ISPIRATORE.md
|    |–– Report.md
|–– drawings
|–– gradle
|–– lib
|–– res
|–– src
|    |–– main
|    |–– test
|–– .gitignore
|–– build.gradle
|–– README.md
|–– gradlew
|–– gradle.bat
|–– settings.gradle
```

Nel seguito si dettagliano i ruoli dei diversi componenti:

- `.github/workflows/docker_build&push.yml` e `.github/workflows/gradle_build.yml` : dettagliano le direttive per assicurare la *continuous integration* attraverso l’uso di GitHub Actions;
- `build/`: ospita la sottocartella `reports/`, contenente gli output dei tool automatici di test e controllo di qualità;
- `config/`: ospita i file di configurazione. L’unica configurazione di base richiesta è quella per il tool checkstyle;
- `docs/`: ospita la documentazione di progetto, incluse le figure (nelle sottocartelle `img/` e `img manuale utente/`).
  Il file `Report.md` verrà usato per redigere la relazione finale del progetto.
  La cartella raccoglie inoltre:
  - `Assegnazione progetto.md`: contenente la descrizione dettagliata del progetto assegnato;
  - `Guida per lo studente.md`: contenente la descrizione di tutti i passi di configurazione necessari per l'attivazione del flusso di lavoro a supporto dello sviluppo del progetto;
  - `CODE_OF_CONDUCT.md`: contenente il codice di condotta del team di sviluppo;
  - `ISPIRATORE.md`: contenente la biografia del vincitore del Turing Award che da il nome al team;
- `gradle/`: ospita il `.jar` relativo al sistema di gestione delle dipendenze *Gradle*.
- `lib`: include eventuali librerie esterne utilizzate dal progetto.
- `res`: contiene risorse varie utilizzate dal sistema
- `src`: cartella principale del progetto, in cui scrivere tutto il codice dell’applicazione. In `main/` ci saranno i file sorgente e `test/` conterrà i test di unità previsti.
- `drawings/`: contiene tutti i diagrammi UML usati per descrivere il progetto.
- `.gitignore`: specifica tutti i file che devono essere esclusi dal sistema di controllo versione.
- `build.gradle`: esplicita le direttive e la configurazione di *Gradle*.
- `gradlew` e `gradlew.bat`: eseguibili di *Gradle*, rispettivamente dedicati a Unix e Windows.
- `settings.gradle`: file di configurazione di *Gradle*.

In alcune cartelle è possibile notare la presenza di un unico file nascosto `.keep`: questo ha il solo scopo di richiedere a Git l’inclusione delle cartelle in cui è contenuto (Git esclude dal *versioning* le cartelle vuote). Pertanto, il file può essere ignorato o eventualmente cancellato nel momento in cui si inserisca almeno un altro file all’interno della cartella.
