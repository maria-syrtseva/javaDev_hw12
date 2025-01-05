package spacetravel.CRUDservice;

import spacetravel.entity.Planet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import spacetravel.hibernate.HibernateUtil;

import java.util.List;

public class PlanetCrudService {

    private final SessionFactory sessionFactory = HibernateUtil.getINSTANCE();

    // Create
    public void savePlanet(Planet planet) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(planet);
            transaction.commit();
        }
    }

    // Read (ID)
    public Planet getPlanetById(String planetId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Planet.class, planetId);
        }
    }

    // Read (All)
    public List<Planet> getAllPlanets() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Planet", Planet.class).list();
        }
    }

    // Update
    public void updatePlanet(Planet planet) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(planet);
            transaction.commit();
        }
    }

    // Delete
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