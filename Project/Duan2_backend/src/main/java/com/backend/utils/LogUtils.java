package com.backend.utils;

import com.backend.entities.Admin;
import com.backend.entities.AdminLogs;
import com.backend.facades.HibernateConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LogUtils {
    public static void logs(int adminID, String content) {
        Transaction trans = null;
        Session session=null;
        try {
            session = HibernateConfiguration.getInstance().openSession();
            trans = session.beginTransaction();
            AdminLogs log = new AdminLogs();
            log.setAdminId(session.get(Admin.class, adminID));
            log.setLogContent(content);
            session.save(log);
            HibernateConfiguration.getInstance().commitTransaction(trans);
        } catch (Exception e) {
            HibernateConfiguration.getInstance().rollbackTransaction(trans);
            e.printStackTrace();
        }
    }

}
