package com.dql.retailmanager.entity.form;

import com.dql.retailmanager.entity.page.PageRequest;
import lombok.Data;

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
}
