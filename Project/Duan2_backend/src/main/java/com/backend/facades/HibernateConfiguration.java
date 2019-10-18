package com.backend.facades;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateConfiguration {

    private static final HibernateConfiguration INSTANCE = new HibernateConfiguration();

    private static SessionFactory sessionFactory = HibernateConfiguration.INSTANCE.buildSessionFactory();

    private HibernateConfiguration() {
    }

    public static HibernateConfiguration getInstance() {
        return INSTANCE;
    }

    public void rollbackTransaction(Transaction tran) {
        if (tran != null) {
            try {
                tran.rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void commitTransaction(Transaction tran) {
        tran.commit();
    }

    private SessionFactory buildSessionFactory() {
        try {
            if (sessionFactory == null) {
                Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
                sessionFactory = configuration.buildSessionFactory();
            }
        } catch (Throwable ex) {
            System.err.println(" Failed to create sessionFactory object." + ex);
            ex.printStackTrace();
        }
        return sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public Session openSession() {
        Session session = null;
        try {
            if (sessionFactory == null || sessionFactory.isClosed()) {
                sessionFactory = HibernateConfiguration.INSTANCE.buildSessionFactory();
            }
            session = sessionFactory.openSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return session;
    }

    public void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
            sessionFactory = null;
        }
    }

    public void open() {
        if (sessionFactory == null) {
            sessionFactory = HibernateConfiguration.INSTANCE.buildSessionFactory();
        }
    }

    public void flushSession(Session session) {
        if (session != null) {
            session.flush();
            session.clear();
        }
    }

    public void closeSession(Session session) {
        try {
            if (session != null) {
                session.close();
            }
        } catch (Exception e) {

        }
    }
}
