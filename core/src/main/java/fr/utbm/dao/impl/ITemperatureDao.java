package fr.utbm.dao.impl;

import fr.utbm.core.entity.Temperature;

import java.util.List;

public interface ITemperatureDao
{
    public void persist(Temperature transientInstance);
    public void update(Temperature instance);
    public void delete(Temperature persistentInstance);
    public Temperature findById(java.lang.String id);
    public List<Temperature> getAll();
    public List<Temperature> getLastByStation();
}
