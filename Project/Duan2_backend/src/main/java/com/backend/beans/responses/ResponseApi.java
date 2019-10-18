/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.beans.responses;

import java.io.Serializable;

/**
 *
 * @author pc3-cellx
 */
public class ResponseApi implements Serializable {

    private Boolean success = Boolean.FALSE;
    private Integer code = 0;
    private String message = "Đã xảy ra lỗi. Vui lòng thử lại sau!";
    private Object data = null;

    public Boolean getSuccess() {
        return success;
    }

    public static ResponseApi createSuccessResponse(Object data) {
        ResponseApi res = new ResponseApi();
        res.success = Boolean.TRUE;
        res.code = 1;
        res.message = "Thành công";
        res.data = data;
        return res;
    } 

    public static ResponseApi createSuccessResponse() {
        return createSuccessResponse(null);
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
