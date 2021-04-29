package com.dql.retailmanager.entity.form;

import com.dql.retailmanager.entity.Item;
import lombok.Data;

import java.util.List;

@Data
public class RetailOrderForm {
    private List<Item> itemList;
    private int storageId;
    private int memberId;
    private String remark;
    private double money;
    private int userId;
    private String retailCode;
}
