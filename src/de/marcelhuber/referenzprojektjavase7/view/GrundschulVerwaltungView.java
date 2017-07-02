package de.marcelhuber.referenzprojektjavase7.view;

import de.marcelhuber.referenzprojektjavase7.controller.*;
import java.util.*;

/**
 *
 * @author Marcel Huber
 */
public interface GrundschulVerwaltungView {
    void setController(GrundschulVerwaltungController controller);
    void showView();
    void reset();     
    // geburtsname
    String getGeburtsname();
    boolean setGeburtsname(String geburtsname);
    // familienname
    String getFamilienname();                               
    boolean setFamilienname(String familienname);                               
    // vorname
    String getVorname();
    boolean setVorname(String vorname);
    // zweitname
    String getZweitname();
    boolean setZweitname(String zweitname);
    // geburtsdatum
    Calendar getGeburtsdatum();                               
    boolean setGeburtsdatum(Calendar geburtsdatum);                               
}