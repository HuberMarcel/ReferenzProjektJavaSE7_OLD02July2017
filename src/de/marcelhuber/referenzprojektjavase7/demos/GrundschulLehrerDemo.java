package de.marcelhuber.referenzprojektjavase7.demos;

import de.marcelhuber.referenzprojektjavase7.model.Adresse;
import de.marcelhuber.referenzprojektjavase7.model.GrundschulLehrer;
import de.marcelhuber.referenzprojektjavase7.model.MenschRealDaten;
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
        marcel.setUnterrichtsFaecher(new String[]{"Mathematik", "Informatik", "Lifehacks"});
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
        oma.setUnterrichtsFaecher(new String[]{"Häkeln", "Lifehacks"});
        oma.getMenschDaten().setVorname("Kath.");
        System.out.println("Oma als Grundschullehrerin und ihre Fächer:\n" + oma);
        System.out.println("Omas Daten jetzt als MenschDaten mit geändertem Separationszeichen:");
        omasDaten.setSeparationsZeichen("..... ");
        System.out.println(omasDaten);        
    }
}
