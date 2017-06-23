package de.marcelhuber.referenzprojektjavase7.datensatzklasse;

import java.util.Date;

/**
 *
 * @author Marcel Huber
 */
public class MenschDatenKonkret extends MenschDatenAbstrakt implements Cloneable {

    // Initialsierungsblock
    private String separationsZeichen;

    {
        separationsZeichen = "| ";
    }

    public String getSeparationsZeichen() {
        return separationsZeichen;
    }

    public void setSeparationsZeichen(String separationsZeichen) {
        this.separationsZeichen = separationsZeichen;
    }

    // diese Klasse dient dazu, einen MenschBuilder zu implementieren
    static public class Builder {

        // Wir benötigen die gleichen Attribute wie in der MenschDatenAbstrakt-Klasse
        private String geburtsname;
        private String familienname;
        private String vorname;
        private String zweitname;
        private Date geburtsDatum;

        public Builder geburtsname(String geburtsname) {
            this.geburtsname = geburtsname;
            return this;
        }

        public Builder familienname(String familienname) {
            this.familienname = familienname;
            return this;
        }

        public Builder vorname(String vorname) {
            this.vorname = vorname;
            return this;
        }

        public Builder zweitname(String zweitname) {
            this.zweitname = zweitname;
            return this;
        }

        public Builder geburtsDatum(Date geburtsDatum) {
            this.geburtsDatum = geburtsDatum;
            return this;
        }

        public MenschDatenKonkret build() {
            return new MenschDatenKonkret(this);
        }

    }

    // der Konstruktor für den Builder!
    private MenschDatenKonkret(Builder build) {
//        System.out.println("Ist build == null? " + (build == null));
        this.setGeburtsname(build.geburtsname);
        this.setFamilienname(build.familienname);
        this.setVorname(build.vorname);
        this.setZweitname(build.zweitname);
        this.setGeburtsDatum(build.geburtsDatum);
    }

    // alternativ kann man auch einen vollständigen Konstruktor verwenden
    // nur mit allen Pflichtfeldern
    public MenschDatenKonkret(String geburtsname, String familienname, String vorname,
            Date geburtsDatum) {
        this.setGeburtsname(geburtsname);
        this.setFamilienname(familienname);
        this.setVorname(vorname);
        this.setGeburtsDatum(geburtsDatum);
    }

    public MenschDatenKonkret(String geburtsname, String familienname, String vorname, String zweitname,
            Date geburtsDatum) {
        this(geburtsname, familienname, vorname, geburtsDatum);
        this.setZweitname(zweitname);
    }

//    // Standardkonstruktor
//    public MenschDatenKonkret() {
//    }
    @Override
    public String toString() {
        String returnString
                = "Vorname: " + this.getVorname() + separationsZeichen;
        if (this.getZweitname() != null && this.getZweitname().length() > 0) {
            returnString += "Zweitname: " + this.getZweitname() + separationsZeichen;
        }
        returnString += "Familienname: " + this.getFamilienname() + separationsZeichen
                + "Geburtsname: " + this.getGeburtsname();
        return returnString;
    }

    /**
     *
     * @return @throws CloneNotSupportedException
     */
    @Override
    public Object clone() {
        Object returnObject = null;
        try {
            returnObject = super.clone();
        } catch (CloneNotSupportedException cnsex) {
            System.out.println("Exception: " + cnsex);
        }
        return returnObject;
    }
}
