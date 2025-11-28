import FillingStationNetwork.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Ladepunkt> ladepunkte = new ArrayList<Ladepunkt>();
        ladepunkte.add(new Ladepunkt("LP-0001", Ladepunkt.ChargingMode.AC, Ladepunkt.ChargingPointStatus.FREE));
        ladepunkte.add(new Ladepunkt("LP-0002", Ladepunkt.ChargingMode.DC, Ladepunkt.ChargingPointStatus.OUT_OF_ORDER));

        Standort standort = new Standort("SID-0001", "Standort Musterstrasse", "Musterstrasse 1, 1010 Wien", ladepunkte, "Toller Standort");
        Kunde neuerKunde = new Kunde("Max", "Muster", "max@muster.com");
        System.out.println("Kundennummer: " + neuerKunde.getKundennummer()); //Kundennummer

        //Admin
        Admin admin = new Admin("admin", "admin123");
        // Test für erfolgreiches Login
        if (admin.login("admin", "admin123")) {
            System.out.println("Admin-Login erfolgreich");
        } else {
            System.out.println("Admin-Login fehlgeschlagen") ;
        }
    }
}
