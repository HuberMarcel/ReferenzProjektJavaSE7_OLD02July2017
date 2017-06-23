package de.marcelhuber.referenzprojektjavase7.datensatzklasse;

import de.marcelhuber.referenzprojektjavase7.datensatzklasse.MenschAbstraktDaten;
import de.marcelhuber.referenzprojektjavase7.datensatzklasse.MenschAbstraktDaten;
import de.marcelhuber.referenzprojektjavase7.model.Adresse;
import de.marcelhuber.referenzprojektjavase7.model.Adresse;
import java.util.Date;

/**
 *
 * @author Marcel Huber
 */
public class MenschRealDaten extends MenschAbstraktDaten {

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

        // Wir benötigen die gleichen Attribute wie in der MenschAbstraktDaten-Klasse
        private String geburtsname;
        private String familienname;
        private String vorname;
        private String zweitname;
        private Date geburtsDatum;
        private Adresse adresse;

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

        public Builder adresse(Adresse adresse) {
            this.adresse = adresse;
            return this;
        }

        public MenschRealDaten build() {
            return new MenschRealDaten(this);
        }

    }

    // der Konstruktor für den Builder!
    private MenschRealDaten(Builder build) {
        this.setGeburtsname(build.geburtsname);
        this.setFamilienname(build.familienname);
        this.setVorname(build.vorname);
        this.setZweitname(build.zweitname);
        this.setGeburtsDatum(build.geburtsDatum);
        this.setAdresse(build.adresse);
    }

    // alternativ kann man auch einen vollständigen Konstruktor verwenden
    // nur mit allen Pflichtfeldern
    public MenschRealDaten(String geburtsname, String familienname, String vorname,
            Date geburtsDatum, Adresse adresse) {
        this.setGeburtsname(geburtsname);
        this.setFamilienname(familienname);
        this.setVorname(vorname);
        this.setGeburtsDatum(geburtsDatum);
        this.setAdresse(adresse);
    }

    public MenschRealDaten(String geburtsname, String familienname, String vorname, String zweitname,
            Date geburtsDatum, Adresse adresse) {
        this(geburtsname, familienname, vorname, geburtsDatum, adresse);
        this.setZweitname(zweitname);
    }

    // Standardkonstruktor
    public MenschRealDaten() {
    }

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
}
