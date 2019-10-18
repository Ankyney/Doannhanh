/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.facades;

import com.backend.entities.Company;
import com.backend.pagers.Pager;
import com.backend.utils.StringUtils;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Administrator
 */
public class CompanyFacade extends AbstractFacade {

    public CompanyFacade() {
        super(Company.class);
    }

    public List pager(Pager pager) {
        List list = null;
        Session session = null;
        try {
            session = HibernateConfiguration.getInstance().openSession();
            if (session != null) {
                Criteria cr = session.createCriteria(Company.class);
                cr.add(Restrictions.eq("isDeleted", false));
                if (!StringUtils.isEmpty(pager.getKeyword())) {
                    cr.add(Restrictions.or(
                            Restrictions.like("name", pager.getKeyword(), MatchMode.ANYWHERE),
                            Restrictions.like("code", pager.getKeyword(), MatchMode.ANYWHERE)
                    ));
                }
                cr.setProjection(Projections.rowCount());
                pager.setTotalResult(((Long) cr.uniqueResult()).intValue());
                cr = session.createCriteria(Company.class);
                cr.add(Restrictions.eq("isDeleted", false));
                if (!StringUtils.isEmpty(pager.getKeyword())) {
                    cr.add(Restrictions.or(
                            Restrictions.like("name", pager.getKeyword(), MatchMode.ANYWHERE),
                            Restrictions.like("code", pager.getKeyword(), MatchMode.ANYWHERE)
                    ));
                }
                cr.setFirstResult(pager.getFirstResult());
                cr.setMaxResults(pager.getDisplayPerPage());
                cr.addOrder(pager.getAsc() ? Order.asc(pager.getOrderColumn()) : Order.desc(pager.getOrderColumn()));
                list = cr.list();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateConfiguration.getInstance().closeSession(session);
        }
        return list;
    }

    public List findAllActiveCompany() {
        List list = null;
        Session session = null;
        try {
            session = HibernateConfiguration.getInstance().openSession();
            if (session != null) {
                Criteria cr = session.createCriteria(Company.class);
                cr.add(Restrictions.eq("isDeleted", false));
                cr.add(Restrictions.eq("isActive", true));
                list = cr.list();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateConfiguration.getInstance().closeSession(session);
        }
        return list;
    }

    public void delete(int id) throws Exception {
        Session session = null;
        Transaction trans = null;
        try {
            session = HibernateConfiguration.getInstance().openSession();
            if (session != null) {
                trans = session.beginTransaction();
                Query query = session.createSQLQuery("update company set isDeleted=:isDeleted where id=:id")
                        .setParameter("isDeleted", true).setParameter("id", id);
                query.executeUpdate();
                HibernateConfiguration.getInstance().commitTransaction(trans);
            }
        } catch (Exception e) {
            HibernateConfiguration.getInstance().rollbackTransaction(trans);
            throw e;
        } finally {
            HibernateConfiguration.getInstance().closeSession(session);
        }
    }

    public void hide(Integer id, Boolean status) throws Exception {
        Transaction trans = null;
        Session session = null;
        try {
            session = HibernateConfiguration.getInstance().openSession();
            if (session != null) {
                trans = session.beginTransaction();
                Query query = session.createSQLQuery("update company set isActive=:isActive where id=:id").setParameter("isActive", status).setParameter("id", id);
                query.executeUpdate();
                HibernateConfiguration.getInstance().commitTransaction(trans);
            }
        } catch (Exception e) {
            HibernateConfiguration.getInstance().rollbackTransaction(trans);
            throw e;
        } finally {
            HibernateConfiguration.getInstance().closeSession(session);
        }
    }

}
