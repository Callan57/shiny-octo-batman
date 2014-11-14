package fr.utbm.core.service;

import fr.utbm.core.entity.Temperature;
import fr.utbm.dao.impl.ITemperatureDao;
import fr.utbm.dao.impl.TemperatureDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ServiceListeTemperatures implements IServiceListeTemperatures
{
    @Autowired
    private ITemperatureDao dao;

    @Transactional
    public List<Temperature> getLastTemperatures()
    {
        List<Temperature> lstTemperatures;
        lstTemperatures = dao.getLastByStation();
        return lstTemperatures;
    }

    @Transactional
    public List<Temperature> getTemperatures()
    {
        List<Temperature> lstTemperatures = null;

        return lstTemperatures;
    }

    @Transactional
    public List<Temperature> getLastFilteredTemperatures(Date debut, Date fin, int idStation)
    {
        List<Temperature> lstTemperatures = null;

        return lstTemperatures;
    }

    @Transactional
    public List<Temperature> getFilteredTemperatures(Date debut, Date fin, int idStation)
    {
        List<Temperature> lstTemperatures = null;

        return lstTemperatures;
    }
}
