package fr.utbm.core.service;

import fr.utbm.core.entity.Temperature;
import java.util.Date;
import java.util.List;

public interface IServiceListeTemperatures
{
    List<Temperature> getLastTemperatures();
    List<Temperature> getTemperatures();
    List<Temperature> getLastFilteredTemperatures(Date debut, Date fin, int idStation);
    List<Temperature> getFilteredTemperatures(Date debut, Date fin, int idStation);
}
