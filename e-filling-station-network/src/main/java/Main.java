import FillingStationNetwork.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== E-Filling Station Network DEMO ===");

        StandortManager standortManager = new StandortManager();

        ArrayList<Ladepunkt> ladepunkte = new ArrayList<>();
        ladepunkte.add(new Ladepunkt("LP-0001", Ladepunkt.ChargingMode.AC, Ladepunkt.ChargingPointStatus.FREE));
        ladepunkte.add(new Ladepunkt("LP-0002", Ladepunkt.ChargingMode.DC, Ladepunkt.ChargingPointStatus.BUSY));
        ladepunkte.add(new Ladepunkt("LP-0003", Ladepunkt.ChargingMode.DC, Ladepunkt.ChargingPointStatus.OUT_OF_ORDER));

        Standort standort = new Standort(
                "ST-0001",
                "Demo-Standort FH Wien",
                "Höchstädtplatz 6, 1200 Wien",
                ladepunkte,
                "Öffentlicher Schnelllade-Standort"
        );

        standortManager.AddStandort(standort);

        LadepunktManager ladepunktManager = new LadepunktManager(standortManager);

        System.out.println("\n-- Ladepunkte für Standort ST-0001 --");
        ArrayList<Ladepunkt> alleLadepunkte = ladepunktManager.GetLadepunkteByStandort("ST-0001");
        if (alleLadepunkte != null) {
            for (Ladepunkt lp : alleLadepunkte) {
                System.out.println("  ID=" + lp.getLadepunktId()
                        + ", Mode=" + lp.getChargingMode()
                        + ", Status=" + lp.getStatus());
            }
        }

        System.out.println("\n-- Verfügbare Ladepunkte für ST-0001 --");
        ArrayList<Ladepunkt> verfuegbar = ladepunktManager.GetAvailableLadepunkte("ST-0001");
        for (Ladepunkt lp : verfuegbar) {
            System.out.println("  Available: " + lp.getLadepunktId());
        }


        System.out.println("\n-- Status von LP-0002 direkt ändern (ohne LadepunktManager.SetLadepunktStatus) --");
        for (Ladepunkt lp : alleLadepunkte) {
            if (lp.getLadepunktId().equals("LP-0002")) {
                lp.SetStatus(Ladepunkt.ChargingPointStatus.FREE);
            }
        }
        for (Ladepunkt lp : alleLadepunkte) {
            if (lp.getLadepunktId().equals("LP-0002")) {
                System.out.println("Neuer Status von LP-0002: " + lp.getStatus());
            }
        }

        System.out.println("\n-- Admin-Login --");
        Admin admin = new Admin("admin", "admin123");
        System.out.println("Login admin/admin123: " +
                (admin.login("admin", "admin123") ? "ERFOLGREICH" : "FEHLGESCHLAGEN"));
        System.out.println("Login admin/falsch  : " +
                (admin.login("admin", "falsch") ? "ERFOLGREICH" : "FEHLGESCHLAGEN"));

        System.out.println("\n-- Kunde & Konto anlegen --");
        KundeManager kundeManager = new KundeManager();

        Kunde kunde = new Kunde("Max", "Muster", "max@muster.com", "K1234");
        Konto konto = kundeManager.createKonto(kunde, "passwort");

        if (konto != null) {
            System.out.println("Konto erstellt für Kunde " + kunde.getVorname()
                    + " mit Kundennummer " + konto.getKundennummer());
        } else {
            System.out.println("Konto konnte nicht erstellt werden.");
        }

        Kunde dupKunde = new Kunde("Maxine", "Muster", "max@muster.com", "K9999");
        Konto dupKonto = kundeManager.createKonto(dupKunde, "pw2");
        System.out.println("Zweites Konto mit gleicher E-Mail wurde "
                + (dupKonto == null ? "NICHT " : "") + "erstellt.");

        System.out.println("\n-- Guthaben & Aufladungen --");
        konto.addAufladung(50.0);
        konto.addAufladung(20.0);
        konto.addTopUp(10.0);

        kundeManager.zeigeGuthaben(konto.getKundennummer());

        System.out.println("Bewegungsdaten:");
        for (String b : konto.getBewegungsdaten()) {
            if (b != null) {
                System.out.println("  " + b);
            }
        }

        System.out.println("Aufladungen (Zeitpunkt + Betrag):");
        for (Aufladung a : konto.getAufladungen()) {
            System.out.println("  " + a.getZeitpunkt() + " -> " + a.getBetrag() + " EUR");
        }

        System.out.println("\n-- Kundendaten & Ladevorgänge --");
        kundeManager.zeigeKundendaten(konto.getKundennummer());

        String lvText1 = "Ladevorgang LV0001 an " + standort.getName() + " (LP-0001)";
        String lvText2 = "Ladevorgang LV0002 an " + standort.getName() + " (LP-0002)";
        konto.addLadevorgang(lvText1);
        konto.addLadevorgang(lvText2);
        kunde.addLadevorgang(lvText1);
        kunde.addLadevorgang(lvText2);

        System.out.println("Ladevorgänge aus KundeManager:");
        kundeManager.zeigeLadevorgaenge(konto.getKundennummer());


        System.out.println("\n-- Ladevorgang starten --");
        LadevorgangManager lvManager = new LadevorgangManager();
        lvManager.StartLadeVorgang(
                Ladepunkt.ChargingMode.DC,
                "LP-0001",
                konto.getKundennummer()
        );
        Ladevorgang lv = lvManager.getLadevorgang();
        System.out.println("Gestarteter Ladevorgang: " + lv.getLadeVorgangId()
                + " | Kunde=" + lv.getKundenId()
                + " | Ladepunkt=" + lv.getLadepunktId()
                + " | Mode=" + lv.getChargingMode()
                + " | Start=" + lv.getStart());

        System.out.println("\n-- Rechnungen --");
        Rechnung rechnungAuto = kundeManager.erstelleRechnung(konto.getKundennummer());
        if (rechnungAuto != null) {
            System.out.println("Automatisch erzeugte Rechnung: "
                    + rechnungAuto.getRechnungsnummer()
                    + " | Betrag=" + rechnungAuto.getBetrag());
        }

        if (rechnungAuto != null) {
            Rechnungsposten rp = new Rechnungsposten(
                    lv.getLadeVorgangId(),
                    standort.getName(),
                    "LP-0001",
                    25.0,
                    30,
                    15.0
            );
            rechnungAuto.addRechnungsposten(rp);
        }

        Rechnung rechnung2 = new Rechnung(
                "R-MANUAL-2",
                konto.getKundennummer(),
                List.of("LV-OTHER"),
                40.0
        );
        rechnung2.addRechnungsposten(new Rechnungsposten(
                "LV-OTHER",
                "Anderer Standort",
                "LP-0003",
                30.0,
                45,
                40.0
        ));
        konto.getRechnungen().add(rechnung2);

        RechnungsManager rechnungsManager = new RechnungsManager();

        System.out.println("\nAlle Rechnungen des Kunden:");
        for (Rechnung r : rechnungsManager.getRechnungenFuerKunde(konto)) {
            System.out.println("  " + r.getRechnungsnummer()
                    + " | Datum=" + r.getErstelldatum()
                    + " | Betrag=" + r.getBetrag());
        }

        if (rechnungAuto != null) {
            System.out.println("\nDetails der automatisch erzeugten Rechnung:");
            Rechnung details = rechnungsManager.getRechnungDetails(konto, rechnungAuto.getRechnungsnummer());
            if (details != null) {
                System.out.println("Rechnung " + details.getRechnungsnummer()
                        + " für Kunde " + details.getKundennummer());
                for (Rechnungsposten p : details.getPosten()) {
                    System.out.println("  Posten: LV=" + p.getLadevorgangId()
                            + ", Standort=" + p.getStandortName()
                            + ", Ladepunkt=" + p.getLadepunktId()
                            + ", Preis=" + p.getPreis());
                }
            }
        }

        System.out.println("\nRechnungen gefiltert nach Standort '" + standort.getName() + "':");
        List<Rechnung> gefiltert = rechnungsManager.filterRechnungen(
                konto,
                LocalDate.now().minusDays(1),
                LocalDate.now().plusDays(1),
                standort.getName()
        );
        for (Rechnung r : gefiltert) {
            System.out.println("  Gefilterte Rechnung: " + r.getRechnungsnummer());
        }

        System.out.println("\n-- Aufladungen über KundeManager --");
        List<Aufladung> auflFromManager = kundeManager.getAufladungen(konto.getKundennummer());
        if (auflFromManager != null) {
            for (Aufladung a : auflFromManager) {
                System.out.println("  " + a.getZeitpunkt() + " -> " + a.getBetrag() + " EUR");
            }
        }

        System.out.println("\n=== DEMO ENDE ===");
    }
}
