package fr.utbm.core.service;

import fr.utbm.core.entity.Temperature;
import fr.utbm.core.model.Wendu;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface IServiceListeTemperatures
{
    ArrayList<Wendu> getLastTemperatures();
    ArrayList<Wendu> getTemperatures(int idStation);
    ArrayList<Wendu> getFilteredTemperatures(Date debut, Date fin, int idStation);
}
