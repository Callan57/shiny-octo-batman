package fr.utbm.dao.impl;

import fr.utbm.core.entity.Temperature;

import java.util.Date;
import java.util.List;

public interface ITemperatureDao
{
    public void persist(Temperature transientInstance);
    public void update(Temperature instance);
    public void delete(Temperature persistentInstance);
    public Temperature findById(int id);
    public List<Temperature> getAll();
    public List<Temperature> getLastByStation();
    public List<Temperature> getAllForStation(int idStation);
    public List<Temperature> getLastFilteredTemperaturesByStation(Date debut,Date fin);
    public List<Temperature> getLastFilteredTemperaturesForStation(Date debut,Date fin, int idStation);
};
