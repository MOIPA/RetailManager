package com.dql.retailmanager.entity.form;

import com.dql.retailmanager.entity.page.PageRequest;
import lombok.Data;

import java.util.Date;

@Data
public class SearchForm extends PageRequest {
    /**
     * user name
     */
    private String username = "";

    /**
     * item name
     */
    private String itemname = "";

    private String storagename = "";

    private Date start = null;

    private Date end = null;

}
