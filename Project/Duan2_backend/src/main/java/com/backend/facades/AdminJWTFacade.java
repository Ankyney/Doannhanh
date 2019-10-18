/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.facades;

import com.backend.entities.Admin;
import com.backend.entities.AdminPrinciple;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pc3-cellx
 */
@Service
public class AdminJWTFacade implements UserDetailsService {

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        try {
            AdminFacade adminFacade = new AdminFacade();
            Admin admin = adminFacade.findAdminInfoByUsername(username);
            if (admin == null) {
                throw new Exception();
            }
            AdminPrinciple principle = AdminPrinciple.build(admin);
            return principle;
        } catch (Exception e) {
            throw new UsernameNotFoundException("User Not Found with -> username or email : " + username);
        }
    }
}
