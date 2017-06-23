package de.marcelhuber.referenzprojektjavase7.demos;

import de.marcelhuber.referenzprojektjavase7.model.Adresse;
import de.marcelhuber.referenzprojektjavase7.model.GrundschulLehrer;
import de.marcelhuber.referenzprojektjavase7.datensatzklasse.MenschRealDaten;
import de.marcelhuber.systemtools.Marker;
import java.util.Date;

/**
 *
 * @author Marcel Huber
 */
public class GrundschulLehrerDemo {

    public static void main(String[] args) {
        new GrundschulLehrerDemo().go();
    }

    private void go() {
        GrundschulLehrer marcel = new GrundschulLehrer();
        marcel.getMenschDaten().setVorname("Marcel");
        System.out.println(marcel);
        marcel.getMenschDaten().setFamilienname("Huber");
        marcel.getMenschDaten().setGeburtsname("Huber");
        marcel.addUnterrichtsFaecher(new String[]{"Mathematik", "Informatik", "Lifehacks"});
        System.out.println(marcel);
        //
        GrundschulLehrer.nutzeMarkiereNeuenAbschnitt();
        System.out.println("Neuer Mensch!!".toUpperCase());
        MenschRealDaten saschasDaten = new MenschRealDaten("Huber", "Huber", "Sascha",
                new Date(), new Adresse("Strasse XY", 0, "54XXX", "TR"));
        System.out.println("Mensch Sascha:           " + saschasDaten);
        Marker.marker();
        System.out.println("");
        GrundschulLehrer sascha = new GrundschulLehrer(saschasDaten);
        System.out.println("Grundschullehrer Sascha: " + sascha);
        saschasDaten.setFamilienname("Huber der 2.");
        System.out.println("Grundschullehrer Sascha: " + sascha);
        //
        GrundschulLehrer.nutzeMarkiereNeuenAbschnitt();
        MenschRealDaten marcelsDaten = marcel.getMenschDaten();
        marcelsDaten.setSeparationsZeichen("||| ---");
        System.out.println(marcel);
        marcel.setSeparationsZeichen("XXXX");
        System.out.println(marcel);
        //
        System.out.println("");
        MenschRealDaten pascalsDaten = new MenschRealDaten("Huber", "Huber", "Pascal", new Date(), null);
        System.out.println(pascalsDaten);
        // 
        GrundschulLehrer.nutzeMarkiereNeuenAbschnitt();
        MenschRealDaten mamasDaten = new MenschRealDaten("Huber", "Herrig", "G.", "S.", new Date(), null);
        System.out.println(mamasDaten);
        //
        GrundschulLehrer.nutzeMarkiereNeuenAbschnitt();
        MenschRealDaten papasDaten = new MenschRealDaten();
        papasDaten.setFamilienname("Huber");
        papasDaten.setZweitname("Matthias");
        System.out.println(papasDaten);
        // 
        GrundschulLehrer.nutzeMarkiereNeuenAbschnitt();
        MenschRealDaten omasDaten = new MenschRealDaten.Builder()
                .geburtsname("HabeIchGeradeVergessen").build();
        System.out.println(omasDaten);
        GrundschulLehrer oma = new GrundschulLehrer();
        oma.setMenschDaten(omasDaten);
        System.out.println("Oma als Grundschullehrerin:\n" + oma);
        oma.addUnterrichtsFaecher(new String[]{"Häkeln", "Lifehacks"});
        oma.getMenschDaten().setVorname("Kath.");
        System.out.println("Oma als Grundschullehrerin und ihre Fächer:\n" + oma);
        System.out.println("Omas Daten jetzt als MenschDaten mit geändertem Separationszeichen:");
        omasDaten.setSeparationsZeichen("..... ");
        System.out.println(omasDaten);
        MenschRealDaten opasDaten = new MenschRealDaten.Builder()
                .zweitname("Frans")
                .vorname("Nikolaus")
                .build();
        System.out.println("Opas Daten: ");
        System.out.println(opasDaten);
        GrundschulLehrer opa = new GrundschulLehrer(opasDaten);
        opa.getMenschDaten().setZweitname("Franz");
        opa.getMenschDaten().setFamilienname("Huber");
        opa.addUnterrichtsFaecher(new String[]{"Mechanik", "Handwerk"});
        opa.addUnterrichtsFach("Fernsehen");
        opa.removeUnterrichtsFaecher(new String[]{"Fernsehen", "Handwerk"});
        System.out.println("Opa als Grundschullehrer mit seinen Fächern: ");
        System.out.println(opa);
        opa.changeUnterrichtsFaecher("Mechanik", "Mechatronik");
        System.out.println(opa);
        opasDaten = new MenschRealDaten.Builder().build();
        opa = new GrundschulLehrer(opasDaten);
        opa.addUnterrichtsFach("Abstraktes Denken");
        System.out.println(opa);
        System.out.println("Opas Unterrichtsfächer: "
                + opa.getUnterrichtsFaecher());
        System.out.println("Jetzt leeren wir seine Liste von Unterrichtsfächern...");
        opa.clearAllUnterrichtsFaecher();
        System.out.println("Opas Unterrichtsfächer: "
                + opa.getUnterrichtsFaecher());
        System.out.println(opa);
        System.out.println("Ende".toUpperCase());
    }
}
