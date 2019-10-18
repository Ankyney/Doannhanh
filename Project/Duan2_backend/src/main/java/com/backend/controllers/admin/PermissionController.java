/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.controllers.admin;

import com.backend.beans.responses.ResponseApi;
import com.backend.beans.responses.ResponsePaging;
import com.backend.entities.Admin;
import com.backend.entities.AdminModule;
import com.backend.entities.AdminRole;
import com.backend.facades.AdminFacade;
import com.backend.facades.AdminModuleFacade;
import com.backend.facades.AdminRoleFacade;
import com.backend.pagers.Pager;
import com.backend.services.TokenAuthenticationService;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/Admin/Permission")
public class PermissionController {

    @GetMapping(value = "/ListModule")
    public ResponseApi ListModule() {
        List items = new AdminModuleFacade().findAllRootModulesEager();
        ResponseApi res = ResponseApi.createSuccessResponse(items);
        res.setData(items);
        return res;
    }

    @GetMapping(value = "/ListModuleOfUser")
    public ResponseApi ListModuleOfUser(HttpServletRequest request) {
        ResponseApi res = new ResponseApi();
        try {
            Admin admin = new AdminFacade().findAdminInfoByUsername(TokenAuthenticationService.getUserName(request));
            List items = new AdminModuleFacade().findAllModuleByUsername(admin.getAdminRoleId().getModuleIDs());
            res = ResponseApi.createSuccessResponse(items);
            res.setData(items);
        } catch (Exception ex) {
            Logger.getLogger(PermissionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    @DeleteMapping(value = "/ListModule/Block/{id}")
    @RequestMapping()
    public ResponseApi BlockModule(@PathVariable(name = "id") int id) {
        ResponseApi res = new ResponseApi();
        try {
            AdminModuleFacade aFacade = new AdminModuleFacade();
            AdminModule module = (AdminModule) aFacade.find(id);
            module.setIsShow(!module.getIsShow());
            aFacade.edit(module);
            res.setCode(1);
            res.setSuccess(Boolean.TRUE);
            res.setMessage((module.getIsShow() ? "Hiện" : "Ẩn") + " module thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @DeleteMapping(value = "/ListModule/Delete/{id}")
    public ResponseApi DeleteModule(@PathVariable(name = "id") int id) {
        ResponseApi res = new ResponseApi();
        try {
            new AdminModuleFacade().delete(id);
            res.setCode(1);
            res.setSuccess(Boolean.TRUE);
            res.setMessage("Xóa module thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @PostMapping(value = "/ListModule/Insert")
    public ResponseApi InsertModule(@RequestBody AdminModule admin) {
        ResponseApi res = new ResponseApi();
        try {
            new AdminModuleFacade().create(admin);
            res.setCode(1);
            res.setSuccess(Boolean.TRUE);
            res.setMessage("Thêm module thành công!");
        } catch (Exception e) {
            e.printStackTrace();
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @PostMapping(value = "/ListModule/Edit")
    public ResponseApi EditModule(@RequestBody AdminModule admin) {
        ResponseApi res = new ResponseApi();
        try {
            new AdminModuleFacade().edit(admin);
            res.setCode(1);
            res.setSuccess(Boolean.TRUE);
            res.setMessage("Cập nhật module thành công!");
        } catch (Exception e) {
            e.printStackTrace();
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @GetMapping(value = "/ListRole")
    public ResponseApi ListRole(@RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage,
                                @RequestParam(value = "displayPerPage", required = false, defaultValue = "1") int displayPerPage,
                                @RequestParam(value = "orderColumn", required = false, defaultValue = "id") String orderColmn,
                                @RequestParam(value = "asc", required = false, defaultValue = "true") boolean asc) {
        Pager pager = new Pager();
        pager.setAsc(asc);
        pager.setCurrentPage(currentPage);
        pager.setDisplayPerPage(displayPerPage);
        pager.setOrderColumn(orderColmn);
        List items = new AdminRoleFacade().pager(pager);
        ResponsePaging paging = new ResponsePaging(pager, items);
        ResponseApi res = new ResponseApi();
        res.setData(paging);
        return res;
    }

    @DeleteMapping(value = "/ListRole/Block/{id}")
    public ResponseApi BlockRole(@PathVariable(name = "id") int id) {
        ResponseApi res = new ResponseApi();
        try {
            AdminRoleFacade aFacade = new AdminRoleFacade();
            AdminRole admin = (AdminRole) aFacade.find(id);
            System.out.println("isActive: " + admin.getIsActive());
            admin.setIsActive(!admin.getIsActive());
            aFacade.edit(admin);
            res.setCode(1);
            res.setSuccess(Boolean.TRUE);
            res.setMessage((admin.getIsActive() ? "Hiện" : "Ẩn") + " quyền thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @DeleteMapping(value = "/ListRole/Delete/{id}")
    public ResponseApi DeleteRole(@PathVariable(name = "id") int id) {
        ResponseApi res = new ResponseApi();
        try {
            new AdminRoleFacade().delete(id);
            res.setCode(1);
            res.setSuccess(Boolean.TRUE);
            res.setMessage("Xóa quyền thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @PostMapping(value = "/ListRole/Insert")
    public ResponseApi InsertRole(@RequestBody AdminRole role) {
        ResponseApi res = new ResponseApi();
        try {
            new AdminRoleFacade().create(role);
            res.setCode(1);
            res.setSuccess(Boolean.TRUE);
            res.setMessage("Thêm quyền thành công!");
        } catch (Exception e) {
            e.printStackTrace();
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @PostMapping(value = "/ListRole/Edit")
    public ResponseApi EditRole(@RequestBody AdminRole role) {
        ResponseApi res = new ResponseApi();
        try {
            new AdminRoleFacade().edit(role);
            res.setCode(1);
            res.setSuccess(Boolean.TRUE);
            res.setMessage("Sửa quyền thành công!");
        } catch (Exception e) {
            e.printStackTrace();
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @GetMapping(value = "/ListRole/FindAllAvaiable")
    public ResponseApi FindAllAvaiableRole() {
        List items = new AdminRoleFacade().findAllAvaiable();
        ResponseApi res = ResponseApi.createSuccessResponse(items);
        return res;
    }

}
