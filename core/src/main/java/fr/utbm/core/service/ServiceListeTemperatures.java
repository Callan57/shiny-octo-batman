package fr.utbm.core.service;

import fr.utbm.core.entity.Temperature;
import fr.utbm.dao.impl.ITemperatureDao;
import fr.utbm.dao.impl.TemperatureDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;

public class ServiceListeTemperatures implements IServiceListeTemperatures
{
    @Autowired
    private ITemperatureDao dao;

    @Transactional
    public ArrayList<Temperature> getLastTemperatures()
    {
        ArrayList<Temperature> lstTemperatures = new ArrayList<Temperature>();

        return lstTemperatures;
    }

    @Transactional
    public ArrayList<Temperature> getTemperatures()
    {
        ArrayList<Temperature> lstTemperatures = new ArrayList<Temperature>();

        return lstTemperatures;
    }

    @Transactional
    public ArrayList<Temperature> getLastFilteredTemperatures(Date debut, Date fin, int idStation)
    {
        ArrayList<Temperature> lstTemperatures = new ArrayList<Temperature>();

        return lstTemperatures;
    }

    @Transactional
    public ArrayList<Temperature> getFilteredTemperatures(Date debut, Date fin, int idStation)
    {
        ArrayList<Temperature> lstTemperatures = new ArrayList<Temperature>();

        return lstTemperatures;
    }
}
