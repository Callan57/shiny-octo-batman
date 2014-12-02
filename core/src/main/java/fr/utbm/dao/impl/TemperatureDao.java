package fr.utbm.dao.impl;// default package
// Generated 31 oct. 2014 13:51:02 by Hibernate Tools 3.4.0.CR1

import fr.utbm.core.entity.Temperature;
import fr.utbm.dao.HibernateDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Home object for domain model class Temperature.
 *
 * @author Hibernate Tools
 * @see .Temperature
 */
@Repository
public class TemperatureDao extends HibernateDao implements ITemperatureDao
{

    private static final Log log = LogFactory.getLog(TemperatureDao.class);

    private static Session session;

    static {
        session = getSession();
    }

    public void persist(Temperature transientInstance) {
        log.debug("persisting Temperature instance");
        super.persist(transientInstance);
    }

    public void update(Temperature instance) {
        log.debug("attaching dirty Temperature instance");
        super.update(instance);
    }

    public void delete(Temperature persistentInstance) {
        log.debug("deleting Temperature instance");
        super.delete(persistentInstance);
    }

    public Temperature findById(int id) {
        log.debug("getting Temperature instance with id: " + id);
        return (Temperature) super.get(Temperature.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Temperature> getAll() {
        log.debug("getting all Temperature instances");
        return (List<Temperature>) super.getAll(Temperature.class);
    }

    //------------------------------------------------------------------------
    //Requête à la base de données
    //retourne la liste des dernières températures des stations
    //------------------------------------------------------------------------
    public List<Object[]> getLastByStation()
    {
        log.debug("getting last Temperature for all Station");
        //ouverture de la transaction
        begin();

        //requête récuperant les dernières température de chaques stations
        Query query = session.createQuery(
                "from Temperature as te " +
                        "inner join te.sensor as se " +
                        "inner join se.station as st " +
                        "WHERE te.date = (SELECT max(te2.date) FROM Temperature te2 " +
                        "INNER JOIN te2.sensor as se2 " +
                        "INNER JOIN se2.station st2 " +
                        "WHERE st2.id = st.id)" +
                        "GROUP BY st.id"

        );
        //fermeture de la transaction
        commit();
        return query.list();
    }

    //------------------------------------------------------------------------
    //Requête à la base de données
    //idStation : identifiant de la station
    //retourne la liste des températures d'une station
    //------------------------------------------------------------------------
    public List<Object[]> getAllForStation(int idStation)
    {
        log.debug("getting all Temperature for one Station");
        //ouverture de la transaction
        begin();

        //requête récupérant les température d'une station
        Query query = session.createQuery(
                "from Temperature as te " +
                        "inner join te.sensor as se " +
                        "inner join se.station as st " +
                        "where st.id = " + idStation +
                        " order by te.date DESC"
        );
        //fermeture de la transaction
        commit();
        return query.list();
    }

    //------------------------------------------------------------------------
    //Requête à la base de données
    //idStation : identifiant de la station
    //debut : date de début de la période
    //fin : date de fin de la période
    //retourne la liste des températures d'uen station en fonction d'une période
    //------------------------------------------------------------------------
    public List<Object[]> getLastFilteredTemperaturesForStation(Date debut,Date fin, int idStation)
    {
        log.debug("getting all filtered Temperature for one Station");
        //ouverture de la transaction
        begin();

        //requête récupérant les température d'une staion en fonction d'une période
        Query query = session.createQuery(
                "from Temperature as te " +
                        "inner join te.sensor as se " +
                        "inner join se.station as st " +
                        "where te.date >= :dateDeb and te.date <= :dateFin " +
                        "and st.id = " + idStation +
                        " order by te.date DESC"

        );
        //passage des paramètre à la requête
        query.setDate("dateDeb",debut);//date début
        query.setDate("dateFin",fin);//date fin
        //fermeture de la transaction
        commit();
        return query.list();
    }

}
