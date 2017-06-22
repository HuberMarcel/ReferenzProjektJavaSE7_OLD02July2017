package de.marcelhuber.referenzprojektjavase7.controller;

import de.marcelhuber.referenzprojektjavase7.model.MenschRealDaten;
import java.util.Collection;

/**
 *
 * @author Marcel Huber
 */
public interface MenschRealDatenDao {

    Collection<MenschRealDaten> findAllMenschRealDaten();

    MenschRealDaten findMenschRealDatenById(int uid);

    void create(MenschRealDaten mrD);

    void delete(MenschRealDaten mrD);

    void update(MenschRealDaten mrD);
}
