/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exception;

/**
 *
 * @author pc3-cellx
 */
public class NotExistAdminException extends Exception {

    public NotExistAdminException(String messString) {
        super(messString);
    }
}
