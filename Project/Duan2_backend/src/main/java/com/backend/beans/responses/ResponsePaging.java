/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.beans.responses;

import com.backend.pagers.Pager;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author pc3-cellx
 */
public class ResponsePaging implements Serializable {

    private Pager pager;
    private List items;

    public ResponsePaging(Pager pager, List items) {
        this.pager = pager;
        this.items = items;
    }

    public ResponsePaging() {
    }

    public Pager getPager() {
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }

    public List getItems() {
        return items;
    }

    public void setItems(List items) {
        this.items = items;
    }

}
