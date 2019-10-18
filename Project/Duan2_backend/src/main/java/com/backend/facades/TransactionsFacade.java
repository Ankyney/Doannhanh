package com.backend.facades;

import com.backend.entities.Transactions;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;
import java.util.Map;

public class TransactionsFacade extends AbstractFacade {
    public TransactionsFacade() {
        super(Transactions.class);
    }

    public List pager() {
        Session session = null;
        List list = null;
        try {
            session = HibernateConfiguration.getInstance().openSession();
            if (session != null) {
                Criteria cr = session.createCriteria(Transactions.class);
                list = cr.list();
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            HibernateConfiguration.getInstance().closeSession(session);
        }
        return list;
    }



    public Transactions findById(String id) {
        Session session = null;
        Transactions trans = null;
        try {
            session = HibernateConfiguration.getInstance().openSession();
            if (session != null) {
                Criteria cr = session.createCriteria(Transactions.class);
                cr.add(Restrictions.eq("transactionId", id));
                trans = (Transactions) cr.uniqueResult();
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            HibernateConfiguration.getInstance().closeSession(session);
        }
        return trans;
    }



    public void delete(String id) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateConfiguration.getInstance().openSession();
            if (session != null) {
                transaction = session.beginTransaction();
                String hql = "delete from Transactions where transactionId=:id";
                Query query = session.createQuery(hql).setParameter("id", id);
                query.executeUpdate();
                HibernateConfiguration.getInstance().commitTransaction(transaction);
            }

        } catch (Exception ex) {
            HibernateConfiguration.getInstance().rollbackTransaction(transaction);
            throw ex;
        } finally {
            HibernateConfiguration.getInstance().closeSession(session);
        }
    }
}
