package de.marcelhuber.referenzprojektjavase7.model;

import de.marcelhuber.systemtools.Marker;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author Marcel Huber
 */
public class GrundschulLehrer {

    private String separationsZeichen;

    {
        separationsZeichen = "; ";
    }

    public GrundschulLehrer() {
        this(new MenschRealDaten.Builder().build());
    }

    public GrundschulLehrer(MenschRealDaten menschDaten) {
        this.menschDaten = menschDaten;
    }

    private String[] unterrichtsFaecher;
    private MenschRealDaten menschDaten;

    public static void main(String[] args) {
        new GrundschulLehrer().go();
    }

    private void go() {
//        auskommentiert, siehe entsprechende Demo-Klasse
////        GrundschulLehrer marcel = new GrundschulLehrer();
////        marcel.getMenschDaten().setVorname("Marcel");
////        System.out.println(marcel);
////        marcel.getMenschDaten().setFamilienname("Huber");
////        marcel.getMenschDaten().setGeburtsname("Huber");
////        marcel.setUnterrichtsFaecher(new String[]{"Mathematik", "Informatik", "Lifehacks"});
////        System.out.println(marcel);
////        //
////        markiereNeuenAbschnitt();
////        System.out.println("Neuer Mensch!!".toUpperCase());
////        MenschRealDaten saschasDaten = new MenschRealDaten("Huber", "Huber", "Sascha",
////                new Date(), new Adresse("Strasse XY", 0, "54XXX", "TR"));
////        System.out.println("Mensch Sascha:           " + saschasDaten);
////        Marker.marker();
////        System.out.println("");
////        GrundschulLehrer sascha = new GrundschulLehrer(saschasDaten);
////        System.out.println("Grundschullehrer Sascha: " + sascha);
////        saschasDaten.setFamilienname("Huber der 2.");
////        System.out.println("Grundschullehrer Sascha: " + sascha);
////        //
////        markiereNeuenAbschnitt();
////        MenschRealDaten marcelsDaten = marcel.getMenschDaten();
////        marcelsDaten.setSeparationsZeichen("||| ---");
////        System.out.println(marcel);
////        marcel.setSeparationsZeichen("XXXX");
////        System.out.println(marcel);
////        //
////        System.out.println("");
////        MenschRealDaten pascalsDaten = new MenschRealDaten("Huber", "Huber", "Pascal", new Date(), null);
////        System.out.println(pascalsDaten);
////        // 
////        markiereNeuenAbschnitt();
////        MenschRealDaten mamasDaten = new MenschRealDaten("Huber", "Herrig", "G.", "S.", new Date(), null);
////        System.out.println(mamasDaten);
////        //
////        markiereNeuenAbschnitt();
////        MenschRealDaten papasDaten = new MenschRealDaten();
////        papasDaten.setFamilienname("Huber");
////        papasDaten.setZweitname("Matthias");
////        System.out.println(papasDaten);
////        // 
////        markiereNeuenAbschnitt();
////        MenschRealDaten omasDaten = new MenschRealDaten.Builder()
////                .geburtsname("HabeIchGeradeVergessen").build();
////        System.out.println(omasDaten);
////        GrundschulLehrer oma = new GrundschulLehrer();
////        oma.setMenschDaten(omasDaten);
////        System.out.println("Oma als Grundschullehrerin:\n" + oma);
////        oma.setUnterrichtsFaecher(new String[]{"Häkeln", "Lifehacks"});
////        oma.getMenschDaten().setVorname("Kath.");
////        System.out.println("Oma als Grundschullehrerin und ihre Fächer:\n" + oma);
////        System.out.println("Omas Daten jetzt als MenschDaten mit geändertem Separationszeichen:");
////        omasDaten.setSeparationsZeichen("..... ");
////        System.out.println(omasDaten);
    }

    public String getSeparationsZeichen() {
        return separationsZeichen;
    }

    public void setSeparationsZeichen(String separationsZeichen) {
        this.separationsZeichen = separationsZeichen;
    }

    public String[] getUnterrichtsFaecher() {
        return unterrichtsFaecher;
    }

    public void setUnterrichtsFaecher(String[] unterrichtsFaecher) {
        this.unterrichtsFaecher = unterrichtsFaecher;
    }

    public MenschRealDaten getMenschDaten() {
        return menschDaten;
    }

    public void setMenschDaten(MenschRealDaten menschDaten) {
        this.menschDaten = menschDaten;
    }

    public String toString() {
        String returnString = menschDaten.toString()
                + "\n"
                + separationsZeichen
                + "\n"
                + "Unterrichtsfächer: " + Arrays.toString(unterrichtsFaecher)
                + "";
        return returnString;
    }

    // alles Folgende ist nur hilfreich für die zugehörige Demo-Klasse
    // die direkt folgende Methode existiert nur wegen dem, was hier in der Main-Methode stand
    private void markiereNeuenAbschnitt() {
        Marker.marker();
        Marker.marker();
        Marker.marker();
        Marker.marker();
        System.out.println("");
        System.out.println("");
    }

    // alles Folgende ist nur hilfreich für die zugehörige Demo-Klasse
    static private GrundschulLehrer dummy;
    static private int counter = 0;

    static public void nutzeMarkiereNeuenAbschnitt() {
        if (dummy == null) {
            dummy = new GrundschulLehrer();
            dummy.getMenschDaten().setFamilienname("GS Hilfsobjekt Nr.: " 
                    + (++counter));
        }
        System.out.println("Ich bin ein Dummy-Objekt: "+ dummy.getMenschDaten().getFamilienname());
        dummy.markiereNeuenAbschnitt();
    }
}
