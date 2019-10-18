package com.backend.facades;

import com.backend.entities.Admin;
import com.backend.entities.AdminRole;
import com.backend.utils.CustomFunction;
import com.backend.utils.StringUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

public class AdminFacade extends AbstractFacade {

    public AdminFacade() {
        super(Admin.class);
    }

    public List pager() {
        Session session = null;
        List list = null;
        try {
            session = HibernateConfiguration.getInstance().openSession();
            if (session != null) {
                Criteria cr = session.createCriteria(Admin.class);
                cr.createAlias("adminRoleId", "adminRoleId", JoinType.LEFT_OUTER_JOIN);
                cr.setFetchMode("adminRoleId", FetchMode.JOIN);
                cr.add(Restrictions.eq("isDeleted", false));
                cr.addOrder(Order.asc("lastName"))
                        .addOrder(Order.asc("firstName"));
                list = cr.list();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateConfiguration.getInstance().closeSession(session);
        }
        return list;
    }

    public Admin checkLogin(String username, String password) {
        Session session = null;
        Admin result = null;
        try {
            session = HibernateConfiguration.getInstance().openSession();
            Criteria cr = session.createCriteria(Admin.class);
            cr.createAlias("adminRoleId", "adminRoleId", JoinType.LEFT_OUTER_JOIN);
            cr.setFetchMode("adminRoleId", FetchMode.JOIN);
            cr.add(Restrictions.eq("username", username));
            cr.add(Restrictions.eq("password", password));
            cr.add(Restrictions.eq("isDeleted", false));
            result = (Admin) cr.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            HibernateConfiguration.getInstance().closeSession(session);
        }
        return result;
    }

    public List findAllActiveAdmin() {
        List list = null;
        Session session = null;
        try {
            session = HibernateConfiguration.getInstance().openSession();
            if (session != null) {
                Criteria cr = session.createCriteria(Admin.class);
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

    public List findAllAdminInSalarytableProduct(int salaryCycleID) {
        List list = null;
        Session session = null;
        try {
            session = HibernateConfiguration.getInstance().openSession();
            if (session != null) {
                SQLQuery q = session.createSQLQuery("select admin.id, admin.name, admin.adminCode \n"
                        + "  from SalaryTable join Admin on salarytable.adminID = admin.id\n"
                        + "  where SalarycycleID = :salaryCycleID\n"
                        + "  group by admin.id, admin.name, admin.adminCode");
                q.addScalar("id", IntegerType.INSTANCE);
                q.addScalar("name", StringType.INSTANCE);
                q.addScalar("adminCode", StringType.INSTANCE);
                q.setParameter("salaryCycleID", salaryCycleID);
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

    public Admin findUserInfo(String username) {
        Session session = null;
        Admin result = null;
        try {
            session = HibernateConfiguration.getInstance().openSession();
            Criteria cr = session.createCriteria(Admin.class);
            cr.createAlias("adminRoleId", "adminRoleId", JoinType.LEFT_OUTER_JOIN);
            cr.setFetchMode("adminRoleId", FetchMode.JOIN);
            cr.add(Restrictions.eq("username", username));
            cr.add(Restrictions.eq("isDeleted", false));
            result = (Admin) cr.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            HibernateConfiguration.getInstance().closeSession(session);
        }
        return result;
    }

    public List search(String keyword) {
        Session session = null;
        List result = null;
        try {
            session = HibernateConfiguration.getInstance().openSession();
            Criteria cr = session.createCriteria(Admin.class);
            cr.add(Restrictions.or(
                    Restrictions.like("username", keyword, MatchMode.ANYWHERE),
                    Restrictions.like("name", keyword, MatchMode.ANYWHERE)
            ));
            cr.add(Restrictions.eq("isDeleted", false));
            result = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            HibernateConfiguration.getInstance().closeSession(session);
        }
        return result;
    }

    public void block(Integer id, Boolean status) throws Exception {
        Session session = null;
        Transaction trans = null;
        try {
            session = HibernateConfiguration.getInstance().openSession();
            if (session != null) {
                trans = session.beginTransaction();
                Query query = session.createSQLQuery("update admin set isActive=:isActive where id=:id").setParameter("isActive", status).setParameter("id", id);
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

    public Admin findAdminByUsername(String userName) throws Exception {
        Session session = null;
        try {
            session = HibernateConfiguration.getInstance().openSession();
            if (session != null) {
                Criteria cr = session.createCriteria(Admin.class);
                cr.add(Restrictions.eq("username", userName));
                cr.add(Restrictions.eq("isDeleted", false));
                return (Admin) cr.uniqueResult();
            }
        } catch (HibernateException e) {
            throw e;
        } finally {
            HibernateConfiguration.getInstance().closeSession(session);
        }
        return null;
    }

    public Admin findAdminWithCompanyByUsername(String userName) throws Exception {
        Session session = null;
        try {
            session = HibernateConfiguration.getInstance().openSession();
            if (session != null) {
                Criteria cr = session.createCriteria(Admin.class);
                cr.createAlias("companyID", "companyID", JoinType.LEFT_OUTER_JOIN);
                cr.setFetchMode("companyID", FetchMode.JOIN);
                cr.add(Restrictions.eq("username", userName));
                cr.add(Restrictions.eq("isDeleted", false));
                return (Admin) cr.uniqueResult();
            }
        } catch (HibernateException e) {
            throw e;
        } finally {
            HibernateConfiguration.getInstance().closeSession(session);
        }
        return null;
    }

    public Admin findAdminInfoByUsername(String userName) throws Exception {
        Session session = null;
        try {
            session = HibernateConfiguration.getInstance().openSession();
            if (session != null) {
                Criteria cr = session.createCriteria(Admin.class);
                cr.createAlias("companyID", "companyID", JoinType.LEFT_OUTER_JOIN);
                cr.createAlias("adminRoleId", "adminRoleId", JoinType.LEFT_OUTER_JOIN);
                cr.setFetchMode("companyID", FetchMode.JOIN);
                cr.setFetchMode("adminRoleId", FetchMode.JOIN);
                cr.add(Restrictions.eq("username", userName));
                cr.add(Restrictions.eq("isDeleted", false));
                return (Admin) cr.uniqueResult();
            }
        } catch (HibernateException e) {
            throw e;
        } finally {
            HibernateConfiguration.getInstance().closeSession(session);
        }
        return null;
    }

    public Integer getAdminRoleByAdminId(int admId) {
        Session session = null;
        try {
            session = HibernateConfiguration.getInstance().openSession();
            if (session != null) {
                Criteria cr = session.createCriteria(Admin.class);
                cr.add(Restrictions.eq("id", admId));
                cr.setProjection(Projections.projectionList().add(Projections.property("roleAdmID.id")));
                return (Integer) cr.uniqueResult();
            }
        } catch (HibernateException e) {
            throw e;
        } finally {
            HibernateConfiguration.getInstance().closeSession(session);
        }
        return null;
    }

//    public Admin findAdminById(Integer id) {
//        Session session = null;
//        Admin admin = null;
//        try {
//            session = HibernateConfiguration.getInstance().openSession();
//            if (session != null) {
//                Criteria cr = session.createCriteria(Admin.class);
//                cr.createAlias("adminRoleId", "adminRoleId", JoinType.LEFT_OUTER_JOIN);
//                cr.setFetchMode("adminRoleId", FetchMode.JOIN);
//                cr.createAlias("adminRoleId.adminModuleInRoles", "adminModuleInRoles", JoinType.LEFT_OUTER_JOIN);
//                cr.setFetchMode("adminModuleInRoles", FetchMode.JOIN);
//                cr.add(Restrictions.eq("id", id));
//                cr.add(Restrictions.eq("isDeleted", false));
//                admin = (Admin) cr.uniqueResult();
//                if (admin != null) {
//                    for (AdminModuleInRole mr : (admin.getAdminRoleId().getAdminModuleInRoles())) {
//                        Hibernate.initialize(mr.getAdminModuleId().getChildrenModules());
//                    }
//                    admin.getAdminRoleId().setAdminModuleInRoles(
//                            admin.getAdminRoleId().getAdminModuleInRoles().stream().sorted((module1, module2) -> {
//                                int orderNumber1 = module1.getAdminModuleId().getOrderNumber() == null ? 0 : module1.getAdminModuleId().getOrderNumber();
//                                int orderNumber2 = module2.getAdminModuleId().getOrderNumber() == null ? 0 : module2.getAdminModuleId().getOrderNumber();
//                                return Integer.compare(orderNumber2, orderNumber1);
//                            }).collect(Collectors.toList())
//                    );
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            HibernateConfiguration.getInstance().closeSession(session);
//        }
//        return admin;
//    }
    public void delete(int id) throws Exception {
        Session session = null;
        Transaction trans = null;
        try {
            session = HibernateConfiguration.getInstance().openSession();
            if (session != null) {
                trans = session.beginTransaction();
                Query query = session.createSQLQuery("update admin set isDeleted=:isDeleted where id=:id")
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

    public int create(Map admin) throws Exception {
        Session session = null;
        Transaction trans = null;
        try {
            session = HibernateConfiguration.getInstance().openSession();
            trans = session.beginTransaction();
            if (admin == null) {
                return 1;
            }
            if (StringUtils.isEmpty(admin.get("userName").toString())
                    || StringUtils.isEmpty(admin.get("name").toString())
                    || StringUtils.isEmpty(admin.get("password").toString())) {
                return 2;
            }
            Admin a = new Admin();
            a.setName(admin.get("name").toString());
            a.setPassword(CustomFunction.md5(admin.get("password").toString()));
            a.setUsername(admin.get("userName").toString());
            a.setAdminRoleId(new AdminRole(Integer.parseInt(admin.get("adminRoleId").toString())));
            a.setIsActive(true);
            if (findAdminByUsername(a.getUsername()) != null) {
                return 3;
            }
            session.save(a);
            HibernateConfiguration.getInstance().commitTransaction(trans);
            return 4;
        } catch (Exception e) {
            HibernateConfiguration.getInstance().rollbackTransaction(trans);
            throw e;
        } finally {
            HibernateConfiguration.getInstance().closeSession(session);
        }
    }

    public int changePassword(String oldpass, String newpass, String username) throws Exception {
        Session session = null;
        Transaction trans = null;
        int rs = 0;
        try {
            session = HibernateConfiguration.getInstance().openSession();
            trans = session.beginTransaction();
            Query q;
            q = session.createSQLQuery("update Admin set Password=:newpass where username=:username and Password=:oldpass");
            q.setParameter("newpass", CustomFunction.md5(newpass))
                    .setParameter("oldpass", CustomFunction.md5(oldpass))
                    .setParameter("username", username);
            rs = q.executeUpdate();
            HibernateConfiguration.getInstance().commitTransaction(trans);
        } catch (Exception e) {
            HibernateConfiguration.getInstance().rollbackTransaction(trans);
            e.printStackTrace();
        } finally {
            HibernateConfiguration.getInstance().closeSession(session);
        }
        return rs;
    }

    public void edit(Admin admin) throws Exception {
        Transaction tran = null;
        Session session = null;
        try {
            session = HibernateConfiguration.getInstance().openSession();
            tran = session.beginTransaction();
            session.update(admin);
            HibernateConfiguration.getInstance().commitTransaction(tran);
        } catch (Exception e) {
            HibernateConfiguration.getInstance().rollbackTransaction(tran);
            e.printStackTrace();
            throw e;
        } finally {
            HibernateConfiguration.getInstance().closeSession(session);
        }
    }

//    public static void main(String[] args) {
//        AdminFacade aFacade = new AdminFacade();
//        List<Admin> listAdmin = aFacade.findAll();
//        DepartmentPositionAdminFacade dpFacade = new DepartmentPositionAdminFacade();
//        DepartmentPositionAdmin dpa;
//        Department department = new Department(5);
//        int count = 1;
//        try {
//            for (Admin admin : listAdmin) {
//                dpa = new DepartmentPositionAdmin();
//                dpa.setAdminID(admin);
//                dpa.setDepartmentID(department);
//                dpa.setPositionAdminID(new PositionAdmin(4));
//                dpFacade.create(dpa);
//                if (count == 12) {
//                    count = 1;
//                    switch (department.getId() + 1) {
//                        case 10:
//                            department = new Department(11);
//                            break;
//                        case 23:
//                            department = new Department(5);
//                            break;
//                        default:
//                            department = new Department(department.getId() + 1);
//                            break;
//                    }
//                } else {
//                    count++;
//                }
//            }
//        } catch (Exception ex) {
//            System.out.println(department.getId());
//            ex.printStackTrace();
//        }
//    }
    private static final String GENDER_MALE = "nam";
    private static final String GENDER_FEMALE = "nữ";

    public int importFromExcel(XSSFWorkbook workBook, Integer companyID) throws Exception {
        Transaction trans = null;
        Session session = null;
        int result = 0;
        int rowIndex = 0;
        try {
            session = HibernateConfiguration.getInstance().openSession();
            trans = session.beginTransaction();
            Sheet sheet = workBook.getSheet("NhanVien");
            Iterator<Row> rowIterator = sheet.iterator();
            if (rowIterator.hasNext()) {
                rowIterator.next();
            }
            rowIterator.hasNext();
            int rowMax = 0;
            StringBuilder sb = new StringBuilder();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                if (rowMax > 0) {

                    sb.append(",");
                } else {

                    sb.append("Insert into Admin(Name,FirstName,LastName,UserName,Password,AdminCode,Gender,Phone,CompanyID) values");
                }
                sb.append("(");
                String name = row.getCell(0).getStringCellValue();
                try {
                    sb.append("N").append(row.getCell(0) == null || StringUtils.isEmpty(name) ? "NULL" : "'" + name + "'");

                } catch (Exception e) {
                    throw new Exception("Không đúng định dạng tại cột HỌ VÀ TÊN dòng " + (rowIndex + 1));
                }
                String firstName = "Họ";
                String lastName = "Họ đệm & Tên";
                String[] nameSplit = name.split(" ");
                if (nameSplit.length > 0) {
                    lastName = nameSplit[nameSplit.length - 1];
                    firstName = "";
                    for (int i = 0; i < nameSplit.length - 1; i++) {
                        lastName += i == 0 ? nameSplit[i] : (" " + nameSplit[i]);
                    }

                }
                sb.append(",N'").append(firstName).append("'");

                sb.append(",N'").append(lastName).append("'");
                try {
                    String adminCode = row.getCell(1).getStringCellValue();
                    sb.append(",").append(row.getCell(1) == null || StringUtils.isEmpty(adminCode) ? "NULL" : "'" + adminCode + "'");
                    sb.append(",").append(row.getCell(1) == null || StringUtils.isEmpty(adminCode) ? "NULL" : "'" + CustomFunction.md5(adminCode) + "'");
                    sb.append(",").append(row.getCell(1) == null || StringUtils.isEmpty(adminCode) ? "NULL" : "'" + adminCode + "'");
                } catch (Exception e) {
                    throw new Exception("Không đúng định dạng tại cột MÃ CHẤM CÔNG dòng " + (rowIndex + 1));
                }
                if (row.getCell(2) == null) {
                    sb.append(",1");
                } else {
                    try {
                        String gender = row.getCell(2).getStringCellValue().toLowerCase();
                        switch (gender) {
                            case GENDER_MALE: {
                                sb.append(",1");
                                break;
                            }
                            case GENDER_FEMALE: {
                                sb.append(",0");
                                break;
                            }
                            default: {
                                throw new Exception();
                            }
                        }
                    } catch (Exception e) {
                        throw new Exception("Không đúng định dạng tại cột GIỚI TÍNH dòng " + (rowIndex + 1));
                    }
                }
                try {
                    String mobile = row.getCell(3).getStringCellValue();
                    sb.append(",").append(row.getCell(3) == null ? "NULL" : "'" + mobile + "'").append("");
                } catch (Exception e) {
                    throw new Exception("Không đúng định dạng tại cột SỐ ĐIỆN THOẠI dòng " + (rowIndex + 1));
                }

                sb.append(",").append(companyID);
                sb.append(")");

                if (rowMax >= 999) {
                    Query q = session.createSQLQuery(sb.toString());
                    result += q.executeUpdate();
                    rowMax = 0;
                } else if (!rowIterator.hasNext()) {
                    Query q = session.createSQLQuery(sb.toString());
                    result += q.executeUpdate();
                } else {
                    rowMax++;
                }
                rowIndex++;
            }
            HibernateConfiguration.getInstance().commitTransaction(trans);
        } catch (Exception e) {
            e.printStackTrace();
            HibernateConfiguration.getInstance().rollbackTransaction(trans);
            throw e;
        } finally {
            HibernateConfiguration.getInstance().closeSession(session);
        }
        return result;
    }

    public boolean isExistUserName(String username, Integer companyID) {
        Session session = null;
        try {
            session = HibernateConfiguration.getInstance().openSession();
            if (session != null) {
                Criteria cr = session.createCriteria(Admin.class);
                cr.createAlias("companyID", "comp");
                cr.add(Restrictions.eq("adminCode", username));
                cr.add(Restrictions.eq("comp.id", companyID));
                cr.add(Restrictions.eq("isDeleted", false));
                List result = cr.list();
                if (result.size() > 0) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateConfiguration.getInstance().closeSession(session);
        }
        return true;
    }

    public String isDuplicateUserName(XSSFWorkbook workBook, Integer companyID) {
        Sheet sheet = workBook.getSheet("NhanVien");
        Iterator<Row> rowIterator = sheet.iterator();
        ArrayList<String> adminCodes = new ArrayList();
        int rowIndex1 = 0;
        while (rowIterator.hasNext()) {
            rowIndex1++;
            Row row = rowIterator.next();
            if (row.getCell(1) != null) {
                String adminCode = row.getCell(1).getStringCellValue();
                if (new AdminFacade().isExistUserName(adminCode, companyID)) {
                    return "MÃ CHẤM CÔNG " + row.getCell(1).getStringCellValue() + " của nhân viên tại dòng " + rowIndex1 + " đã tồn tại!";
                }
                if (adminCodes.indexOf(adminCode) != -1) {
                    return "MÃ CHẤM CÔNG " + adminCode + " bị lặp";
                } else {
                    adminCodes.add(adminCode);
                }
            }
        }
        return "";
    }


}
