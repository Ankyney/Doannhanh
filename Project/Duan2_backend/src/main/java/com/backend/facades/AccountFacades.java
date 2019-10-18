/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.facades;

import com.backend.entities.Account;
import com.backend.utils.StringUtils;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.JoinColumn;

/**
 * @author SamyFox
 */
public class AccountFacades extends AbstractFacade {

    public AccountFacades() {
        super(Account.class);
    }

    public List pager() {
        Session session = null;
        List list = null;
        try {
            session = HibernateConfiguration.getInstance().openSession();
            if (session != null) {
                Criteria cr = session.createCriteria(Account.class);
                list = cr.list();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            HibernateConfiguration.getInstance().closeSession(session);
        }
        return list;
    }

    public Account findAccountByName(String name) throws Exception {
        Session session = null;
        try {
            session = HibernateConfiguration.getInstance().openSession();
            if (session != null) {
                Criteria cr = session.createCriteria(Account.class);
                cr.add(Restrictions.eq("name", name));
                return (Account) cr.uniqueResult();
            }
        } catch (HibernateException e) {
            throw e;
        } finally {
            HibernateConfiguration.getInstance().closeSession(session);
        }
        return null;
    }

    public void delete(String accountId) throws Exception {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateConfiguration.getInstance().openSession();
            if (session != null) {
                transaction = session.beginTransaction();
                Query query = session.createQuery("delete from Account where accountId=:accountId").setParameter("accountId", accountId);
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
