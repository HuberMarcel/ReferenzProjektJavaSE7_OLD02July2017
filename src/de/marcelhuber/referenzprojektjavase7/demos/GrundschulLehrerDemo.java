package de.marcelhuber.referenzprojektjavase7.demos;

import de.marcelhuber.referenzprojektjavase7.datensatzklasse.MenschDatenKonkret;
import de.marcelhuber.referenzprojektjavase7.model.GrundschulLehrer;
import de.marcelhuber.referenzprojektjavase7.model.MenschReal;
import de.marcelhuber.systemtools.Pause;
import java.util.Date;

/**
 *
 * @author Marcel Huber
 */
public class GrundschulLehrerDemo {

    public static void main(String[] args) {
        new GrundschulLehrerDemo().goDemo();
    }

    private void goDemo() {
        MenschDatenKonkret marcelsDaten = new MenschDatenKonkret("Huber", "", "Marcel", new Date());
        System.out.println(marcelsDaten);
        MenschReal marcel = MenschReal.getInstance(marcelsDaten);
        System.out.println(marcel);
        marcel.getMenschDaten().setZweitname("B.");
        System.out.println(marcel);
        marcelsDaten.setFamilienname("Huber".toUpperCase());
        System.out.println(marcel);
        GrundschulLehrer marcelAlsGrundschullehrer = GrundschulLehrer.getInstance(marcel);
        System.out.println(marcelAlsGrundschullehrer);
        marcelAlsGrundschullehrer.setSeparationsZeichen(" --- ");
        System.out.println(marcelAlsGrundschullehrer);
        marcelAlsGrundschullehrer.addUnterrichtsFach("Mathematik");
        System.out.println("Der GS (Grundschullehrer) Marcel mit seinem Unterrichtsfach: ");
        System.out.println(marcelAlsGrundschullehrer);
        MenschDatenKonkret saschasDaten = (MenschDatenKonkret) (marcelsDaten.clone());
        saschasDaten.setVorname("Sascha");
        MenschReal sascha = MenschReal.getInstance(saschasDaten);
        System.out.println(sascha);
        GrundschulLehrer saschaAlsGrundschullehrer = GrundschulLehrer.getInstance(sascha);
        saschaAlsGrundschullehrer.addUnterrichtsFaecher(new String[]{"Sport", "Philosophie"});
        System.out.println(saschaAlsGrundschullehrer);
        GrundschulLehrer.nutzeMarkiereNeuenAbschnitt();
        saschaAlsGrundschullehrer.removeUnterrichtsFaecher(new String[]{"Philosophie", "Sport"});
        System.out.println(saschaAlsGrundschullehrer);
        GrundschulLehrer.nutzeMarkiereNeuenAbschnitt();
//        // die folgenden 3 Zeilen sind auskommentiert, wurden wegen der Exc. getestet
//        MenschReal oma = null;
//        Pause.breakInSeconds(3);
//        GrundschulLehrer omaAlsGrundschullehrer = GrundschulLehrer.getInstance(oma);
        MenschReal oma = MenschReal.getInstance(new MenschDatenKonkret.Builder().build());
        GrundschulLehrer omaAlsGrundschullehrer = GrundschulLehrer.getInstance(oma);
        omaAlsGrundschullehrer.addUnterrichtsFaecher(new String[]{"Häkeln", "Lifehacks"});
        System.out.println(omaAlsGrundschullehrer);
        MenschDatenKonkret omasDaten = omaAlsGrundschullehrer.getMenschDaten();
        omasDaten.setVorname("Kath.");
        omasDaten.setFamilienname("Huber");
        omasDaten.setGeburtsname("HabeIchGeradeVergessen");
        System.out.println(omaAlsGrundschullehrer);
        System.out.println(omasDaten);
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println(oma);
    }
}
