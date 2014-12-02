package fr.utbm.core.service;


import fr.utbm.core.entity.Station;
import fr.utbm.dao.impl.IStationDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Yohann on 22/11/2014.
 * Classe service gérant les station
 */

@Service
public class ServiceStation implements IServiceStation
{
    @Autowired
    private IStationDao dao;//Appel à la DAO Station
    private Station station;//Information d'une station


    //------------------------------------------------------------------------
    //Demande au DAO Station
    //id : identifaint de la station
    //retoune les informations d'une station
    //------------------------------------------------------------------------
    @Transactional
    public Station getStaionById(int id)
    {
        //demande d'information au DAO pour une station donnée
        return dao.findById(id);
    }
}
