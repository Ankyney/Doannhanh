package com.backend.facades;

import com.backend.entities.AdminModule;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.hibernate.transform.Transformers;
import org.hibernate.type.BooleanType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

public class AdminModuleFacade extends AbstractFacade {

    public AdminModuleFacade() {

        super(AdminModule.class);
    }

    public List findAllRootModulesEager() {
        Session session = null;
        List list = null;
        try {
            session = HibernateConfiguration.getInstance().openSession();
            Criteria cr = session.createCriteria(AdminModule.class);
            cr.add(Restrictions.eq("isDeleted", false));
            cr.createAlias("parentId", "parentId", JoinType.LEFT_OUTER_JOIN);
            cr.setFetchMode("parentId", FetchMode.JOIN);
            cr.addOrder(Order.desc("orderNumber"));
            list = cr.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateConfiguration.getInstance().closeSession(session);
        }
        return list;
    }

    public List findAllModuleByUsername(String moduleIDs) {
        Session session = null;
        List list = null;
        try {
            session = HibernateConfiguration.getInstance().openSession();
            if (session != null) {
                String sql = "Select id,name,routeLink,icon,parentID,isShow,orderNumber,level from AdminModule"
                        + " where id in (select * from fnSplit(:moduleIDs,',')) and IsDeleted=0 and IsShow=1";
                Query q = session.createSQLQuery(sql)
                        .addScalar("id", IntegerType.INSTANCE)
                        .addScalar("name", StringType.INSTANCE)
                        .addScalar("routeLink", StringType.INSTANCE)
                        .addScalar("icon", StringType.INSTANCE)
                        .addScalar("parentID", IntegerType.INSTANCE)
                        .addScalar("isShow", BooleanType.INSTANCE)
                        .addScalar("orderNumber", IntegerType.INSTANCE)
                        .addScalar("level", IntegerType.INSTANCE);
                q.setParameter("moduleIDs", moduleIDs);
                q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
                list = q.list();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateConfiguration.getInstance().closeSession(session);
        }
        return list;
    }

    public void delete(Integer moduleID) throws Exception {
        Transaction trans = null;
        Session session = null;
        try {
            session = HibernateConfiguration.getInstance().openSession();
            trans = session.beginTransaction();
            Query q = session.createSQLQuery("Update AdminModule set IsDeleted=1 where ID=:moduleID");
            q.setParameter("moduleID", moduleID);
            q.executeUpdate();
            HibernateConfiguration.getInstance().commitTransaction(trans);
        } catch (Exception e) {

            HibernateConfiguration.getInstance().rollbackTransaction(trans);
            throw e;
        } finally {
            HibernateConfiguration.getInstance().closeSession(session);
        }
    }
}
