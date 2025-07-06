# Simple Time Logger

Ein leichter Desktop-Client zum Loggen von Arbeits- und Pausenzeiten in Java/Swing, nach MVC/MVP-Prinzip aufgebaut.

## Features (PoC)

- **Registrierung & Login**  
  - Benutzer anlegen und zur Login-Maske zurückkehren  
  - Einfache Passwort-Validierung  
- **Zeiterfassung**  
  - „Einstempeln“ (Start Working)  
  - „Pause“ (Pause Working)  
  - Live-Update der Arbeits- und Pausenzeit via Swing-Timer
 
## Roadmap (PoC)

- Bugfixes  
- Fehlende Unit-Tests ergänzen  
- Passwort-Hashing statt Klartext einführen  
- UI anpassen und verfeinern  

## Installation & Start
 > **Hinweis:** Dies ist ein Proof-of-Concept und befindet sich noch im aktiven Umbau.  

```bash
git clone https://github.com//iaryser/simple-time-logger.git
cd simple-time-logger
mvn clean install
mvn exec:java -Dexec.mainClass="ch.timor.projects.simpletimelogger.Main"
