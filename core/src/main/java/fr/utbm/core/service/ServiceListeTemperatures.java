package fr.utbm.core.service;

import fr.utbm.core.entity.Sensor;
import fr.utbm.core.entity.Station;
import fr.utbm.core.entity.Temperature;
import fr.utbm.core.model.Wendu;
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
    private Wendu temp;

    @Transactional
    public ArrayList<Wendu> getLastTemperatures()
    {
        ArrayList<Wendu> lstOut = new ArrayList<Wendu>();
        List<Object[]> lstTemperatures = dao.getLastByStation();
        for (Object[] tab : lstTemperatures)
        {
            Temperature t = (Temperature)tab[0];
            Sensor se = (Sensor)tab[1];
            Station st = (Station)tab[2];
            Wendu item = new Wendu(t.getId(),t.getValue(),t.getDate(),se.getId(),se.getLabel(),st.getId(),st.getLabel(),st.getArea().getId(),st.getArea().getLabel(),st.getArea().getRoad());
            lstOut.add(item);
        }

        return lstOut;
    }

    @Transactional
    public ArrayList<Wendu> getTemperatures(int idStation)
    {
        ArrayList<Wendu> lstOut = new ArrayList<Wendu>();
        List<Object[]> lstTemperatures = dao.getAllForStation(idStation);
        for (Object[] tab : lstTemperatures)
        {
            Temperature t = (Temperature)tab[0];
            Sensor se = (Sensor)tab[1];
            Station st = (Station)tab[2];
            Wendu item = new Wendu(t.getId(),t.getValue(),t.getDate(),se.getId(),se.getLabel(),st.getId(),st.getLabel(),st.getArea().getId(),st.getArea().getLabel(),st.getArea().getRoad());
            lstOut.add(item);
        }
        return lstOut;
    }

    @Transactional
    public ArrayList<Wendu> getFilteredTemperatures(Date debut, Date fin, int idStation)
    {
        ArrayList<Wendu> lstOut = new ArrayList<Wendu>();
        List<Object[]> lstTemperatures = dao.getLastFilteredTemperaturesForStation(debut,fin,idStation);
        for (Object[] tab : lstTemperatures)
        {
            Temperature t = (Temperature)tab[0];
            Sensor se = (Sensor)tab[1];
            Station st = (Station)tab[2];
            Wendu item = new Wendu(t.getId(),t.getValue(),t.getDate(),se.getId(),se.getLabel(),st.getId(),st.getLabel(),st.getArea().getId(),st.getArea().getLabel(),st.getArea().getRoad());
            lstOut.add(item);
        }
        return lstOut;
    }
}
