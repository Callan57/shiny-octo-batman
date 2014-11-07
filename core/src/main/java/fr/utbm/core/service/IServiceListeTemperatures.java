package fr.utbm.core.service;

import fr.utbm.core.entity.Temperature;

import java.util.ArrayList;
import java.util.Date;

public interface IServiceListeTemperatures
{
    ArrayList<Temperature> getLastTemperatures();
    ArrayList<Temperature> getTemperatures();
    ArrayList<Temperature> getLastFilteredTemperatures(Date debut, Date fin, int idStation);
    ArrayList<Temperature> getFilteredTemperatures(Date debut, Date fin, int idStation);
}
