package spacetravel.CRUDservice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import spacetravel.entity.Ticket;

public class TicketCrudService {

    private final SessionFactory sessionFactory;

    public TicketCrudService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // Create
    public Ticket create(Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(ticket);
            session.getTransaction().commit();
            return ticket;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to create ticket");
        }
    }

    // Read (ID)
    public Ticket read(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Ticket.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to read ticket with ID: " + id);
        }
    }

    // Update
    public Ticket update(Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(ticket);
            session.getTransaction().commit();
            return ticket;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to update ticket");
        }
    }

    // Delete
    public void delete(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Ticket ticket = session.get(Ticket.class, id);
            if (ticket != null) {
                session.delete(ticket);
                session.getTransaction().commit();
            } else {
                System.out.println("Білет: " + id + " не знайдено.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Помилка при видаленні білета: " + id);
        }
    }
}