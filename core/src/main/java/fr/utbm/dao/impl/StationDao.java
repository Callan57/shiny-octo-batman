package fr.utbm.dao.impl;// default package
// Generated 31 oct. 2014 13:51:02 by Hibernate Tools 3.4.0.CR1

import fr.utbm.core.entity.Station;
import fr.utbm.core.entity.Temperature;
import fr.utbm.core.tools.HibernateUtil;
import fr.utbm.dao.HibernateDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Home object for domain model class Temperature.
 *
 * @author Hibernate Tools
 * @see .Temperature
 */
@Repository
public class StationDao extends HibernateDao implements IStationDao
{

    private static final Log log = LogFactory.getLog(TemperatureDao.class);

    private static Session session;

    static {
        session = getSession();
    }

    public void persist(Station transientInstance) {
        log.debug("persisting Temperature instance");
        super.persist(transientInstance);
    }

    public void update(Station instance) {
        log.debug("attaching dirty Temperature instance");
        super.update(instance);
    }

    public void delete(Station persistentInstance) {
        log.debug("deleting Temperature instance");
        super.delete(persistentInstance);
    }

    public Station findById(int id) {

        log.debug("getting last Temperature for all Station");

        Station station;

        session = HibernateUtil.getSessionFactory().openSession();
        station =  (Station) session.get(Station.class, id);

        return station;

    }

    @SuppressWarnings("unchecked")
    public List<Station> getAll() {
        log.debug("getting all Temperature instances");
        return (List<Station>) super.getAll(Station.class);
    }


}
