package fr.utbm.core.service;

import fr.utbm.core.entity.Sensor;
import fr.utbm.core.entity.Station;
import fr.utbm.core.entity.Temperature;
import fr.utbm.core.model.Wendu;
import fr.utbm.dao.impl.ITemperatureDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Julien on 21/11/14.
 * Classe service gérant les listes de températures
 */

@Service
public class ServiceListeTemperatures implements IServiceListeTemperatures
{
    @Autowired
    private ITemperatureDao dao;//Appel à la DAO Température
    private Wendu temp;//Modèle contenant la liste des températures

    //------------------------------------------------------------------------
    //Demande au DAO Température
    //id : identifaint de la station
    //retoune les dernières températures des staions
    //------------------------------------------------------------------------
    @Transactional
    public ArrayList<Wendu> getLastTemperatures()
    {
        //initialisation de la liste du modèle de températures
        ArrayList<Wendu> lstOut = new ArrayList<Wendu>();
        //demande au DAO des dernières températures de chaques staions
        List<Object[]> lstTemperatures = dao.getLastByStation();
        //pour chaques température
        for (Object[] tab : lstTemperatures)
        {
            Temperature t = (Temperature)tab[0];//récupération de l'object température
            Sensor se = (Sensor)tab[1];//récupération de l'object sonde
            Station st = (Station)tab[2];//récupération de l'object station
            //construction d'un item de la liste du modéle de températures
            Wendu item = new Wendu(t.getId(),t.getValue(),t.getDate(),se.getId(),se.getLabel(),st.getId(),st.getLabel(),st.getArea().getId(),st.getArea().getLabel(),st.getArea().getRoad());
            //ajout de l'item à la liste
            lstOut.add(item);
        }

        return lstOut;
    }

    //------------------------------------------------------------------------
    //Demande au DAO Température
    //id : identifaint de la station
    //retoune les dernières températures d'une staion
    //------------------------------------------------------------------------
    @Transactional
    public ArrayList<Wendu> getTemperatures(int idStation)
    {
        //initialisation de la liste du modèle de températures
        ArrayList<Wendu> lstOut = new ArrayList<Wendu>();
        //demande au DAO des températures d'un station donnée
        List<Object[]> lstTemperatures = dao.getAllForStation(idStation);
        //pour chaques température
        for (Object[] tab : lstTemperatures)
        {
            Temperature t = (Temperature)tab[0];//récupération de l'object température
            Sensor se = (Sensor)tab[1];//récupération de l'object sonde
            Station st = (Station)tab[2];//récupération de l'object station
            //construction d'un item de la liste du modéle de températures
            Wendu item = new Wendu(t.getId(),t.getValue(),t.getDate(),se.getId(),se.getLabel(),st.getId(),st.getLabel(),st.getArea().getId(),st.getArea().getLabel(),st.getArea().getRoad());
            //ajout de l'item à la liste
            lstOut.add(item);
        }
        return lstOut;
    }

    //------------------------------------------------------------------------
    //Demande au DAO Température
    //id : identifaint de la station
    //debut : date de début de la période
    //fin : date de fin de la période
    //retoune les dernières températures d'une staion en fonction d'une période
    //------------------------------------------------------------------------
    @Transactional
    public ArrayList<Wendu> getFilteredTemperatures(Date debut, Date fin, int idStation)
    {
        //initialisation de la liste du modèle de températures
        ArrayList<Wendu> lstOut = new ArrayList<Wendu>();
        //demande au DAO des températures d'un station donnée en fonction d'une période
        List<Object[]> lstTemperatures = dao.getLastFilteredTemperaturesForStation(debut,fin,idStation);
        //pour chaques température
        for (Object[] tab : lstTemperatures)
        {
            Temperature t = (Temperature)tab[0];//récupération de l'object température
            Sensor se = (Sensor)tab[1];//récupération de l'object sonde
            Station st = (Station)tab[2];//récupération de l'object station
            //construction d'un item de la liste du modéle de températures
            Wendu item = new Wendu(t.getId(),t.getValue(),t.getDate(),se.getId(),se.getLabel(),st.getId(),st.getLabel(),st.getArea().getId(),st.getArea().getLabel(),st.getArea().getRoad());
            //ajout de l'item à la liste
            lstOut.add(item);
        }
        return lstOut;
    }
}
