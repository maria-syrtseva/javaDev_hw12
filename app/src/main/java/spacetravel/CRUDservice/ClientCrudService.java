package spacetravel.CRUDservice;

import spacetravel.entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import spacetravel.hibernate.HibernateUtil;

import java.util.List;

public class ClientCrudService {

    private final SessionFactory sessionFactory = HibernateUtil.getINSTANCE();

    // Create
    public void saveClient(Client client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(client);
            transaction.commit();
        }
    }

    // Read (ID)
    public Client getClientById(long clientId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Client.class, clientId);
        }
    }

    // Read (All)
    public List<Client> getAllClients() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Client", Client.class).list();
        }
    }

    // Update
    public void updateClient(Client client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(client);
            transaction.commit();
        }
    }

    // Delete
    public void deleteClient(long clientId) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Client client = session.get(Client.class, clientId);
            if (client != null) {
                session.delete(client);
            }
            transaction.commit();
        }
    }
}