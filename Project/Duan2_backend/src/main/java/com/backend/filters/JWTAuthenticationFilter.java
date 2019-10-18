package com.backend.filters;

import com.google.gson.Gson;
import com.backend.beans.responses.ResponseApi;
import com.backend.services.TokenAuthenticationService;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by nhs3108 on 29/03/2017.
 */
public class JWTAuthenticationFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            Authentication authentication = TokenAuthenticationService.getAuthentication((HttpServletRequest) servletRequest);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (ExpiredJwtException e) {
            ResponseApi apiResonse = new ResponseApi();
            apiResonse.setSuccess(Boolean.FALSE);
            apiResonse.setCode(-9999);
            apiResonse.setMessage("Phiên làm việc của bạn đã hết hạn. Vui lòng đăng nhập lại!");
            try {
                Gson gson = new Gson();
                servletResponse.getWriter().write(gson.toJson(apiResonse));
                servletResponse.getWriter().flush();
                servletResponse.getWriter().close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (Exception ex) {
//            Logger.getLogger(JWTAuthenticationFilter.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }
}
