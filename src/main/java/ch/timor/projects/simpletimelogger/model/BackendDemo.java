package ch.timor.projects.simpletimelogger.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class BackendDemo {
    private static final Logger LOG = LoggerFactory.getLogger(BackendDemo.class);

    public static void main(String[] args) {
        UserDataBase dataBase = new UserDataBase();
        LoginService  service = new LoginService(dataBase);

        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Benutzername: ");
            String username = scanner.nextLine();
            System.out.println("Passwort: ");
            String password = scanner.nextLine();

            if (!service.login(username, password)) {
                System.out.println("Kein Account gefunden. [registrieren] oder [beenden]?");
                String input = scanner.nextLine();

                if ("registrieren".equalsIgnoreCase(input)) {
                    System.out.println("Vorname: ");
                    String firstName = scanner.nextLine();
                    System.out.println("Nachname: ");
                    String lastName = scanner.nextLine();
                    System.out.println("Benutzername: ");
                    String newUsername = scanner.nextLine();
                    System.out.println("Passwort: ");
                    String newPassword = scanner.nextLine();

                    try {
                        dataBase.addUser(new User(firstName, lastName, newUsername, newPassword));
                        System.out.println("Registrierung erfolgreich – bitte erneut einloggen.");
                        continue;
                    } catch (IllegalArgumentException ex) {
                        LOG.error(ex.getMessage());
                        continue;
                    }
                } else {
                    break;
                }
            }

            LOG.info("Login für {} erfolgreich", username);
            WorkSession session = new WorkSession();

            while (true) {
                System.out.println("[starten] [pause] [resume] [beenden]");
                String command = scanner.nextLine();

                switch (command.toLowerCase()) {
                    case "starten"  -> session.startWorking();
                    case "pause"    -> session.pauseWorking();
                    case "resume"   -> session.resumeWork();
                    case "beenden"  -> { isRunning = false; break; }
                    default         -> LOG.error("Ungültige Eingabe!");
                }
                if (!isRunning || "logout".equalsIgnoreCase(command)) break;
            }
        }
    LOG.info("Applikation beendet.");
    }

}
