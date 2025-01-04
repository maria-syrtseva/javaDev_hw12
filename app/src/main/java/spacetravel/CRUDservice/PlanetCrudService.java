package spacetravel.CRUDservice;

import spacetravel.entity.Planet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import spacetravel.hibernate.HibernateUtil;

public class PlanetCrudService {

    private SessionFactory sessionFactory = HibernateUtil.getINSTANCE();

    public void savePlanet(Planet planet) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(planet);
            transaction.commit();
        }
    }

    public void deletePlanet(String planetId) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Planet planet = session.get(Planet.class, planetId);
            if (planet != null) {
                session.delete(planet);
            }
            transaction.commit();
        }
    }
}