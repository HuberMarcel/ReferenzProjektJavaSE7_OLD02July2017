package de.marcelhuber.referenzprojektjavase7.controller;

import de.marcelhuber.referenzprojektjavase7.model.*;
import de.marcelhuber.referenzprojektjavase7.view.*;
import java.util.*;

/**
 *
 * @author Marcel Huber
 */
public class GrundschulverwaltungController implements Observer {

    private GrundschulVerwaltungGesamtModel gsVgModel;
    private GrundschulVerwaltungView gsVView;

    public GrundschulverwaltungController(GrundschulVerwaltungGesamtModel gsVgModel, GrundschulVerwaltungView gsVView) {
        this.gsVgModel = gsVgModel;
        gsVgModel.addObserver(this);
        this.gsVView = this.gsVView;
        gsVView.setController(this);
    }

    public void update(Observable o, Object arg) {
        gsVView.showView();
    }
}
