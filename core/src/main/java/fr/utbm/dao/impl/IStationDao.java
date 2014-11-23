package fr.utbm.dao.impl;

import fr.utbm.core.entity.Station;

import java.util.List;

/**
 * Created by Yohann on 23/11/2014.
 */
public interface IStationDao {

    public void persist(Station transientInstance);
    public void update(Station instance);
    public void delete(Station persistentInstance);
    public Station findById(int id);
    public List<Station> getAll();

}
