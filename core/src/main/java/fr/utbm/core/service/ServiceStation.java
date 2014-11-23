package fr.utbm.core.service;


import fr.utbm.core.entity.Station;
import fr.utbm.dao.impl.IStationDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ServiceStation implements IServiceStation
{
    @Autowired
    private IStationDao dao;
    private Station station;

    @Transactional
    public Station getStaionById(int id)
    {
        return dao.findById(id);
    }
}
