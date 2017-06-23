package de.marcelhuber.referenzprojektjavase7.daointerface;

import de.marcelhuber.referenzprojektjavase7.datensatzklasse.MenschRealDaten;
import java.util.Collection;

/**
 *
 * @author Marcel Huber
 */
public interface InterfaceMenschRealDatenDao {

    Collection<MenschRealDaten> findAllMenschRealDaten();

    MenschRealDaten findMenschRealDatenById(int uid);

    void create(MenschRealDaten mrD);

    void delete(MenschRealDaten mrD);

    void update(MenschRealDaten mrD);
}
