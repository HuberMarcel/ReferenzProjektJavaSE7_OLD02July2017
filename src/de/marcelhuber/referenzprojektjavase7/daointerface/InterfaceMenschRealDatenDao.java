package de.marcelhuber.referenzprojektjavase7.daointerface;

import de.marcelhuber.referenzprojektjavase7.model.MenschReal;
import java.util.Collection;

/**
 *
 * @author Marcel Huber
 */
public interface InterfaceMenschRealDatenDao {

    Collection<MenschReal> findAllMenschRealDaten();

    MenschReal findMenschRealDatenById(int uid);

    void create(MenschReal mrD);

    void delete(MenschReal mrD);

    void update(MenschReal mrD);
}
