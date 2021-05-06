package com.dql.retailmanager.entity.form;

import com.dql.retailmanager.entity.page.PageRequest;
import lombok.Data;

import java.util.Date;

@Data
public class SearchForm extends PageRequest {
    /**
     * name search
     */
    private String username = "";

    private String itemname = "";

    private String storagename = "";

    private String bankname = "";

    /**
     * id and status search
     */
    private int sellOrder;

    private int storageId;

    private int itemId;

    private int memberId = -1;

    /**
     * date search
     */
    private Date start = null;

    private Date end = null;

}
