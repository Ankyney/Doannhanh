package com.backend.utils;

import com.google.gson.Gson;
import com.backend.facades.AdminRoleFacade;
import com.backend.pagers.Pager;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomFunction {

    public static int getIntegerRandom() {
        try {
            Random r = new Random();
            return r.nextInt();
        } catch (Exception e) {
            return 0;
        }
    }

    public static String getBundle(String localeCode, String key) {
        try {
            Locale locale = localeCode == null ? new Locale("en") : new Locale(localeCode);
            ResourceBundle bundles = ResourceBundle.getBundle("com/bundle/Resources", locale);
            return bundles.getString(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String md5(String input) {
        MessageDigest md;
        StringBuffer sB;
        String output = null;
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(input.getBytes());
            byte[] digest = md.digest();
            sB = new StringBuffer();
            for (byte b : digest) {
                sB.append(String.format("%02x", b & 0xff));
            }
            output = sB.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CustomFunction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }

    public static int size(Collection c) {
        return c == null ? 0 : c.size();
    }

    public static String buildPager(Pager pager) {
        String url = "?currentPage=" + pager.getCurrentPage() + "&displayPerPage=" + pager.getDisplayPerPage()
                + "&orderColumn=" + pager.getOrderColumn() + "&asc=" + pager.getAsc() + "&keyword=" + pager.getKeyword();
        return url;
    }

    public static List findAllAvailableAdminRole() {
        return new AdminRoleFacade().findAll();
    }

    public static String formatDate(Date date) {
        return new SimpleDateFormat("MMMM dd, yyyy").format(date);
    }

    public static String customFormatDate(String format, Date date) {
        return new SimpleDateFormat(format).format(date);
    }

    public static String customFormatDecimal(String format, BigDecimal num) {
        num = num == null ? BigDecimal.ZERO : num;
        return new DecimalFormat(format).format(num);
    }

    public static String getJSON(Object object) {
        Gson gson = new Gson();
        return gson.toJson(object);
    }

    public static int getDay(Date startDate) {
        Date endDate = new Date();
        long startTime = startDate.getTime();
        long endTime = endDate.getTime();
        long diffTime = endTime - startTime;
        long diffDays = diffTime / (1000 * 60 * 60 * 24);
        return ((Long) diffDays).intValue();
    }

    public static Date getCurrentTime() {
        return new Date();
    }

    public static int dateDiffToDays(Date startDate, Date enddate) {
        return (int) (enddate.getTime() - startDate.getTime()) / (1000 * 60 * 60 * 24) + 1;
    }

    public static boolean compareString(String str1, String str2) {
        return StringUtils.isEquals(str1, str2);
    }

    public static List findAllAvailableRoleAdmin() {
        return new AdminRoleFacade().findAll();
    }

    public static String subString(String str, Integer beginIndex, Integer endIndex) {
        if (beginIndex < 0 || beginIndex == null || beginIndex > endIndex || beginIndex > str.length()) {
            return str;
        }
        if (endIndex == null) {
            return str.substring(beginIndex);
        }
        return str.length() > endIndex ? str.substring(beginIndex, endIndex) + "..." : str.substring(beginIndex);
    }
}
