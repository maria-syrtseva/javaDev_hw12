package spacetravel.CRUDservice;

import spacetravel.entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import spacetravel.hibernate.HibernateUtil;

public class ClientCrudService {

    private SessionFactory sessionFactory = HibernateUtil.getINSTANCE();

    public void saveClient(Client client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(client);
            transaction.commit();
        }
    }

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