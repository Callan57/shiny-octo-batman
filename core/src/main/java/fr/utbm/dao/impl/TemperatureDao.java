package fr.utbm.dao.impl;// default package
// Generated 31 oct. 2014 13:51:02 by Hibernate Tools 3.4.0.CR1

import fr.utbm.core.entity.Temperature;
import fr.utbm.dao.HibernateDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Home object for domain model class Temperature.
 *
 * @author Hibernate Tools
 * @see .Temperature
 */
public class TemperatureDao extends HibernateDao {

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

    public List<Temperature> getLastByStation()
    {
        log.debug("getting last Temperature for all Station");
        begin();

        Query query = session.createQuery(
                "from Temperature as te " +
                        "inner join te.sensor as se " +
                        "inner join se.station as st " +
                        "group by st.id"

        );
        commit();
        return query.list();
    }
}
