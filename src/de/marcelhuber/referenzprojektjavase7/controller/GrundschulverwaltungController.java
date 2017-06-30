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

    // MVC mit main()-Klasse als Starter (im OCP-Bsp.)
    public GrundschulverwaltungController(GrundschulVerwaltungGesamtModel gsVgModel, 
            GrundschulVerwaltungView gsVView) {
        this.gsVgModel = gsVgModel;
        gsVgModel.addObserver(this);
        this.gsVView = this.gsVView;
        gsVView.setController(this);
    }
    // Bei anzeigewürdigen neuen Daten --> Model entscheidet
    public void update(Observable o, Object arg) {
        // showView in Controler, nicht in der upate()
        // controller showView delegiert Aufruf an die View
        // gui set Visible true
        gsVView.showView();
    }
}
