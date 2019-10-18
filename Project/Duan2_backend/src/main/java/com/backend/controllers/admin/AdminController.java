/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.controllers.admin;

import com.backend.beans.responses.ResponseApi;
import com.backend.entities.Account;
import com.backend.entities.Admin;
import com.backend.facades.AccountFacades;
import com.backend.facades.AdminFacade;
import com.backend.services.TokenAuthenticationService;
import com.backend.utils.ExcelUtils;
import com.backend.utils.StringUtils;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/Admin/ListAdmin")
public class AdminController {
    
    @GetMapping
    public ResponseApi ListAdmin(HttpServletRequest request) {
        List items = new AdminFacade().pager();
        ResponseApi res = ResponseApi.createSuccessResponse(items);
        return res;
    }
    
    @DeleteMapping(value = "/Block/{id}")
    public ResponseApi BlockAdmin(@PathVariable(name = "id") int id) {
        ResponseApi res = new ResponseApi();
        try {
            AdminFacade aFacade = new AdminFacade();
            Admin admin = (Admin) aFacade.find(id);
            admin.setIsActive(admin.getIsActive() != null ? !admin.getIsActive() : true);
            aFacade.edit(admin);
            res.setCode(1);
            res.setSuccess(Boolean.TRUE);
            res.setMessage((admin.getIsActive() ? "Hiện" : "Ẩn") + " nhân viên thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
    
    @DeleteMapping(value = "/Delete/{id}")
    public ResponseApi DeleteAdmin(@PathVariable(name = "id") int id) {
        ResponseApi res = new ResponseApi();
        try {
            new AdminFacade().delete(id);
            res.setCode(1);
            res.setSuccess(Boolean.TRUE);
            res.setMessage("Xóa nhân viên thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
    
    @GetMapping(value = "/FindAllAvaiable")
    public ResponseApi FindAllAvaiable() {
        ResponseApi res = new ResponseApi();
        try {
            List list = new AdminFacade().findAllActiveAdmin();
            res.setData(list);
            res.setCode(1);
            res.setMessage("Tìm danh sách nhân viên thành công!");
            res.setSuccess(Boolean.TRUE);
            
        } catch (Exception e) {
            e.printStackTrace();
            res.setMessage(e.getMessage());
        }
        return res;
    }
    
    @GetMapping(value = "/FindAdminInRole")
    public ResponseApi FindAdminInRole(HttpServletRequest request) {
        ResponseApi res = new ResponseApi();
        try {
            Admin admin = new AdminFacade().findAdminInfoByUsername(TokenAuthenticationService.getUserName(request));
            res.setData(admin);
        } catch (Exception e) {
            e.printStackTrace();
            res.setMessage(e.getMessage());
        }
        return res;
    }
    
    @PostMapping(value = "/Search")
    public ResponseApi ListAdminShow(@RequestBody String keyword
    ) {
        ResponseApi res = new ResponseApi();
        try {
            List list = new AdminFacade().search(keyword);
            res.setData(list);
            res.setCode(1);
            res.setMessage("Tìm danh sách nhân viên thành công!");
            res.setSuccess(Boolean.TRUE);
            
        } catch (Exception e) {
            e.printStackTrace();
            res.setMessage(e.getMessage());
        }
        return res;
    }
    
    @PostMapping(value = "/Insert")
    public ResponseApi InsertAdmin(@RequestBody Admin admin, HttpServletRequest request) {
        ResponseApi res = new ResponseApi();
        try {
            AdminFacade aFacade = new AdminFacade();
            Admin adminCheck = aFacade.findAdminByUsername(admin.getUsername());
            if (adminCheck != null) {
                throw new Exception("Tên đăng nhập đã tồn tại!");
            }
            String[] nameSplit = admin.getName().split(" ");
            admin.setLastName(nameSplit[nameSplit.length - 1]);
            for (int i = 0; i < nameSplit.length - 1; i++) {
                admin.setFirstName(StringUtils.isEmpty(admin.getFirstName()) ? nameSplit[i] : admin.getFirstName() + " " + nameSplit[i]);
            }
            Admin insertedAdmin = new AdminFacade().findAdminWithCompanyByUsername(TokenAuthenticationService.getUserName(request));
            admin.setCompanyID(insertedAdmin.getCompanyID());
            aFacade.create(admin);
            res.setCode(1);
            res.setSuccess(Boolean.TRUE);
            res.setMessage("Thêm nhân viên thành công!");
        } catch (ConstraintViolationException e) {
            res.setMessage("Mã chấm công đã tồn tại!");
        } catch (Exception e) {
            e.printStackTrace();
            res.setMessage(e.getMessage());
        }
        return res;
    }
    
    @PostMapping(value = "/Edit")
    public ResponseApi EditAdminFindID(@RequestBody Admin admin) {
        ResponseApi res = new ResponseApi();
        try {
            String[] nameSplit = admin.getName().split(" ");
            admin.setLastName(nameSplit[nameSplit.length - 1]);
            for (int i = 0; i < nameSplit.length - 1; i++) {
                admin.setFirstName(StringUtils.isEmpty(admin.getFirstName()) ? nameSplit[i] : admin.getFirstName() + " " + nameSplit[i]);
            }
            new AdminFacade().edit(admin);
            res.setCode(1);
            res.setSuccess(Boolean.TRUE);
            res.setMessage("Cập nhật nhân viên thành công!");
        } catch (ConstraintViolationException e) {
            res.setMessage("Mã chấm công đã tồn tại!");
        } catch (Exception e) {
            e.printStackTrace();
            res.setMessage(e.getMessage());
        }
        return res;
    }
    
    @GetMapping(value = "/Information")
    public ResponseApi Information(HttpServletRequest request) {
        ResponseApi res = new ResponseApi();
        try {
            String username = TokenAuthenticationService.getUserName(request);
            Admin admin = new AdminFacade().findAdminByUsername(username);
            res = ResponseApi.createSuccessResponse(admin);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    //ChangePassword
    @PostMapping(value = "/changePassword")
    public ResponseApi ChangePassword(@RequestParam(value = "oldpass") String oldpass,
            @RequestParam(value = "newpass") String newpass, HttpServletRequest request) {
        ResponseApi res = new ResponseApi();
        try {
            new AdminFacade().changePassword(oldpass, newpass, TokenAuthenticationService.getUserName(request));
            res.setCode(1);
            res.setSuccess(Boolean.TRUE);
            res.setMessage("Đổi mật khẩu thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
    
    @GetMapping(value = "/ImportTemplate")
    public void ImportTemplate(HttpServletResponse response) {
        try {
            String[] headerCells = new String[]{"Họ tên", "Mã chấm công", "Giới tính", "Số điện thoại"};
            String[] valueCells = new String[]{"Nguyễn Văn A", "00000", "Nam", "000000000"};
            response.setHeader("Content-disposition", "attachment; filename=Mãu file import admin.xlsx");
            Workbook workbook = ExcelUtils.createExcelFile(headerCells, valueCells);
            workbook.write(response.getOutputStream());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    @PostMapping(value = "/Import")
    public ResponseApi ImportAdmin(@RequestPart(name = "importedFile", required = true) @Valid @NotBlank MultipartFile file,
            @RequestParam(value = "companyID") Integer companyID
    ) {
        ResponseApi res = new ResponseApi();
        try {
            XSSFWorkbook wb = new XSSFWorkbook(file.getInputStream());
            String checkDuplicateUsername = new AdminFacade().isDuplicateUserName(wb, companyID);
            if (StringUtils.isEmpty(checkDuplicateUsername)) {
                new AdminFacade().importFromExcel(wb, companyID);
                res.setCode(1);
                res.setSuccess(Boolean.TRUE);
                res.setMessage("Import nhân viên thành công!");
            } else {
                res.setMessage(checkDuplicateUsername);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }


}
