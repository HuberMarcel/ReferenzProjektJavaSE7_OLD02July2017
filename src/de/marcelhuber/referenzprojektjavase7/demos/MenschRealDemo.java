package de.marcelhuber.referenzprojektjavase7.demos;

import de.marcelhuber.referenzprojektjavase7.datensatzklasse.MenschDatenKonkret;
import de.marcelhuber.referenzprojektjavase7.model.MenschReal;
import java.util.Date;

/**
 *
 * @author Marcel Huber
 */
public class MenschRealDemo {

    public static void main(String[] args) {
        new MenschRealDemo().goDemo();
    }

    private void goDemo() {
//        MenschDatenKonkret marcelsDaten = null;
        MenschDatenKonkret marcelsDaten = new MenschDatenKonkret.Builder().build();
        marcelsDaten.setFamilienname("Huber");
        System.out.println(marcelsDaten);
//        MenschReal marcel = MenschReal.getInstance(null);
        MenschReal marcel = MenschReal.getInstance(marcelsDaten);
        System.out.println("Der Reale Mensch Marcel: " + marcel);
        // jetzt Mal gucken, wie das mit dem Builder funktioniert
        marcel = MenschReal.getInstance(new MenschDatenKonkret.Builder().build());
        System.out.println(marcel);
        // der Builder erzeugt mindestens ein MenschDatenKonkret-Objekt, auch, wenn es noch keine sinnvollen Werte hat
        marcelsDaten = new MenschDatenKonkret("Huber", "Huber", "Marcel", new Date(0));
        marcelsDaten.setSeparationsZeichen(" || ");
        System.out.println("Marcels Daten:           " + marcelsDaten);
        marcel = MenschReal.getInstance(marcelsDaten);
        System.out.println("Der Reale Mensch Marcel: " + marcel);
        MenschReal sascha = MenschReal.getInstance(marcelsDaten);
        System.out.println(sascha);
        // sascha hat dieSELBEN Menschdaten wie marcel!!
        MenschDatenKonkret saschasDaten = (MenschDatenKonkret) (marcelsDaten.clone());
        System.out.println(saschasDaten);
        saschasDaten.setVorname("Sascha");
        System.out.println(saschasDaten);
        System.out.println(marcelsDaten);
    }
}
