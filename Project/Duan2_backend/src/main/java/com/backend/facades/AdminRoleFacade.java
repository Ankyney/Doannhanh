package com.backend.facades;

import com.backend.entities.AdminRole;
import com.backend.pagers.Pager;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

public class AdminRoleFacade extends AbstractFacade {

    public AdminRoleFacade() {
        super(AdminRole.class);
    }

    @Override
    public List<AdminRole> findAll() {
        List<AdminRole> list = null;
        Session session = null;
        try {
            session = HibernateConfiguration.getInstance().openSession();
            if (session != null) {
                list = session.createCriteria(AdminRole.class).add(Restrictions.eq("isActive", true))
                        .add(Restrictions.eq("isDeleted", false)).list();
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            HibernateConfiguration.getInstance().closeSession(session);
        }
        return list;
    }

    @Override
    public AdminRole find(Integer id) {
        Session session = null;
        AdminRole obj = null;
        try {
            session = HibernateConfiguration.getInstance().openSession();
            Criteria cr = session.createCriteria(AdminRole.class);
            cr.add(Restrictions.eq("id", id));
            obj = (AdminRole) cr.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            HibernateConfiguration.getInstance().closeSession(session);
        }
        return obj;
    }

    public List pager(Pager pager) {
        Session session = null;
        List list = null;
        try {
            session = HibernateConfiguration.getInstance().openSession();
            if (session != null) {
                Criteria cr = session.createCriteria(AdminRole.class);
                cr.add(Restrictions.eq("isDeleted", false));
                cr.setProjection(Projections.rowCount());
                pager.setTotalResult(((Long) cr.uniqueResult()).intValue());
                cr = session.createCriteria(AdminRole.class);
                cr.add(Restrictions.eq("isDeleted", false));
                cr.setFirstResult(pager.getFirstResult());
                cr.setMaxResults(pager.getDisplayPerPage());
                cr.addOrder(pager.getAsc() ? Order.asc(pager.getOrderColumn()) : Order.desc(pager.getOrderColumn()));
                list = cr.list();
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            HibernateConfiguration.getInstance().closeSession(session);
        }
        return list;
    }

    public List findAllAvaiable() {
        Session session = null;
        List list = null;
        try {
            session = HibernateConfiguration.getInstance().openSession();
            if (session != null) {
                Criteria cr = session.createCriteria(AdminRole.class);
                cr.add(Restrictions.eq("isActive", true));
                cr.add(Restrictions.eq("isDeleted", false));
                list = cr.list();
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            HibernateConfiguration.getInstance().closeSession(session);
        }
        return list;
    }

    public int delete(int roleId) throws Exception {
        Transaction trans = null;
        int result = 0;
        Session session = null;
        try {
            session = HibernateConfiguration.getInstance().openSession();
            trans = session.beginTransaction();
            result = session.createSQLQuery("update AdminRole set isDeleted=1 where id=:roleId").setParameter("roleId", roleId).executeUpdate();
            HibernateConfiguration.getInstance().commitTransaction(trans);
        } catch (Exception e) {
            HibernateConfiguration.getInstance().rollbackTransaction(trans);
            throw e;
        } finally {
            HibernateConfiguration.getInstance().closeSession(session);
        }
        return result;
    }
}
