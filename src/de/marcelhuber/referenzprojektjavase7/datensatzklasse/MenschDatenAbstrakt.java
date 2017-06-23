package de.marcelhuber.referenzprojektjavase7.datensatzklasse;

import java.util.Date;

/**
 *
 * @author Marcel Huber
 */
public abstract class MenschDatenAbstrakt {

    private String geburtsname;         // Pflichtfeld
    private String familienname;        // Pflichtfeld
    private String vorname;             // Pflichtfeld
    private String zweitname;
    private Date geburtsDatum;          // Pflichtfeld

    public String getGeburtsname() {
        return geburtsname;
    }

    public void setGeburtsname(String geburtsname) {
        this.geburtsname = geburtsname;
    }

    public String getFamilienname() {
        return familienname;
    }

    public void setFamilienname(String familienname) {
        this.familienname = familienname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getZweitname() {
        return zweitname;
    }

    public void setZweitname(String zweitname) {
        this.zweitname = zweitname;
    }

    public Date getGeburtsDatum() {
        return geburtsDatum;
    }

    public void setGeburtsDatum(Date geburtsDatum) {
        this.geburtsDatum = geburtsDatum;
    }
}
