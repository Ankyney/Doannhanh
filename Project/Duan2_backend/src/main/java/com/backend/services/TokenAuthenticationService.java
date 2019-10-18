package com.backend.services;

/**
 * Created by nhs3108 on 29/03/2017.
 */
import com.google.gson.Gson;
import com.backend.beans.responses.ResponseApi;
import com.backend.beans.responses.ResponseAuth;
import com.backend.entities.Admin;
import com.backend.facades.AdminFacade;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.io.IOException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

import static java.util.Collections.emptyList;

public class TokenAuthenticationService {

    static final long EXPIRATIONTIME = 84_400_000; // 1 days
    static final String SECRET = "Cellx@1234";
    static final String TOKEN_PREFIX = "Bearer";
    static final String HEADER_STRING = "Authorization";

    public static void successAuthentication(HttpServletResponse res, String username) {
        Date expireDate = new Date(System.currentTimeMillis() + EXPIRATIONTIME);
        String JWT = Jwts.builder()
                .setSubject(username)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        ResponseApi apiResonse = new ResponseApi();
        apiResonse.setSuccess(Boolean.TRUE);
        apiResonse.setCode(1);
        apiResonse.setMessage("Đăng nhập thành công.");
        ResponseAuth auth = new ResponseAuth(username, TOKEN_PREFIX + " " + JWT, expireDate);
        try {
            Admin admin = new AdminFacade().findAdminInfoByUsername(username);
            auth.setCompanyID(admin.getCompanyID());
            auth.setId(admin.getId());
            auth.setAdminRoleID(admin.getAdminRoleId());
            auth.setFullName(admin.getName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        apiResonse.setData(auth);
        res.setStatus(HttpServletResponse.SC_OK);
        try {
            Gson gson = new Gson();
            res.getWriter().write(gson.toJson(apiResonse));
            res.getWriter().flush();
            res.getWriter().close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
//        res.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
    }

    public static void unSuccessAuthentication(HttpServletResponse res) {
        ResponseApi apiResonse = new ResponseApi();
        apiResonse.setSuccess(Boolean.FALSE);
        apiResonse.setCode(0);
        apiResonse.setMessage("Đăng nhập không thành công.");
        res.setStatus(HttpServletResponse.SC_OK);
        try {
            Gson gson = new Gson();
            res.getWriter().write(gson.toJson(apiResonse));
            res.getWriter().flush();
            res.getWriter().close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
//        res.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
    }

    public static String getUserName(HttpServletRequest request) throws Exception {
        String user = null;
        try {
            String token = request.getHeader(HEADER_STRING);
            if (token != null) {
                // parse the token.
                user = Jwts.parser()
                        .setSigningKey(SECRET)
                        .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                        .getBody()
                        .getSubject();
            }
        } catch (Exception e) {
            throw e;
        }
        return user;
    }

    public static Authentication getAuthentication(HttpServletRequest request) throws Exception {
        Authentication auth = null;
        try {
            String token = request.getHeader(HEADER_STRING);
            if (token != null) {
                // parse the token.
                String user = Jwts.parser()
                        .setSigningKey(SECRET)
                        .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                        .getBody()
                        .getSubject();
                if (user != null) {
                    auth = new UsernamePasswordAuthenticationToken(user, null, emptyList());
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return auth;
    }
}
