package com.backend.controllers.admin;


import com.backend.beans.responses.ResponseApi;
import com.backend.entities.Transactions;
import com.backend.facades.TransactionsFacade;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/Transactions/ListTransactions")
public class TransactionsController {

    @GetMapping
    public ResponseApi ListTransactions(HttpServletRequest request) {
        List list = new TransactionsFacade().pager();
        return ResponseApi.createSuccessResponse(list);
    }

    @PostMapping(value = "/Insert")
    public ResponseApi InsertTransactions(@RequestBody Transactions transactions, HttpServletRequest request) {
        ResponseApi res = new ResponseApi();
        try {
            new TransactionsFacade().create(transactions);
            res.setSuccess(Boolean.TRUE);
            res.setCode(1);
            res.setMessage("Thêm giao dịch thành công!");
        } catch (Exception ex) {
            res.setMessage(ex.getMessage());
        }
        return res;
    }

    @PutMapping(value = "/Edit")
    public ResponseApi UpdateTransactions(@RequestBody Transactions transactions, HttpServletRequest request) {
        ResponseApi res = new ResponseApi();
        try {
            new TransactionsFacade().edit(transactions);
            res.setCode(1);
            res.setSuccess(Boolean.TRUE);
            res.setMessage("Sửa giao dịch thành công!");
        } catch (Exception ex) {
            res.setMessage(ex.getMessage());
        }
        return res;
    }

    @DeleteMapping(value = "/Delete/{id}")
    public ResponseApi DeleteTransaction(@PathVariable(name = "id") String id) {
        ResponseApi res = new ResponseApi();
        try {
            new TransactionsFacade().delete(id);
            res.setCode(1);
            res.setSuccess(Boolean.TRUE);
            res.setMessage("Xóa giao dịch thành công!");
        } catch (Exception ex) {
            res.setMessage(ex.getMessage());
        }
        return res;
    }


}
